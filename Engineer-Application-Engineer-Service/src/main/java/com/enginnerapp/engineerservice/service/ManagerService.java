package com.enginnerapp.engineerservice.service;

import java.util.List;

import com.enginnerapp.engineerservice.dao.util.UserDTO;
import com.enginnerapp.engineerservice.model.AccountDetails;
import com.enginnerapp.engineerservice.model.Branch;
import com.enginnerapp.engineerservice.model.PersonInfo;
import com.enginnerapp.engineerservice.model.TransactionDetails;
 


public interface ManagerService {

	Branch addNewBranch(Branch branch);

	PersonInfo addNewPerson(PersonInfo personInfo);

	int updateCustomer(int accountNumber, PersonInfo personInfo);

	String getPersonId(int customer_id);

	Boolean checkCustomer_id(int customer_id);

	void deleteCustomer(int customer_id);

	 
	
public int changePassword(UserDTO userDTO);
	
	public String checkBalance(int accountNumber);

	public String withdrawMoney(int accountNumber, double amount, String description, String userType,
			String transactionType, String accountType);

	public String DepositMoney(int accountNumber, double amount, String description, String userType,
			String transactionType, String accountType);

	public List<TransactionDetails> CustomizedMiniStatement(int accountNumber, double amount, String fromdate,
			String toDate);

	public String fundTransfer(int accountNumber, double amount, String description, String userType,
			String transactionType, String accountType);
	
 


	public List<TransactionDetails> MiniStatement(int accountNumber);

	 
	public List<AccountDetails> findAccountDetails();
	
	int updateAccount(int customerId, int accountNumber, String accountType, int balance);

	int deleteAccount(int customerId, int accountNumber, String accountType);

	 
	public void addAccount(String roleType,int accountId,int balance,int customerId,int managerId,int accountTypeId,int branchId);


	 

}
