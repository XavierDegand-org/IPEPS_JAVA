package Jessica;

import java.util.HashMap;

public class Magasin {
	
		//HashMap <Key, Value> = Clé est un int (id), contenu est classe produit. Classe produit contient nom, description
		static HashMap<Integer, Produit> liste;
		
		public Magasin() {
			liste = new HashMap<Integer, Produit>();
		}

		public void AjouterProduit(int id, String nom, String description) {
			Produit prod = new Produit (nom, description);
			liste.put(id,prod);
		}

		public void listeMap() {
			
			System.out.println("Le magasin est composé de " + liste.size()+" articles");
			System.out.println("Produits =" + liste.values());
		}
		
		public void getProduit() {
		
		}
		
		public void isEmpty() {
			
		}
	}
