package UytterhaegenLouis;

public class Emprunt {
	
	private int nombre;
	Produit produit;
	Personnel personnel;

	public Emprunt(Personnel personnel, Produit produit) {
		this.personnel = personnel;
		this.produit = produit;
	}
	  public String getEmprunteur() {
			return personnel.getNom()+" "+personnel.getPrenom();
	  }

	  public void setEmprunteur(String nom) {
			
	  }
	  @Override
		public String toString() {
		  return String.format( "Id : %s %s %s sexe : %s date de naissance : %s. Email : %s Département : %s    Produit [nom = %s, description = %s  ]",
	               personnel.getIdPersonnel(),
	               personnel.getNom(),
	               personnel.getPrenom(),
	               personnel.getSexe(),
	               personnel.getDateddMMyyyy(),
	               personnel.getEmail(),
	               personnel.getDepartement(),
	               produit.getNom(),
	               produit.getDescription());
		}
	  
	  public String getMateriel() {
			return produit.getNom();
	  }
	  
	  public String getArticle() {
			return produit.getDescription();
	  }
	  
	  public int getNombre() {
			return nombre;
	  }

}
