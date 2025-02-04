package com.bank.service;

import java.security.Principal;
import java.util.List;

import com.bank.model.SavingsTransfers;

public interface SavingsTransfersService {
	
	public List<SavingsTransfers> findSavingsTransfersList(String username);

	public void toSomeoneElseTransfer(long receiverAccountNumber,String amount,String recipient,Principal principal);

}
