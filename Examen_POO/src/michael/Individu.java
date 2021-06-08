package michael;

public class Individu {
	 private String nom;
	  private String prenom;
	  private Sexe sexe;
	  private MyDate dateNaissance;

	  public Individu(String nom, String prenom, Sexe sexe, MyDate dateNaissance) {
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
			return String.format("%s %s sexe : %s date de naissance : %d-%d-%d."
					,nom,prenom,sexe,dateNaissance.getJour(),dateNaissance.getMois(),dateNaissance.getAnnee());
	  }
}
