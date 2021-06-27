package UytterhaegenLouis;

import java.util.HashMap;
import java.util.Map;


public class Magasin  {

	public  Map<Integer,Produit> produits;  // Clé = id du produit afin de le retrouver / Contenu = objets de la classe Produit ( Nom et description )
	public Produit produit;

	public Magasin() {
		produits = new HashMap <Integer,Produit>();
	}

	public void ajouterProduit (String nom,String description) {
		try {
			Produit produit = new Produit(nom, description);
			produits.put(produits.size()+1, produit); // l'id est attribué en fonction de la taille de la liste qui augmente
		}catch (UnsupportedOperationException e) {
			System.err.println("Une erreur est survenue : "+e.getMessage());
		}catch (ClassCastException e){
			System.err.println("Une erreur est survenue : "+e.getMessage());
		}catch (NullPointerException e){
			System.err.println("Une erreur est survenue : "+e.getMessage());
		}catch (IllegalArgumentException e) {
			System.err.println("Une erreur est survenue : "+e.getMessage());
		}
	}



	public void listeMap() {
		System.out.println("Le magasin est composé de " + produits.size() + " articles");
		for (int CompteurList=1;CompteurList<=produits.size();CompteurList++) { // boucle pour afficher les différents articles du magasin
			System.out.println(""+ CompteurList +" "+  produits.get(CompteurList).toString());
		}

	}

	public Map<Integer,Produit> getProduit () { // permet de retourner l'objet sous forme de hashmap
		return produits;
	}


	public boolean isEmpty () { // Si aucun produits n'a été ajouté
		if (produits.size()== 0 ) {
			return true;
		}
		return false;
	}

}
