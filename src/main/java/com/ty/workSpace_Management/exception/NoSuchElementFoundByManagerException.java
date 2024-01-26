package com.ty.workSpace_Management.exception;

public class NoSuchElementFoundByManagerException extends RuntimeException {
	private String message = "element is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByManagerException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByManagerException() {
		super();

	}

}