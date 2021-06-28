package Aude;

import java.util.HashMap;


public class Magasin {
	
	HashMap<Integer,Produit> liste;
	
	public Magasin() {
		
		this.liste = new HashMap<Integer, Produit>();
	}
	
	public void AjouterProduit(int id, String nom, String description) { // rajouter id dans variables du Produit
		//int id = liste.size()+1;
		Produit produit = new Produit(nom, description);
		liste.put(id,produit);
	}
	
	// ------ Afficher la liste des articles composant le magasin ------
	
	public void ListeMap() {
			
			System.out.println("Le magasin comprend : " + liste.size()+" articles.");
			/*for (int elementListe = 1; elementListe <= liste.size(); elementListe++) { 
				
				System.out.println("Id_"+ elementListe +liste.get(elementListe).toString()+"\n");
			}*/
			
			/*for (Map.Entry entreeListe : liste.entrySet()) {
				System.out.println("Id_"+entreeListe.getKey()+entreeListe.getValue().toString());
				
			}*/
		
			
		}
	
	
	
	public void getProduit(int nbre) {  
		for (HashMap.Entry entreeListe : liste.entrySet()) {
			if(entreeListe.getKey().equals(nbre)) {
			System.out.println("Id_"+entreeListe.getKey()+entreeListe.getValue().toString());
			}
		}
		
		return; 
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
