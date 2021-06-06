package Dorian;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Personnel {
	private static int id = 1;
	 private int identification;
	 private String email;
	 private String departement;
	 
	protected static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	 
	public Personnel( String departement, String prénom, String nom, String Sexe ,Date naissance , String email) 
	{
	        this.identification = id++;
	        this.setEmail(email);
	}
	public int getIdPersonnel() 
	{
      return identification;
	}
	
	public String getDepartement() 
	{
      return departement;
	}    
	
	public String getEmail() 
	{
	  return email;
	}
	    
	public void setEmail( String email ) 
	{              
	 this.email = email;
	}
	    
	    @Override 
	    public String toString() {
	        return String.format( "%d : %s %s nais le %s  @mail :  %s",
	                this.identification,        
	                this.email );
	    }
	    
}


