package com.bank.service;

import java.util.List;

import com.bank.model.User;


public interface RegisterService {
	
	public User createUser(User user);
	public User updateUser(User user);
	public List<User> getAllUsers();
	public User findByUsername(String username);

}