package yacineFrimi;

import java.util.List;

import boutons.btnPretListener;

public class Emprunt {

	// Classe en cours de développement
	int nombre;
	Personnel emprunteur;
	Produit produit;

	List<Emprunt> listeEmprunt = btnPretListener.getListEmprunt();

	public Emprunt(Personnel emprunteur, Produit produit) {
		this.emprunteur = emprunteur;
		this.produit = produit;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public Personnel getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Personnel emprunteur) {
		this.emprunteur = emprunteur;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public String toString() {
		return "Id : " + (emprunteur.getIdPersonnel() + 1) + " " + getEmprunteur() + getProduit();
	}

}
