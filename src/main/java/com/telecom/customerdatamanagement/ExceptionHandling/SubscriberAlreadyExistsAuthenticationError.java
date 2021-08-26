package com.telecom.customerdatamanagement.ExceptionHandling;

import javax.security.sasl.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class SubscriberAlreadyExistsAuthenticationError extends AuthenticationException {
	public SubscriberAlreadyExistsAuthenticationError(final String message)
	{
		super(message);
	}
}
