package yacineFrimi;

public class Produit {


	private String nom;
	private String description;


	public Produit(String nom, String description) {
		this.nom = nom;
		this.description = description;
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
		return " --- Produit [Nom = "+nom+",description = "+description+"]"; 
	}


}
