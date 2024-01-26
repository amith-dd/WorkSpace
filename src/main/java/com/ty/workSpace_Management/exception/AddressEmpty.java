package com.ty.workSpace_Management.exception;

public class AddressEmpty extends RuntimeException {
	private String message;

	public AddressEmpty(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	
}
