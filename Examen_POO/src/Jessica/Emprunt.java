package Jessica;

import java.util.HashMap;

public class Emprunt {

	private static int nombre;
	private static Personnel emprunteur;
	private static HashMap<Integer, Produit> materiel;

	public Emprunt(int nombre, Personnel emprunteur, HashMap<Integer, Produit> materiel) {
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

	 /*public HashMap<Integer, Produit> getMateriel() {
			return materiel;
	  }*/
	  
	  public static HashMap<Integer, Produit> getMateriel(int nbr) {
			
		  for(HashMap.Entry<Integer, Produit> pair: materiel.entrySet()) {
				if(pair.getKey().equals(nbr)) {
					System.out.println("Id_" + pair.getKey() + " --- " + pair.getValue());
				}
			}
			return materiel;
		}
	  
	  /*public Produit getArticle() {
			return article;
	  }*/
	  
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
				  " Département : " + getEmprunteur().getDepartement()
				  + "   " + getMateriel(nombre)
				   ;
	  }

	/*public static HashMap<Integer, Produit> getMateriel(int nbr) {
		// TODO Auto-generated method stub
		return materiel;
	}*/


}
