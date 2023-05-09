package com.ty.workSpace_Management.exception;

public class ClientNotFoundByEmail extends RuntimeException{
	String message;

	public String getMessage() {
		return message;
	}

	public ClientNotFoundByEmail(String message) {
		super();
		this.message = message;
	}
	
	
	
}
