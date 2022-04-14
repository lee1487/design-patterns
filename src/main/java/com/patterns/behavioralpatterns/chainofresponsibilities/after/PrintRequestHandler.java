package com.patterns.behavioralpatterns.chainofresponsibilities.after;

import com.patterns.behavioralpatterns.chainofresponsibilities.before.Request;

public class PrintRequestHandler extends RequestHandler {

	public PrintRequestHandler(RequestHandler nextHandler) {
		super(nextHandler);
	}
	
	@Override
	public void handle(Request request) {
		System.out.println(request.getBody());
		super.handle(request);
	}

	
	
}
