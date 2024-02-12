package com.Springboot.BankingApplication.mapper;

import com.Springboot.BankingApplication.Dao.AccountDao;
import com.Springboot.BankingApplication.entity.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDao accountDao) {
		
		Account account = new Account(
				
				accountDao.getId(),
				accountDao.getAccountholdername(),
				accountDao.getBalance()
				
				);
		return account;
		
	}
	
	public static AccountDao mapTAccountDao(Account account) {
		
		AccountDao accountDao = new AccountDao(
				
					account.getId(),
					account.getAccountholdername(),
					account.getBalance()
					
				);
		return accountDao;
	}

	
}
