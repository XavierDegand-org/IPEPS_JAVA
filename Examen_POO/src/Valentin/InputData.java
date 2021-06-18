package Valentin;

public class InputData {
	
	public static String inputNomPrenom() {
		boolean arret = false;
		String nomPrenom = null;
		while (!arret) {
			nomPrenom = Lire.texte();
			if (ControleSaisie.valideNom(nomPrenom)){
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
			System.out.print("Entrer un nom de fichier :  ");
			nomFichier = Lire.texte();
			if (ControleSaisie.valideNomFichier(nomFichier)){
				return nomFichier;
			}else {
				System.out.print("Erreur de saisie !  ");
				arret = false;
			}
		}
		return nomFichier;
		
	}

}
