package com.mail.ExceptionHandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling 
{
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<?> handleAllNullPointerHere(Exception msg)
	{
		return ResponseEntity.internalServerError().body(msg);
	}
}
