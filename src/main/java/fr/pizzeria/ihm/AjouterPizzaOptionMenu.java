package main.java.fr.pizzeria.ihm;

import java.util.Scanner;

import main.java.fr.pizzeria.dao.IPizzaDao;
import main.java.fr.pizzeria.exception.SavePizzaException;
import main.java.fr.pizzeria.model.CategoriePizza;
import main.java.fr.pizzeria.model.Pizza;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AjouterPizzaOptionMenu extends PizzeriaOptionMenu{

	private static final Logger LOG = LoggerFactory.getLogger(AjouterPizzaOptionMenu.class);
	
	IPizzaDao dao;
	
	public AjouterPizzaOptionMenu(IPizzaDao dao){
		
		this.dao = dao;
	}
	
	public void execute(Scanner sc) throws SavePizzaException{
		
		
		LOG.info("Ajout d’une nouvelle pizza");
		
		
		LOG.info("Veuillez saisir le code");
		String code =  sc.next().toUpperCase() ;
		
		if( code.trim().isEmpty() || code.length() != 3){
				
			throw new SavePizzaException("Le code doit faire 3 caractère");
				
		}
		LOG.info("Veuillez saisir le nom (sans espace)");
		String nom =  sc.next();
		if(nom.trim().isEmpty()){
			throw new SavePizzaException("Le nom doit étre renseigner");
		}
		System.out.println("Veuillez saisir le prix");
		float prix = sc.nextFloat();
	
		if(prix == 0){
			throw new SavePizzaException("Le prix doit étre renseigner");
		}
		
		LOG.info("Veuillez choisir le type");
		LOG.info("1 : Viande");
		LOG.info("2 : Sans Viande");
		LOG.info("3 : Poisson");
		
		int type = sc.nextInt();
		
		if(type == 1 ){
			
			if(!dao.saveNewPizza(new Pizza(code.toUpperCase(), nom, prix, CategoriePizza.VIANDE))){

				throw new SavePizzaException("Code déjà existant");
			}
			
			
		}else if (type == 2) {
			
			if(!dao.saveNewPizza(new Pizza(code.toUpperCase(), nom, prix, CategoriePizza.SANS_VIANDE))){

				throw new SavePizzaException("Code déjà existant");
			}
			
		}else if (type == 3) {
			
			if(!dao.saveNewPizza(new Pizza(code.toUpperCase(), nom, prix, CategoriePizza.POISSON))){

				throw new SavePizzaException("Code déjà existant");
			}
			
		}	
		
	}
}
