package org.ncu.paymentService.handler;

import org.ncu.paymentService.dto.ErrorResponse;
import org.ncu.paymentService.exception.InvalidTransactionId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(InvalidTransactionId.class)
	public final ResponseEntity<ErrorResponse> handleInvalidBookingIdException(InvalidTransactionId e){
		ErrorResponse response = new ErrorResponse(e.getLocalizedMessage(), 400);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}
	 
	 
}