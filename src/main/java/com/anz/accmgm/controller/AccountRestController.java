package com.anz.accmgm.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anz.accmgm.domain.Account;
import com.anz.accmgm.domain.Transaction;
import com.anz.accmgm.exception.AccountNotFoundException;
import com.anz.accmgm.exception.TransactionNotFoundException;
import com.anz.accmgm.repository.AccountDao;
import com.anz.accmgm.repository.TransactionDao;


@RestController
public class AccountRestController {
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private TransactionDao transactionDao;

	/**
	 * getAllAccounts
	 * @return List<Account> all accounts
	 */
	@GetMapping(path="/anz/accounts")
	public List<Account> getAllAccounts() {
		return accountDao.findAll();
	}
	
	/**
	 * retrieveAccount
	 * @return Optional<Account> requested account
	 */
	
	@GetMapping(path="/anz/accounts/{accountNo}")
	public Optional<Account> retrieveAccount(@PathVariable int accountNo) {
		Optional<Account> account = accountDao.findById(accountNo);
		
		if (!account.isPresent()) {
			throw new AccountNotFoundException("accountNo: " + accountNo);
		}

		Resource<Account> resource = new Resource<Account>(account.get());
		
		// Enable creates links from methods
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).getAllAccounts());
		
		resource.add(linkTo.withRel("all-accounts"));
		
		return account;
	}

	/**
	 * 
	 * @param account
	 * @return ResponseEntity<Object> response
	 */
	@PostMapping(path="/anz/accounts")
	public ResponseEntity<Object> createAccount(@Valid @RequestBody Account account) {
		Account accountObj = accountDao.save(account);

		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{accountNo}")
			.buildAndExpand(accountObj.getAccountNumber())
			.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	/**
	 * 
	 * @param accountNo
	 * @return List<Transaction> all transactions of the account No
	 */
	@GetMapping(path="/anz/accounts/{accountNo}/transactions")
	public List<Transaction> getAllTransactions(@PathVariable int accountNo) {
		Optional<Account> accountOptional = accountDao.findById(accountNo);
		if (!accountOptional.isPresent()) {
			throw new AccountNotFoundException("accountNo:" + accountNo);
		}
		return accountOptional.get().getTransactions();
	}
	
	@GetMapping(path="/anz/accounts/{accountNo}/transactions/{transactionId}")
	public Optional<Transaction> getTransaction(@PathVariable int accountNo,
			@PathVariable int transactionId) {
		Optional<Transaction> transaction = transactionDao.findById(transactionId);
		
		if (!transaction.isPresent()) {
			throw new TransactionNotFoundException("transactionId: " + transactionId);
		}

		Resource<Transaction> resource = new Resource<Transaction>(transaction.get());
		
		// Enable creates links from methods
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).getAllAccounts());
		
		resource.add(linkTo.withRel("all-transactions"));
		
		return transaction;
	}
	
	/**
	 * 
	 * @param accountNo
	 * @param transaction
	 * @return ResponseEntity<Object>  response
	 */
	@PostMapping(path="/anz/accounts/{accountNo}/transactions")
	public ResponseEntity<Object> createTransaction(@PathVariable int accountNo,
			@RequestBody Transaction transaction) {
		
		Optional<Account> accountOptional = accountDao.findById(accountNo);
		
		if (!accountOptional.isPresent()) {
			throw new AccountNotFoundException("accountNo:" + accountNo);
		}

		Account account = accountOptional.get();
		transaction.setAccount(account);
		transactionDao.save(transaction);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{accountNo}")
			.buildAndExpand(transaction.getId())
			.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
