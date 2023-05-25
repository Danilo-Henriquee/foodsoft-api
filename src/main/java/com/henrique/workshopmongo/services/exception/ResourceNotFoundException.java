package com.henrique.workshopmongo.services.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String id) {
		super("Object not found with id " + id);
	}
}
