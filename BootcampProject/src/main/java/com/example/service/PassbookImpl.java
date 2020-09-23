package com.example.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.AccountSummaryDao;
import com.example.dao.AddTransactionsDao;
import com.example.entity.AccountDetails;
import com.example.entity.TransactionsDone;


@Service
@Transactional
public  class PassbookImpl implements PassbookService{
	
@Autowired
private AccountSummaryDao adao;

long millis=System.currentTimeMillis();  
Date date=new Date(millis); 

	@Override		
	public List<TransactionsDone> accountSummary(Long accountId, Date startDate, Date endDate) {
		List<TransactionsDone> transInfo=adao.getSummary(accountId,startDate,endDate);
		updateLastUpdated(accountId);
		return transInfo;
	}

	@Override
	public List<TransactionsDone> updatePassbook(Long accountId) {
		//AccountDetails updateinfo=adao.getTransactions(accountId);
		List<TransactionsDone> details=adao.getTransactions(accountId);
		updateLastUpdated(accountId);
		System.out.println(details);
		return details;
	}
	
	@Override
	public List<AccountDetails> accountValidation(Long accountId) {
		List<AccountDetails> details=adao.fetch(accountId);
		
		return details;
	}

	@Override
	public AccountDetails postDetails(AccountDetails acc) {	
		return adao.save(acc);
		
	}

	@Override
	public void updateLastUpdated(Long accountId) {
	adao.update(accountId,date);
		
	}
}

	
	

	

