package Dorian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class btnAffichageListener implements ActionListener
{

	public void actionPerformed(ActionEvent e) 
	{
		int long_name = 0;
		int long_surname = 0;
		int long_sex = 0;
		int long_brihday = 0;
		int long_email = 0;
		int long_prod = 0;
		int numb_espace = 0;
		
		for ( int i = 0; i < btnloadListener.Tableau_personal_name.size(); i++)
	    {
			if ( btnloadListener.Tableau_personal_prod.get(i).length() > long_prod ) { long_prod = btnloadListener.Tableau_personal_prod.get(i).length(); }
			if ( btnloadListener.Tableau_personal_name.get(i).length() > long_name ) { long_name = btnloadListener.Tableau_personal_name.get(i).length(); }
			if ( btnloadListener.Tableau_personal_surname.get(i).length() > long_surname ) { long_surname = btnloadListener.Tableau_personal_surname.get(i).length(); }
			if ( btnloadListener.Tableau_personal_sex.get(i).length() >  long_sex ) { long_sex = btnloadListener.Tableau_personal_sex.get(i).length();}
		    if ( btnloadListener.Tableau_personal_brihday.get(i).length() > long_brihday ) { long_brihday = btnloadListener.Tableau_personal_brihday.get(i).length();}
		    if ( btnloadListener.Tableau_personal_email.get(i).length() > long_email ) { long_email = btnloadListener.Tableau_personal_email.get(i).length();}	    	
	    }
		   
		System.out.print( "+" );
		if ( long_prod < 23 ) { long_prod = 23; }
		for ( int j = 0; j <= long_prod; j++)
		{
			System.out.print("-");
		}
		System.out.print("+" );
		if ( long_surname < 23 ) { long_surname = 23; }
		for ( int j = 0; j <= long_surname; j++)
		{
			System.out.print("-");
		}
		System.out.print("+" );
		if ( long_name < 23 ) { long_name = 23; }
		for ( int j = 0; j <= long_name; j++)
		{
			System.out.print("-");
		}
		System.out.print("+" );
		if ( long_sex < 8 ) { long_sex = 8; }
		for ( int j = 0; j <= long_sex; j++)
		{
			System.out.print("-");
		}
		System.out.print("+" );
		if ( long_brihday < 15 ) { long_brihday = 15; }
		for ( int j = 0; j <= long_brihday; j++)
		{
			System.out.print("-");
		}
		System.out.print("+" );
		if ( long_email < 23 ) { long_email = 23; }
		for ( int j = 0; j <= long_email; j++)
		{
			System.out.print("-");
		}
		System.out.print("+\n" );
			
		System.out.print( "|" );
		System.out.print( "Département" );
		numb_espace = long_prod - 11;
		for ( int j = 0; j <= numb_espace; j++)
		{
			System.out.print(" ");
		}
		System.out.print("|" );		
		
		System.out.print( "Prénom" );
		numb_espace = long_surname - 6;
		for ( int j = 0; j <= numb_espace; j++)
		{
			System.out.print(" ");
		}
		System.out.print("|" );	
		
		System.out.print( "Nom" );
		numb_espace = long_name - 3;
		for ( int j = 0; j <= numb_espace; j++)
		{
			System.out.print(" ");
		}
		System.out.print("|" );	
		
		System.out.print( "Sexe" );
		numb_espace = long_sex - 4;
		for ( int j = 0; j <= numb_espace; j++)
		{
			System.out.print(" ");
		}
		System.out.print("|" );	
		
		System.out.print( "Naissance" );
		numb_espace = long_brihday - 9;
		for ( int j = 0; j <= numb_espace; j++)
		{
			System.out.print(" ");
		}
		System.out.print("|" );	
		
		System.out.print( "Email" );
		numb_espace = long_email - 5;
		for ( int j = 0; j <= numb_espace; j++)
		{
			System.out.print(" ");
		}
		System.out.print("|\n" );	
		
		
		System.out.print( "+" );
		for ( int j = 0; j <= long_prod; j++)
		{
			System.out.print("-");
		}
		System.out.print("+" );
		for ( int j = 0; j <= long_surname; j++)
		{
			System.out.print("-");
		}
		System.out.print("+" );
		for ( int j = 0; j <= long_name; j++)
		{
			System.out.print("-");
		}
		System.out.print("+" );
		for ( int j = 0; j <= long_sex; j++)
		{
			System.out.print("-");
		}
		System.out.print("+" );
		for ( int j = 0; j <= long_brihday; j++)
		{
			System.out.print("-");
		}
		System.out.print("+" );
		for ( int j = 0; j <= long_email; j++)
		{
			System.out.print("-");
		}
		System.out.print("+\n" );		
		
		for ( int i = 0; i < btnloadListener.Tableau_personal_name.size(); i++)
	    {
			System.out.print( "|" );
			System.out.print( btnloadListener.Tableau_personal_prod.get(i) );
			numb_espace = long_prod - btnloadListener.Tableau_personal_prod.get(i).length();
			for ( int j = 0; j <= numb_espace; j++)
			{
				System.out.print(" ");
			}
			System.out.print("|" );

			System.out.print( btnloadListener.Tableau_personal_surname.get(i) );
			numb_espace = long_surname - btnloadListener.Tableau_personal_surname.get(i).length();
			for ( int j = 0; j <= numb_espace; j++)
			{
				System.out.print(" ");
			}
			System.out.print("|" );
			
			System.out.print( btnloadListener.Tableau_personal_name.get(i) );
			numb_espace = long_name - btnloadListener.Tableau_personal_name.get(i).length();
			for ( int j = 0; j <= numb_espace; j++)
			{
				System.out.print(" ");
			}
			System.out.print("|" );
						
			
			System.out.print( btnloadListener.Tableau_personal_sex.get(i) );
			numb_espace = long_sex - btnloadListener.Tableau_personal_sex.get(i).length();
			for ( int j = 0; j <= numb_espace; j++)
			{
				System.out.print(" ");
			}
			System.out.print("|" );
			
			System.out.print( btnloadListener.Tableau_personal_brihday.get(i) );
			numb_espace = long_brihday - btnloadListener.Tableau_personal_brihday.get(i).length();
			for ( int j = 0; j <= numb_espace; j++)
			{
				System.out.print(" ");
			}
			System.out.print("|" );
			
			System.out.print( btnloadListener.Tableau_personal_email.get(i) );
			numb_espace = long_email - btnloadListener.Tableau_personal_email.get(i).length();
			for ( int j = 0; j <= numb_espace; j++)
			{
				System.out.print(" ");
			}
			System.out.print("|\n" ); 
			
	    }
		System.out.print( "+" );
		for ( int j = 0; j <= long_prod; j++)
		{
			System.out.print("-");
		}
		System.out.print("+" );
		for ( int j = 0; j <= long_surname; j++)
		{
			System.out.print("-");
		}
		System.out.print("+" );
		for ( int j = 0; j <= long_name; j++)
		{
			System.out.print("-");
		}
		System.out.print("+" );
		for ( int j = 0; j <= long_sex; j++)
		{
			System.out.print("-");
		}
		System.out.print("+" );
		for ( int j = 0; j <= long_brihday; j++)
		{
			System.out.print("-");
		}
		System.out.print("+" );
		for ( int j = 0; j <= long_email; j++)
		{
			System.out.print("-");
		}
		System.out.print("+\n" );
    }
	
	
}