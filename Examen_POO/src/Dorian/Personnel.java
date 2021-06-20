package Dorian;

import java.util.regex.Pattern;

public class Personnel  {
	
	
	 private static final Pattern EMAIL_PATTERN = Pattern.compile( "^[\\w.-]+@[\\w.-]+[a-z]{2,}$" );
	
	 private static int id = 1;
	 private int identification;
	 private String email;
	 private Departement departement;
	 private String nom;
	 private String Id;
	 

	 
	public Personnel( Departement departement,String nom, String email) 
	{
	       
		   this.identification = id++;
	       this.setEmail(email);
	       this.nom = nom ;
	       this.departement=departement;
	       this.Id = String.valueOf(identification);
	}
	
	
	public int getidentification() 
	{
        return identification;
    }
    
	public void setidentification( int identification ) 
	{
        if ( identification < 0 )  
        {
            throw new RuntimeException( "la valeur de l'identification doit être possitive." );
        }
        this.identification = identification;
	}
	

	
	public int getIdPersonnel() 
	{
      return identification;
	}
	
	public String getDepartement() 
	{
      return departement.getLabelD();
	} 
	
	
	public void setDepartement(Departement departement) 
	{
		this.departement = departement;
	} 
	
	
	public String getnom() 
	{
      return nom;
	}
	
	public void setEmail( String email ) 
	{
	    if ( email == null ) 
	        {
	            throw new NullPointerException( "email cannot be null" );
	        }
	        if ( ! EMAIL_PATTERN.matcher( email ).matches() ) 
	        {
	            throw new RuntimeException( "Le format de l'email ne coorespond pas aux patterns." );
	        }
	        this.email = email;
	}
	
	
	public String getEmail() 
	{
	  return email;
	}
	
   
	    @Override 
	    public String toString() 
	    {
	        return String.format
	        		( "%s :  département : %s nom :  %s  @mail :  %s",
	        		setfixedLength(this.Id,2), 
	        		//setfixedLength(this.departement,10),
	        		setfixedLength(this.nom,10),     
	        		setfixedLength(this.email,20)); 
	    }
   
	    static String setfixedLength(String s, int taille){
			StringBuilder ss= new StringBuilder(s);
			
			while ( ss.length() < taille ) 
			{
				String D = " ";
				char c1 = D.charAt(0);
				ss.insert( s.length(),c1 );

			}
	    	
			String c = ss.substring(0,taille);
	    	
	    	
	    	return c;
	    	
	    	
	    }
	    
	    static String setfixedLength2(String s, int taille){
			
	    	
	    	String resul = "";
	    	
	    	for ( int taille_s =  s.length(); taille_s < taille; taille_s++ )
	    	{
	    		resul = resul + "0";
	    	}
	    	
	    	String return_str = resul + s;	    	
	    	return return_str;
	    	
	    	
	    }


		public void set(int i, String string) {
			
		}
	    
	    
}


