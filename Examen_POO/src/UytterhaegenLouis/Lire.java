package UytterhaegenLouis;

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
			System.out.println("No line was found ");
		}catch(IllegalStateException e) {
			vider();
			System.out.println("Scanner is closed");
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
				System.out.println("No line was found ");
			}catch(IllegalStateException e) {
				vider();
				System.out.println("This scanner is closed");
			}
			
		}while(!loop);
		return result;
										
	}
	
	public static void vider() {
		try {
			clavier.nextLine();
		} catch (NoSuchElementException e) {
			vider();
			System.out.println("No line was found ");
		}catch(IllegalStateException e) {
			vider();
			System.out.println("This scanner is closed");
		}
	}
	
}