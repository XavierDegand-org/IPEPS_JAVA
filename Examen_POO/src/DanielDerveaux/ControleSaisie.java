package DanielDerveaux;

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
	
	private static final String FILE_TXT_PATTERN = "^[a-zA-A0-9]+[.txt]+$";
	
	private static Pattern pattern_file = Pattern.compile(FILE_TXT_PATTERN);

	public static boolean valideFichier(final String file) {
		Matcher matcher = pattern_file.matcher(file);
		return matcher.matches();
	}
}