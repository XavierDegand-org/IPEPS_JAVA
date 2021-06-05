package NathanaëlDuyck;

public class InputData {

	public static String inputNomPrenom(String libelle) {
		boolean arret = false;
		String result = null;
		while (!arret) {
			System.out.print("Entrer un "+libelle+"  :  ");
			result = Lire.texte();
			if (ControleSaisie.valideNom(result)){
				return result;
			}else {
				System.out.print("Erreur de saisie !  ");
				arret = false;
			}
		}
		return result;
	}
	
	private String inputEmail() {
		String email = null;
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
	public static String inputNomFichier() {
		boolean arret = false;
		String result = null;
		while (!arret) {
			System.out.print("Entrer un nom de fichier :  ");
			result = Lire.texte();
			if (ControleSaisie.valideNomFichier(result)){
				return result;
			}else {
				System.out.print("Erreur de saisie !  ");
				arret = false;
			}
		}
		return result;
		
	}
}
