package boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import yacineFrimi.Magasin;
import yacineFrimi.Produit;

public class btnMagListener implements ActionListener {

	HashMap<Integer,Produit> listeMap = Magasin.getListeMap();

	@Override
	public void actionPerformed(ActionEvent e) {
		// Classe en cours de developpement


		listeMap.put(1, new Produit("HP1", "Elitebook 850 G7"));
		listeMap.put(2, new Produit("HP2", "Elitebook 850 G7 X360"));
		listeMap.put(3, new Produit("Dell1", "Inspiron 15 3000"));
		listeMap.put(4, new Produit("Dell2", "XPS 13"));
		listeMap.put(5, new Produit("Dell3", "XPS 15"));
		listeMap.put(6, new Produit("Lenovo1", "Thinkpad E15 G2"));
		listeMap.put(7, new Produit("Lenovo2", "IdeaPad 3 14IIL05 81WD00B2MH"));

		System.out.println("Le magasin est composé de "+listeMap.size()+" articles.");

		for (int i= 1; i<=listeMap.size(); i++ )	{
			System.out.println("Id_"+i+listeMap.get(i));
		}
	}







}

