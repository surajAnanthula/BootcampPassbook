package com.example.dao;

import java.util.List;

import com.example.entity.AccountDetails;

public interface AddTransactionsDao {

	List<AccountDetails> save(AccountDetails acc);

}
