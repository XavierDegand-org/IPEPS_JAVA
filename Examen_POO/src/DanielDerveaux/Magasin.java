package DanielDerveaux;

import java.util.HashMap;

public class Magasin {
	
	HashMap<Integer,Produit> produits;
	
	public Magasin() {
		produits = new HashMap<Integer,Produit>();
	}
	
	public void ajouterProduit(int IdProduit, String nom, String description) {
		Produit prod = new Produit (nom, description);
		produits.put(IdProduit, prod);
	}
	
	public void listeMap() {
		if(produits.isEmpty()) {
			System.out.println("Affichage impossible, le magasin est vide !");
		} else {
			System.out.println("Le magasin est composé de " + produits.size() + " articles");
			for (HashMap.Entry<Integer, Produit> ListeProduits : produits.entrySet()) {
				System.out.println("Id_" + ListeProduits.getKey() + " --- " +  ListeProduits.getValue());
			}
		}
	}
	
	public HashMap<Integer, Produit> getProduit() {
		return produits;
	}
	
	public boolean isEmpty() {
		if (produits.size() == 0) {
			return true;
		}
		return false;
	}
}
