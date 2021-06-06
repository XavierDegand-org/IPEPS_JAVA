package CetaudMichel;

public class Magasin {
	
	public static String [][] Values = Produit.getProduit();

public static void Magasin() {
	// ASK peut on créer un magasin sans charger le personnel ?
	
	
	System.out.println("Le magasin est composé de " + Values[0].length + " Articles");
	
	for(int i=0;i<Values[0].length;i++){
	
		System.out.println("Id_" + i + " --- Produit [nom = " + Values[0][i] + ", Description = " + Values[1][i] + "]");
	}
}

}
