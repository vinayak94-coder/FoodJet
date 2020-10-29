package com.myapp.favourite.exception;

@SuppressWarnings("serial")
public class AlreadyExistException extends Exception{
	
	public AlreadyExistException(String message)
	{
		super(message);
		
	}

}
