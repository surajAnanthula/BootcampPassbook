package com.example.exceptions;

@SuppressWarnings("serial")
public class NoTransactions extends Exception {
	public NoTransactions(String msg){
        super(msg);
    }

}
