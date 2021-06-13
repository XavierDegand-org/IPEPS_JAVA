package DanielDerveaux;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleSaisie {
	/* controle prénom & nom */
	 public static boolean valideNom(String text,int taille) {
		 String nullString = null;
		 String vide = new String();
		 boolean estNull = text.equals(nullString);
		 boolean estVide = text.equals(vide);
		 Pattern rule = Pattern.compile("\\p{L}*(-\\p{L}*)*");
		 if(estNull || estVide){
			System.out.println("Valeur null ou vide !");
			 return false;
		 } 
		else{
			if (text.matches("^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$") && text.length() <= taille) { 
				return true;
			}
			else {
				System.out.println("Valeur hors contraintes !");
			}
		}
		return false;
	       
	 }
	 
	 /* Controle mail */

	 private static final String EMAIL_PATTERN
	         = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";	         
	
	private static Pattern pattern_email = Pattern.compile(EMAIL_PATTERN);
	
	public static boolean valideEmail(final String hex) {
	     Matcher matcher = pattern_email.matcher(hex);
	     return matcher.matches();
	}
	
	/* Controle nom fichier */

	public static boolean valideFichier(String nomfichier) {
		 String nullString = null;
		 String vide = new String();
		 boolean estNull = nomfichier.equals(nullString);
		 boolean estVide = nomfichier.equals(vide);
		 Pattern rule = Pattern.compile("\\p{L}*(-\\p{L}*)*");
		 if(estNull || estVide){
			System.out.println("Valeur null ou vide !");
			 return false;
		 } 
		else{
			if (nomfichier.matches("^([ \\u00c0-\\u01ffa-zA-Z'\\-])+[.txt]+$")) { 
				return true;
			}
			else {
				System.out.println("Valeur hors contraintes !");
			}
		}
		return false;
	}

	public static boolean valideFichier(File nomfichier) {
		// TODO Auto-generated method stub
		return false;
	}
}