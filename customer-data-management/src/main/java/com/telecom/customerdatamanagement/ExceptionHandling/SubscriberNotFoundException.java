package com.telecom.customerdatamanagement.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SubscriberNotFoundException extends RuntimeException {
	public SubscriberNotFoundException(String message) {
		super(message);
	}
}
