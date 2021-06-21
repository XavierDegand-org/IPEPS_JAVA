package StainierEdwin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleSaisie {

	private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";    	        
	private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	
	public static boolean valideEmail(final String hex) {
		
	     Matcher matcher = pattern.matcher(hex);
	     return matcher.matches();
	}
	
	public static boolean ValideNom(String texte,int taille)
	{
		 String nullTexte = null;
		 String vide = new String();
		 boolean estNull = texte.equals(null);
		 boolean estVide = texte.equals(vide);
		 Pattern rule = Pattern.compile("\\p{L}*(-\\p{L}*)*");
		 if(estNull || estVide){
			System.out.println("Valeur null ou vide !");
			 return false;
		 } 
		else{
			if (texte.matches("^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$") && texte.length() <= taille) { 
				return true;
			}
			else {
				System.out.println("Valeur hors contraintes !");
			}
		}
		return false;
	}
	
	
}