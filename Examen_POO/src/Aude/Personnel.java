package Aude;

import java.util.regex.Pattern;

public class Personnel extends Individu {
	 private static int id = 1;
	 private int idPersonnel;
	 private String email;
	 private Departement departement;
	 //private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+[a-z]{2,}$");
	
	 public Personnel (String nom, String prenom, Sexe sexe, MyDate dateNaissance, String email,Departement departement) {
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
	 
	 public String getEmail() { // Controle de la validité de l'email 
		 boolean arret = false;
			while (!arret) {
				email = Lire.texte();
				if (ControleSaisie.valideEmail(email)){
					return email;
				}else {
					System.out.print("L'email n'est pas correct !");
					arret = false;
				}
			}
			return email;
	  }
	 
	 public void setEmail( String email ) {
	        this.email = email;
	    }
	 
}
