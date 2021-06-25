package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Console.Emprunt;
import Console.Lire;

public class RetourMateriel implements ActionListener  {
	PreterPersonnel pretPersonnel;
	
	public RetourMateriel(PreterPersonnel pretPersonnel) {
		this.pretPersonnel = pretPersonnel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(pretPersonnel.magasinLoader.magasin.listMap().isEmpty()) {
			System.out.println("Magasin pas créé");
			return;
		}
		
		System.out.println("Liste des emprunts");
		for (int i = 0; i <= pretPersonnel.listEmprunt.size()-1; i++) {
			Emprunt emprunt = pretPersonnel.listEmprunt.get(i);
			System.out.println("N° "+(i+1)+" "+emprunt.getEmprunteur().getNom()+"   "+emprunt.getMateriel());
		}
		
		System.out.println("Introduire le numéro d'emprunt à annuler :");
		Lire.vider();
		int number = Lire.nbre();
		try {
			pretPersonnel.listEmprunt.remove(number-1);
			System.out.println("Emprunt retourné");
			}
			catch(Exception e1) {
				System.out.println("Impossible de retourner l'emprunt");
			}
	}
}
