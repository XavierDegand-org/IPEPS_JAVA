package CetaudMichel;



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
	
	public String description() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		
		return String.format("Id_%-5i %-10s  %-10s test",nom,description);
	}

	
}
