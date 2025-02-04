package com.bank.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.UserDAO;
import com.bank.model.SavingsAccount;
import com.bank.model.User;
import com.bank.service.RegisterService;
import com.bank.service.SavingsAccountService;


@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private UserDAO dao;
	
	@Autowired
	private SavingsAccountService savingsAccountService;
	
	@Override
	public User createUser(User user) {
		
		user.setSavingsAccount(savingsAccountService.createSavingsAccount());
		
		return dao.save(user);
	}

	@Override
	public User updateUser(User user) {
		return dao.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return dao.findAll();
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}
		
	}	
	