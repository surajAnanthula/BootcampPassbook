package com.example.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class AccountDetails {
	@Id   //primary Key
	@Column(name="accountId",length=12)  //name and length of column      
	private long accountId;
	@Column(length=15)
	private String branch;
	@Column(length=15)
	private String accountType;
	@Column(length=8)
	private float amount;
	@Column(length=10)
	private Date lastTransaction;

	
	
	  //Using OneToMany to cascade one table to other
	  
	  @OneToMany(targetEntity=TransactionsDone.class,cascade=CascadeType.ALL)
	//@OneToMany(mappedBy="mainMenu",cascade=CascadeType.ALL)
	  @JoinColumn(name="accountId",referencedColumnName="accountId")
	  private List<TransactionsDone> transactionsDone=new ArrayList<TransactionsDone>();
	  
	  public List<TransactionsDone> getTransactionsDone() 
	  { 
		  return transactionsDone; 
	  } 
	  public void setTransactionsDone(List<TransactionsDone> transactionsDone)
	  {
		  this.transactionsDone = transactionsDone;
	  }
	 
	 
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getLastTransaction() {
		return lastTransaction;
	}
	public void setLastTransaction(Date lastTransaction) {
		this.lastTransaction = lastTransaction;
	}
	public AccountDetails(long accountId, String branch, String accountType, float amount, Date lastTransaction,List<TransactionsDone> transactionsDone) {
		super();
		this.accountId = accountId;
		this.branch = branch;
		this.accountType = accountType;
		this.amount = amount;
		this.lastTransaction = lastTransaction;
		this.transactionsDone = transactionsDone;
	}
	public AccountDetails()
	{
		
	}
	
	
}
