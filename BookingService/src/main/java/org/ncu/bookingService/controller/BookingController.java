package org.ncu.bookingService.controller;

import org.ncu.bookingService.dto.TransactionDetailsDto;
import org.ncu.bookingService.entity.BookingInfoEntity;
import org.ncu.bookingService.exception.InvalidBeanException;
import org.ncu.bookingService.exception.InvalidBookingId;
import org.ncu.bookingService.exception.InvalidPaymentMode;
import org.ncu.bookingService.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hotel/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	@Autowired
	private RestTemplate restTemplate;
	
	
	@PostMapping(path="/")
	public ResponseEntity<BookingInfoEntity> saveBooking(@RequestBody BookingInfoEntity bookinginfo ){
		BookingInfoEntity savedEntity = bookingService.addBooking(bookinginfo);
		return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
	}
	
	@PostMapping("/{bookingId}/transaction")
    public ResponseEntity<BookingInfoEntity> processTransaction(
            @PathVariable int bookingId,
            @RequestBody TransactionDetailsDto transactionRequest) {
		 
        // Validate payment mode
        if (!isValidPaymentMode(transactionRequest.getPaymentMode())) {
            throw new InvalidPaymentMode("Invalid mode of payment");
        }
        if (restTemplate != null) {
        	if(bookingService.fetchBookingById(bookingId)) {
        		// Make a request to Payment Service through API Gateway
                String paymentServiceUrl = "http://localhost:8083/payment/transaction";
            	ResponseEntity<Integer> paymentResponse = restTemplate.postForEntity(
                        paymentServiceUrl,
                        transactionRequest,
                        Integer.class
                );
            	 
            	// Save the transaction ID to the booking table
                Integer transactionId = paymentResponse.getBody();
                BookingInfoEntity updatedEntity = bookingService.updateBookingStatus(bookingId, transactionId);
                if(paymentResponse.getStatusCode() == HttpStatus.ACCEPTED) {
                	String message = "Booking confirmed for user with aadhaar number: ";
                	System.out.println(message+updatedEntity.getAadharNumber()
                	+ "|"
                	+ "Here are booking details: "
                	+updatedEntity.toString());
                }
              
        		return new ResponseEntity<>(updatedEntity, HttpStatus.CREATED);
        	}
        	
        } else {
            throw new InvalidBeanException("Cannot make payment");
        }
		return null;
       
    }

    private boolean isValidPaymentMode(String paymentMode) {
        return "UPI".equalsIgnoreCase(paymentMode) || "CARD".equalsIgnoreCase(paymentMode);
    }

    

}
