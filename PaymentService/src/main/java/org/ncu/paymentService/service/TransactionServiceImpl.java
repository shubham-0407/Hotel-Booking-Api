package org.ncu.paymentService.service;
import java.util.Optional;

import org.ncu.paymentService.entity.TransactionDetailsInfo;
import org.ncu.paymentService.exception.InvalidTransactionId;
import org.ncu.paymentService.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepo;
	@Override
	public TransactionDetailsInfo initiateTransaction(TransactionDetailsInfo transaction) {
		if(transaction.getPaymentMode().equalsIgnoreCase("CARD") || transaction.getPaymentMode().equalsIgnoreCase("UPI")) {
			return transactionRepo.save(transaction);
		} 
		return null;
	}
	
	@Override
	public TransactionDetailsInfo fetchTransactionById(int id) {
		Optional<TransactionDetailsInfo> optionalTransaction = transactionRepo.findById(id);
		if(optionalTransaction.isPresent()){
			TransactionDetailsInfo transaction = optionalTransaction.get();
			return transaction;
        }else {
        	throw new InvalidTransactionId("Invalid transaction id");
        }
		 
	}

}
