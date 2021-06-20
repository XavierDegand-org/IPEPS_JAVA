package Valentin;

import java.util.HashMap;


public class Magasin  {

	HashMap<Integer, Produit> produits;
	
	public Magasin() {
		produits = new HashMap<Integer,Produit>();
	}
	
	public void AjouterProduit(Integer id,String nom, String description) {
		Produit produit = new Produit(nom, description);
		produits.put(id, produit);
	}
	
	public void listeMap() {
		System.out.println("le magasin est composé de "+produits.size()+" articles");
		
		for(int compteur=1; compteur<=produits.size();compteur++) {
			System.out.println("Id_"+compteur+" --- "+produits.get(compteur));
		}
	}
	
	public  HashMap<Integer, Produit> getProduit(){
		return produits;
	}
	
	public void isEmpty() {
		
	}
	
	
	
	
}
