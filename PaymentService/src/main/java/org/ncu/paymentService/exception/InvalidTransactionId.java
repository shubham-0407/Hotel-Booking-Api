package org.ncu.paymentService.exception;

public class InvalidTransactionId extends RuntimeException{
 
	private static final long serialVersionUID = 1L;
	
	public InvalidTransactionId(String msg) {
		super(msg);
	}

}