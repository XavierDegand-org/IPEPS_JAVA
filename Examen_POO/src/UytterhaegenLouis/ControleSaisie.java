package UytterhaegenLouis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleSaisie {

	private static final String EMAIL_PATTERN
	= "^[\\w._-]{2,64}@[\\w.-]{2,292}.[a-zA-Z]{2,64}$"; // Accepte les lettres, points et tirets de 1 à 64 caractères/Obligation de mettre un @ / accepte les lettres, . , tirets / obligation de mettre un point suivi de minimum 2 lettres

	private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	public static boolean valideNom(String text,int taille) {
		String nullString = null;
		String vide = new String();
		boolean estNull = text.equals(nullString);
		boolean estVide = text.equals(vide);
		text = text.trim(); // Permet de supprimer les blancs inutiles
		if(estNull || estVide){
			System.out.println("La valeur est nulle ou vide !");
			return false;
		} 
		else{
			if (text.matches("^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$") && text.length() <= taille) { // permet les noms avec des tirets, des espaces et des apostrophes
				return true;
			}
			else {
				System.out.println("Texte Invalide !");
			}
		}
		return false;

	}
	
	public static boolean valideNomFichier(String nomFichier,int taille) { // vérifie la validité du nom du fichier
		String nullString = null;
		String vide = new String();
		boolean estNull = nomFichier.equals(nullString);
		boolean estVide = nomFichier.equals(vide);
		nomFichier = nomFichier.trim(); // Permet de supprimer les blancs inutiles
		if(estNull || estVide){
			System.out.println("Nom de fichier est nul ou vide !");
			return false;
		} 
		else{
			if (nomFichier.matches("^[^/<>*:\\\\?\"|]{1,}(.txt)$") && nomFichier.length() <= taille) { // vérifie que le nom du fichier est correct( qu'il ne contient pas de caractères interdit ) et qu'il ne dépasse pas la taille limite
		        return true;
			}
			else {
				System.out.println("Nom de fichier invalide !");	
			}
		}
		return false;

	}

	public static boolean valideEmail( String hex) { // Vérifie que le pattern de l'email est correct

		Matcher matcher = pattern.matcher(hex);
		return matcher.matches();
	}

}
