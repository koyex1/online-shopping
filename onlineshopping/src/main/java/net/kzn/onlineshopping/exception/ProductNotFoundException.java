package net.kzn.onlineshopping.exception;

public class ProductNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public ProductNotFoundException() {
		this("Product is not available");
	}
	
	public ProductNotFoundException(String message) {
		this.message=System.currentTimeMillis()+ ": " + message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
