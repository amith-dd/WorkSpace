package com.ty.workSpace_Management.exception;

public class NoSuchListBasedOnCapacity extends RuntimeException {
	private String message = "element is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchListBasedOnCapacity(String message) {
		super();
		this.message = message;
	}

	public NoSuchListBasedOnCapacity() {
		super();

	}

}