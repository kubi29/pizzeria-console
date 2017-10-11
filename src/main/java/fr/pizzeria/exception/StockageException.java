package main.java.fr.pizzeria.exception;

public class StockageException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4L;

	public StockageException() {
		
	}
	
	public StockageException(String msg) {
		
		super(msg);
		
	}
}
