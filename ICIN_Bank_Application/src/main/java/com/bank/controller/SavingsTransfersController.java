package com.bank.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.model.User;
import com.bank.service.RegisterService;
import com.bank.service.SavingsTransfersService;



@Controller
public class SavingsTransfersController {
	
	@Autowired
	private SavingsTransfersService savingsTransferService; 
	
	@Autowired
	private RegisterService registerService;

//	@PostMapping("/tranfers")
//	public void totransferToOtherUser(@RequestParam("recipientAccountNumber")long receiverAccountNumber,@RequestParam("amount") String amount, @RequestParam("recipient")String recipient,Principal principal) {
//		
//		savingsTransferService.toSomeoneElseTransfer(receiverAccountNumber, amount, recipient, principal);
//		
//	}
	
    @RequestMapping(value = "/toSomeoneElse",method = RequestMethod.GET)
    public String toSomeoneElse(Model model, Principal principal) {
        
        model.addAttribute("recipientAccountNumber", "");
        model.addAttribute("recipient", "");

        return "toSomeoneElse";
    }
	
	@RequestMapping(value = "/toSomeoneElse",method = RequestMethod.POST)
    public String toSomeoneElsePost(@ModelAttribute("recipientAccountNumber") long receiverAccountNumber, @ModelAttribute("amount") String amount,@ModelAttribute("recipient") String recipient, Principal principal) {
        User user = registerService.findByUsername(principal.getName());
        
        savingsTransferService.toSomeoneElseTransfer(receiverAccountNumber, amount, recipient, principal);

        return "redirect:/ICINBank";
    }


	
	
	

}
