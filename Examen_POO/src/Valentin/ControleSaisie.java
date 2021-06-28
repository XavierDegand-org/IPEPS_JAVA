package Valentin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleSaisie {
	
	
	private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	
	public static boolean valideNom(String text, int tailleNom) {
		 String stringNull = null; 				// la chaîne de caractères stringNull signifie qu'aucune valeur n'est attribué a à stringNull 
		 String vide = new String();
		 boolean estNull = text.equals(stringNull);
		 boolean estVide = text.equals(vide);
		 text = text.trim();
		 if(estNull || estVide){                         	// on vérifie si le String est null ou vide 
			System.out.println("Valeur null ou vide !");
			 return false;
		 } 
		else{
				if (text.matches("^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$") && text.length() <= tailleNom) {  // on va vérifier si le texte match avec le regex données en paramètres
				return true;																	// mais aussi que la longueur du text est inférieure ou égale à 30
				}
				else {
				System.out.println("Erreur de saisie ! Veuillez réessayer !");
				}
		}
		return false;
	       
	 }
	
	public static boolean valideEmail(final String hex) {
		
	     Matcher matcher = pattern.matcher(hex);
	     return matcher.matches();
	}

	public static boolean valideNomFichier(String nomFichier) {
		String nullString = null;
		String vide = new String();
		boolean estNull = nomFichier.equals(nullString);
		boolean estVide = nomFichier.equals(vide);
		
		if (estNull || estVide) {
			System.out.println("Valeur null ou vide !");
			return false;
		} else {
			if (nomFichier.matches("^[^\\/:*?<>|]+[a-zA-Z_0-9_-]+(.txt)$")) { 
				return true;
			} 
			else {
				System.out.println("Nom fichier incorrect. Veuillez réessayer : ");
			}
		}
		return false;

	}
	}
	

