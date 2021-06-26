package Dorian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public  class btnAffichageListener implements ActionListener
{
   static List<Personnel> Perso = new ArrayList<>();

   public void actionPerformed(ActionEvent e) 
	
	{   
	  
	   if(btnloadListener.Tableau_personal_name.size() != 0) // Empeche de l'utilise si égale a Zéro
	   {
	   
	    System.out.println("+------------------------------+------------------------------+------------------------------+---------------+--------------+----------------------------+");	
		System.out.println("+ Département                  | Prénom                       | Nom                          |Sexe           | Naissance    | Email                      +");	
		System.out.println("+------------------------------+------------------------------+------------------------------+---------------+--------------+----------------------------+");	
		
        Perso.clear();
             
		for(int i=0; i < btnloadListener.Tableau_personal_name.size(); i++) // ajoute Personne a perso
	    {
		  Perso.add(btnloadListener.Personne[i]);
		}
		
		
		
	    for(int i=0; i < Perso.size(); i++) //boucle sur taille de pers
	    {
	        
	    		System.out.println( Perso.get(i) );	 //affiche 
		
	    }

		}else	
		{
			
			System.out.println("liste non chargé");
		}
			
		
	}
   
   
   
   public static String AffichageResume(int ID) //information rapide 
{
	  
	  return String.format("%s -- %s -- %s -- %s -- %s"
			  ,btnloadListener.Personne[ID].getNom()
			  ,btnloadListener.Personne[ID].getPrenom()
			  ,btnloadListener.Personne[ID].getSexe()
			  ,btnloadListener.Personne[ID].getEmail()
			  ,btnloadListener.Personne[ID].getDepartement()
			  );
}
   
   
   
}


		


	
