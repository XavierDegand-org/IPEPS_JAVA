package Dorian;

public class Individu extends Personnel{
	 private String nom;
	 private String prenom;
	 private Sexe sexe;
	 private MyDate dateNaissance;

	 
	 
	  public Individu(Departement departement,String nom, String prenom, Sexe sexe, MyDate dateNaissance,String email) {
		  
		    super(departement,nom,email);

			this.nom = nom;
			this.prenom = prenom;
			this.sexe = sexe;
			this.dateNaissance = dateNaissance; 
	  }

	  
	  public String getNom() {
			return nom;
	  }

	  public void setNom(String nom) {
			this.nom = nom;
	  }

	  public String getPrenom() {
			return prenom;
	  }

	  public void setPrenom(String prenom) {
			this.prenom = prenom;
	  }

	  public String getSexe() {
			return sexe.getLabel();
	  }

	  public void setSexe(Sexe sexe) {
			this.sexe = sexe;
	  }

	  public MyDate getDateNaissance() {
			return dateNaissance;
	  }

	  public void setDateNaissance(MyDate dateNaissance) {
			this.dateNaissance = dateNaissance;
	  }

	  public String getDateddMMyyyy() {
			return String.format("%d-%d-%d", dateNaissance.getJour(),dateNaissance.getMois(),dateNaissance.getAnnee());
	  }

	  @Override
	  public String toString() {
			return String.format("%s %s %s %s  %s-%s-%s %s",
					Personnel.setfixedLength( getDepartement(),30 ),
					Personnel.setfixedLength( nom,30 ),
					Personnel.setfixedLength( prenom,30 ),
					Personnel.setfixedLength( sexe.getLabel(),15 ),
					Personnel.setfixedLength2( String.valueOf(dateNaissance.getJour()), 2),
					Personnel.setfixedLength2( String.valueOf(dateNaissance.getMois()), 2),
					Personnel.setfixedLength( String.valueOf(dateNaissance.getAnnee()), 8),
			        Personnel.setfixedLength( getEmail(),30) );

	  }
	  
	  
	  
}
