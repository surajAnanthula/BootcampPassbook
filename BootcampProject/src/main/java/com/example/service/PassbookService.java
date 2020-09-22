package com.example.service;

import java.sql.Date;
import java.util.List;

import com.example.entity.AccountDetails;
import com.example.entity.TransactionsDone;

public interface PassbookService {

	List<TransactionsDone> accountSummary(Long accountId, Date startDate, Date endDate);

	List<AccountDetails> accountValidation(Long accountId);


	AccountDetails postDetails(AccountDetails acc);

	

}

