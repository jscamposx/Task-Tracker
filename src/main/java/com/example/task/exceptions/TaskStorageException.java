package com.example.task.exceptions;

public class TaskStorageException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TaskStorageException(String message) {
		super(message);
	}

	public TaskStorageException(String message, Throwable cause) {
		super(message, cause);
	}

	public TaskStorageException(Throwable cause) {
		super(cause);
	}
}