package CetaudMichel;

import java.util.HashMap;
import java.util.Map;

public class Magasin{
	

public Magasin() {
	
	
}

public void AjouterProduit() {
	
}

public static void listeMap() {
	Map<Integer,Produit> listProduit = new HashMap<>();

	listProduit.put(1,new Produit("Nom","Description"));
	listProduit.put(2,new Produit("Nom","Description"));
	
	for(int i = 0;i<listProduit.size();i++) {
		System.out.println("Id_" + i + " --- Produit " + listProduit.get(i));
	}
	
	
}

public String getProduit() {
	return "hh";
}

}
