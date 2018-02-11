package com.trav.exceptions;

/**
 * PersistenceException is related to any Errors made involved in Interacting with the DB.
 * 
 * @author nachmi
 *
 */

public class PersistenceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PersistenceException(String errorMessage) {
		super(errorMessage);
	}
}
