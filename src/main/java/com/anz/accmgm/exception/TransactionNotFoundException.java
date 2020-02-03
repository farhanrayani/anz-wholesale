package com.anz.accmgm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Customized Exception Class for Transaction.
 * @author Farhan Rayani
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TransactionNotFoundException extends RuntimeException {
	public TransactionNotFoundException(String message) {
		super(message);
	}
}
