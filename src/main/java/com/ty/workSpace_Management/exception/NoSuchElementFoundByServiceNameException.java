package com.ty.workSpace_Management.exception;

public class NoSuchElementFoundByServiceNameException extends RuntimeException {
	private String message = "element is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByServiceNameException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByServiceNameException() {
		super();

	}

}