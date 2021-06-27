package UytterhaegenLouis;

public class InputData {

	private static String email;

	public static String inputEmail() { // permet de vérifier que l'email introduit est valide
		boolean arret = false;
		while (!arret) {
			System.out.print("Entrer une adresse mail  :  ");
			email = Lire.texte();
			if (ControleSaisie.valideEmail(email)){
				return email;
			}else {
				System.out.print("Adresse mail non valide ! ");
			}
		}
		return email;
	}
	public static String inputNomPrenom(String libelle) { // permet de vérifier que le nom ou le prénom introduit est valide
		boolean arret = false;
		String result = null;
		while (!arret) {
			System.out.print("Entrer un "+libelle+"  :  ");
			result = Lire.texte();
			if (ControleSaisie.valideNom(result, GestionJFrame.tailleNom)){
				return result;
			}
		}
		return result;

	}
	public static String inputNomFichier() { // permet de vérifier que le nom du fichier introduit est valide
		boolean arret = false;
		String result = null;
		while (!arret) {
			System.out.println("Introduire le nom du fichier extension .txt !");
			result = Lire.texte();
			if (ControleSaisie.valideNomFichier(result, GestionJFrame.tailleFichier)) {
				return result;
			}
		}
		return result;
	}

}
