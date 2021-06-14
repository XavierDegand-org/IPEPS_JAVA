package Jessica;

public class Produit {
	
	  private static int id = 1;
	  private int IdProduit;
	  private String nom;
	  private String description;

	  public Produit(String nom, String description) {
		    this.IdProduit = id++;
			this.nom = nom;
			this.description = description;
	  }
	  
	  public int getIdProduit() {
			return IdProduit;
	  }
	 

	  public String getNom() {
			return nom;
	  }

	  public void setNom(String nom) {
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
			return String.format("Produit [nom = %s, description = %s]",
					this.nom,
					this.description);
	  }


}
