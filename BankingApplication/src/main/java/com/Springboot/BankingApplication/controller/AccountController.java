package com.Springboot.BankingApplication.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.BankingApplication.Dao.AccountDao;
import com.Springboot.BankingApplication.services.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	private AccountService accountService;
	
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	// add account api
	@PostMapping
	public ResponseEntity<AccountDao> addAccount(@RequestBody AccountDao accountDao)
	{
		return new ResponseEntity<>(accountService.createAccount(accountDao), HttpStatus.CREATED);
	}
	
	// get account by id api
	@GetMapping("/{id}")
	public ResponseEntity<AccountDao> getAccountById(@PathVariable Long id){
		
		AccountDao accountDao = accountService.getAccountById(id);
		
		return ResponseEntity.ok(accountDao);
	}
	
	// deposit (add) balance to account api
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDao> deposit(@PathVariable Long id,@RequestBody Map<String, Double> request)
	{
		Double amount = request.get("amount");
		AccountDao accountDao = accountService.deposit(id, amount);
		
		return ResponseEntity.ok(accountDao);
	}
	
	// withdraw (remove) balance account api
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDao> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request)
	{
		Double amount = request.get("amount");
		AccountDao accountDao = accountService.withdraw(id, amount);
		
		return ResponseEntity.ok(accountDao);
	}
	
	// get all accounts api
	@GetMapping
	public ResponseEntity<List<AccountDao>>getAllAccounts()
	{
		List<AccountDao> accountDao = accountService.getAllAccounts();
		
		return ResponseEntity.ok(accountDao);
	}
	
	// delete account by id api
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteAccount(@PathVariable Long id){
		
		accountService.deleteAccount(id);
		
		return ResponseEntity.ok("Account deleted successfully !");
	}
}
