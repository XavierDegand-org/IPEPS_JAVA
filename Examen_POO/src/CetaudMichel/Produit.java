package CetaudMichel;

public class Produit {

	public static String [][] Produit;
	public static String[] Materiel = {"Dell","Apple","Windows"};
	public static String[] Description = {"Pc portable","Macbook Pro","Tablette surface pro"};

	public static String[][] getProduit() {
		
		String[][] Produit = {Materiel,Description};
		
		return Produit;
	}

}
