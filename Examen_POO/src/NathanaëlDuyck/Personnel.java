package NathanaëlDuyck;

import java.util.regex.Pattern;

public class Personnel extends Individu {
	
	private int IdPersonnel;
	private String email;
	private static final Pattern EMAIL_PATTERN = Pattern.compile( 
			"^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
	private Departement departement;
	
	public Personnel(int idPersonnel,String nom, String prenom, Sexe sexe, MyDate dateNaissance, String email,Departement depart) {
		super(nom, prenom, sexe, dateNaissance);
		this.IdPersonnel = idPersonnel;
		this.email = email;
		this.departement=depart;
	}

	@Override
	public String toString() {
		return String.format(" %s %s %s %s %d-%d-%d %s"
				,getDepartement(),getPrenom(),getNom(),getSexe(),getDateNaissance().getJour(),getDateNaissance().getMois(),getDateNaissance().getAnnee(),getEmail());
	}

	public int getIdPersonnel() {
		return IdPersonnel;
	}
	
	public String getDepartement() {
		return departement.getDeptNom();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		   if ( email == null ) {
	            throw new NullPointerException( "email cannot be null" );
	        }
	        if ( ! EMAIL_PATTERN.matcher( email ).matches() ) {
	            throw new RuntimeException( "Le format de l'email ne coorespond pas aux patterns." );
	        }
	        this.email = email;
	    }
}
	
	
	
	
	

