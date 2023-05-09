package com.ty.workSpace_Management.exception;

public class IdNotFoundByManager extends RuntimeException {

	String message="id is not found for admin";

	public IdNotFoundByManager(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public IdNotFoundByManager() {
		super();
	}

	
	
	
	
}
