package UytterhaegenLouis;

import java.util.HashMap;

public class Magasin  {
	
	private HashMap<Integer,Produit> listeProduit;

	public Magasin() {
		this.listeProduit = new HashMap <Integer,Produit>();
	}
	
	public void ajouterProduit (String nom,String description) {
		Produit produit = new Produit(nom, description);
		listeProduit.put(listeProduit.size()+1, produit);
	}
	

	
	public void listeMap() {
		
		System.out.println("Le magasin est composé de : " + listeProduit.size() + " articles");
		for (int CompteurListe=1;CompteurListe<=listeProduit.size();CompteurListe++) {
			System.out.println(""+ CompteurListe +" "+  listeProduit.get(CompteurListe).toString());
		}
		
	}
	
	public void getProduit () {
		
	}
	public boolean isEmpty () {
		if (listeProduit.size()== 0 ) {
			return true;
		}
		return false;
	}

}
