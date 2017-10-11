package main.java.fr.pizzeria.console;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.fr.pizzeria.dao.PizzaDaoImpl;
import main.java.fr.pizzeria.exception.DeletePizzaException;
import main.java.fr.pizzeria.exception.SavePizzaException;
import main.java.fr.pizzeria.exception.UpdatePizzaException;
import main.java.fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import main.java.fr.pizzeria.ihm.ListerPizzasOptionMenu;
import main.java.fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import main.java.fr.pizzeria.ihm.SupprimerPizzaOptionMenu;

public class PizzeriaAdminConsoleApp {

	public static final Scanner sc = new Scanner(System.in);

	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		menu();

		int choix = sc.nextInt();

		PizzaDaoImpl array = new PizzaDaoImpl();

		do {

			if (choix == 1) {

			} else if (choix == 2) {

				AjouterPizzaOptionMenu ajouter = new AjouterPizzaOptionMenu(array);

				try {
					ajouter.execute(sc);
				} catch (SavePizzaException e) {
					System.out.println(e.getMessage());
				}

			} else if (choix == 3) {

				ModifierPizzaOptionMenu modifier = new ModifierPizzaOptionMenu(array);

				try {
					modifier.execute(sc);
				} catch (UpdatePizzaException e) {
					System.out.println(e.getMessage());
				}

			} else if (choix == 4) {

				SupprimerPizzaOptionMenu supprimer = new SupprimerPizzaOptionMenu(array);

				try {
					supprimer.execute(sc);
				} catch (DeletePizzaException e) {
					System.out.println(e.getMessage());
				}

			}

			ListerPizzasOptionMenu lister = new ListerPizzasOptionMenu(array);

			lister.execute(sc);

			menu();

			choix = sc.nextInt();

		} while (choix != 99);

		LOG.info("Aurevoir");

	}

	private static void menu() {
		
		LOG.info("***** Pizzeria Administration *****");
		LOG.info("1. Lister les pizzas");
		LOG.info("2. Ajouter une nouvelle pizza");
		LOG.info("3. Mettre à jour une pizza");
		LOG.info("4. Supprimer une pizza");
		LOG.info("99. Sortir");

	}

}
