package com.enginnerapp.engineerservice.dao;

import java.util.List;

import com.enginnerapp.engineerservice.model.AccountDetails;
import com.enginnerapp.engineerservice.model.Branch;
import com.enginnerapp.engineerservice.model.PersonInfo;
 

public interface ManagerDao {

	Branch addNewBranch(Branch branch);

	PersonInfo addNewPerson(PersonInfo personInfo);

	int updateCustomer(int accountNumber, PersonInfo personInfo);

	String getPersonId(int customer_id);

	Boolean checkCustomer_id(int customer_id);

	void deleteCustomer(int customer_id);

	public void addAccount(String roleType,int accountId,int balance,int customerId,int managerId,int accountTypeId,int branchId);


	List<AccountDetails> findAccountDetails();

	int updateAccount(int customerId, int accountNumber, String accountType, int balance);

	int deleteAccount(int customerId, int accountNumber, String accountType);

}