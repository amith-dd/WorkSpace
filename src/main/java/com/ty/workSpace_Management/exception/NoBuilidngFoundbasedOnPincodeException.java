package com.ty.workSpace_Management.exception;

public class NoBuilidngFoundbasedOnPincodeException extends RuntimeException {
	private String message = "element is not Found ";

	public String getMessage() {
		return message;
	}

	public NoBuilidngFoundbasedOnPincodeException(String message) {
		super();
		this.message = message;
	}

	public NoBuilidngFoundbasedOnPincodeException() {
		super();

	}

}