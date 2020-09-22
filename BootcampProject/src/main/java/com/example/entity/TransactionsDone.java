package com.example.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//This class gives all the attributes in passbook
@Entity								//Refers Present class will map to a table in database
@Table(name="Passbook")				//Name of the table
public class TransactionsDone {
	@Id 							//PrimaryKey
	@Column(length=5) 				 //Customizing column length
	private int transactionId;
	@Column(length=10)
	private String transactionType;
	@Column(length=10)
	private float transactionAmount;
	@Column(length=10)
	private Date transDate;
	@Column(length=10)
	private String transFrom;
	@Column(length=10)
	private String transTo;
    
	//constructor for entity class
	public TransactionsDone(int transactionId, String transactionType, float transactionAmount,
			Date transDate, String transFrom, String transTo) {
		super();
		//this.accountId = accountId;
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transDate = transDate;
		this.transFrom = transFrom;
		this.transTo = transTo;
	}

	//Getter and setter methods
	public TransactionsDone(){
		
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public String getTransFrom() {
		return transFrom;
	}

	public void setTransFrom(String transFrom) {
		this.transFrom = transFrom;
	}

	public String getTransTo() {
		return transTo;
	}

	public void setTransTo(String transTo) {
		this.transTo = transTo;
	}

	
}

