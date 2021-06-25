package Jessica;

import java.util.HashMap;

public class Emprunt {

	private static int nombre;
	private static Personnel emprunteur;
	private static Produit materiel;

	public Emprunt(int nombre, Personnel emprunteur, Produit materiel) {
		this.nombre = nombre;
		this.emprunteur = emprunteur;
		this.materiel = materiel;
	}
	
	  public static Personnel getEmprunteur() {
			return emprunteur;
	  }

	  public void setEmprunteur(Personnel emprunter) {
			this.emprunteur = emprunteur;
	  }
	  
	  public static String getMateriel() {
		  return materiel.getNom();
	  }
	  
	  public static String getArticle() {
		  return materiel.getDescription();
	  }
	  
	  public static int getNombre() {
			return nombre;
	  }

	  @Override
	  public String toString() {
		  return 
				  "Id : " + getEmprunteur().getIdPersonnel() +
				  " " + getEmprunteur().getNom() +
				  " " + getEmprunteur().getPrenom() +
				  " sexe : " + getEmprunteur().sexe +
				  " date de naissance : " + getEmprunteur().getDateddMMyyyy() +
				  ". Email : " + getEmprunteur().getEmail() +
				  " Département : " + getEmprunteur().getDepartement() +
				  "   Produit [ nom = " + getMateriel() + 
				  ", description = " + getArticle() + " ]"
				   ;
	  }


}
