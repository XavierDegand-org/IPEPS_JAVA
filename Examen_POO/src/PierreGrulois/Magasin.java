package PierreGrulois;

import java.util.HashMap;

public class Magasin {
	HashMap<Integer,Produit> map;
	public Produit produits;

	public Magasin(){
		
		this.map = new HashMap<Integer,Produit>();
		
	}
	
	public void AjouterProduit(String nom, String description) {
			int id = map.size()+1;
			Produit produits = new Produit(nom, description);
			map.put(id,produits);
	}
	
	public void ListeMap() {
		
		System.out.println("Le magasin est composé de : " + map.size()+" articles.");
		for (int cpt = map.size(); cpt > 0; cpt--) {
			
			System.out.println("Id_"+ cpt + map.get(cpt).toString());
		}
	}
	
	public HashMap<Integer, Produit> getProduit(int nbr) {
		return map;
	}
	
	public boolean isEmpty() {
		
		if (map.size() == 0) {
			return true;
		}
		else {
			
			return false;

		}
	}
}