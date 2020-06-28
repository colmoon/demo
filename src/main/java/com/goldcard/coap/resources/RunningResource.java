package com.goldcard.coap.resources;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 * This resource contains two subresources: shutdown and restart. Send a POST
 * request to subresource shutdown to stop the server. Send a POST request to
 * the subresource restart to restart the server.
 */
public class RunningResource extends CoapResource {

	private CoapServer server;
	
	private int restartCount;
	
	public RunningResource(String name, CoapServer s) {
		super(name);
		this.server = s;
		
		add(new CoapResource("shutdown") {
			@Override
            public void handlePOST(CoapExchange exchange) {
				exchange.respond(ResponseCode.CHANGED);
				sleep(100);
				server.stop();
			}
		});
		
		add(new CoapResource("restart") {
			@Override
            public void handlePOST(CoapExchange exchange) {
				restartCount++;
				server.stop();
				sleep(100);
				server.start();
				exchange.respond(ResponseCode.CHANGED, "Restart count: "+restartCount);
			}
		});
	}
	
	private void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}