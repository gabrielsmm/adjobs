package com.gabriel.empregos.services.exceptions;

public class EmailSenderException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EmailSenderException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmailSenderException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
