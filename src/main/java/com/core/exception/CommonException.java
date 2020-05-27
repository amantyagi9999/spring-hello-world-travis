package com.core.exception;

public class CommonException extends Exception {

	private static final long serialVersionUID = 9090867734427198196L;

	public CommonException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommonException(String message) {
		super(message);
	}

	public CommonException() {
		super();
	}
}
