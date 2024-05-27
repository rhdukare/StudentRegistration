package com.handling.CollegeRegistractionDemo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import jakarta.el.Expression;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	//specific
	@ExceptionHandler(ResourceNotFoundExpression.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundExpression expression, WebRequest request)
	{
		ExceptionDetails details= new ExceptionDetails(new Date(), expression.getMessage(), request.getDescription(false));
		return new ResponseEntity(details, HttpStatus.NOT_FOUND);
	}
	
//	//global
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<?> handleGlobalException(Expression expression, WebRequest request)
//	{
//		ExceptionDetails details= new ExceptionDetails(new Date(), expression.getExpressionString() , request.getDescription(false));
//		return new ResponseEntity(details, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	//specific
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<?> handleInvalidInputException(InvalidInputException expression, WebRequest request)
	{
		ExceptionDetails details= new ExceptionDetails(new Date(), expression.getMessage() , request.getDescription(false));
		return new ResponseEntity(details, HttpStatus.UNPROCESSABLE_ENTITY);
	}

}