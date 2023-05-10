package com.ty.workSpace_Management.exception;

public class NoSuchWorkSpaceFoundForBooking extends RuntimeException {
	private String message = "element is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchWorkSpaceFoundForBooking(String message) {
		super();
		this.message = message;
	}

	public NoSuchWorkSpaceFoundForBooking() {
		super();

	}

}