package com.bank.service.impl;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.SavingsAccountDAO;
import com.bank.model.SavingsAccount;
import com.bank.model.User;
import com.bank.service.RegisterService;
import com.bank.service.SavingsAccountService;


@Service
public class SavingsAccountServiceImpl implements SavingsAccountService{
	
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private SavingsAccountDAO dao;
	
	private static long count = 10000000;

	@Override
	public SavingsAccount createSavingsAccount() {
		
		SavingsAccount savingsAccount = new SavingsAccount();
		savingsAccount.setAccountNumber(accountGenerator());
		savingsAccount.setAccountBalance(new BigDecimal(0.0));
		dao.save(savingsAccount);
		
		return dao.findByAccountNumber(savingsAccount.getAccountNumber());
	}

	@Override
	public List<SavingsAccount> getAllSavingsAccounts() {
		
		return dao.findAll();
	}
	
	
	private long accountGenerator() {
		return ++count;
	}

	@Override
	public SavingsAccount findByAccountNumber(long accountNumber) {
		
		return dao.findByAccountNumber(accountNumber);
	}

	@Override
	public String getSavingsAccountBalance(Principal principal) {
		User user = registerService.findByUsername(principal.getName());
		
		BigDecimal savingsAccountBalance = user.getSavingsAccount().getAccountBalance();
		return savingsAccountBalance.toString();
	}
	
	

}
