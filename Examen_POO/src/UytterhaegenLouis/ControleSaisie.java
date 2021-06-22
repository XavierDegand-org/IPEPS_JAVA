package UytterhaegenLouis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleSaisie {

	private static final String EMAIL_PATTERN
	= "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";	         

	private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);

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
	
	public static boolean valideNomFichier(String text,int taille) {
		String nullString = null;
		String vide = new String();
		boolean estNull = text.equals(nullString);
		boolean estVide = text.equals(vide);
		if(estNull || estVide){
			System.out.println("Value is null or empty !");
			return false;
		} 
		else{
			if (text.matches("^[a-zA-Z_0-9]{1,}+(.txt)$") && text.length() <= taille) { 
				return true;
			}
			else {
				System.out.println("Nom de fichier invalide !");
				
			}
		}
		return false;

	}

	public static boolean valideEmail( String hex) {

		Matcher matcher = pattern.matcher(hex);
		return matcher.matches();
	}

}
