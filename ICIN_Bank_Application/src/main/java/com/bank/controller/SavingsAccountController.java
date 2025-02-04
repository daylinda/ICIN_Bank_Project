package com.bank.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bank.model.SavingsAccount;
import com.bank.model.SavingsTransfers;
import com.bank.model.User;
import com.bank.service.RegisterService;
import com.bank.service.SavingsAccountService;
import com.bank.service.SavingsTransfersService;


@Controller
public class SavingsAccountController {
	
	
	@Autowired
	private SavingsTransfersService transfersService;
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private SavingsAccountService savingsAccountService;
	
//	@PostMapping("/savingsAccount")
//	public SavingsAccount createSavingsAccount() {
//		return savingsAccountService.createSavingsAccount();
//	}
	
	@GetMapping("/savingsAccount/accountBalance/{accountNumber}")
	public String getSavingsAccountBalance(Principal principal) {
		
		return savingsAccountService.getSavingsAccountBalance(principal);
		
	}
	
	@RequestMapping("/savingsAccount")
    public String savingsAccount(Model model, Principal principal) {
		List<SavingsTransfers> savingsTransactionList = transfersService.findSavingsTransfersList(principal.getName());
        User user = registerService.findByUsername(principal.getName());
        SavingsAccount savingsAccount = user.getSavingsAccount();

        model.addAttribute("savingsAccount", savingsAccount);
        model.addAttribute("savingsTransactionList", savingsTransactionList);

        return "savingsAccount";
    }

	

}