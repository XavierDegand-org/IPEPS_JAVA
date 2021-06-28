package Aude;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lire {

	static Scanner clavier = new Scanner(System.in);
	static BufferedReader kb = new BufferedReader (new InputStreamReader(System.in));
	
	public static String texte () {
		boolean saisieCorrecte = false;
		String saisie = " ";
		while(saisieCorrecte) {
		try {
			if (saisie == null || saisie == "" || saisie == " ") {
				System.out.println("Vous n'avez rien saisi, veuillez recommencer:");
			}
			else {
				saisie = clavier.nextLine();
				saisieCorrecte = true;
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println("Exception thrown : "+e);
		} 
		
	}
		return saisie;
	}
	
	public static int nbre() {
		int result = 0;
		try {
			if (clavier.hasNextInt()) {
				result = clavier.nextInt();
			}
			else
			{
				System.out.println("L'entrée n'est pas un chiffre.");
				Lire.vider();
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println("Exception thrown : "+e);
		}
		return result;
	}
	public static void vider() {
		try {
			clavier.nextLine();
		} catch (NoSuchElementException e) {
			vider();
			System.out.println("if no line was found ");
		}catch(IllegalStateException e) {
			vider();
			System.out.println("if this scanner is closed");
		}
	}
}
