package Aude;

public class Individu {
	  private static String nom;
	  private String prenom;
	  private Sexe sexe;
	  private MyDate dateNaissance;
	  private static int tailleNom = 30;
	  

	  public Individu(String nom, String prenom, Sexe sexe, MyDate dateNaissance) {
			this.nom = nom;
			this.prenom = prenom;
			this.sexe = sexe;
			this.dateNaissance = dateNaissance;
	  }

	  public static String getNom() {
			return nom;
	  }

	  public void setNom(String nom) {
		  if ( nom == null ) {
	            throw new NullPointerException( "nom cannot be null" );
	        }
	        nom = nom.trim();   // Pour supprimer les blancs inutiles
	        if ( nom.equals( "" ) ) {
	            throw new RuntimeException( "nom cannot be empty" );
	        }
	        int positionTiret = nom.indexOf("-");
	        int positionEspace = nom.indexOf(" ");
	       
	        if(positionTiret == -1) {
	        	this.nom = nom.substring(0,1).toUpperCase()+nom.substring(1,nom.length()); 
	        }else {
	        	this.nom = nom.substring(0,1).toUpperCase()+nom.substring(1,positionTiret)+nom.substring(positionTiret,positionTiret+1)+
	        			   nom.substring(positionTiret+1,positionTiret+2).toUpperCase()+nom.substring(positionTiret+2,nom.length()); 
	        }
	        if(positionEspace == -1) {
	        	this.nom = nom.substring(0,1).toUpperCase()+nom.substring(1,nom.length()); 
	        }else {
	        	this.nom = nom.substring(0,1).toUpperCase()+nom.substring(1,positionEspace)+nom.substring(positionEspace,positionEspace+1)+
	        			   nom.substring(positionEspace+1,positionEspace+2).toUpperCase()+nom.substring(positionEspace+2,nom.length()); 
	        }
	  }

	  public String getPrenom() {
			return prenom;
	  }

	  public void setPrenom(String prenom) {
		  if ( prenom == null ) {
	            throw new NullPointerException( "prenom cannot be null" );
	        }
	        prenom = prenom.trim();   // Pour supprimer les blancs inutiles
	        if ( prenom.equals( "" ) ) {
	            throw new RuntimeException( "prenom cannot be empty" );
	        }
	        int positionTiret = prenom.indexOf("-");
	        
	        if(positionTiret == -1) {
	        	this.prenom = prenom.substring(0,1).toUpperCase()+prenom.substring(1,prenom.length()); 
	        }else {
	        	this.prenom = prenom.substring(0,1).toUpperCase()+prenom.substring(1,positionTiret)+prenom.substring(positionTiret,positionTiret+1)+
	        			   prenom.substring(positionTiret+1,positionTiret+2).toUpperCase()+prenom.substring(positionTiret+2,prenom.length()); 
	        }
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
