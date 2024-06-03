package com.hrportal.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hrportal.dao.ErrorDto;
import com.hrportal.exceptions.AppException;

@RestControllerAdvice
public class RestExceptionHandler {

//	@ExceptionHandler(value = { AppException.class })
//	@ResponseBody
//	public ResponseEntity<ErrorDto> handleException(AppException ex) {
//		return ResponseEntity.status(ex.getHttpStatus()).body(new ErrorDto(ex.getMessage()));
//	}
}
