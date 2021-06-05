package NathanaëlDuyck;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleSaisie {
	
	private static final Pattern EMAIL_PATTERN = Pattern.compile( 
			"^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
	private static Pattern pattern =Pattern.compile(
			"\\p{L}*(-\\p{L}*)*");
	
	public static boolean valideEmail(final String email) {
		
		Matcher matcher = EMAIL_PATTERN.matcher(email);
	     return matcher.matches();
		
	}

	 public static boolean valideNom(String text) {
		 String nullString = null;
		 int taille =30;
		 String vide = new String();
		 boolean estNull = text.equals(nullString);
		 boolean estVide = text.equals(vide);
		 Matcher match = pattern.matcher(text);
		 boolean isMatch = match.matches();
		 if(estNull || estVide){
			System.out.println("Valeur null ou vide !");
			 return false;
		 } 
		else{
			if (isMatch  && text.length() <= taille) { 
				return true;
			}
			else {
				System.out.println("Valeur hors contraintes !");
			}
		}
		return false;
	       
	 }
	
	public static boolean valideNomFichier(String result) {
		return false;
	}
}
