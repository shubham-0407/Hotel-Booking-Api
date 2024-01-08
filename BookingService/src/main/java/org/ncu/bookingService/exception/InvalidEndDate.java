package org.ncu.bookingService.exception;

public class InvalidEndDate extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidEndDate(String msg) {
		super(msg);
	}
}