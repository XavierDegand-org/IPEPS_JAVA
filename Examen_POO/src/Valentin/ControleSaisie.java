package Valentin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleSaisie {
	
	
	private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	
	public static boolean valideNom(String text, int tailleNom) {
		 int taille = 30;
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
	
	public static boolean valideEmail(final String hex) {
		
	     Matcher matcher = pattern.matcher(hex);
	     return matcher.matches();
	}

	public static boolean valideNomFichier(String result) {
		
		return true;
	}
	
}
