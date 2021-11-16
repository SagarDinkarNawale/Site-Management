package com.statebank.xoriant.service;

import java.util.List;

import com.statebank.xoriant.dao.util.CustomerDTO;
import com.statebank.xoriant.model.TransactionDetails;

public interface TransactionService {


	public	String withdrawMoney(CustomerDTO customerDTO);

	public	String DepositMoney(CustomerDTO customerDTO);

	public	List<TransactionDetails> MiniStatement(int accountNumber);

	public	List<TransactionDetails> CustomizedMiniStatement(CustomerDTO customerDTO);

	public	String fundTransfer(CustomerDTO customerDTO);

	public	String checkBalance(int accountNumber);

}
