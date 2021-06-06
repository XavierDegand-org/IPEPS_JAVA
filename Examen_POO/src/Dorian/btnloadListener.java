package Dorian;


import java.util.*;
import java.awt.event.*;
//import java.awt.event.ActionListener;
//import java.io.IOException;
import java.io.*;
//import java.nio.file.LinkOption;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.charset.Charset;
//import java.nio.file.Files;

public class btnloadListener implements ActionListener 
{
	static ArrayList<String> Tableau_personal_name = new ArrayList<String>(0);
	static ArrayList<String> Tableau_personal_surname = new ArrayList<String>(0);
	static ArrayList<String> Tableau_personal_sex = new ArrayList<String>(0);
	static ArrayList<String> Tableau_personal_brihday = new ArrayList<String>(0);
	static ArrayList<String> Tableau_personal_email = new ArrayList<String>(0);
	static ArrayList<String> Tableau_personal_prod = new ArrayList<String>(0);
	
	static String pwd = System.getProperty("user.dir");
	static File file_personal = new File(pwd + "/" +"src"+ "/" + "Dorian" + "/" +  "Personnel.txt");

	
	
	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
			FileInputStream file = new FileInputStream(file_personal);   
		    Scanner scanner = new Scanner(file);  	    
		    while( scanner.hasNextLine() )
		    {
		    	final String separateur = ",";
		    	String mots[] = scanner.nextLine().split(separateur);
		    	for ( int i = 0; i < mots.length; i ++)
		    	{
		    		switch ( i ) 
		    		{
		    		case 0:
		    			Tableau_personal_name.add( mots[i]);
		    			break;
		    		case 1:
		    			Tableau_personal_surname.add( mots[i]);
		    			break;
		    		case 2:
		    			Tableau_personal_sex.add( mots[i]);
		    			break;
		    		case 3:
		    			Tableau_personal_brihday.add( mots[i]);
		    			break;
		    		case 4:
		    			Tableau_personal_email.add( mots[i]);
		    			break;
		    		case 5:
		    			Tableau_personal_prod.add( mots[i]);
		    			break;
		    		}	
		    	}
		    }
		    scanner.close(); 
		    System.out.println("le ficher " +file_personal+" est chargé en mémoire\n");
			
		} catch (IOException e1) 
		{
			
			System.out.println("le ficher " +file_personal+" ne peut etre ouvert\n");
		}
		
		
    }
	

	
}
/*
public Individu(String nom, String prenom, Sexe sexe, MyDate dateNaissance) {
	this.nom = nom;
	this.prenom = prenom;
	this.sexe = sexe;
	this.dateNaissance = dateNaissance;
*/