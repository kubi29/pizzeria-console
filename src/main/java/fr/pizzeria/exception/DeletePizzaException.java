package main.java.fr.pizzeria.exception;

public class DeletePizzaException extends StockageException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	
	public DeletePizzaException() {
		
	}
	
	public DeletePizzaException(String msg) {
		
		super(msg);
	
	}

}
