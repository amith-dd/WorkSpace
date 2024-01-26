package com.ty.workSpace_Management.exception;

public class EmployeeNotFound extends RuntimeException{
	
	String message = "employee not found";

	public String getMessage() {
		return message;
	}

	public EmployeeNotFound(String message) {
		this.message = message;
	}
	
	
	
}
