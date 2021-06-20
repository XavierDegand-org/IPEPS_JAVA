package UytterhaegenLouis;

import java.util.HashMap;

public class Magasin  {
	
	private HashMap<Integer,Produit> liste;

	public Magasin() {
		this.liste = new HashMap <Integer,Produit>();
	}
	
	public void ajouterProduit (String nom,String description) {
		Produit produit = new Produit(nom, description);
		liste.put(liste.size()+1, produit);
	}
	

	
	public void listeMap() {
		
		System.out.println("Le magasin est composé de : " + liste.size() + " articles");
		for (int CompteurListe=1;CompteurListe<=liste.size();CompteurListe++) {
			System.out.println(""+ CompteurListe +" "+  liste.get(CompteurListe).toString());
		}
		
	}
	public boolean isEmpty () {
		if (liste.size()== 0 ) {
			return true;
		}
		return false;
	}

}
