package com.bank.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SavingsAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int savingsAccountId;
	private long accountNumber;
	private BigDecimal accountBalance;

	
	@OneToMany(mappedBy = "savingsAccount", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<SavingsTransfers> savingsTransfersList;
	
	public SavingsAccount() {
		// TODO Auto-generated constructor stub
	}

	public int getSavingsAccountId() {
		return savingsAccountId;
	}

	public void setSavingsAccountId(int savingsAccountId) {
		this.savingsAccountId = savingsAccountId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber=accountNumber;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<SavingsTransfers> getSavingsTransfersList() {
		return savingsTransfersList;
	}

	public void setSavingsTransfersList(List<SavingsTransfers> savingsTransfersList) {
		this.savingsTransfersList = savingsTransfersList;
	}
	
	
	
	

}
