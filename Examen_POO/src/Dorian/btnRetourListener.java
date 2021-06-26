package Dorian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class btnRetourListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(btnMagListener.Tableau_Mag_name.size() != 0 && btnloadListener.Tableau_personal_name.size() !=0 ) // empeche d'utiliser le button retour s'il a rien 
	    {
		
		
		if(btnpretListener.emprunt.size() !=0)	 // empche de faire un retour si emprunt et vide 
		{   
			System.out.println("-----------------------");
			System.out.println("Liste des emprunts");
			System.out.println("-----------------------");
			int temp = 0;
			for(int i=0; i <btnpretListener.emprunt.size(); i++) //boucle sur taille de emprunt
			{   
			temp = i + 1;
	    	System.out.println("N°"+ temp + " " + btnpretListener.emprunt.get(i).toString2() ); //affiche les emprunt 
		    }
			System.out.println("-----------------------");
			
			System.out.println("Entrer le numéro d'emprunt à annuler : ");
			int Emprunt_annuler = Lire.nbre_limité(1,btnpretListener.emprunt.size()) - 1; //demande le numéro a annulé 1 pour le tableau
			
			
	        int article =  btnpretListener.emprunt.get(Emprunt_annuler).getArticle(); //recuperer les info de l'article a annulé
	        
	         
			btnMagListener.Article[article].setEmprunteur(0); //setemprunteur a 0 afin de le rendre disponible 
	        
	        btnpretListener.emprunt.remove(Emprunt_annuler); //sup l'emprunt du tableau d'affichage 
	

			System.out.println("-----------------------");
			System.out.println("Liste des emprunts");
			System.out.println("-----------------------");
			 temp = 0;
			for(int i=0; i <btnpretListener.emprunt.size(); i++)
			{   
			temp = i + 1;
	    	System.out.println("N°"+ temp + " " + btnpretListener.emprunt.get(i).toString2() ); //affiche les autre emprunt encore dispo
		    }
			System.out.println("-----------------------");

		}else
		{
			System.out.println("Liste des emprunts");
			System.out.println("-----------------------");
			System.out.println("aucun article emprunter");
			System.out.println("-----------------------");
		}
		
    }else
    {
    	System.out.println("pas d'information chargé"); // explique l'interdit
    }
	
	}
}