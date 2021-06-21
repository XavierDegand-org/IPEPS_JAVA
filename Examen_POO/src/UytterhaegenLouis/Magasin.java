package UytterhaegenLouis;

import java.util.HashMap;
import java.util.Map;


public class Magasin  {
	
	HashMap<Integer,Produit> listeProduit;  // Clé = id du produit / Contenu = objets de la classe Produit ( Nom et description )
	Produit produit;
	
	public Magasin() {
		this.listeProduit = new HashMap <Integer,Produit>();
	}
	
	public void ajouterProduit (String nom,String description) {
		Produit produit = new Produit(nom, description);
		listeProduit.put(listeProduit.size()+1, produit); // l'id est attribué en fonction de la taille de la liste
	}
	

	
	public void listeMap() {
		
		System.out.println("Le magasin est composé de : " + listeProduit.size() + " articles");
		for (int CompteurListe=1;CompteurListe<=listeProduit.size();CompteurListe++) {
			System.out.println(""+ CompteurListe +" "+  listeProduit.get(CompteurListe).toString());
		}
		
	}
	
	public Map<Integer,Produit> getProduit () { // permet de retourner l'objet sous forme de hashmap
		return listeProduit;
	}
	public boolean isEmpty () {
		if (listeProduit.size()== 0 ) {
			return true;
		}
		return false;
	}

}
