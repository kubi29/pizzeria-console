package main.java.fr.pizzeria.ihm;

import java.util.Scanner;

import main.java.fr.pizzeria.exception.DeletePizzaException;
import main.java.fr.pizzeria.exception.SavePizzaException;
import main.java.fr.pizzeria.exception.UpdatePizzaException;

public abstract  class PizzeriaOptionMenu {
	
	
	public PizzeriaOptionMenu(){
		
	}
	
	public abstract void execute(Scanner sc) throws SavePizzaException, UpdatePizzaException, DeletePizzaException;
	

}
