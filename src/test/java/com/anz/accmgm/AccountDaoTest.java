package com.anz.accmgm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.anz.accmgm.constants.AccountType;
import com.anz.accmgm.constants.Currency;
import com.anz.accmgm.domain.Account;
import com.anz.accmgm.domain.Transaction;
import com.anz.accmgm.repository.AccountDao;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountDaoTest {
	
	@Autowired
	private AccountDao accountRepository;
	
	@Test
	public void testFindAll() {
		List<Account> allAccounts = accountRepository.findAll();
		assertThat(allAccounts.size() == 3);
	}
	
	@Test
	public void testFindOne() {
		Optional<Account> account = accountRepository.findById(9001);
		assertThat(account.get().getAccountName() == "Account 1");
	}

	@Test
	public void testSave() {
		double amt = 10.0;
		List<Transaction> transactions = null;
		Account newAccount = accountRepository.save(new Account(1, "Account 1", 
				AccountType.CURRENT.toString(), new Date(), Currency.AUD.toString(), amt, transactions)) ;
		Optional<Account> searchedAccount = accountRepository.findById(1);
		assertThat(newAccount.getAccountNumber() == searchedAccount.get().getAccountNumber());
	}
	
	@Test
	public void testDelete() {
		Optional<Account> account = accountRepository.findById(9001); 
		accountRepository.deleteById(account.get().getAccountNumber());
		Optional<Account> searchAccount = accountRepository.findById(9001); 
		assertThat(searchAccount == null);
	}
}

