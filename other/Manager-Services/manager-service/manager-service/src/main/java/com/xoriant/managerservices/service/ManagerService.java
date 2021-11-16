package com.xoriant.managerservices.service;

import com.xoriant.managerservices.model.Branch;
import com.xoriant.managerservices.model.PersonInfo;

public interface ManagerService {

	Branch addNewBranch(Branch branch);

	PersonInfo addNewPerson(PersonInfo personInfo);

	int updateCustomer(int accountNumber, PersonInfo personInfo);

	String getPersonId(int customer_id);

	Boolean checkCustomer_id(int customer_id);

	void deleteCustomer(int customer_id);

	void addAccount(String roleType, int accountId, int balance, int customerId, int managerId, int accountTypeId,
			int branchId);

	void addAccount(String userId, int customerId, int balance, int branchId, String accountType);
	public int updateAccount(int customerId,int accountNumber,String accountType,int balance);
	public int deleteAccount(int customerId, int accountNumber, String accountType);


	 

	

}
