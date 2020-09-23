package com.example.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.AccountDetails;
import com.example.entity.TransactionsDone;
import com.example.exceptions.IdNotFound;
import com.example.exceptions.NoTransactions;
import com.example.service.PassbookService;

@RestController//Helps to eliminate use of @Responsebody in every request handling method 
@RequestMapping("/Pasbook")
public class PassbookController {
	@Autowired
	private PassbookService service1;
	
	@GetMapping("/accountSummary/{accountId}/{startDate}/{endDate}")	//http request to get all transactions of an account within givet dates
	public List<TransactionsDone> accountSummary(@PathVariable Long accountId,@PathVariable Date startDate,@PathVariable Date endDate) throws IdNotFound,NoTransactions
	{
		List<AccountDetails> account=service1.accountValidation(accountId);	//Account Validation method
		if(account.isEmpty())
		{
			throw new IdNotFound("AccountId does not exists");	//AccountId  not found exception
		}
		else
		{
			List<TransactionsDone> t=service1.accountSummary(accountId,startDate,endDate);//retuen transactions based on accountId, startDate and endDate
			if(t.isEmpty())
			{
				throw new NoTransactions("no Transactions found");
			}
			else {
			return t;
			}
		}
	 }
	
	@GetMapping("/updatePabook/{accountId}")
	public List<TransactionsDone> updatePassbook(@PathVariable Long accountId) throws IdNotFound,NoTransactions
	{
		List<AccountDetails> account1=service1.accountValidation(accountId);
		if(account1.isEmpty())
		{
			throw new IdNotFound("AccountId does not exist");
		}
		else {
			List<TransactionsDone> trns=service1.updatePassbook(accountId);
			if(trns.isEmpty())
			{
				throw new NoTransactions("no Transactions found");
			}
			else
			{
			return trns;
			}
		}
		
	}
	
	//method to add transactions 
	@PostMapping("/postdata")
	public AccountDetails postDetails(@RequestBody AccountDetails acc) {
		
		AccountDetails result= service1.postDetails(acc);
		return result;
		
	}
}
