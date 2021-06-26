package Dorian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class btnpretListener implements ActionListener
{
	static ArrayList<Emprunt> emprunt = new ArrayList<>(0);
	
	String Nom_du_matériel;
	int ID_de_emprunteur;
	int ID_objet_emprunter;
    
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	

		if(btnMagListener.Tableau_Mag_name.size() != 0 && btnloadListener.Tableau_personal_name.size() !=0 ) // empeche d'utilise le button sans information
	    {
			if(emprunt.size() < 7)// max d'emprunt dispo
			{
		
		if(emprunt.size() !=0) // si emprunt et égale a zéro il est vide 
		{
			
			System.out.println("-----------------------");
			for(int i=0; i <emprunt.size(); i++)
			{   
	    	System.out.println( emprunt.get(i).toString() ); // affiche les emprunt effectué
		    }
			System.out.println("-----------------------");
			
		
		}else
		{
			System.out.println("-----------------------");
			System.out.println("aucun article emprunter");
			System.out.println("-----------------------");
		}
		
	
    for(int i= 0; i < btnloadListener.Tableau_personal_name.size(); i++) // boucle sur la taille de Tableau_personal_name
    {
    	System.out.println(btnloadListener.Personne[i].toString3()); //affichage du personnel
    }
		
		
		

	System.out.println("Entrer le numéro de la personne qui emprunte : ");
	ID_de_emprunteur = Lire.nbre_limité(1, 13) ;  
	System.out.println(" Enter le numéro de l'objet emprenter : ");
	ID_objet_emprunter = Lire.nbre_limité(1,7) ;
	int ID_objet_Corrigé = ID_objet_emprunter - 1 ; // permet de respecté le tableau
	int ID_de_emprunteur_Corrigé = ID_de_emprunteur - 1;
	
	
	
	
	if(btnMagListener.Article[ID_objet_Corrigé].getEmprunteur()!= 0)//vérifie sir l'article et deja emprunter
	{
      System.out.println("article deja emprunter");
    
  	}
    else
	{
		
    	btnMagListener.Article[ID_objet_Corrigé].setEmprunteur(ID_de_emprunteur_Corrigé); //article set avec les information 
    	btnpretListener.emprunt.add(btnMagListener.Article[ID_objet_Corrigé]); //add dans tableau d'affichage

	}
	


    /*System.out.println("--------------"+btnloadListener.Personne[ID_de_emprunteur_Corrigé]);
	 System.out.println(btnMagListener.Article[ID_objet_emprunter]);
	 System.out.println("--------------");*/

	
	for(int i=0; i <emprunt.size(); i++) //boucle sur la taille de emprunt 
    {   
		
		
    	System.out.println( emprunt.get(i).toString() ); // affichage des emprunt 
	 	
	}
	
	
	  }
	  else
	  {
          	System.out.println(" Limite d'emprunt max ");
	  }
			

	}
	else
	{
		System.out.println("Pas d'information");
	}
	
			
		
   }   
	
	
}