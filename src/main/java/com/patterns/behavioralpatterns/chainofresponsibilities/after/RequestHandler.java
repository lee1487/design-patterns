package com.patterns.behavioralpatterns.chainofresponsibilities.after;

import com.patterns.behavioralpatterns.chainofresponsibilities.before.Request;

public abstract class RequestHandler {

	private RequestHandler nextHandler;

	public RequestHandler(RequestHandler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	public void handle(Request request) {
		if (nextHandler != null) {
			nextHandler.handle(request);
		}
	}
	
	
}
