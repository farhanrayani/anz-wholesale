package com.anz.accmgm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception Class for Account.
 * @author Farhan Rayani
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException {

	public AccountNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
