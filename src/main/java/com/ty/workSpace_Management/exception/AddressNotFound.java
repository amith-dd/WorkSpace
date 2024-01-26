package com.ty.workSpace_Management.exception;

public class AddressNotFound extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}

	public AddressNotFound(String message) {
		this.message = message;
	}
	
}
