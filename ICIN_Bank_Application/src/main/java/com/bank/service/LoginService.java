package com.bank.service;

import com.bank.model.Login;
import com.bank.model.User;

public interface LoginService {
	
	public User login(Login login) throws Exception;

}