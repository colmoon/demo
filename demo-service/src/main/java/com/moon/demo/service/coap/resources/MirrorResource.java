package com.moon.demo.service.coap.resources;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.server.resources.Resource;

/**
 * This resource responds with the data from a request in its payload. This
 * resource responds to GET, POST, PUT and DELETE requests.
 */
public class MirrorResource extends CoapResource {

	public MirrorResource(String name) {
		super(name);
	}
	
	@Override
	public Resource getChild(String name) {
		return this;
	}
	
	/**
	 * This method uses the internal {@link Exchange} class for advanced handling.
	 */
	@Override
	public void handleRequest(Exchange exchange) {
		Request request = exchange.getRequest();
		StringBuilder buffer = new StringBuilder();
		buffer.append("resource ").append(getURI()).append(" received request")
			.append("\n").append("Code: ").append(request.getCode())
			.append("\n").append("Source: ").append(request.getSource()).append(":").append(request.getSourcePort())
			.append("\n").append("Type: ").append(request.getType())
			.append("\n").append("MID: ").append(request.getMID())
			.append("\n").append("Token: ").append(request.getTokenString())
			.append("\n").append(request.getOptions());
		Response response = new Response(ResponseCode.CONTENT);
		response.setPayload(buffer.toString());
		response.getOptions().setContentFormat(MediaTypeRegistry.TEXT_PLAIN);
		exchange.sendResponse(response);
	}
}