package Jessica;

public class Emprunt extends Personnel {

	private int nombre;

	public Emprunt(String nom, String prenom, Sexe sexe, MyDate dateNaissance, int IdPersonnel,
			String email, Departement Departement, int nombre) {
		super(nom, prenom, sexe, dateNaissance, email, Departement);
		this.nombre = nombre;
	}
	
	/*
	  public String getEmprunteur() {
			return nom;
	  }

	  public void setEmprunteur(String nom) {
			this.nom = nom;
	  }

	  public String getDescription() {
			return description;
	  }

	  public void setDescription(String description) {
			this.description = description;
	  }

	  @Override
	  public String toString() {
			return String.format(
					this.nom,
	                this.description );
	  }*/


}
