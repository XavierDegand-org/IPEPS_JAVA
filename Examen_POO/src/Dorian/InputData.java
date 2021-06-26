package Dorian;

public class InputData 
{
	
	private static String email;
	private static int tailleNom = 30;
	
	
	
	
	public static String inputEmail()  //Entre un email + controle de saisie
	{
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

	public static String inputNomPrenom(String libelle)  //entre non ou prénom avec controle de saisie 
	{
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
	
	
	
	public static String Nom_Fichier() //entre le nom de ficher avec controle de saisie
	{
		boolean arret = false;
		//String result = null;
		String Nom_Fichier = null;
		
		while (!arret) {
			System.out.print("Entrer un Nom de Fichier :  ");
			Nom_Fichier = Lire.texte();
			if (ControleSaisie.valide_Fichier(Nom_Fichier,30)){
				return Nom_Fichier;
			}else {
				System.out.print("Saisie non valide !  ");
				arret = false;
			}
		}
		return Nom_Fichier;
	}
	
	

}
