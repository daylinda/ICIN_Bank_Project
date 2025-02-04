package com.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.UserDAO;
import com.bank.model.Login;
import com.bank.model.User;
import com.bank.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserDAO dao;
	
	@Override
	public User login(Login login) throws Exception {
		User user=null;
		try {
			user=dao.findByUsername(login.getUsername());
			if(!login.getPassword().equals(user.getPassword())) {
				throw new Exception();
			}
		} 
		catch (Exception e) {
			throw new Exception("Username or password is incorrect");
		}
		return user;
	}
}