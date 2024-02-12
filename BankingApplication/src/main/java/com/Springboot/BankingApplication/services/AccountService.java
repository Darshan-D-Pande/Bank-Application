package com.Springboot.BankingApplication.services;

import java.util.List;

import com.Springboot.BankingApplication.Dao.AccountDao;


public interface AccountService {
	
	//abstract method for create account 
	AccountDao createAccount(AccountDao account);

	// abstract method for get / search account by id
	AccountDao getAccountById(Long id);
	
	// abstract method for deposit (add) balance / money by id
	AccountDao deposit(Long id, double amount);
	
	// abstract method for withdraw (remove) balance by id
	AccountDao withdraw(Long id, double amount);
	
	// abstract method for get All accounts 
	List<AccountDao> getAllAccounts();
	
	//	abstract method for delete account by id
	void deleteAccount(Long id);
}
