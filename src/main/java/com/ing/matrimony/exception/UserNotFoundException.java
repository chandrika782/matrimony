package com.ing.matrimony.exception;

import java.io.Serializable;

public class UserNotFoundException extends RuntimeException implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static final  String MESSAGE = "Invalid User";
	
	public UserNotFoundException() {
		super(MESSAGE);
	}
}