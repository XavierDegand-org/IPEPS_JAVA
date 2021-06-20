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
	
	static ArrayList<String> Tableau_personal_name      = new ArrayList<String>(0);
	static ArrayList<String> Tableau_personal_surname   = new ArrayList<String>(0);
	static ArrayList<String> Tableau_personal_sex       = new ArrayList<String>(0);
	static ArrayList<String> Tableau_personal_brihday_j = new ArrayList<String>(0);
	static ArrayList<String> Tableau_personal_brihday_m = new ArrayList<String>(0);
	static ArrayList<String> Tableau_personal_brihday_y = new ArrayList<String>(0);
	static ArrayList<String> Tableau_personal_email     = new ArrayList<String>(0);
	static ArrayList<String> Tableau_personal_prod      = new ArrayList<String>(0);
	
	static Individu[] Personne = new Individu[13];
	
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

		  		        	final String separateur2 = "/";
		  		    		String date[] = mots[i].split(separateur2);
		  		    		
		  		    		for (int j = 0; j < date.length; j++)
		  		    		{ 
		  		    			
		  		    			switch ( j ) 
		  			    		{
		  		    			case 0:
		  		    				Tableau_personal_brihday_j.add(date[j]) ;
		  			    			break;
		  			    			
		  			    		case 1:
		  			    			Tableau_personal_brihday_m.add(date[j]) ;
		  			    			break;
		  		    		
		  		    			case 2:
		  		    				Tableau_personal_brihday_y.add(date[j]) ;
		  		    				break; 
		  			    	    }
		  		    		}

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
		   

		  for(int i= 0; i < btnloadListener.Tableau_personal_name.size(); i++)
		  {
			  
			  int ID = i ; 
			  
		Personne[i] = new Individu
				(
				  
				  Departement.valueOf( btnloadListener.Tableau_personal_prod.get(ID) ),
				  btnloadListener.Tableau_personal_surname.get(ID),
				  btnloadListener.Tableau_personal_name.get(ID),
				  Sexe.valueOf(btnloadListener.Tableau_personal_sex.get(ID) ),
				  new MyDate(
						  Integer.parseInt(btnloadListener.Tableau_personal_brihday_j.get(ID) ),
						  Integer.parseInt(btnloadListener.Tableau_personal_brihday_m.get(ID) ),
					      Integer.parseInt(btnloadListener.Tableau_personal_brihday_y.get(ID) ) 
						  ),			  
		  		 btnloadListener.Tableau_personal_email.get(ID)
		  		 
				  );
		
		  }
		  

		    System.out.println("le ficher est chargé en mémoire\n");

 
		} catch (IOException e1) 
		{
			
         	System.out.println("le ficher  ne peut etre ouvert\n");
		}
    }
}