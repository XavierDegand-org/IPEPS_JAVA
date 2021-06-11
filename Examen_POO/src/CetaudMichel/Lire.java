package CetaudMichel;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lire {

	static Scanner clavier = new Scanner(System.in);

	public static String texte() {
		String texte = "Erreur";
		try {
			texte = clavier.nextLine();
		} catch (NoSuchElementException e) {
			vider();
			System.out.println("if no line was found ");
		} catch (IllegalStateException e) {
			vider();
			System.out.println("if this scanner is closed");
		}
		return texte;

	}

	public static char caractere() {
		char caractere = 0;
		try {
			caractere = clavier.nextLine().charAt(0);
		} catch (NoSuchElementException e) {
			vider();
			System.out.println("if no line was found ");
		} catch (IllegalStateException e) {
			vider();
			System.out.println("if this scanner is closed");
		}
		return caractere;

	}

	public static int nbre() {
		int result = 0;
		boolean loop = false;
		do {
			try {
				result = clavier.nextInt();
				loop = true;
			} catch (InputMismatchException e) {
				vider();
				System.out.println("Erreur, veuillez recommencer ! Veuillez entrer un chiffre s.v.p !");
			} catch (NoSuchElementException e) {
				vider();
				System.out.println("if no line was found ");
			} catch (IllegalStateException e) {
				vider();
				System.out.println("if this scanner is closed");
			}

		} while (!loop);
		return result;

	}

	public static void vider() {
		try {
			clavier.nextLine();
		} catch (NoSuchElementException e) {
			vider();
			System.out.println("if no line was found ");
		} catch (IllegalStateException e) {
			vider();
			System.out.println("if this scanner is closed");
		}
	}

}