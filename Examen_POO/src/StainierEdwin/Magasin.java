package StainierEdwin;

import java.util.ArrayList;
import java.util.List;

public class Magasin {

	public ArrayList<Produit> listProduit = new ArrayList<>();
	
	public Magasin()
	{
		listProduit.add(new Produit("HP1", "Elitebook 850 G7"));
		listProduit.add(new Produit("HP2", "Elitebook 830 G7 x360"));
		listProduit.add(new Produit("Dell1", "Inspiron 15 3000"));
		listProduit.add(new Produit("Dell2", "XPS 13"));
		listProduit.add(new Produit("Dell3", "XPS 15"));
		listProduit.add(new Produit("Lenovo1", "Thinkpad E15 G2"));
		listProduit.add(new Produit("Lenovo2", "IdeaPad 3 14IIL05 81 WDOOB2MH"));
	}
	
	public void AjouterProduit(String nom, String description)
	{
		listProduit.add(new Produit(nom, description));
	}
	
	public Produit GetProduit(int id)
	{
		return listProduit.get(id);
	}
	
	
}
