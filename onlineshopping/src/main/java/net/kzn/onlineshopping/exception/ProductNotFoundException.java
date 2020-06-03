package net.kzn.onlineshopping.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public ProductNotFoundException() {    //constructor
		 this("Product is not available");
	}
	
	public ProductNotFoundException(String message) {		//also a constructor
		this.message=System.currentTimeMillis()+ ": " + message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
