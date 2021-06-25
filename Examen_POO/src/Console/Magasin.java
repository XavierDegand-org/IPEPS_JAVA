package Console;

import java.util.HashMap;

public class Magasin {

        private HashMap<String, Produit> liste;

        public Magasin() {
            liste = new HashMap<>(); 
           }
        
        public HashMap<String, Produit> listMap() {
			return liste;
		}

		public void setListe(HashMap<String, Produit> liste) {
			this.liste = liste;
		}

		public void AjouterProduit(Produit produit) {
        	liste.put(produit.getNom(), produit);
        }
		
		public Produit getProduit(String produitName) {
			return liste.get(produitName);
		}
		
		public boolean isEmpty() {
			return liste.isEmpty();
		}
    }
