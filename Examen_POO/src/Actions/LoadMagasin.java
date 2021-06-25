package Actions;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Console.Magasin;
import Console.Produit;

public class LoadMagasin implements ActionListener {
	public static Magasin magasin;

	public LoadMagasin() {
		magasin = new Magasin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			File file = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Produit.txt");
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				if (!line.contains(";"))
					continue;
				String[] data = line.split(";");
				String nom = data[0];
				String description = data[1];
				Produit produit = new Produit(nom, description);
				magasin.AjouterProduit(produit);
			}
			myReader.close();
		} catch (FileNotFoundException e1) {
			System.out.println("Error pendant le chargement des produits.");
			e1.printStackTrace();
		}
		
		ArrayList<Produit> produits = new ArrayList<>(magasin.listMap().values());
		System.out.println("Le magasin est composé de " + produits.size() + " articles");
		for (int i = 0; i <= produits.size()-1; i++) {
			System.out.println("Id "+(i+1)+" --- "+produits.get(i).toString());
		}
	}
}