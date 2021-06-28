package Aude;

public class Produit {
	
	private static int id;
	private int identifiant = 0;
	private String nom;
	private String description;
	
	public Produit (String nom, String description) {
		this.identifiant = id++;
		this.nom = nom;
		this.description= description;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override public String toString() {;
	
			return String.format( " --- Produit [nom =  %s , description : %s ]", this.getNom(), this.getDescription() );  
 
	}
	
}
