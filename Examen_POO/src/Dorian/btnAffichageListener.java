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
	  
	   if(btnloadListener.Tableau_personal_name.size() != 0)
	   {
	   
	    System.out.println("+------------------------------+------------------------------+------------------------------+---------------+--------------+----------------------------+");	
		System.out.println("+ Département                  | Prénom                       | Nom                          |Sexe           | Naissance    | Email                      +");	
		System.out.println("+------------------------------+------------------------------+------------------------------+---------------+--------------+----------------------------+");	
		
        Perso.clear();
             
		for(int i=0; i < btnloadListener.Tableau_personal_name.size(); i++)
	    {
		  Perso.add(btnloadListener.Personne[i]);
		}
		
		
		
	    for(int i=0; i < Perso.size(); i++)
	    {
	        
	    		System.out.println( Perso.get(i) );	
		
	    }

		}else	
		{
			
			System.out.println("liste non chargé");
		}
			
		
	}
   
   
   
   public static String AffichageResume(int ID)
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


		


	
