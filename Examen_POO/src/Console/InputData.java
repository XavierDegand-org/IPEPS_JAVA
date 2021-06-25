package Console;

public class InputData {
	private static String nom;
	private static String prenom;
	private static String email;
	private static String nomfichier;
	private static int tailleNom = 30;
	
	public static String inputNomPrenom() {
		boolean arret = false;
		Lire.vider();
		String result = null;
		while (!arret) {
			result = Lire.texte();
			if (ControleSaisie.valideNom(result, tailleNom)){
				return result;
			} else {
				System.out.print("Erreur de saisie !  ");
				arret = false;
			}
		}
		return result;
		
	}
	public static String inputEmail() {
		boolean arret = false;
		Lire.vider();
		while (!arret) {
			System.out.print("Entrer une adresse mail : ");
			email = Lire.texte();
			if (ControleSaisie.valideEmail(email)){
				return email;
			} else {
				System.out.print("Saisie non valide !");
				arret = false;
			}
		}
		return email;
	}	
	
	public static String inputNomFichier() {
		boolean arret = false;
		Lire.vider();
		while(!arret) {
			nomfichier = Lire.texte();
			if (ControleSaisie.valideFichier(nomfichier)) {
				return nomfichier;
			} else {
				System.out.println("Saisie non valide !");
				arret = false;
			}
		}
		return nomfichier;
	}
}
