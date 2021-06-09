package Jessica;

import java.util.HashMap;

public class Magasin {

		HashMap<String,Produit> liste;
		
		public Magasin() {
			liste = new HashMap<String,Produit>();
		}

		public void AjouterProduit(String nom, String description) {
			Produit p = new Produit (nom, description);
			liste.put(nom,p);
		}

		public void listeMap() {
			
			System.out.println("La taille de la HashMap est :" + liste.size());
			System.out.println("Produits =" + liste.values());
		}
		
		public void getProduit() {
			
		}
		
		public void isEmpty() {
			
		}
	}
