package Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleSaisie {
	 public static boolean valideNom(String text,int taille) {
		 boolean estNull = text.equals("");
		 boolean estVide = text.equals(null);
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
	
	public static boolean valideFichier(String nomfichier) {
		 boolean estNull = nomfichier.equals(null);
		 boolean estVide = nomfichier.equals("");
		 Pattern rule = Pattern.compile("\\p{L}*(-\\p{L}*)*");
		 if(estNull || estVide){
			System.out.println("Valeur null ou vide !");
			 return false;
		 } 
		else{
			if (nomfichier.matches("^([ \\u00c0-\\u01ffa-zA-Z'\\-])+(\\.(?i)(txt))+$")) { 
				return true;
			}
			else {
				System.out.println("Valeur hors contraintes !");
			}
		}
		return false;
	}
}