package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.model.Requests;
import com.bank.service.RequestsService;

@Controller
public class RequestsController implements RequestsService{
	
	@Autowired
	private RequestsService requestsService;

	@PostMapping("/request")
	public void createRequests(@RequestParam("requestType")String requestType,@RequestParam("requestDescription")String requestDiscription) {
		
		requestsService.createRequests(requestType, requestDiscription);
		
	}
	
	@PutMapping("/admin/request/{requestId}")
	public void acceptRequests(@PathVariable int requestId) {
		
		requestsService.acceptRequests(requestId);
		
	}

	@GetMapping("/admin/requests")
	public List<Requests> findAllRequests() {
		
		return requestsService.findAllRequests();
	}

	@Override
	public void deleteRequests(int requestId) {
		
		requestsService.deleteRequests(requestId);
		
	}
	
	

}
