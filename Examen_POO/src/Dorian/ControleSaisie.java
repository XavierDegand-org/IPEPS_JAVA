package Dorian;

	
import java.util.regex.Matcher;
	
import java.util.regex.Pattern;

	public class ControleSaisie {
		
		// private static Matcher matcher;
		
		 public static boolean valideNom(String text,int taille) { //controle de saisie nom 
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
		

		private static final String EMAIL_PATTERN
		         = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";	         
		
		private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		
		public static boolean valideEmail(final String hex) {
		
		     Matcher matcher = pattern.matcher(hex);
		     return matcher.matches();
		}
		
		
		
		 public static boolean valide_Fichier(String Nom_Fichier,int taille) {// controle de saisie nom de fichier 
			 String nullString = null;
			 String vide = new String();
			 boolean estNull = Nom_Fichier.equals(nullString);
			 boolean estVide = Nom_Fichier.equals(vide);
			 if(estNull || estVide){
				System.out.println("Valeur null ou vide !");
				 return false;
			 } 
			else{
				if (Nom_Fichier.matches("^[a-zA-Z0-9áàâäãåçéèêëíìîïñóòôöõúùûüýÿæœÁÀÂÄÃÅÇÉÈÊËÍÌÎÏÑÓÒÔÖÕÚÙÛÜÝŸÆŒ._\s-]{1,}") && Nom_Fichier.length() <= taille) { 
					return true;
				}
				else {
					System.out.println("Valeur hors contraintes !");
				}
			}
			return false;
		       
		 }
		
		
		
	}
	


