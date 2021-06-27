package NathanaëlDuyck;

import java.util.HashMap;
import java.util.Map;

public class Magasin {
	
	HashMap<Integer,Produit> produits;

	
	public Magasin() {
		produits = new HashMap<Integer,Produit>() ;
	}
	
	public void AjouterProduit (int id,String nom,String description) {	
		Produit p = new Produit (nom, description);
		produits.put(id,p);
	}
	
	public void listeMap() {//Affiche la liste des produits+le nombre de produit dans le magasin
		if(!produits.isEmpty()) {
		System.out.println("Le magasin est composé de " + produits.size()+" articles");
		for (Map.Entry<Integer, Produit> entry : produits.entrySet()) {
			  System.out.println("Id_"+entry.getKey()+" --- "+entry.getValue());
		}	
		}
		else {
			 System.out.println( "Liste des produits ne peut pas être vide" );
		}
	}
	
	public HashMap<Integer, Produit> getProduits() {
		return produits;
	} 
	
	public boolean isEmpty () { //Retourne true si la HashMap est vide
		if (produits.size()== 0 ) {
			return true;
		}
		return false;
	}
}
