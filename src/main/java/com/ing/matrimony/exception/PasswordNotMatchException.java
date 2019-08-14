package com.ing.matrimony.exception;

import java.io.Serializable;

public class PasswordNotMatchException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Your password and confirm password was not match";

	public PasswordNotMatchException() {
		super(MESSAGE);
	}
}
