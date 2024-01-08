package org.ncu.paymentService.service;

import java.util.Map;
import java.util.Optional;

import org.ncu.paymentService.entity.TransactionDetailsInfo;

public interface TransactionService {

	public TransactionDetailsInfo initiateTransaction(TransactionDetailsInfo transaction);

	public  TransactionDetailsInfo fetchTransactionById(int id);

//	public Movie updateMovie(Movie movie);

}