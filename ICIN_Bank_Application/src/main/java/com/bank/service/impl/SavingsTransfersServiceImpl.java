package com.bank.service.impl;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.SavingsAccountDAO;
import com.bank.dao.SavingsTransfersDAO;
import com.bank.model.SavingsAccount;
import com.bank.model.SavingsTransfers;
import com.bank.model.User;
import com.bank.service.RegisterService;
import com.bank.service.SavingsTransfersService;


@Service
public class SavingsTransfersServiceImpl implements SavingsTransfersService{
	
	@Autowired
	private SavingsTransfersDAO savingsTransfersDao;
	
	@Autowired
	private SavingsAccountDAO savingsAccountDao;

	@Autowired
	private RegisterService registerService;
	
	

	@Override
	public void toSomeoneElseTransfer(long recipientAccountNumber, String amount, String recipient,Principal principal) {
		
		User user = registerService.findByUsername(principal.getName());
		long userAccountNumber = user.getSavingsAccount().getAccountNumber();
		
		BigDecimal amountToBeTransfered = new BigDecimal(amount);
		
		SavingsAccount userSavingsAccount = savingsAccountDao.findByAccountNumber(userAccountNumber);
		SavingsAccount recipientSavingsAccount = savingsAccountDao.findByAccountNumber(recipientAccountNumber);
		Date date = new Date();
		if(userSavingsAccount.getAccountBalance().compareTo(amountToBeTransfered)==1||userSavingsAccount.getAccountBalance().compareTo(amountToBeTransfered)==0) {
			userSavingsAccount.setAccountBalance(userSavingsAccount.getAccountBalance().subtract(amountToBeTransfered));
			
			if(recipientSavingsAccount!=null) {
				recipientSavingsAccount.setAccountBalance(recipientSavingsAccount.getAccountBalance().add(amountToBeTransfered));
				savingsAccountDao.save(recipientSavingsAccount);
			}
			
			savingsAccountDao.save(userSavingsAccount);
			SavingsTransfers savingsTransfers = new SavingsTransfers(date, recipient, recipientAccountNumber, Double.parseDouble(amount),"Finsihed",userSavingsAccount);
			savingsTransfersDao.save(savingsTransfers);
		}else {
			SavingsTransfers savingsTransfers = new SavingsTransfers(date, recipient, recipientAccountNumber, Double.parseDouble(amount),"Cancelled,Inadequate balance",userSavingsAccount);
			savingsTransfersDao.save(savingsTransfers);
		}
				
	}




	public List<SavingsTransfers> findSavingsTransfersList(String username) {
        User user = registerService.findByUsername(username);
        List<SavingsTransfers> savingsTransfersList = user.getSavingsAccount().getSavingsTransfersList();

        return savingsTransfersList;
    }


}
