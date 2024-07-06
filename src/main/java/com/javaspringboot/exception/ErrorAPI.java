package com.javaspringboot.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorAPI {

	public int statusCode;
	public String message;
	public String details;
}
