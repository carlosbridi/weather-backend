package com.bridi.weather.exception;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceException(String msgException){
		throw new RuntimeException(msgException);
	}
		
}