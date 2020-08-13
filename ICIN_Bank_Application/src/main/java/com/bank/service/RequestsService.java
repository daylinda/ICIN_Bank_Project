package com.bank.service;

import java.util.List;

import com.bank.model.Requests;

public interface RequestsService {
	
	public void createRequests(String requestType,String requestDiscription);
	public void acceptRequests(int requestId);
	public List<Requests> findAllRequests();
	public void deleteRequests(int requestId);

}
