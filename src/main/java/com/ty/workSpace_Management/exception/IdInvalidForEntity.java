package com.ty.workSpace_Management.exception;

public class IdInvalidForEntity extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}

	public IdInvalidForEntity(String message) {
		this.message = message;
	}
	
	
	
}
