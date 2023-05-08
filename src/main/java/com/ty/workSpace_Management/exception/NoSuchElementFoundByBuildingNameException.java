package com.ty.workSpace_Management.exception;

public class NoSuchElementFoundByBuildingNameException extends RuntimeException {
	private String message = "element is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByBuildingNameException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByBuildingNameException() {
		super();

	}

}