package CetaudMichel;

public class Personnel {
	

	
	public static String[] Departement = {"Resources Humaines","Comptabilité","Production"};
	public static String[] Nom = {"Michel","Francis","Oliver"};
	public static String[] Prenom = {"Cétaud","Marie","Thomas"};
	public static String[] Sexe = {"H","H","F"};
	public static String[] Naissance = {"10-08-1990","03-05-1996","12-12-2012"};
	public static String[] Email = {"Michel@gmail.com","Francis@hotmail.com","Oliver@skeynet.be"};
	

	public static String[][] getValues() {
		
		String[][] Values = {Departement,Nom,Prenom,Sexe,Naissance,Email};
		
		return Values;
	}
	
}