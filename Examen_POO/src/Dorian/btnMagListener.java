package Dorian;


import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.crypto.Mac;

import com.sun.tools.javac.Main;



public class btnMagListener implements ActionListener
{
	static ArrayList<String> Tableau_Mag_name = new ArrayList<String>(0);
	static ArrayList<String> Tableau_Mag_puissance = new ArrayList<String>(0);
	static ArrayList<String> Tableau_Mag_ID = new ArrayList<String>(0);
	
	static HashMap< Integer, String> Magasin = new HashMap < Integer, String>();
	static Produit[] Produit = new Produit[7];
	static Emprunt[] Article = new Emprunt[7];
	
	
	static String pwd = System.getProperty("user.dir");
	static File file_Mag = new File(pwd + "/" +"src"+ "/" + "Dorian" + "/" +  "Produit.txt");

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		try 
		{
			if(Tableau_Mag_name.size() == 0)  // lance si tableau et à zérp
			{
			
			FileInputStream file = new FileInputStream(file_Mag);  // une nouvelle variable avec les information du fichier 
		    Scanner scanner = new Scanner(file); // scanne le ficher file 
		    while( scanner.hasNextLine() ) // ligne par ligne 
		    {
		    	final String separateur = ";";
		    	String mots[] = scanner.nextLine().split(separateur); //separe dans les ligne a chaque ;
		    	for ( int i = 0; i < mots.length; i ++) //boucle pour entre les informatons dans les tableau 
		    	{	
		    		switch ( i ) 
		    		{
		    		case 0:
		    			Tableau_Mag_name.add( mots[i]);
		    			break;
		    		case 1:
		    			Tableau_Mag_puissance.add( mots[i]);
		    			break;	
		    			
		    	    }
	    		
		        } 
	
		    }
		    scanner.close(); //ferme la recherche d'information dans le doc 
		    
		    
		    //Magasin.clear();
		    		    
		    System.out.println("le magasin est composé de "+ Tableau_Mag_name.size()+" articles");
	    
		    for(int i= 0; i < Tableau_Mag_name.size(); i++)// boucle sur la taille de name
			  {
				  
				  
			Produit[i] = new Produit( Integer.toString(i),Tableau_Mag_name.get(i), Tableau_Mag_puissance.get(i) ); //créer les produit avec les information 
			
			 //System.out.println( Produit[i] );
			
			  }
		    
		    

		   
		    for(int i=0; i < Tableau_Mag_name.size(); i++) // add les information dans magasin
		    {	    	
			  Magasin.put(i,Produit[i].toString());
			 
			}
		    
		    
		    for(int i= 0; i < Tableau_Mag_name.size(); i++) // affichage 
			{
		    System.out.println(Magasin.get(i));
		    }
		    
		    
		    for(int i= 0; i < Tableau_Mag_name.size(); i++) // créer les emprunt avec Zéro pour dire dispo
			  {
				
		    	
			Article[i] = new Emprunt(i, 0 , btnMagListener.Produit[i].getIDProduit() );
			
			  }
		    

		    
		}else
		{
			 System.out.println("le Magasin est deja chargé en mémoire");
		}
		    

    
		}catch(IOException e1) 
	
			{
		
			System.out.println("le ficher " +file_Mag+" ne peut etre ouvert\n");
			
			}
	
  }
}