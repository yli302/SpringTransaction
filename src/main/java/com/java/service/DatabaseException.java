package com.java.service;

public class DatabaseException extends RuntimeException {
	public DatabaseException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

	public DatabaseException(String errorMessage) {
		super(errorMessage);
	}
}
