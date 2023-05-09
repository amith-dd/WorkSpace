package com.ty.workSpace_Management.exception;

public class LoginByAdminException extends RuntimeException {
	private String message = "element is not Found ";

	public String getMessage() {
		return message;
	}

	public LoginByAdminException(String message) {
		super();
		this.message = message;
	}

	public LoginByAdminException() {
		super();

	}

}