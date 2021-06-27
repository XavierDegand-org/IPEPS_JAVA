package NathanaëlDuyck;

public class InputData {

	/*Permet l'entrée du nom ou prénom valide.
	 * Tant que le nom ou prénom est pas valide selon le contrôle de saisie, il redemandera de rentrer un nom ou prénom valide. 
	 */
	public static String inputNomPrenom(String libelle) {
		boolean arret = false;
		String result = null;
		while (!arret) {
			System.out.print("Entrer un "+libelle+"  :  ");
			result = Lire.texte();
			if (ControleSaisie.valideNom(result)){
				return result;
			}else {
				System.out.print("Erreur de saisie !  \n");
				arret = false;
			}
		}
		return result;
	}
	/*Permet l'entrée d'un email valide.
	 * Tant que l'email est pas valide selon le contrôle de saisie, il redemandera de rentrer email valide. 
	 */
	public static String inputEmail() {
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
	/*Permet l'entrée d'un nom de fichier valide.
	 * Tant que le nom de fichier  est pas valide selon le contrôle de saisie, il redemandera de rentrer un nom de fichier  valide. 
	 */
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
