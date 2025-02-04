package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.User;
import com.bank.service.RegisterService;


@RestController
public class RegisterController{
	
	@Autowired
	private RegisterService service;
	
	private MultiValueMap<String, String> map;
	@PostMapping("/registration")
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}

	@PutMapping("/user")
	public User updateUser(User user) {
		
		return service.updateUser(user);
	}

		
	@GetMapping("/users")
	public List<User> getAllUsers() {
		
		return service.getAllUsers();
	}

	
	
}