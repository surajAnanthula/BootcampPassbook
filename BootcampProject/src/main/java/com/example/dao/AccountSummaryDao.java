package com.example.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.AccountDetails;
import com.example.entity.TransactionsDone;
@Repository
public interface AccountSummaryDao extends JpaRepository<AccountDetails,Integer>{

	//jpa query to get all the transactions between given dates
	@Query("select p from TransactionsDone p where account_Id=?1 and p.transDate>=?2 and p.transDate<=?3") 
	List<TransactionsDone> getSummary(Long accountId,Date startDate, Date endDate);
	
	//jpa query for validating account
	@Query("select d from AccountDetails d where d.accountId=?1")		
	List<AccountDetails> fetch(Long accountId);
	
	//updating the last date of passbook updation
	@Modifying
	@Query("update AccountDetails set lastTransaction=?2 where accountId=?1") //jpa query for updating last transaction date in accountDetails
	void update(Long accountId, Date date);
	
	//jpa query for printing pasbookbased on last date of updation
	@Query("select p from TransactionsDone p where account_Id=?1 and p.transDate>=(select a.lastTransaction from AccountDetails a where a.accountId=?1)")	
	List<TransactionsDone> getTransactions(Long accountId);
	
	
	
	

}
