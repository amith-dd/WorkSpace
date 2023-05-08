package com.ty.workSpace_Management.exception;

public class IdNotFoundByBuilding extends RuntimeException {

	String message="id is not found for admin";

	public IdNotFoundByBuilding(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public IdNotFoundByBuilding() {
		super();
	}

	
	
	
	
}
