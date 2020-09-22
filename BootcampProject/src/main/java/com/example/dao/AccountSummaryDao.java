package com.example.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.AccountDetails;
import com.example.entity.TransactionsDone;
@Repository
public interface AccountSummaryDao extends JpaRepository<AccountDetails,Integer>{

	@Query("select p from TransactionsDone p where account_Id=?1 and p.transDate>=?2 and p.transDate<=?3")
	//@Query("select p from TransactionsDone p where account_Id=?1 and p.transDate BETWEEN : ?2 AND : ?3")
	List<TransactionsDone> getSummary(Long accountId,Date startDate, Date endDate);
	
	//boolean existsById(Long accountId);
	//TransactionsDone save(TransactionsDone transactions);
	@Query("select d from AccountDetails d where d.accountId=?1")
	List<AccountDetails> fetch(Long accountId);
	
	
	

}
