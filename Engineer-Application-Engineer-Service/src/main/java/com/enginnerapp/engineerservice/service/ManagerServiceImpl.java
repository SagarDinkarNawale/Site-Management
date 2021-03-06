package com.enginnerapp.engineerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enginnerapp.engineerservice.dao.ManagerDao;
import com.enginnerapp.engineerservice.dao.util.UserDTO;
import com.enginnerapp.engineerservice.model.AccountDetails;
import com.enginnerapp.engineerservice.model.Branch;
import com.enginnerapp.engineerservice.model.PersonInfo;
import com.enginnerapp.engineerservice.model.TransactionDetails;
 

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerDao managerDao;	
	
//	 @Autowired(required = false) 
//	private UserServiceProxy userServiceProxy;
//	
//	@Autowired
//	private TransactionServiceProxy transactionServiceProxy;
	
	@Override
	public Branch addNewBranch(Branch branch) {
		// TODO Auto-generated method stub
		return managerDao.addNewBranch(branch);
	}

	@Override
	public PersonInfo addNewPerson(PersonInfo personInfo) {
		// TODO Auto-generated method stub
		return managerDao.addNewPerson(personInfo);
	}

	@Override
	public int updateCustomer(int accountNumber, PersonInfo personInfo) {
		// TODO Auto-generated method stub
		return managerDao.updateCustomer(accountNumber, personInfo);
	}

	@Override
	public String getPersonId(int customer_id) {
		// TODO Auto-generated method stub
		return managerDao.getPersonId(customer_id);
	}

	@Override
	public Boolean checkCustomer_id(int customer_id) {
		// TODO Auto-generated method stub
		return managerDao.checkCustomer_id(customer_id);
	}

	@Override
	public void deleteCustomer(int customer_id) {
		managerDao.deleteCustomer(customer_id);
	}

	@Override
	public void addAccount(String roleType,int accountId,int balance,int customerId,int managerId,int accountTypeId,int branchId)
 {
		managerDao.addAccount(roleType, accountId, balance, customerId, managerId, accountTypeId, branchId);
		
	}
	@Override
	public int changePassword(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return  0;//userServiceProxy.changePassword(userDTO);
	}
	@Override
	public String withdrawMoney(int accountNumber, double amount, String description, String userType,
			String transactionType, String accountType) {
		// TODO Auto-generated method stub
		return "";//transactionServiceProxy.withdrawMoney(accountNumber, amount, description, userType, transactionType, accountType);
	}
	@Override
	public String DepositMoney(int accountNumber, double amount, String description, String userType,
			String transactionType, String accountType) {
		// TODO Auto-generated method stub
		return "";//return transactionServiceProxy.DepositMoney(accountNumber, amount, description, userType, transactionType, accountType);
	}
	@Override
	public List<TransactionDetails> CustomizedMiniStatement(int accountNumber, double amount, String fromDate,
			String toDate) {
		// TODO Auto-generated method stub
		return null;//return transactionServiceProxy.CustomizedMiniStatement(accountNumber, amount, fromDate, toDate);
	}
	@Override
	public String fundTransfer(int accountNumber, double amount, String description, String userType,
			String transactionType, String accountType) {
		// TODO Auto-generated method stub
		return "";//return transactionServiceProxy.fundTransfer(accountNumber, amount, description, userType, transactionType, accountType);
	}

	  @Override
	  public String checkBalance(int accountNumber) { 
	
		  return "";//return transactionServiceProxy.checkBalance(accountNumber); 
	  }

	@Override
	public List<TransactionDetails> MiniStatement(int accountNumber) {
		// TODO Auto-generated method stub
		return null;//return transactionServiceProxy.MiniStatement(accountNumber);
	}

	@Override
	public List<AccountDetails> findAccountDetails() {
		// TODO Auto-generated method stub
		return managerDao.findAccountDetails();// transactionServiceProxy.find;
	}

	@Override
	public int updateAccount(int customerId, int accountNumber, String accountType, int balance) {
		// TODO Auto-generated method stub
		return managerDao.updateAccount(customerId, accountNumber, accountType, balance);
	}

	@Override
	public int deleteAccount(int customerId, int accountNumber, String accountType) {
		// TODO Auto-generated method stub
		return managerDao.deleteAccount(customerId, accountNumber, accountType);
	}
	


}
