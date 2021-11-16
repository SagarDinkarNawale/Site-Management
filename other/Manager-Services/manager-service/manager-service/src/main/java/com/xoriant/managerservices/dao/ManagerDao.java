package com.xoriant.managerservices.dao;

import com.xoriant.managerservices.model.Branch;
import com.xoriant.managerservices.model.PersonInfo;

public interface ManagerDao {

	Branch addNewBranch(Branch branch);

	PersonInfo addNewPerson(PersonInfo personInfo);

	int updateCustomer(int accountNumber, PersonInfo personInfo);

	String getPersonId(int customer_id);

	Boolean checkCustomer_id(int customer_id);

	void deleteCustomer(int customer_id);
	public String getOldAccountType(int accountId) ;
	public void addAccount(int managerId,int customerId,int balance ,int branchId,String accountType);
	public int updateAccount(int customerId,int accountNumber,String accountType,int balance);
	public int deleteAccount(int customerId, int accountNumber, String accountType);

}