package main.java.fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.fr.pizzeria.dao.IPizzaDao;
import main.java.fr.pizzeria.exception.UpdatePizzaException;
import main.java.fr.pizzeria.model.CategoriePizza;
import main.java.fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends PizzeriaOptionMenu {

	IPizzaDao dao;

	private static Logger LOG = LoggerFactory.getLogger(ModifierPizzaOptionMenu.class);

	public ModifierPizzaOptionMenu(IPizzaDao dao) {

		this.dao = dao;

	}

	public void execute(Scanner sc) throws UpdatePizzaException {

		LOG.info("Mise à jour d’une pizza");

		for (Pizza pizza : dao.findAllPizzas()) {
			System.out.println(pizza);
		}

		LOG.info("99 pour abandonner");
		LOG.info("Veuillez choisir la pizza à modifier");

		int result = sc.nextInt();

		if (result != 99) {
			LOG.info("Veuillez saisir le code de la pizza à modifier");
			String codeAModifier = sc.next();

			for (Pizza pizza : dao.findAllPizzas()) {

				if (codeAModifier.equals(pizza.getCode())) {
					LOG.info("Veuillez saisir le code");
					String code = sc.next().toUpperCase();
					if (code.trim().isEmpty() || code.length() != 3) {

						throw new UpdatePizzaException("Le code doit faire 3 caractère");

					}
					LOG.info("Veuillez saisir le nom (sans espace)");
					String nom = sc.next();
					if (nom.trim().isEmpty()) {
						throw new UpdatePizzaException("Le nom doit étre renseigner");
					}
					LOG.info("Veuillez saisir le prix");
					float prix = sc.nextFloat();

					if (prix == 0f) {
						throw new UpdatePizzaException("Le prix doit étre renseigner");
					}
					LOG.info("Veuillez choisir le type");
					LOG.info("1 : Viande");
					LOG.info("2 : Sans Viande");
					LOG.info("3 : Poisson");

					int type = sc.nextInt();

					if (type == 1) {

						Pizza p = new Pizza(code, nom, prix, CategoriePizza.VIANDE);
						dao.updatePizza(codeAModifier, p);

					} else if (type == 2) {

						Pizza p = new Pizza(code, nom, prix, CategoriePizza.SANS_VIANDE);
						dao.updatePizza(codeAModifier, p);

					} else if (type == 3) {

						Pizza p = new Pizza(code, nom, prix, CategoriePizza.POISSON);
						dao.updatePizza(codeAModifier, p);

					}

				}
			}

		}

	}
}
