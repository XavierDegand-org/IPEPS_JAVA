package boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import yacineFrimi.Emprunt;
import yacineFrimi.Magasin;
import yacineFrimi.Personnel;
import yacineFrimi.Produit;

public class btnPretListener implements ActionListener {

	static List<Emprunt> listeEmprunt = new ArrayList<Emprunt>();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		List<Personnel> listePersonnel = btnLoadListener.getListPersonnel();
		HashMap<Integer, Produit> listeMap = Magasin.getListeMap();

		if (listePersonnel.isEmpty() || listeMap.isEmpty()) {
			System.out.println("Affichage impossible. Pas de personnel ou de magasin !");

		} else {
			listeEmprunt.add(new Emprunt(listePersonnel.get(0), listeMap.get(2)));
			listeEmprunt.add(new Emprunt(listePersonnel.get(1), listeMap.get(3)));
			listeEmprunt.add(new Emprunt(listePersonnel.get(2), listeMap.get(4)));
			listeEmprunt.add(new Emprunt(listePersonnel.get(4), listeMap.get(6)));
			listeEmprunt.add(new Emprunt(listePersonnel.get(6), listeMap.get(7)));
			
			for (Emprunt Emprunt : listeEmprunt) {
				System.out.println(Emprunt.toString());
			}
			
			

		}

	}

	public static List<Emprunt> getListEmprunt() {
		return listeEmprunt;

	}
}
