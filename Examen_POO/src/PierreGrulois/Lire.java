package PierreGrulois;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lire {
	
	static Scanner clavier = new Scanner(System.in);
	
	
	
	public static String texte() {
		String saisie = "";  // j'utilise une variable pour éviter la double saisie. 
		try {
			saisie = clavier.nextLine();
		}catch (java.util.NoSuchElementException e) {
			System.out.println("Aucune ligne n'a été trouver.");
		}catch (java.lang.IllegalStateException e) {
			System.out.println("Le scanner est fermé.");
		}
		return saisie;
	}
	
	
	public static int nbre() {
		int saisie = 0;    // j'utilise une variable pour éviter la double saisie. 
		try { 
			saisie = clavier.nextInt();
		}catch (java.util.InputMismatchException e) {
			System.out.println("L'entrer n'est pas un entier ou elle est hors de portée.");
		}catch (java.util.NoSuchElementException e) {
			System.out.println("L'entrée est épuisée.");
		}catch (java.lang.IllegalStateException  e) {
			System.out.println("aucune entrée n'a été trouvée.");
		}
		return saisie;
	}

	public static void vider() {
		try{
			clavier.nextLine();
		}catch(NoSuchElementException e) {
			System.out.println("Aucune ligne n'a été trouvée.");
		}catch(IllegalStateException e) {
			System.out.println("Le scanner est fermé.");
		}
	}
	
}