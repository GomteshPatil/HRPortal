package com.hrportal.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AppException extends RuntimeException {

	public final HttpStatus httpStatus;

	public AppException(String message, HttpStatus status) {
		super(message);
		this.httpStatus = status;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
