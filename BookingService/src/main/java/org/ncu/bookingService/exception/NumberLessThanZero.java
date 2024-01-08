package org.ncu.bookingService.exception;

public class NumberLessThanZero extends RuntimeException  {

	private static final long serialVersionUID = 1L;
	public NumberLessThanZero(String msg) {
		super(msg);
	}
}