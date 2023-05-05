package com.ty.workSpace_Management.exception;

public class ClientBookingNotFound extends RuntimeException {
	
	String message = "client booking not found ";

	public String getMessage() {
		return message;
	}

	public ClientBookingNotFound(String message) {
		this.message = message;
	}

	
}
