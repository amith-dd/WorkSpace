package com.ty.workSpace_Management.exception;

public class IdNotFoundByAdmin extends RuntimeException {

	String message="id is not found for admin";

	public IdNotFoundByAdmin(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public IdNotFoundByAdmin() {
		super();
	}

	
	
	
	
}
