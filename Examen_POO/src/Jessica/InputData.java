package Jessica;

import java.util.ArrayList;

public class InputData {
	
	private static String nom;
	private static String prenom;
	private static String email;
	private static String nomFichier;
	private static int tailleNom = 30;

	public static void main( String [] args ) {
	InputData saisie = new InputData();
	ArrayList<Personnel> Person = new ArrayList<>();
	
	for (int i = 0; i < Person.size(); i++) {
		nom = InputData.inputNomPrenom("nom :");
		prenom = InputData.inputNomPrenom("prénom :");
		Lire.vider();
		saisie.inputEmail();
		
	}
	
	for(Personnel Pers : Person) {
		System.out.println(Pers);
	}
}

	public static String inputNomPrenom(String libelle) {
		boolean arret = false;
		String result = null;
		while (!arret) {
			System.out.print("Entrer un "+libelle+"  :  ");
			result = Lire.texte();
			if (ControleSaisie.valideNom(result, tailleNom)){
				return result;
			}else {
				System.out.print("Erreur de saisie !  ");
				arret = false;
			}
		}
		return result;
		
	}
	
	private String inputEmail() {
		boolean arret = false;
		//String result = null;
		while (!arret) {
			System.out.print("Entrer une adresse mail  :  ");
			email = Lire.texte();
			if (ControleSaisie.valideEmail(email)){
				return email;
			}else {
				System.out.print("Saisie non valide !  ");
				arret = false;
			}
		}
		return email;
	}
	
	
	private String inputNomFichier() {
		boolean arret = false;
		//String result = null;
		while (!arret) {
			System.out.print("Entrer un nom de fichier  :  ");
			nomFichier = Lire.texte();
			if (ControleSaisie.valideNomFichier(nomFichier)){
				return nomFichier;
			}else {
				System.out.print("Saisie non valide !  ");
				arret = false;
			}
		}
		return nomFichier;
	}
	

}