package org.ncu.paymentService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="transaction")
@Entity
public class TransactionDetailsInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	
	@Column
	private String paymentMode;
	
	@Column(nullable = false)
	private int bookingId;
	
	@Column(nullable = true)
	private String upiId;
	
	@Column(nullable = true)
	private String cardNumber;

}