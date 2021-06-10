package yacineFrimi;

public class InputData {
	
	public static String inputNomPrenom() {
		boolean arret = false;
		String nomPrenom = null;
		while (!arret) {
			nomPrenom = Lire.texte();
			if (ControleSaisie.valideNom(nomPrenom,30)){
				return nomPrenom;
			}else {
				arret = false;
			}
		}
		
		System.out.println(miseEnForme(nomPrenom));
		return miseEnForme(nomPrenom);
	}
	
	public static String inputEmail() {
		String email = null;
		boolean arret = false;
		while (!arret) {
			 email = Lire.texte();
			if (ControleSaisie.valideEmail(email)){
				arret = true;
				return email;
			}else {
				arret = false;
				System.out.println("Email incorrect. Veuillez réessayer : ");
			}
		}
		return email.toLowerCase();
	}
	public static String inputNomFichier() {
		boolean arret = false;
		String nomFichier = null;
		while (!arret) {
			nomFichier = Lire.texte();
			if (ControleSaisie.valideNomFichier(nomFichier)){
				return nomFichier;
			}else {
				arret = false;
			}
		}
		return nomFichier;
		
	}
	
	public static String miseEnForme ( String mot ) {
		  
	      String premiereLettre = mot.substring(0,1).toUpperCase();
	      String resteDuMot = mot.substring(1).toLowerCase();
	      return premiereLettre + resteDuMot;
	  }
}
