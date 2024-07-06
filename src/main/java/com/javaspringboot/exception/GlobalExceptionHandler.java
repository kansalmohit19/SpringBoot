package com.javaspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorAPI handleException(ResourceNotFoundException ex) {
		ErrorAPI error = new ErrorAPI();
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setDetails(HttpStatus.BAD_REQUEST.getReasonPhrase());
		return error;
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorAPI handleException(RuntimeException ex) {
		ErrorAPI error = new ErrorAPI();
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setDetails(HttpStatus.BAD_REQUEST.getReasonPhrase());
		return error;
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorAPI handleException(Exception ex) {
		ErrorAPI error = new ErrorAPI();
		error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		error.setDetails(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		return error;
	}

}
