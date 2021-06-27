package NathanaëlDuyck;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleSaisie {
	
	//Pattern pour les emails
	private static final Pattern EMAIL_PATTERN = Pattern.compile( 
			"^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
	
	//Pattern pour les noms et prénoms
	private static Pattern pattern =Pattern.compile(
			"\\p{L}*(-\\p{L}*)*");
	
	/*Contrôle de saisie sur le nom et prénom
	  Si le texte est vide ou null ou qu'il n'est pas conforme au pattern pour les noms et prénoms et qu'il depasse la taille alors il sera false
	  sinon le nom ou prénom sera valide. */
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
	
	 /*Contrôle de saisie sur le nom du fichier
	  Si le nom de fichier est vide ou null ou qu'il n'est pas conforme au pattern pour les noms de fichiers, il sera false
	  sinon le nom de fichier sera valide. */
	 public static boolean valideNomFichier(String nomfichier) {
		String nullString = null;
		 String vide = new String();
		 boolean estNull = nomfichier.equals(nullString);
		 boolean estVide = nomfichier.equals(vide);
		 Pattern fichierpattern = Pattern.compile("^.{1,}[^\\\\/:\\*\\?\"<>\\|]+(.txt)$");//Pattern pour le nom du fichier
		 Matcher match = fichierpattern.matcher(nomfichier);
		 boolean isMatch = match.matches();
		 if(estNull || estVide){
			System.out.println("Valeur null ou vide !");
			 return false;
		 }
		 else {	if (isMatch) { 
				return true;
			}
			else {
				System.out.println("Valeur hors contraintes !");
			}
		}
		return false;
	       
	 }
	
	 /*Contrôle de saisie sur Email
	  On vérifi si l'email correspond bien au pattern et si c'est le cas on retourn l'email . */
	public static boolean valideEmail(final String email) {
		
		Matcher matcher = EMAIL_PATTERN.matcher(email);
	    return matcher.matches();
		
	}
}
