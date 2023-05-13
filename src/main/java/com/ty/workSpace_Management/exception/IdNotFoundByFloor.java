package com.ty.workSpace_Management.exception;

public class IdNotFoundByFloor extends RuntimeException {

	String message="id is not found for admin";

	public IdNotFoundByFloor(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public IdNotFoundByFloor() {
		super();
	}

	
	
	
	
}
