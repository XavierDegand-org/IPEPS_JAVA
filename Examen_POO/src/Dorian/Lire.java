package Dorian;


import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Lire {
	
	
	static Scanner clavier = new Scanner(System.in);
	
	public static String texte() { //vérifie l'entré texte
		String texte = "Erreur";
		try {
			texte = clavier.nextLine();
		} catch (NoSuchElementException e) {
			vider();
			System.out.println("if no line was found ");
		}catch(IllegalStateException e) {
			vider();
			System.out.println("if this scanner is closed");
		}
		return texte;
				
	}	
	 
	public static int nbre() { //ne permetr que de rentrer des chiffre
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
				System.out.println("if no line was found ");
			}catch(IllegalStateException e) {
				vider();
				System.out.println("if this scanner is closed");
			}
			
		}while(!loop);
		return result;
										
	}
	
	
	
	public static int nbre_limité(int min, int max) {//limite l'entre de chiffre entre min et max 
		int result = 0;
		boolean loop = false;						
		do {		

			try {		
				
				result = clavier.nextInt();
				
				if(result > max || result < min  )
				{
					System.out.println("hors limite");
				}else
				{
				  loop = true;
				}
	
			}
			catch(InputMismatchException e) {		
				vider();
				System.out.println("Erreur, veuillez recommencer ! Veuillez entrer un chiffre s.v.p !");
			}		
			catch (NoSuchElementException e) {
				vider();
				System.out.println("if no line was found ");
			}catch(IllegalStateException e) {
				vider();
				System.out.println("if this scanner is closed");
			}
			
		}while(!loop);
		return result;
	}
	
	public static void vider() { //vide 
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


