package yacineFrimi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleSaisie {
	 
	
	public static boolean valideNom(String text,int taille) {
		 
		 String nullString = null;
		 String vide = new String();
		 boolean estNull = text.equals(nullString);
		 boolean estVide = text.equals(vide);
		 
		 
		 if(estNull || estVide){
			System.out.println("Valeur null ou vide !");
			 return false;
		 } 
		else{
			if (text.matches("^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$") && text.length() <= taille) { 
				return true;
			}
			else {
				System.out.println("Nom incorrect. Veuillez réessayer : ");
			}
		}
		return false;
	  }
	

	private static final String EMAIL_PATTERN
	         = "^[A-Za-z0-9+_.-]+@(.+)$\", ^[A-Za-z0-9+_.-]";	         
	
	private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	
	public static boolean valideEmail(String hex) {
		 Matcher matcher = pattern.matcher(hex);
	     return matcher.matches();
	}
	
	public static boolean valideNomFichier(String text) {
		 String nullString = null;
		 String vide = new String();
		 boolean estNull = text.equals(nullString);
		 boolean estVide = text.equals(vide);
		 if(estNull || estVide) {
			 System.out.println("Valeur null ou vide !");
	}
		 else {
			 if(text.matches("^[^*&%\s]+$")) {
				 return true;
			 }
			 else {
				 System.out.println("Nom fichier incorrect. Veuillez réessayer : ");
			 }
		 }
		 return false;

	}
}
