package com.anz.accmgm.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Domain Account.
 * @author Farhan Rayani
 *
 */
@ApiModel(description="All details about the Account.")
@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private Integer accountNumber;
	
	@Size(min = 2, message = "Account Name should have at least 2 characters.")
	@ApiModelProperty(notes="Account Name should have at least 2 characters. ")
	private String accountName;

	private String accountType;
	
	@Past(message = "Balance Date should be in the past.")
	@ApiModelProperty(notes="Balance date should be in the past.")
	private Date balanceDate;
	
	private String currency;
	
	private double openingAvailableBalance;
	
	@OneToMany(mappedBy="account")
	private List<Transaction> transactions;
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getOpeningAvailableBalance() {
		return openingAvailableBalance;
	}

	public void setOpeningAvailableBalance(double openingAvailableBalance) {
		this.openingAvailableBalance = openingAvailableBalance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	protected Account() { }

	public Account(Integer accountNumber,
			@Size(min = 2, message = "Account Name should have at least 2 characters.") String accountName,
			@NotBlank String accountType, @Past(message = "Balance Date should be in the past.") Date balanceDate,
			String currency, double openingAvailableBalance, List<Transaction> transactions) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.accountType = accountType;
		this.balanceDate = balanceDate;
		this.currency = currency;
		this.openingAvailableBalance = openingAvailableBalance;
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName + ", accountType="
				+ accountType + ", balanceDate=" + balanceDate + ", currency=" + currency + ", openingAvailableBalance="
				+ openingAvailableBalance + ", transactions=" + transactions + "]";
	}
}
