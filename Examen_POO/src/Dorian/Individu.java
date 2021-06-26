package Dorian;

public class Individu extends Personnel{
	 private String nom;
	 private String prenom;
	 private Sexe sexe;
	 private MyDate dateNaissance;

	 
	 
	  public Individu(Departement departement,String nom, String prenom, Sexe sexe, MyDate dateNaissance,String email) { //constructeur de individu
		  
		    super(departement,nom,email);

			this.nom = nom;
			this.prenom = prenom;
			this.sexe = sexe;
			this.dateNaissance = dateNaissance; 
	  }

	  
	  public String getNom() { //get le nom de l'object
			return nom;
	  }

	  public void setNom(String nom) { //set le nom de l'object
			this.nom = nom;
	  }

	  public String getPrenom() { //get le prenom de l'object
			return prenom;
	  }

	  public void setPrenom(String prenom) { //set le prenom de l'object
			this.prenom = prenom;
	  }

	  public String getSexe() {  // get le sexe de l'object via l'enum sexe
			return sexe.getLabel();
	  }

	  public void setSexe(Sexe sexe) { //Set le sexe de l'object
			this.sexe = sexe;
	  }

	  public MyDate getDateNaissance() {//get date de naissance de l'object
			return dateNaissance;
	  }

	  public void setDateNaissance(MyDate dateNaissance) { // set la date de naissance via Mydate
			this.dateNaissance = dateNaissance;
	  }

	  public String getDateddMMyyyy() { // string pour l'affichage de date de naissance 
			return String.format("%d-%d-%d", dateNaissance.getJour(),dateNaissance.getMois(),dateNaissance.getAnnee());
	  }

	  @Override
	  public String toString() { // string d'affichage avec des séparation 
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
	  
	  public String toString2() // string sans séparation
      {
			return String.format("ID : %d  %s %s sexe: %s date de naissance : %s-%s-%s Email : %s Départemement %s",
					
					getidentification(),nom,prenom,sexe,dateNaissance.getJour(),dateNaissance.getMois(),dateNaissance.getAnnee(),getEmail(),getDepartement());
					
					
			
	   }
	  
	  public String toString3() // affiche juste l'idendification nom et prénom
      {
			return String.format("ID : %d  %s %s ",
					
					getidentification(),nom,prenom);
					
					
			
	   }
	  
	  
	  
	  
	  
}
