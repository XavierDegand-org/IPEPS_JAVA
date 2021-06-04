package Jessica;

import java.util.regex.Pattern;

public class Personnel extends Individu {
	
	  private static int id = 1;
	  private int IdPersonnel;
	  private String Departement;
	  private String email;
	  private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+[a-z]{2,}$");
	
	 public Personnel(String nom, String prenom, Sexe sexe, MyDate dateNaissance, int IdPersonnel, String Departement, String email) {
	    	super(nom, prenom, sexe, dateNaissance);
	    	this.IdPersonnel = id++;
	    	this.Departement = Departement;
	    	this.email = email;
	    }
	 
	 public int getIdPersonnel() {
			return IdPersonnel;
	  }

	  public String getDepartement() {
			return Departement.getDeptNom();
	  }
	  
	  public String getEmail() {
			return email;
	  }
	  
	  public void setEmail(String email) {
	        if ( email == null ) {
	            throw new NullPointerException( "L'adresse e-mail ne peut pas être nulle." );
	        }
	        if ( ! EMAIL_PATTERN.matcher( email ).matches() ) {
	            throw new RuntimeException( "L'adresse e-mail n'a pas un format valide." );
	        }
	        this.email = email;
	    }

	  @Override
	  public String toString() {
			return String.format(
	                this.Departement,
	                this.IdPersonnel,
	                this.email );
	  }


}
