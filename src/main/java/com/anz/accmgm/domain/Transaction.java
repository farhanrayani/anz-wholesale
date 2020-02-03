package com.anz.accmgm.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Domain Transaction
 * @author Farhan Rayani
 *
 */
@Entity
public class Transaction {
	
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Account account;
	
	private Date valueDate;
	
	private double debitAmount;
	
	private double creditAmount;
	
	private String debitCredit;
	
	private String transactionNarrative;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(float debitAmount) {
		this.debitAmount = debitAmount;
	}

	public double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(float creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getDebitCredit() {
		return debitCredit;
	}

	public void setDebitCredit(String debitCredit) {
		this.debitCredit = debitCredit;
	}

	public String getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", account=" + account + ", valueDate=" + valueDate + ", debitAmount="
				+ debitAmount + ", creditAmount=" + creditAmount + ", debitCredit=" + debitCredit
				+ ", transactionNarrative=" + transactionNarrative + "]";
	}
}
