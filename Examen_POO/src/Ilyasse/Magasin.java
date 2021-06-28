package Ilyasse;

import java.util.ArrayList;
import java.util.List;

public class Magasin {
	public ArrayList<Produit> listProduit = new ArrayList<>();

	public ArrayList<Emprunt> listEmprunt = new ArrayList<>();	

	
	public Magasin() {
		listProduit.add(new Produit("HP1","Elitebook 850 G7" ));
		listProduit.add(new Produit("HP2","Elitebook 830 G7 X360"));
		listProduit.add(new Produit("Dell1","Inspiron 15 3000"));
		listProduit.add(new Produit("Dell2","XPS 13"));
		listProduit.add(new Produit("Dell3","XPS 15"));
		listProduit.add(new Produit("Lenovo1","Thinkpad E15 G2"));
		listProduit.add(new Produit("Lenovo2","IdeaPad 3 14IIL05 81WD00B2MH "));
	listEmprunt.add(new Emprunt(new Personnel(0,"Collon", "Albert", Sexe.HOMME, new MyDate(10, 8, 1990), "Collon.a@test.be", Departement.HR), new Produit("HP", "Elitebook 850 G7"), 0));
	listEmprunt.add(new Emprunt(new Personnel(2,"Peeters", "Marie", Sexe.FEMME, new MyDate(1, 5, 1985), "Peeters_M@@test.be", Departement.HR), new Produit("Dell","Inspiron 15 3000"),1));
	listEmprunt.add(new Emprunt(new Personnel(3,"Janssens","Sarah",Sexe.FEMME, new MyDate(23,5,1999),"Sarah.Janssens@test.be",Departement.COMPTA), new Produit("Dell", "XPS 13"), 2));
	listEmprunt.add(new Emprunt(new Personnel(4,"Jacobs","Charles",Sexe.HOMME, new MyDate(12,12,2009),"Charles.j#test.be",Departement.SEC) , new Produit("Lenovo", "Thinkpad E15 G2"), 3));
	listEmprunt.add(new Emprunt(new Personnel(5,"Willems","Francois-Xavier",Sexe.HOMME, new MyDate(28, 10, 1996),"Willems.F-X@test.be",Departement.Prod), new Produit("Lenovo", "IdeaPad 3 14IIL05 81WD00B2MH"), 4));
}

	public void AddProduit(String nom, String description)
	{
		listProduit.add(new Produit(nom, description));
	}
		public Produit getProduit(int i)
	{
		return listProduit.get(i);
	}

}
