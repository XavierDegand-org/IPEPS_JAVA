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
		if (btnAffichageListener.Perso.size() != 0 )
		{
			
		  
		  System.out.println("Introduire les information de la persone à modifier :");
		  
		  String personne_a_modifier = InputData.inputNomPrenom("nom");
		    
		    
		  
		  for(int i=0; i < btnAffichageListener.Perso.size(); i++)
		    {
		        if( btnloadListener.Personne[i].getNom().equalsIgnoreCase(personne_a_modifier) )
		        {
		        	ID_a_modifier =  i ;
		        	personne_trouve = 1 ;
		        }
		        else if( personne_trouve != 1)
		        {
		        	personne_trouve = 0 ;
		        }

		    }

		  if ( personne_trouve != 0)
		  {
			int ID_a_afficher = ID_a_modifier +1;
			
			
			System.out.print(ID_a_afficher+" ");
				
				
			System.out.println( btnAffichageListener.AffichageResume(ID_a_modifier) );
		

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



