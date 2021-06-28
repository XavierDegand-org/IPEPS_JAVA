package Ilyasse;


import java.util.NoSuchElementException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lire {

	static Scanner clavier = new Scanner(System.in);
	
	
	public static int nbre() 
	{		
		try
		{
			clavier.hasNextInt();						
			
			int valeurClavier = clavier.nextInt();
			return valeurClavier;							
		}
		catch (InputMismatchException e)
		{
			System.out.println("Erreur : " + e + "\nEntrer un nombre : ");
			vider();
			nbre();
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Erreur : + " + e);
			vider();
			nbre();
		}	
		return 0;
	}
	
	
	public static String texte()
	{
		return clavier.nextLine();
	}
	
	// Vider le scanner
	public static void vider() {
		if (clavier.hasNextLine())
			clavier.nextLine();
		else
			System.out.println("Clavier est deja vide");
	}
	
	
}