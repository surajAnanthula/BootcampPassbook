package com.example.exceptions;

@SuppressWarnings("serial")
public class IdNotFound extends Exception{
	public IdNotFound(String msg){
        super(msg);
    }
}
