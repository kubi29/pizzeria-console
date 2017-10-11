package main.java.fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.fr.pizzeria.dao.IPizzaDao;
import main.java.fr.pizzeria.exception.DeletePizzaException;
import main.java.fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends PizzeriaOptionMenu{
	
	IPizzaDao dao;
	private static final Logger LOG = LoggerFactory.getLogger(SupprimerPizzaOptionMenu.class);
	public SupprimerPizzaOptionMenu(IPizzaDao dao){
		
		
		this.dao = dao;
		
	}
	
	public void execute (Scanner sc) throws DeletePizzaException{
		
		LOG.info("Suppression d’une pizza");
		
		for (Pizza pizza : dao.findAllPizzas()) {
			System.out.println(pizza);
		}
		LOG.info("1 pour supprimer");
		LOG.info("99 pour abandonner");
		LOG.info("Veuillez siasir vote choix");
		
		int choix1 = sc.nextInt();
		
		if(choix1 != 99){
			LOG.info("Veuillez choisir la pizza à supprimer en indiquent son code");
			
			String codeASupprimmer = sc.next().toUpperCase();
			if (codeASupprimmer.trim().isEmpty() || codeASupprimmer.length() != 3){
				throw new DeletePizzaException("Veuiller renseigner le code a supprimer");
			}
			dao.deletePizza(codeASupprimmer);
		
		}
	}
}
