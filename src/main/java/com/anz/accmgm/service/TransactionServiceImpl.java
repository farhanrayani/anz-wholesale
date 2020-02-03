package com.anz.accmgm.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anz.accmgm.domain.Transaction;
import com.anz.accmgm.repository.TransactionDao;
import com.anz.accmgm.service.impl.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
 
    @Autowired
    private TransactionDao transactionDao;
    
    public List<Transaction> getAllTransactions() {
    	return transactionDao.findAll();
    }
    
    public Optional<Transaction> findByTransactionId(int transId) {
    	return transactionDao.findById(transId);
    }
    
    public Transaction saveTransaction(Transaction transaction){
    	return transactionDao.save(transaction);
    }

}
