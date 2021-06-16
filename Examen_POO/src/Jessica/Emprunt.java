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

	  public String getMateriel() {
			return Materiel;
	  }
	  
	  public String getArticle() {
			return Article;
	  }
	  
	  public String getNombre() {
			return nombre;
	  }

	  @Override
	  public String toString() {
			return String.format(
					this.nom,
	                this.description );
	  }*/


}
