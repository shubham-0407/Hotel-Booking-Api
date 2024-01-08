package org.ncu.bookingService.exception;

public class InvalidBeanException extends RuntimeException{
private static final long serialVersionUID = 1L;
	
	public InvalidBeanException(String msg) {
		super(msg);
	}
}
