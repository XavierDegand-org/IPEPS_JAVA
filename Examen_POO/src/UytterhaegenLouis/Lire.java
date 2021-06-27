package UytterhaegenLouis;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Lire {


	static Scanner clavier = new Scanner(System.in);

	public static String texte() {
		String texte = ""; // Variable pour éviter la double saisie
		try {
			texte = clavier.nextLine();
		} catch (NoSuchElementException e) {
			vider();
			System.out.println("Erreur, Aucune ligne n'a été trouvée");
		}catch(IllegalStateException e) {
			vider();
			System.out.println("Erreur, le Scanner est fermé");
		}
		return texte;

	}	

	public static int nbre() {
		int result = 0; // Variable pour éviter la double saisie
		boolean loop = false;						
		while (!loop) {										
			try {				// tente de convertir le result en int					
				result = clavier.nextInt();
				loop = true;
				vider();
			}
			catch(InputMismatchException e) {		
				vider();
				System.out.println("Erreur ! Veuillez entrer un nombre !");
			}		
			catch (NoSuchElementException e) {
				vider();
				System.out.println("Erreur, Aucune ligne n'a été trouvée");
			}catch(IllegalStateException e) {
				vider();
				System.out.println("Erreur, le Scanner est fermé");
			}

		}
		return result;

	}

	public static void vider() { // méthode qui permet de vider le scanner
		try {
			clavier.nextLine();
		} catch (NoSuchElementException e) {
			vider();
			System.out.println("Erreur, Aucune ligne n'a été trouvée");
		}catch(IllegalStateException e) {
			vider();
			System.out.println("Erreur, le Scanner est fermé");
		}
	}

}