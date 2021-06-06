package CetaudMichel;

public class Personnel {
	
	public static String [][] Values;
	public static String[] Departement = {"Resources Humaines","Comptabilité","Production"};
	public static String[] Nom = {"Michel","Francis","Oliver"};
	public static String[] Prenom = {"Cétaud","Marie","Thomas"};
	public static String[] Sexe = {"H","H","F"};
	public static String[] Naissance = {"10-08-1990","03-05-1996","12-12-2012"};
	public static String[] Email = {"Michel@gmail.com","Francis@hotmail.com","Oliver@skeynet.be"};
	
	public static void LoadPersonnel() {
		
		//Charge avant d'afficher si pas appuyer sur load
		if(Values==null) {
			
			Values = Personnel.getValues();
			System.out.println("Chargement complet.");
			
		}
		else {
			System.out.println("Les données sont déjà chargées.");;
		}
	}

	public static void Affichage() {
		
		//Charge avant d'afficher si pas appuyer sur load
		if(Values==null) {
			System.out.println("Pas de personnel à afficher. Vous devez d'abord le charger !");;
		}
		else {
		
			System.out.println("+--------------------+----------------+----------------+------+----------------+-------------------------+");
			System.out.println("|    Département     |       Nom      |     Prénom     | Sex  |    Naissance   |          Email          |");
			System.out.println("+--------------------+----------------+----------------+------+----------------+-------------------------+");
			
			for(int i = 0;i<Values[0].length;i++) {
			
				System.out.printf("|%-20s|%-16s|%-16s|%-6s|%-16s|%-25s|\n",Values[0][i],Values[1][i],Values[2][i],Values[3][i],Values[4][i],Values[5][i]);
			}
			System.out.println("+--------------------+----------------+----------------+------+----------------+-------------------------+");
		}
	}
	
public static String[][] getValues() {
		
		String[][] Values = {Departement,Nom,Prenom,Sexe,Naissance,Email};
		
		return Values;
	}
public static void GestionPersonnel() {
	
	
	//Charge avant d'afficher si pas appuyer sur load
	if(Values==null) {
		System.out.println("Pas de personnel à afficher. Vous devez d'abord le charger !");;
	}
	else {
	
		Affichage();
		
		System.out.println("Introduire le nom de la personne à modifier :");
		System.out.print("Quel est le nom ? : ");
		
		String input = InputData.InputData();	
		
		for(int i=0;i<Values[1].length;i++){
			
			if(Values[1][i].equals(input)){
				
				System.out.println(Values[1][i].indexOf(Values[1][i])+ 1 + " .. " + Values[1][i] + " .. " + Values[2][i] + " .. " + Values[3][i] + " .. " + Values[5][i] + " .. " + Values[0][i]);
				System.out.println("Introduire les nouvelles valeurs :");
				
				System.out.print("Nouveau nom : ");
				String Nom = InputData.InputData();
				
				System.out.print("Nouveau prénom : ");
				String Prenom = InputData.InputData();
				
				System.out.print("Adresse mail : ");
				String Email = InputData.InputData();
				
				Values[1][i] = Nom;
				Values[2][i] = Prenom;
				Values[5][i] = Email;
				
				System.out.println("Modification complète !");
				
				return;
			}
		}
		System.out.println("Nom introuvable !");

	}
	
}

}