package com.anz.accmgm.service.impl;

import java.util.List;
import java.util.Optional;
import com.anz.accmgm.domain.Transaction;

public interface TransactionService {

	 public List<Transaction> getAllTransactions();
	 public Optional<Transaction> findByTransactionId(int transId);
	 public Transaction saveTransaction(Transaction transaction);
}
