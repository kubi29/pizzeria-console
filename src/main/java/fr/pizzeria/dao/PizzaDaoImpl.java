package main.java.fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.Iterator;

import main.java.fr.pizzeria.model.CategoriePizza;
import main.java.fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {

	ArrayList<Pizza> array = new ArrayList<>();

	Pizza pizza1 = new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE);
	Pizza pizza2 = new Pizza("MAR", "Margherita ", 14.00, CategoriePizza.SANS_VIANDE);
	Pizza pizza3 = new Pizza("REI", "La Reine ", 11.50, CategoriePizza.VIANDE);
	Pizza pizza4 = new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE);
	Pizza pizza5 = new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE);
	Pizza pizza6 = new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE);
	Pizza pizza7 = new Pizza("ORI", "L’orientale", 13.50, CategoriePizza.POISSON);
	Pizza pizza8 = new Pizza("IND", "L'indienne", 14.00, CategoriePizza.VIANDE);

	private void addPizza() {

		array.add(pizza1);
		array.add(pizza2);
		array.add(pizza3);
		array.add(pizza4);
		array.add(pizza5);
		array.add(pizza6);
		array.add(pizza7);
		array.add(pizza8);

	}

	@Override
	public ArrayList<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub

		return array;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub

		array.add(pizza);

		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizzaUpdate) {
		// TODO Auto-generated method stub

		for (Pizza pizza : findAllPizzas()) {

			if (codePizza.equals(pizza.getCode())) {
				pizza.setCode(pizzaUpdate.getCode());
				pizza.setNom(pizzaUpdate.getNom());
				pizza.setPrix(pizzaUpdate.getPrix());
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		// TODO Auto-generated method stub

		Iterator<Pizza> iterator = findAllPizzas().iterator();
		while (iterator.hasNext()) {

			Pizza pizza = iterator.next();
			if (codePizza.equals(pizza.getCode())) {
				iterator.remove();
				return true;
			}

		}

		return false;
	}

}
