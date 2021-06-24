package Valentin;

public class Individu  {
	
	/*********Atributs*********/
	  private String nom;
	  private String prenom;
	  private Sexe sexe;		//attribut sexe associé au type Sexe
	  private MyDate dateNaissance; // atribut dateNaissance associé au type Mydate
	  
	  /*********Constructeur*********/

	  public Individu(String nom, String prenom, Sexe sexe, MyDate dateNaissance) {
			this.nom = nom;
			this.prenom = prenom;
			this.sexe = sexe;
			this.dateNaissance = dateNaissance;
	  }
	  
	  /*********Getters et Setters*********/

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
		  // format() --> retourne une chaîne formatée en utilisant les paramètres fournis --> %d formate un entier en base décimale
			return String.format("%d-%d-%d", dateNaissance.getJour(),dateNaissance.getMois(),dateNaissance.getAnnee());
	  }

	  @Override
	  public String toString() {
		  // format() --> retourne une chaîne formatée en utilisant les paramètres fournis --> %s permet de formater une chaîne de caractères
			return String.format("%s %s sexe : %s date de naissance : %d-%d-%d."
					,nom,prenom,sexe,dateNaissance.getJour(),dateNaissance.getMois(),dateNaissance.getAnnee());
	  }
}
