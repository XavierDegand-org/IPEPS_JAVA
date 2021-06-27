package NathanaëlDuyck;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Lire {
	
	
	static Scanner clavier = new Scanner(System.in);
	
	/*Méthode pour lire un texte qui est entrer par l'utilisateur grâce au scanner
	 * A 2 exceptions, NoSuchElementException et le IllegalStateException.
	 */
	public static String texte() {
		String texte = "Erreur";
		try {
			texte = clavier.nextLine();
		} catch (NoSuchElementException e) {
			vider();
			System.out.println("Si aucune ligne a été trouvé");
		}catch(IllegalStateException e) {
			vider();
			System.out.println("Si le scanneur a été fermé");
		}
		return texte;
				
	}	
	/*Méthode pour lire un nombre qui est entrer par l'utilisateur grâce au scanner
	 * A 3 exceptions, NoSuchElementException et le IllegalStateException et InputMismatchException.
	 */
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
				System.out.println("Erreur,veuillez recommencer ! Veuillez entrer un chiffre s.v.p !");
			}		
			catch (NoSuchElementException e) {
				vider();
				System.out.println("Si aucune ligne a été trouvé");
			}catch(IllegalStateException e) {
				vider();
				System.out.println("Si le scanneur a été fermé");
			}
		}while(!loop);
		return result;
										
	}
	/*Méthode pour vider le scanner
	 * A 2 exceptions, NoSuchElementException et le IllegalStateException.
	 */
	public static void vider() {
		try {
			clavier.nextLine();
		} catch (NoSuchElementException e) {
			vider();
			System.out.println("Si aucune ligne a été trouvé");
		}catch(IllegalStateException e) {
			vider();
			System.out.println("Si le scanneur a été fermé");
		}
	}
	
}
