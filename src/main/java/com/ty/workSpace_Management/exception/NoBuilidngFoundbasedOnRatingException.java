package com.ty.workSpace_Management.exception;

public class NoBuilidngFoundbasedOnRatingException extends RuntimeException {
	private String message = "element is not Found ";

	public String getMessage() {
		return message;
	}

	public NoBuilidngFoundbasedOnRatingException(String message) {
		super();
		this.message = message;
	}

	public NoBuilidngFoundbasedOnRatingException() {
		super();

	}

}