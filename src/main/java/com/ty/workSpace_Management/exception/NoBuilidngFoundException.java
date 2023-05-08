package com.ty.workSpace_Management.exception;

public class NoBuilidngFoundException extends RuntimeException {
	private String message = "element is not Found ";

	public String getMessage() {
		return message;
	}

	public NoBuilidngFoundException(String message) {
		super();
		this.message = message;
	}

	public NoBuilidngFoundException() {
		super();

	}

}