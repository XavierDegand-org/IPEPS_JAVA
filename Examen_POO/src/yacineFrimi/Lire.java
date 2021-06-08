package yacineFrimi;

import java.util.NoSuchElementException;
import java.util.Scanner;



public class Lire {
	
	static Scanner clavier = new Scanner(System.in);
	
	
	public static String texte() {
		return clavier.nextLine();		
	}
	
	public static int nbre() {
		int entrée = 0;
		boolean testEntrée = true;
		while (testEntrée) {
		try {
			entrée = clavier.nextInt();
			testEntrée = false;
			
		}catch (java.util.InputMismatchException e) {
			System.out.println("Veuillez entrer un entier.");
			Lire.vider();
		}catch (NoSuchElementException e) {
			   System.out.println("erreur "+e.toString());
			   System.out.println( "Saisie impossible !" );						   
		   }	
	   catch (IllegalStateException e) {
			   System.out.println("erreur "+e.toString());
			   System.out.println( "Saisie impossible !" );	
		   }
		}
		return entrée;
	} 
		
	
	public static void vider() {
		clavier.nextLine();
	}

}
