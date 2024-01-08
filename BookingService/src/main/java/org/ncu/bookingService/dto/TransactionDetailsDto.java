package org.ncu.bookingService.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDetailsDto {

	private int transactionId;
	private String paymentMode;
	private int bookingId;
	private String upiId;
	private String cardNumber;
}
