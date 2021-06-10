package CetaudMichel;

public class InputData {

	public static String inputNomPrenom() {

		boolean stop = true;

		String Nom = null;
		while (stop) {
			Nom = Lire.texte();
			if (ControleSaisie.valideNom(Nom, 30)) {
				stop = false;
			}
		}
		return Nom;

	}

	public static String inputEmail() {

		boolean stop = true;

		String Email = null;
		while (stop) {
			Email = Lire.texte();
			if (ControleSaisie.valideEmail(Email)) {
				stop = false;
			}
		}
		return Email;

	}


	public static String inputNomFichier() {
	
		boolean stop = true;
	
		String Fichier = null;
		while (stop) {
			Fichier = Lire.texte();
			if (ControleSaisie.valideNomFichier(Fichier,30)) {
				stop = false;
			}
		}
		return Fichier;
	
	}
}