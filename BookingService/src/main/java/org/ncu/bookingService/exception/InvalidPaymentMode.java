package org.ncu.bookingService.exception;

public class InvalidPaymentMode extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidPaymentMode (String msg) {
		super(msg);
	}

}