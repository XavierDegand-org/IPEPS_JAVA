package PierreGrulois;

import java.util.regex.Pattern;

public class Personnel extends Individu{
	private int idPersonnel;
	private int id=1;
	private String email;
	private Departement departement;
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+[a-z]{2,}$");
		
	public Personnel(String nom, String prenom, Sexe sexe, MyDate dateNaissance, String email, Departement departement) {
		super (nom, prenom, sexe, dateNaissance);
		this.idPersonnel= id;
		this.email= email;
		this.departement = departement;
		id++;
		
		
	}
	
	@Override public String toString() {;
		
		//try{
			return String.format( "%s %s %s %s %s %s",
		
                this.getDepartement(),
                this.getPrenom(),
                this.getNom(),
                this.getSexe(),
                this.getDateNaissance(),
                this.getEmail() );
		/*}catch(java.util.IllegalFormatException e) {
			System.out.println("Une ou plusieurs entrées ne sont pas valide.");
		} */
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

