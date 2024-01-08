package org.ncu.bookingService.exception;

public class InvalidBookingId extends RuntimeException{
 
	private static final long serialVersionUID = 1L;
	
	public InvalidBookingId(String msg) {
		super(msg);
	}

}