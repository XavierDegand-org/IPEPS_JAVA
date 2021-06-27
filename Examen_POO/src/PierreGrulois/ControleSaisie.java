package PierreGrulois;

import java.util.regex.PatternSyntaxException;

public class ControleSaisie {
	final static String EMAIL_PATTERN
    = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-][a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9-]+\\.[a-z]{2,}$";	
	final static String regNom = "^[A-Z][a-zA-Z' -]{1,29}$";
	final static String regNomFile =  "^[a-zA-Z0-9_!#$&'+=`{}~^. -]{1,30}$";
	
	
	public static boolean valideNom(String nom) {
		try {
			return nom.matches(regNom);
		}catch(PatternSyntaxException e) {
			System.out.println("Le RegEx est invalide.");
			return false;
		}
	}	
	
	public static boolean valideNomFichier(String nomFile) {
		
		try {
			return nomFile.matches(regNomFile);
		}catch(PatternSyntaxException e) {
			System.out.println("Le RegEx est invalide.");
			return false;
		}
		
	}
	
	public static boolean ValideMail(String email) {
		
		try {
			return email.matches(EMAIL_PATTERN);
		}catch(PatternSyntaxException e) {
			System.out.println("Le RegEx est invalide.");
			return false;
		}
	}
}
