package Aude;

public class Personnel extends Individu {
	 private static int id = 1;
	 private int idPersonnel;
	 private String email;
	 private Departement departement;
	
	 public Personnel (String nom, String prenom, Sexe sexe, MyDate dateNaissance,int idPersonnel, int id, String email,Departement departement) {
		 super (nom, prenom, sexe, dateNaissance);
		 this.idPersonnel = idPersonnel;
		 this.id = id;
		 this.email = email;
		 this.departement = departement;
	 }
	 
	 @Override
	  public String toString() {
		 return String.format("%d %d %s",idPersonnel, id, email);
	 }
	 
	 public int getidPersonnel() {
			return idPersonnel;
	  }
	 
	 public String getDepartement() {
		 return departement.getdeptNom();
	 }
	 
	 public String getEmail() {
			return email;
	  }
	 
	 public void setEmail( String email ) {
	        this.email = email;
	    }
	 
}
