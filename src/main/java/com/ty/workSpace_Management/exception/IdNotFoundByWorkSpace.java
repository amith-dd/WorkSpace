package com.ty.workSpace_Management.exception;

public class IdNotFoundByWorkSpace extends RuntimeException {

	String message="id is not found for admin";

	public IdNotFoundByWorkSpace(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public IdNotFoundByWorkSpace() {
		super();
	}

	
	
	
	
}
