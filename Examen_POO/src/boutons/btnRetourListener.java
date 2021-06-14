package boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import yacineFrimi.Emprunt;
import yacineFrimi.Lire;

public class btnRetourListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		List<Emprunt> listeEmprunt = btnPretListener.getListEmprunt();

		if (listeEmprunt.isEmpty()) {
			System.out.println("Aucun emprunt.");
		} else {
			System.out.println("Liste des emprunts.");
			for (int i = 0; i < listeEmprunt.size(); i++) {
				System.out.println("N°" + (i + 1) + " " + listeEmprunt.get(i).getEmprunteur().getNom() + " "
						+ listeEmprunt.get(i).getProduit().getNom() + " "
						+ listeEmprunt.get(i).getProduit().getDescription());
			}
			System.out.println("Introduire le numéro d'umprunt à annuler :");
			
			boolean testEntree = true;
			while (testEntree)
			try {
			int input =Lire.nbre();
			listeEmprunt.remove(input-1);
			testEntree = false;
			}catch (IndexOutOfBoundsException e1) {
				System.out.println("Index incorrect !");
				
			}
			
			for (int i = 0; i < listeEmprunt.size(); i++) {
				System.out.println("N°" + (i + 1) + " " + listeEmprunt.get(i).getEmprunteur().getNom() + " "
						+ listeEmprunt.get(i).getProduit().getNom() + " "
						+ listeEmprunt.get(i).getProduit().getDescription());
			
		
			
		}

	}
	}

}
