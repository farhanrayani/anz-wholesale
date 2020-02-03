package com.anz.accmgm.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anz.accmgm.domain.Account;
import com.anz.accmgm.repository.AccountDao;
import com.anz.accmgm.service.impl.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
 
    @Autowired
    private AccountDao accountDao;
    
    public List<Account> getAllAccounts() {
    	return accountDao.findAll();
    }
    
    public Optional<Account> findByAccountNo(int accountNo) {
    	return accountDao.findById(accountNo);
    }
    
    public Account saveAccount(Account account){
    	return accountDao.save(account);
    }

}
