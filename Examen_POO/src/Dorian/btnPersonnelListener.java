package Dorian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class btnPersonnelListener implements ActionListener
{

	int ID_a_modifier = 0 ; 
	int personne_trouve = 0 ;
	


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (btnAffichageListener.Perso.size() != 0 ) // permet de ne pas utilise le button sans rien 
		{
			
		  
		  System.out.println("Introduire les information de la persone à modifier :");
		  
		  String personne_a_modifier = InputData.inputNomPrenom("nom"); // demande le nom de la personne a modifier avec un controle de saisie
		    
		    
		  
		  for(int i=0; i < btnAffichageListener.Perso.size(); i++) // boucle sur la taille de perso 
		    {
		        if( btnloadListener.Personne[i].getNom().equalsIgnoreCase(personne_a_modifier) ) // vérifie si la personne existe dans le personnel
		        {
		        	ID_a_modifier =  i ;
		        	personne_trouve = 1 ;
		        }
		        else if( personne_trouve != 1)
		        {
		        	personne_trouve = 0 ;
		        }

		    }

		  if ( personne_trouve != 0) // si trouve effectue la suite 
		  {
			int ID_a_afficher = ID_a_modifier +1; //pour respecte les tableau
			
			
			System.out.print(ID_a_afficher+" "); //affiche 
				
				
			System.out.println( btnAffichageListener.AffichageResume(ID_a_modifier) ); // affiche un résumé
		

			System.out.println("Introduire les nouvelle valeur: ");
			
			
			//System.out.print("Entrer un nom"); 
			btnloadListener.Personne[ID_a_modifier].setNom(InputData.inputNomPrenom("nom"));
			//System.out.print("Entrer un prénom"); 
			btnloadListener.Personne[ID_a_modifier].setPrenom(InputData.inputNomPrenom("prénom"));
			//System.out.print("Entrer une adresse mail");
			btnloadListener.Personne[ID_a_modifier].setEmail(InputData.inputEmail());

			

		  }else
		  {
			System.out.println ("Personne n'a été trouver relance une mofication des données !");
		  }
		  
		  
		  
		}else	
		{		
			System.out.println("liste non chargé");
			
		}
			
		
    }

	
	
}



