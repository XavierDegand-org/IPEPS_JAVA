package Jessica;

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
			System.out.println(" si aucune ligne n'a été trouvée. ");
		}catch(IllegalStateException e) {
			vider();
			System.out.println(" si le scanner est fermé.");
		}
		return texte;
				
	}	
	 
	public static int nbre() {
		int result = 0;
		boolean loop = false;						
		do {										
			try {									
				result = clavier.nextInt();
				loop = true;
			}
			catch(InputMismatchException e) {		
				vider();
				System.out.println("Erreur, veuillez recommencer ! Veuillez entrer un chiffre s.v.p !");
			}		
			catch (NoSuchElementException e) {
				vider();
				System.out.println("Erreur si aucune ligne n'a été trouvée.");
			}catch(IllegalStateException e) {
				vider();
				System.out.println("Erreur si le scanner est fermé.");
			}
			
		}while(!loop);
		return result;
										
	}
	
	public static void vider() {
		try {
			clavier.nextLine();
		} catch (NoSuchElementException e) {
			vider();
			System.out.println("Erreur si aucune ligne n'a été trouvée.");
		}catch(IllegalStateException e) {
			vider();
			System.out.println("Erreur si le scanner est fermé.");
		}
	}
	
}