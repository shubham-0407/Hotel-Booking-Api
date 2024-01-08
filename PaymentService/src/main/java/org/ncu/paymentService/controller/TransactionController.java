package org.ncu.paymentService.controller;

import org.ncu.paymentService.entity.TransactionDetailsInfo;
import org.ncu.paymentService.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment/")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping(path=" ")
	public String demo() {
		return "Payment-page";
	}
	
	@PostMapping(path="transaction")
	public int transaction(@RequestBody TransactionDetailsInfo transactioninfo){
		TransactionDetailsInfo transactionEntity = transactionService.initiateTransaction(transactioninfo);
		return transactionEntity.getTransactionId();
		
	}
	
	@GetMapping(path="transaction/{transactionId}")
	public ResponseEntity<TransactionDetailsInfo> getTransactionDetail(@PathVariable int transactionId){
		TransactionDetailsInfo getTransaction = transactionService.fetchTransactionById(transactionId);
		return new ResponseEntity<>(getTransaction, HttpStatus.CREATED);
	}

}
