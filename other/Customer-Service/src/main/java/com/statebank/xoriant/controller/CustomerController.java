package com.statebank.xoriant.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.statebank.xoriant.model.AccountDetails;
import com.statebank.xoriant.model.Address;
import com.statebank.xoriant.model.CustomerDTO;
import com.statebank.xoriant.model.TransactionDetails;
import com.statebank.xoriant.service.CustomerService;



@RestController
@RequestMapping("/api/customer")
@CrossOrigin
@RefreshScope
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PutMapping("/editAddress/{customer_id}")
	public Address editAddress(@RequestBody Address address,@PathVariable int customer_id) {
		return customerService.editAddress(address,customer_id);
	}
	

	
	@GetMapping("/viewAccountList/{customer_id}")
	public List<AccountDetails> viewAllAccounts(@PathVariable int customer_id){
		return customerService.viewAllAccounts(customer_id);
	}
	@GetMapping("/findAccountDetails") // manager method
	public List<AccountDetails> findAccountDetails(){
		return customerService.findAccountDetails();
	}
	
	@GetMapping("/withdraw")
	public String withdrawMoney(@RequestBody CustomerDTO customerDTO) {
		String balance = customerService.withdrawMoney(customerDTO.getAccountNumber(),customerDTO.getAmount(),customerDTO.getDescription(),
				customerDTO.getUserType(),customerDTO.getTransactionType(),customerDTO.getAccountType());
		
		return balance;
	}
	@GetMapping("/deposite")
	public String DepositMoney(@RequestBody CustomerDTO customerDTO) {
		String balance = customerService.DepositMoney(customerDTO.getAccountNumber(),customerDTO.getAmount(),customerDTO.getDescription(),
				customerDTO.getUserType(),customerDTO.getTransactionType(),customerDTO.getAccountType());
		return balance;
		
		
	}
	@GetMapping("/miniStatement/{accountNumber}")
	public List<TransactionDetails> MiniStatement(@PathVariable int accountNumber){
		
		List<TransactionDetails> list =customerService.MiniStatement(accountNumber);
		
		return list;
		
	}
	@GetMapping("/customizedStatement")
	public List<TransactionDetails> CustomizedMiniStatement(@RequestBody CustomerDTO customerDTO){
		
		List<TransactionDetails> list = customerService.CustomizedMiniStatement(customerDTO.getAccountNumber(),customerDTO.getAmount(),customerDTO.getFormDate(),
				customerDTO.getToDate());
		
		return list;
	}
	@GetMapping("/fundTransfer")
	public String fundTransfer(@RequestBody CustomerDTO customerDTO) {
		
		String balance = customerService.fundTransfer(customerDTO.getAccountNumber(),customerDTO.getAmount(),customerDTO.getDescription(),
				customerDTO.getUserType(),customerDTO.getTransactionType(),customerDTO.getAccountType());
		return balance;
		
	}
	
	
	  @GetMapping("/checkBalance/{accountNumber}")
	  public String checkBalance(@PathVariable int accountNumber) {
	  
	  String balance = customerService.checkBalance(accountNumber);
	  
	  return balance; }
	 

}
