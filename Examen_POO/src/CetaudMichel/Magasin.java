package CetaudMichel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Magasin {

	static Map<Integer, Produit> listProduit = new HashMap<>();

	public Magasin() throws FileNotFoundException {

		File file = new File(System.getProperty("user.dir") + "/Sources/Produit.txt");
		Scanner scan = new Scanner(file);

		String[] produit;
		int i = 1;

		while (scan.hasNextLine()) {

			produit = scan.nextLine().split(";");
			listProduit.put(i++, new Produit(produit[0], produit[1]));

		}

		scan.close();

		listeMap();
	}

	public void AjouterProduit(String nom, String description) {
		listProduit.put(listProduit.size() + 1, new Produit(nom, description));
	}

	public void listeMap() {
		System.out.println("Le magasin est composé de " + listProduit.size() + " artichle(s)");
		for (int key : listProduit.keySet()) {
			System.out.println("Id_" + key + listProduit.get(key));
		}

	}

	public static Map<Integer, Produit> getProduit() {
		return listProduit;
	}

}
