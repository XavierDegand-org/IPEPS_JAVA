package Jessica;

import java.util.HashMap;

public class Emprunt {

	private int nombre;
	private Personnel emprunteur;
	private Produit materiel;

	public Emprunt(int nombre, Personnel emprunteur, HashMap<Integer, Produit> hashMap) {
		this.nombre = nombre;
		this.emprunteur = emprunteur;
		this.materiel = materiel;
	}
	
	  public Personnel getEmprunteur() {
			return emprunteur;
	  }

	  public void setEmprunteur(Personnel emprunter) {
			this.emprunteur = emprunteur;
	  }

	  public Produit getMateriel() {
			return materiel;
	  }
	  
	  /*public Produit getArticle() {
			return article;
	  }*/
	  
	  public int getNombre() {
			return nombre;
	  }

	  @Override
	  public String toString() {
		  return String.format(
				  "Id : " + getEmprunteur().getIdPersonnel() +
				  " " + getEmprunteur().getNom() +
				  " " + getEmprunteur().getPrenom() +
				  " sexe : " + getEmprunteur().getSexe() + // à modifier pour avoir label correct !
				  " date de naissance : " + getEmprunteur().getDateddMMyyyy() +
				  ". Email : " + getEmprunteur().getEmail() +
				  " Département : " + getEmprunteur().getDepartement()
				  + "   " + getMateriel()
				   );
	  }


}
