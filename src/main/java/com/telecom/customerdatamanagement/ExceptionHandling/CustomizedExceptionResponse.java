package com.telecom.customerdatamanagement.ExceptionHandling;

import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice   
public class CustomizedExceptionResponse extends ResponseEntityExceptionHandler {
		
	@ExceptionHandler(Exception.class) 
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
			
		ExceptionResponse ER = new ExceptionResponse(new Date(), ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(ER, HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	@ExceptionHandler(SubscriberNotFoundException.class)  //customized
	public final ResponseEntity<Object> SubscriberNotFoundException(Exception ex, WebRequest request){
			
		ExceptionResponse ER = new ExceptionResponse(new Date(), ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(ER, HttpStatus.NOT_FOUND);
	}
		
	@ExceptionHandler(SubscriberAlreadyExistsAuthenticationError.class)  
	public final ResponseEntity<Object> SubscriberAlreadyExistsAuthenticationError(Exception ex, WebRequest request){
			
		ExceptionResponse ER = new ExceptionResponse(new Date(), ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(ER, HttpStatus.CONFLICT);
	}
	
	@Override 
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status, WebRequest request){
		ExceptionResponse ER = new ExceptionResponse(new Date(),"Initialization failed",ex.getBindingResult().getFieldError().toString());
		return new ResponseEntity(ER,HttpStatus.BAD_REQUEST);
	}
}
