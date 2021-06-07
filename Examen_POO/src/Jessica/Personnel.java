package Jessica;

import java.util.regex.Pattern;

public class Personnel extends Individu {
	
	  private static int id = 1;
	  private int IdPersonnel;
	  private Departement Departement;
	  private String email;
	  private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+[a-z]{2,}$");
	
	 public Personnel(String nom, String prenom, Sexe sexe, MyDate dateNaissance, String email, Departement Departement) {
	    	super(nom, prenom, sexe, dateNaissance);
	    	this.IdPersonnel = id++;
	    	this.email = email;
	    	this.Departement = Departement;
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
			return String.format("%s %s %s %s %s %s",
	                this.getDepartement(),
	                this.getPrenom(),
	                this.getNom(),
	                this.getSexe(),
	                this.getDateddMMyyyy(),
	                this.email );
	  }


}
