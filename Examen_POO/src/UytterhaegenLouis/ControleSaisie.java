package UytterhaegenLouis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleSaisie {
	
	// private static Matcher matcher;
	
	 public static boolean valideNom(String text,int taille) {
		 String nullString = null;
		 String vide = new String();
		 boolean estNull = text.equals(nullString);
		 boolean estVide = text.equals(vide);
		 if(estNull || estVide){
			System.out.println("Value is null or empty !");
			 return false;
		 } 
		else{
			if (text.matches("^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$") && text.length() <= taille) { 
				return true;
			}
			else {
				System.out.println("Texte Invalide!");
			}
		}
		return false;
	       
	 }
	

	private static final String EMAIL_PATTERN
	         = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";	         
	
	private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	
	public static boolean valideEmail( String hex) {
	
	     Matcher matcher = pattern.matcher(hex);
	     return matcher.matches();
	}

}
