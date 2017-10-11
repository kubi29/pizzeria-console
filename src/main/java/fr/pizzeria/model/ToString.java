package main.java.fr.pizzeria.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {

	public boolean uppercase()  default false;

	

	
}


