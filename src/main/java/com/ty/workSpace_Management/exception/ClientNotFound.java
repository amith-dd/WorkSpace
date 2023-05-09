package com.ty.workSpace_Management.exception;

public class ClientNotFound extends RuntimeException{
	
	String message = " client not found with given credentials";
	
	
	
	public String getMessage() {
		return message;
	}
	
	
	public ClientNotFound() {
		super();
	}


	public ClientNotFound(String message) {
		this.message = message;
	}
	
	
	
}
