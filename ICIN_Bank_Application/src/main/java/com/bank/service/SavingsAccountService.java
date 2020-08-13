package com.bank.service;

import java.security.Principal;
import java.util.List;

import com.bank.model.SavingsAccount;



public interface SavingsAccountService {
	
	public SavingsAccount createSavingsAccount();
	public List<SavingsAccount> getAllSavingsAccounts();
	public SavingsAccount findByAccountNumber(long accountNumber);
	public String getSavingsAccountBalance(Principal principal);

}
