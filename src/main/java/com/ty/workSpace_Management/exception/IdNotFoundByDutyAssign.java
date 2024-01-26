package com.ty.workSpace_Management.exception;

public class IdNotFoundByDutyAssign extends RuntimeException {

	String message="id is not found for admin";

	public IdNotFoundByDutyAssign(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public IdNotFoundByDutyAssign() {
		super();
	}

	
	
	
	
}
