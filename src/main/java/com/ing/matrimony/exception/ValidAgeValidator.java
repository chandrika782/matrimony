package com.ing.matrimony.exception;

import java.io.Serializable;

public class ValidAgeValidator extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "no profile found";
	
	public ValidAgeValidator() {
		super(MESSAGE);
	}
	
}
