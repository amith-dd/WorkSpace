package com.ty.workSpace_Management.exception;

public class EmployeePasswordWrong extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}

	public EmployeePasswordWrong(String message) {
		this.message = message;
	}

	
	
	
}
