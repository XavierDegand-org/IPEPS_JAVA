package DanielDerveaux;

public class Emprunt {
	public int nombre;
	public Personnel emprunteur;
	public Produit materiel;
	
	public Emprunt(int nombre, Personnel emprunteur, Produit materiel) {
		this.nombre = nombre;
		this.emprunteur = emprunteur;
		this.materiel = materiel;
	}
	
	public Personnel getEmprunteur() {
		return emprunteur;
	}
	
	public void setEmprunter(Personnel emprunteur) {
		this.emprunteur = emprunteur;
	}

	  @Override
	  public String toString() {
		  return String.format( "Id : %s %s %s sexe : %s date de naissance : %s. Email : %s Département : %s    Produit [nom = %s, description = %s]",
				  emprunteur.getIdPersonnel(),
				  emprunteur.getNom(),
				  emprunteur.getPrenom(),
				  emprunteur.getSexe(),
				  emprunteur.getDateddMMyyyy(),
				  emprunteur.getEmail(),
				  emprunteur.getDepartement(),
				  materiel.getNom(),
				  materiel.getDescription());
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
}
