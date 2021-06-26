package Dorian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class btnSauvegardeListener implements ActionListener
{
	//private static String pwd = System.getProperty("user.dir");
	//private static final String File_Path = pwd + "/" +"src"+ "/" + "Dorian" + "/";
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(btnMagListener.Tableau_Mag_name.size() != 0 && btnloadListener.Tableau_personal_name.size() !=0 ) // interdit de save temps qu'il n'a rien 
	    {
		
		
		System.out.println("introduire le nom du fichier extension txt");
		String nom_du_fichier = InputData.Nom_Fichier(); //entre le nom de fichier via un controle de saisie nom de fichier
		//File_Path = File_Path ;
		String pwd = System.getProperty("user.dir"); //repertoire au je lance le programme
		File outFile = new File(pwd + "/" +"src"+ "/" + "Dorian" + "/"+nom_du_fichier+".txt"); //ajoute le fichier au repertoire du programme
		//PrintWriter writer;
		
			FileWriter fileWriter; // commence l'ecriture dans le fichier
			try {
				fileWriter = new FileWriter(outFile, true); // nouv fichier + ecrire en dessous 
				
				SimpleDateFormat DTG = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //format de l'écriture de la date 
			    Date date = new Date();
			    
			    System.out.println("DTG de la sauvegarde : "+DTG.format(date)); // montre la date 
			    fileWriter.write("DTG de la sauvegarde : "+DTG.format(date) ); // ecrit la date dans le fichier
			    fileWriter.write("\n"); // espace pour le fichier 
				System.out.println("+------------------------------+------------------------------+------------------------------+---------------+--------------+----------------------------+");	
				System.out.println("+ Département                  | Prénom                       | Nom                          |Sexe           | Naissance    | Email                      +");	//montre l'affichage du fichier
				System.out.println("+------------------------------+------------------------------+------------------------------+---------------+--------------+----------------------------+");
				
				fileWriter.write("+------------------------------+------------------------------+------------------------------+---------------+--------------+----------------------------+");	
				fileWriter.write("\n");
				fileWriter.write("+ Département                  | Prénom                       | Nom                          |Sexe           | Naissance    | Email                      +");	 // ecrit dans le fichier
				fileWriter.write("\n");
				fileWriter.write("+------------------------------+------------------------------+------------------------------+---------------+--------------+----------------------------+");
				fileWriter.write("\n");
				
				 for(int i=0; i < btnAffichageListener.Perso.size(); i++) // boucle selon la taille de perso
				    {
				        
				    		System.out.println( btnAffichageListener.Perso.get(i) );	// afficher le perso a ecrire 
				    		fileWriter.write( btnAffichageListener.Perso.get(i).toString() );// ecrit dans le fichier
				    		fileWriter.write("\n");
				    }
				 
				 System.out.println("+----------+------------------------------+-------------------------------+");	
			     System.out.println("+ N°       | Nom - Prénom                 | Matériel                      |");	//montre l'affichage
			     System.out.println("+----------+------------------------------+-------------------------------+");
				 
			     fileWriter.write("+----------+------------------------------+-------------------------------+");	
			     fileWriter.write("\n");
			     fileWriter.write("+ N°       | Nom - Prénom                 | Matériel                      |");	//ecrit dans le doc
			     fileWriter.write("\n");
			     fileWriter.write("+----------+------------------------------+-------------------------------+");
			     fileWriter.write("\n");
			     
					int temp = 0;
					for(int i=0; i <btnpretListener.emprunt.size(); i++) // boucle sur la taile de emprunt
					{   
					temp = i + 1;
			    	System.out.println( temp + "          " + btnpretListener.emprunt.get(i).toString3() ); //montre dans le console
			    	fileWriter.write( temp + "          " + btnpretListener.emprunt.get(i).toString3() ); // ecrit dans le fichier
			    	fileWriter.write("\n");
				    }
					fileWriter.close(); // save
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	    }else
	    {
	    	System.out.println("Rien à sauvegarder "); //explication de l'interdit
	    }
			
		
	    

	}
	
	
}