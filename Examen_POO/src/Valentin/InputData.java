package Valentin;

public class InputData {
	
	public static String inputNomPrenom(String libelle) {  //
		boolean arret = false;
		String nomPrenom = null;
		while (!arret) {
			System.out.println("Entrer un "+libelle+ " :");
			nomPrenom = Lire.texte();
			if (ControleSaisie.valideNom(nomPrenom,GestionJFrame.tailleNom)){
				return nomPrenom;
			}else {
				System.out.print("Erreur de saisie !  ");
				arret = false;
			}
		}
		return nomPrenom;
	}
	
	public static String inputEmail() {
		String email = null;
		boolean arret = false;
		//String result = null;
		while (!arret) {
			System.out.println("Entrer une adresse mail :");
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
	public static String inputNomFichier() {
		boolean arret = false;
		String nomFichier = null;
		while (!arret) {
			nomFichier = Lire.texte();
			if (ControleSaisie.valideNomFichier(nomFichier)) {
				arret = true;
			} else {
				arret = false;
			}
		}
		return nomFichier;
	}

}
