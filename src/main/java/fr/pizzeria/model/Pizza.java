package main.java.fr.pizzeria.model;

import java.lang.reflect.Field;
import java.util.logging.Logger;


public class Pizza {

	protected static Logger LOGGER= Logger.getLogger("erreur");
	
	public Integer id;
	@ToString (uppercase = true)
	public String code;
	@ToString (uppercase = true)
	public String nom;
	@ToString
	public double prix;
	@ToString 
	public CategoriePizza categoriePizza ;

	static Integer increment = 0;
	
	public Pizza (){
		
	}
	
	public Pizza  (String code , String nom , double prix ,CategoriePizza categoriePizza){
		
		
		setId(increment);
		setCode(code);
		setNom(nom);
		setPrix(prix);
		setCategoriePizza(categoriePizza) ;
		increment++;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public CategoriePizza getCategoriePizza() {
		return categoriePizza;
	}

	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categoriePizza = categoriePizza;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		Class<?> thisClass = null;
		
		try {
			
			
			thisClass = Class.forName(this.getClass().getName());
			
			Field[] aClassFields = thisClass.getDeclaredFields();
			
			sb.append(this.getClass().getSimpleName() + " : ");
			
			for(Field f : aClassFields){
				
				String name = f.getName();
				if(f.isAnnotationPresent(ToString.class)){
					
					if(f.getAnnotation(ToString.class).uppercase() ){

						if(name.equals("code")){
							sb.append(code.toUpperCase()  );
						}

						else if(name.equals("nom")){
							sb.append(" -> " + nom.toUpperCase() );
						}

						else if(name.equals("prix")){
							sb.append(" ( " + prix + " ) " );
						}

						else if(name.equals("categoriePizza")){
							sb.append(" type : " + categoriePizza);
						}

					}
					if (!f.getAnnotation(ToString.class).uppercase()){

						if(name.equals("code")){
							sb.append(code  );
						}

						else if(name.equals("nom")){
							sb.append(" -> " + nom );
						}

						else if(name.equals("prix")){
							sb.append(" ( " + prix + " ) " );
						}

						else if(name.equals("categoriePizza")){
							sb.append(" type : " + categoriePizza);
						}
					}
				}
	        }
			
		}  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.log(null, "erreur",e);
		}  
		return sb.toString();

			
	}

	
	
}
