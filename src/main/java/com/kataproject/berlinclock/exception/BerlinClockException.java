package com.kataproject.berlinclock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Basic exception handling for the Berlin Clock as there is no user need
 * expressed for error management
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BerlinClockException extends Exception {

	private static final long serialVersionUID = 8669162305610694510L;

	public BerlinClockException(Exception e) {
		super(e);
	}

}
