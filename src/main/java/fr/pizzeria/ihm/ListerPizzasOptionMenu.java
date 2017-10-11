package main.java.fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.fr.pizzeria.dao.IPizzaDao;
import main.java.fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends PizzeriaOptionMenu {
	
	IPizzaDao dao;
	
	private static final Logger LOG = LoggerFactory.getLogger(ListerPizzasOptionMenu.class);
	
	public ListerPizzasOptionMenu (IPizzaDao dao){
		
		
		this.dao = dao;
		
	}
	
	
	public void execute(Scanner sc){
		
		LOG.info("Liste des pizzas");
		
		for (Pizza pizza : dao.findAllPizzas()) {
			System.out.println(pizza);
		}
		
	}

}
