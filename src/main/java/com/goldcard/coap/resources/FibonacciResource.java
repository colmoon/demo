package com.goldcard.coap.resources;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;

import java.util.List;
import java.util.regex.Pattern;

/**
 * This resource recursively computes the Fibonacci numbers and therefore needs
 * a lot of computing power to respond to a request. Use the query ?n=20 to
 * compute the 20. Fibonacci number, e.g.: coap://localhost:5683/fibonacci?n=20.
 */
public class FibonacciResource extends CoapResource {

	private Pattern pattern;
	
	public FibonacciResource(String name) {
		super(name);
		this.pattern = Pattern.compile("n=\\d*");
	}

	@Override
	public void handleGET(CoapExchange exchange) {
		int n = 20;
		if (exchange.getRequestOptions().getURIQueryCount() > 0) {
			try {
				List<String> queries = exchange.getRequestOptions().getUriQuery();
				for (String query:queries) {
					if (pattern.matcher(query).matches()) {
						n = Integer.parseInt(query.split("=")[1]);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				exchange.respond(CoAP.ResponseCode.BAD_REQUEST, e.getMessage());
				return;
			}
		}
		
		int fib = fibonacci(n);
		exchange.respond("fibonacci("+n+") = "+fib);
	}
	
	/**
	 * Recursive Fibonacci algorithm
	 */
	private int fibonacci(int n) {
		if (n <= 1) return n;
		else return fibonacci(n-1) + fibonacci(n-2);
	}
	
}