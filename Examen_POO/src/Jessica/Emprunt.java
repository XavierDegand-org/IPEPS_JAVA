package Jessica;

public class Emprunt {

	private int nombre;
	private Personnel emprunteur;
	private Produit materiel;

	public Emprunt(int nombre, Personnel emprunteur, Produit materiel) {
		this.nombre = nombre;
		this.emprunteur = emprunteur;
		this.materiel = materiel;
	}
	
	  public Personnel getEmprunteur() {
			return emprunteur;
	  }

	  public void setEmprunteur(Personnel emprunter) {
			this.emprunteur = emprunteur;
	  }
	  
	  public String getMateriel() {
		  return materiel.getNom();
	  }
	  
	  public String getArticle() {
		  return materiel.getDescription();
	  }
	  
	  public int getNombre() {
			return nombre;
	  }

	  @Override
	  public String toString() {
		  return 
				  "Id : " + getEmprunteur().getIdPersonnel() +
				  " " + getEmprunteur().getNom() +
				  " " + getEmprunteur().getPrenom() +
				  " sexe : " + getEmprunteur().sexe +
				  " date de naissance : " + getEmprunteur().getDateddMMyyyy() +
				  ". Email : " + getEmprunteur().getEmail() +
				  " Département : " + getEmprunteur().getDepartement() +
				  "   Produit [ nom = " + getMateriel() + 
				  ", description = " + getArticle() + " ]"
				   ;
	  }


}