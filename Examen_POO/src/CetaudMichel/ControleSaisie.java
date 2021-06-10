package CetaudMichel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleSaisie {

	public static boolean valideNom(String text, int taille) {
		String nullString = null;
		String vide = new String();
		boolean estNull = text.equals(nullString);
		boolean estVide = text.equals(vide);

		if (estNull || estVide) {
			System.out.println("Valeur null ou vide !");
			return false;
		} else {
			if (text.matches("^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$") && text.length() <= taille) {
				return true;
			} else {
				System.out.println("Valeur hors contraintes ! Veuillez réessayer.");
			}
		}
		return false;

	}

	public static boolean valideEmail(final String hex) {
		String EMAIL_PATTERN = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);

		Matcher matcher = pattern.matcher(hex);
		if (matcher.matches()) {
			return true;
		} else {
			System.out.println("Valeur hors contraintes ! Veuillez réessayer.");
			return false;
		}

	}

	public static boolean valideNomFichier(String text, int taille) {
		String nullString = null;
		String vide = new String();
		boolean estNull = text.equals(nullString);
		boolean estVide = text.equals(vide);

		if (estNull || estVide) {
			System.out.println("Valeur null ou vide !");
			return false;
		} else {
			if (text.matches("^([a-zA-Z0-9'\\-])+$") && text.length() <= taille) {
				return true;
			} else {
				System.out.println("Valeur hors contraintes ! Veuillez réessayer.");
			}
		}
		return false;

	}
}
