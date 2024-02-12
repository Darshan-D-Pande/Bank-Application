package com.Springboot.BankingApplication.services.impl;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Springboot.BankingApplication.Dao.AccountDao;
import com.Springboot.BankingApplication.entity.Account;
import com.Springboot.BankingApplication.mapper.AccountMapper;
import com.Springboot.BankingApplication.repository.AccountRepository;
import com.Springboot.BankingApplication.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	private AccountRepository accountRepository;
	
	
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}


	
	//implementation method for service layer for create account 
	@Override
	public AccountDao createAccount(AccountDao accountDao) {
		
		Account account = AccountMapper.mapToAccount(accountDao);
		Account savedAccount = accountRepository.save(account);
		
		return AccountMapper.mapTAccountDao(savedAccount);
	}
	
	//implementation method for service layer for get account by id 
	@Override
	public AccountDao getAccountById(Long id){
		
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
		
		return AccountMapper.mapTAccountDao(account);
	}


	//implementation method for service layer for deposit balance 
	@Override
	public AccountDao deposit(Long id, double amount) {
		
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
		
		double totalBalance = account.getBalance()+amount;
		account.setBalance(totalBalance);
		Account savedAccount = accountRepository.save(account);
		
		return AccountMapper.mapTAccountDao(savedAccount);
	}


	//implementation method for service layer for withdraw balance
	@Override
	public AccountDao withdraw(Long id, double amount) {
		
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
		
		if(account.getBalance()<amount)
		{
			throw new RuntimeException("Insufficient Balance");
		}
		
		double totalBalance = account.getBalance()-amount;
		account.setBalance(totalBalance);
		Account savedAccount = accountRepository.save(account);
		
		return AccountMapper.mapTAccountDao(savedAccount);
	}


	//implementation method for service layer for get all accounts
	@Override
	public List<AccountDao> getAllAccounts() {
		
		return accountRepository.findAll().stream().map((account)->AccountMapper.mapTAccountDao(account)).
				collect(Collectors.toList());
		
	}


	//implementation method for service layer for delete account
	@Override
	public void deleteAccount(Long id) {
		
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
		
		accountRepository.delete(account);
	}



	
	
	

}
