package Aude;

import java.util.HashMap;

public class Magasin {
	
	HashMap<Integer,Produit> liste;
	
	public Magasin() {
		
		this.liste = new HashMap<Integer, Produit>();
	}
	
	public void AjouterProduit(String nom, String description) {
		int id = liste.size()+1;
		Produit produits = new Produit(nom, description);
		liste.put(id,produits);
	}
	
	// ------ Afficher la liste des articles composant le magasin ------
	
	public void ListeMap() {
			
			System.out.println("Le magasin comprend : " + liste.size()+" articles.");
			for (int elementListe = 1; elementListe <= liste.size(); elementListe++) { 
				
				System.out.println("Id_"+ elementListe + " --- "+liste.get(elementListe)+"\n");
			}
		}
	
	public HashMap<Integer, Produit> getProduit(int nbr) {
		return liste;
	}
	
	public boolean isEmpty() {
	
		if (liste.size() == 0) {
			return true;
		}
		else {
			
			return false;

		}
	}
}
