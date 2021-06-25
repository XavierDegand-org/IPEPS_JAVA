package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Console.Emprunt;
import Console.Produit;

public class PreterPersonnel implements ActionListener  {
	LoadPersonnel personnelLoader;
	LoadMagasin magasinLoader;
	public static ArrayList<Emprunt> listEmprunt;
	
	public PreterPersonnel(LoadPersonnel personnelLoader, LoadMagasin magasinLoader) {
		this.personnelLoader = personnelLoader;
		this.magasinLoader = magasinLoader;
		listEmprunt = new ArrayList<Emprunt>();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(magasinLoader.magasin.listMap().isEmpty()) {
			System.out.println("Magasin pas créé");
			return;
		}
		if(listEmprunt.isEmpty()) {
			listEmprunt.add(new Emprunt(1,
					personnelLoader.personnels.get(1), magasinLoader.magasin.getProduit("HP1")));
			listEmprunt.add(new Emprunt(2,
					personnelLoader.personnels.get(2), magasinLoader.magasin.getProduit("Dell1")));
			listEmprunt.add(new Emprunt(3,
					personnelLoader.personnels.get(3), magasinLoader.magasin.getProduit("Dell2")));
			listEmprunt.add(new Emprunt(4,
					personnelLoader.personnels.get(4), magasinLoader.magasin.getProduit("Lenovo1")));
			listEmprunt.add(new Emprunt(7,
					personnelLoader.personnels.get(6), magasinLoader.magasin.getProduit("Lenovo2")));
		}
			
		
		for(Emprunt emprunt: listEmprunt)
			System.out.println(emprunt);
		
	}
}
