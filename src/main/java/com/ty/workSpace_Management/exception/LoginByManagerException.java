package com.ty.workSpace_Management.exception;

public class LoginByManagerException extends RuntimeException {
	private String message = "element is not Found ";

	public String getMessage() {
		return message;
	}

	public LoginByManagerException(String message) {
		super();
		this.message = message;
	}

	public LoginByManagerException() {
		super();

	}

}