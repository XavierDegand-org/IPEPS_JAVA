package UytterhaegenLouis;

import java.util.regex.Pattern;

public class Personnel extends Individu {
	private int IdPersonnel;
	private String email;
	private static int id=1;
	private Departement Departement;

    private static final Pattern EMAIL_PATTERN = Pattern.compile( 
    		"^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$" 
    );

	public Personnel(String nom, String prenom, Sexe sexe, MyDate dateNaissance, String Email, Departement Departement) {
		super(nom, prenom, sexe, dateNaissance);
		this.IdPersonnel = id++;
		if ( ControleSaisie.valideEmail(Email)) { // Permet qu'en cas de mauvaise écriture de l'email, d'automatiquement écrire le mail dans un bon format
			this.email = Email;
		} else {
			this.email = nom+"."+prenom.charAt(0) +"@test.be";
		}
		this.Departement= Departement;
	}


	public int getIdPersonnel() {
		return IdPersonnel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if ( email == null ) {
            throw new NullPointerException( "email cannot be null" );
        }
        if ( !EMAIL_PATTERN.matcher( email ).matches() ) {
            throw new RuntimeException( "Le format de l'email ne coorespond pas aux patterns." );
        }
        this.email = email;
    }
	
	public String getDepartement() {
		return Departement.getDeptNom();
	}
	@Override
	public String toString() {
		return String.format( "%s %s %s %s %s %s",
				this.getDepartement(),
				this.getPrenom(),
				this.getNom(),
				this.getSexe(),
				this.getDateNaissance(),
				this.email );
	}


}
