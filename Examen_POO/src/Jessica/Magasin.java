package Jessica;

import java.util.HashMap;

public class Magasin {
	
		//HashMap <Key, Value> = Clé est un int (id), contenu est classe produit. Classe produit contient nom, description
		static HashMap<Integer, Produit> produits;
		
		public Magasin() {
			produits = new HashMap<Integer, Produit>();
		}

		public void AjouterProduit(int id, String nom, String description) {
			Produit prod = new Produit (nom, description);
			produits.put(id,prod);
		}
		
		public void listeMap() {
			
			if (produits.isEmpty()) {
				System.out.println("Le magasin est vide, impossible à charger.");
			}
			else {			
				for (HashMap.Entry<Integer, Produit> pair : produits.entrySet()) {
				    System.out.println("Id_" + pair.getKey() + " --- " + pair.getValue());   
				}
				
			}
		}
		
		
		public HashMap<Integer, Produit> getProduit() {
			return produits;
		}
		
		public boolean isEmpty() {
			
				if (produits.size()== 0 ) {
					return true;
				}
				return false;
			}
	
	}
