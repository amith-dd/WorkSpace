package com.ty.workSpace_Management.exception;

public class ClientPasswordIncorrect extends RuntimeException {
	String message ;

	public ClientPasswordIncorrect(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}


	
}
