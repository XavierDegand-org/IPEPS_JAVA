package PierreGrulois;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Personnel extends Individu{
	private int idPersonnel;
	private static int id=1;
	private String email;
	boolean verrifMail;
	private Departement departement;
	private static final String EMAIL_PATTERN = "^[\\w.-]+@[\\w.-]+[a-z]{2,}$";
	private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		
	public Personnel(String nom, String prenom, Sexe sexe, MyDate dateNaissance, String email, Departement departement) {
		super (nom, prenom, sexe, dateNaissance);
		this.idPersonnel= id++;
		Matcher matcher = pattern.matcher(email);
		verrifMail = matcher.matches();
		if(verrifMail == true) {
			this.email=email;
		}
		else {
			email = "E-mail non valide.";
		}
		this.email= email;
		this.departement = departement;
		
		
		
	}
	
	@Override public String toString() {;
		
		try{
			return String.format( "%s %s %s %s %s %s",
		
                this.getDepartement(),
                this.getPrenom(),
                this.getNom(),
                this.getSexe(),
                this.getDateNaissance(),
                this.getEmail() );
		}catch(java.util.IllegalFormatException e) {
			return ("Une ou plusieurs entrées ne sont pas valide.");
		} 
	}
	
	public int getIdPersonnel() {
		return idPersonnel;
	}
	
	 public String getDepartement(){
		 return departement.getDeptNom();
		
	}
	 
	 public String getEmail() {
		 return email;
	 }

	public void setEmail(String email) {
		this.email = email;
	}
	 
	
	 
	 
	
	

}

