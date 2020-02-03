package com.anz.accmgm.service.impl;

import java.util.List;
import java.util.Optional;

import com.anz.accmgm.domain.Account;

public interface AccountService {

	public List<Account> getAllAccounts();
	public Optional<Account> findByAccountNo(int accountNo);
	public Account saveAccount(Account account);
}
