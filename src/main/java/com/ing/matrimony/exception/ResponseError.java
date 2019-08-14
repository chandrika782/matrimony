package com.ing.matrimony.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseError implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;
	private Integer statusCode;

	public ResponseError(String message, Integer statusCode) {
		this.message = message;
		this.statusCode = statusCode;
	}
}
