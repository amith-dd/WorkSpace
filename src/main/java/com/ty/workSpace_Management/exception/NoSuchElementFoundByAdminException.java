package com.ty.workSpace_Management.exception;

public class NoSuchElementFoundByAdminException extends RuntimeException {
	private String message = "element is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByAdminException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByAdminException() {
		super();

	}

}