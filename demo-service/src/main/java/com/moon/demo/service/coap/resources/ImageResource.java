package com.moon.demo.service.coap.resources;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.core.server.resources.ResourceAttributes;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * This resource responds with an image to GET requests. Use the ACCEPT option
 * to choose between the JPG and PNG file.
 */
public class ImageResource extends CoapResource {

	private String filePath = "src/main/resources/data/image/";
	private String fileName = "image";
	
	private List<Integer> supported = new ArrayList<Integer>();

	public ImageResource(String resourceIdentifier) {
		super(resourceIdentifier);
		
		ResourceAttributes attributes = getAttributes();
		attributes.setTitle("GET an image with different content-types");
		attributes.addResourceType("Image");
		
		supported.add(MediaTypeRegistry.IMAGE_PNG);
		supported.add(MediaTypeRegistry.IMAGE_JPEG);
		
		for (int ct : supported) {
			attributes.addContentType(ct);
		}
		
		attributes.setMaximumSizeEstimate(18029);
	}

	@Override
	public void handleGET(CoapExchange exchange) {
		Integer ct = MediaTypeRegistry.IMAGE_PNG;
		if (exchange.getRequestOptions().hasAccept()) {
			ct = exchange.getRequestOptions().getAccept();
			if (!supported.contains(ct)) {
				exchange.respond(new Response(CoAP.ResponseCode.NOT_ACCEPTABLE));
				return;
			}
		}
		
		String filename = filePath + fileName + "." + MediaTypeRegistry.toFileExtension(ct);

		// load representation from file
		System.out.println("Opening file "+filename+", "+new File(filename).getAbsolutePath());
		File file = new File(filename);
		
		if (!file.exists()) {
			exchange.respond(CoAP.ResponseCode.INTERNAL_SERVER_ERROR, "Image file not found");
			return;
		}
		
		// get length of file for buffer
        int fileLength = (int)file.length();
        byte[] fileData = new byte[fileLength];
        
        try
        {
			// open input stream from file
        	FileInputStream fileIn = new FileInputStream(file);
			// read file into byte array
			fileIn.read(fileData);
			fileIn.close();
			
			// create response
			Response response = new Response(CoAP.ResponseCode.CONTENT);
			response.setPayload(fileData);
			response.getOptions().setContentFormat(ct);

			exchange.respond(response);
			
        } catch (Exception e) {
			exchange.respond(CoAP.ResponseCode.INTERNAL_SERVER_ERROR, "I/O error");
        }
	}
	
}