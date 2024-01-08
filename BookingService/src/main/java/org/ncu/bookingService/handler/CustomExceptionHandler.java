package org.ncu.bookingService.handler;

import org.ncu.bookingService.dto.ErrorResponse;
import org.ncu.bookingService.exception.InvalidBeanException;
import org.ncu.bookingService.exception.InvalidBookingId;
import org.ncu.bookingService.exception.InvalidEndDate;
import org.ncu.bookingService.exception.InvalidPaymentMode;
import org.ncu.bookingService.exception.NumberLessThanZero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(InvalidBookingId.class)
	public final ResponseEntity<ErrorResponse> handleInvalidBookingIdException(InvalidBookingId e){
		ErrorResponse response = new ErrorResponse(e.getLocalizedMessage(), 400);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidPaymentMode.class)
	public final ResponseEntity<ErrorResponse> handleInvalidPaymentModeException(InvalidPaymentMode e){
		ErrorResponse response = new ErrorResponse(e.getLocalizedMessage(), 400);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidEndDate.class)
	public final ResponseEntity<ErrorResponse> handleInvalidEndDateException(InvalidEndDate e){
		ErrorResponse response = new ErrorResponse(e.getLocalizedMessage(), 400);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NumberLessThanZero.class)
	public final ResponseEntity<ErrorResponse> handleNumberLessThanZeroException(NumberLessThanZero e){
		ErrorResponse response = new ErrorResponse(e.getLocalizedMessage(), 400);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidBeanException.class)
	public final ResponseEntity<ErrorResponse> handleNoBeanCreationException(InvalidBeanException e){
		ErrorResponse response = new ErrorResponse(e.getLocalizedMessage(), 400);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}
}