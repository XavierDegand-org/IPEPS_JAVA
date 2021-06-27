package PierreGrulois;

public class InputData {
	
	public static String InputEmail() {
		String newMail=null;
		boolean valideEmail=false;
		
		while(valideEmail == false) {
			
			System.out.println("Entrer la nouvelle adresse e-mail:");
			newMail = Lire.texte();
			valideEmail = ControleSaisie.ValideMail(newMail);
			if(valideEmail == false) {
				System.out.println("L'adresse E-mail est invalide, veuillez recommencer!");
			}
		}
		return newMail;
	}
	
	public static String InputNom() {
		
		String newNom=null;
		boolean valideNom=false;
		System.out.println("Entrer le nouveau nom:");
		do {
			newNom = Lire.texte();
			valideNom = ControleSaisie.valideNom(newNom);
			if(valideNom == false) {
				System.out.println("Le nouveau nom est invalide, veuillez recommencer!");
			}
		}while(valideNom == false);
		return newNom;
	}
	
	public static String InputPrenom() {
		
		String newPrenom=null;
		boolean validePrenom=false;
		System.out.println("Entrer le nouveau prénom:");
		do {
			newPrenom = Lire.texte();
			validePrenom = ControleSaisie.valideNom(newPrenom);
			if(validePrenom == false) {
				System.out.println("Le nouveau prénom est invalide, veuillez recommencer!");
			}
		}while(validePrenom == false);
		return newPrenom;
	}
	
	public static String InputNomFichier() {
		
		String newNomFile=null;
		boolean valideNomFile=false;
		
		do {
			
			System.out.println("Entrer le nom du fichier à sauvgarder:");
			newNomFile = Lire.texte();
			valideNomFile = ControleSaisie.valideNomFichier(newNomFile);
			if(valideNomFile == false) {
				System.out.println("Ce nom de fichier est invalide, veuillez recommencer!");
			}
			
		}while(valideNomFile == false);
		return newNomFile;
	}

}
