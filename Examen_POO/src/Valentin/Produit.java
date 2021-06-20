package Valentin;

public class Produit {
	
	String nom;
	String description;
	
	public Produit(String nom, String description) {
		this.nom=nom;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Produit [nom = "+this.nom+" , description =  "+this.description+" ]\n";
	}

}
