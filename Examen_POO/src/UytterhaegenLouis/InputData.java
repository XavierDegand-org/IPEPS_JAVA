package UytterhaegenLouis;

public class InputData {
	
	private static String email;
	
	public static String inputEmail() {
		boolean arret = false;
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
	public static String inputNomPrenom(String libelle) {
		boolean arret = false;
		String result = null;
		while (!arret) {
			System.out.print("Entrer un "+libelle+"  :  ");
			result = Lire.texte();
			if (ControleSaisie.valideNom(result, GestionJFrame.tailleNom)){
				return result;
			}else {
				System.out.print("Erreur de saisie !  ");
				arret = false;
			}
		}
		return result;
		
	}

}
