package Ilyasse;

import java.util.regex.Pattern;

public class Personnel {
	public Individu individu;
	 private static int id = 1;
	 private int identification;
	public String email;
	private Departement departement; 
    // On définie une expression régulière compilé une fois pour toute.
    // Elle est partagée par toutes les instances de Personne
    private static final Pattern EMAIL_PATTERN = Pattern.compile( 
            "^[\\w.-]+@[\\w.-]+[a-z]{2,}$" 
    );

	public Personnel(int identification, String nom, String prenom, Sexe sexe, MyDate dateNaissance, String email,Departement departement ){
		this.identification = id++;
		individu = new Individu(nom, prenom, sexe, dateNaissance);
		this.email = email;
		this.departement = departement;
	}

	public Departement getDepartement() {
		return departement;
	}	
	public Individu getindividu() {
		return individu;
	}	
    
    @Override 
    public String toString() {
        return String.format( "%d: %s %s @ %s",
        		individu, email, departement );
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail( String email ) {
        if ( email == null ) {
            throw new NullPointerException( "email cannot be null" );
        }
        if ( ! EMAIL_PATTERN.matcher( email ).matches() ) {
            throw new RuntimeException( "Le format de l'email ne coorespond pas aux patterns." );
        }
        this.email = email;
    }

	  
	

}
