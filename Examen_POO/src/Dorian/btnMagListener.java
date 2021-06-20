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
	
	
	static String pwd = System.getProperty("user.dir");
	static File file_Mag = new File(pwd + "/" +"src"+ "/" + "Dorian" + "/" +  "Produit.txt");

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		try 
		{
			FileInputStream file = new FileInputStream(file_Mag);   
		    Scanner scanner = new Scanner(file);  	    
		    while( scanner.hasNextLine() )
		    {
		    	final String separateur = ";";
		    	String mots[] = scanner.nextLine().split(separateur);
		    	for ( int i = 0; i < mots.length; i ++)
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
		    scanner.close(); 
		    
		   for( int i = 0; i < Tableau_Mag_name.size(); i++ )
		   {
			   
			   String ID = Integer.toString(i+1);
			   
			   Tableau_Mag_ID.add(ID);
	 
		   }
		    
		   System.out.println("le magasin est composé de 7 articles");
		   

		    List<Produit> Magasin = new ArrayList<>();
		    Magasin.add(new Produit(  Tableau_Mag_ID.get(0),Tableau_Mag_name.get(0),Tableau_Mag_puissance.get(0) ) );
		    Magasin.add(new Produit(  Tableau_Mag_ID.get(1),Tableau_Mag_name.get(1),Tableau_Mag_puissance.get(1) ) );
		    Magasin.add(new Produit(  Tableau_Mag_ID.get(2),Tableau_Mag_name.get(2),Tableau_Mag_puissance.get(2) ) );
		    Magasin.add(new Produit(  Tableau_Mag_ID.get(3),Tableau_Mag_name.get(3),Tableau_Mag_puissance.get(3) ) );
		    Magasin.add(new Produit(  Tableau_Mag_ID.get(4),Tableau_Mag_name.get(4),Tableau_Mag_puissance.get(4) ) );
		    Magasin.add(new Produit(  Tableau_Mag_ID.get(5),Tableau_Mag_name.get(5),Tableau_Mag_puissance.get(5) ) );
		    Magasin.add(new Produit(  Tableau_Mag_ID.get(6),Tableau_Mag_name.get(6),Tableau_Mag_puissance.get(6) ) );
	
		   
		    for (Produit Produit : Magasin)
		    {
		    	System.out.println(Produit.toString());
	
		    }
		    

    
		}catch(IOException e1) 
	
			{
		
			System.out.println("le ficher " +file_Mag+" ne peut etre ouvert\n");
			
			}
	
}
	}