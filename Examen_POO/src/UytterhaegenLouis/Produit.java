package UytterhaegenLouis;

public class Produit {
	private String nom;
	private String description;


	public Produit( String nom, String description) {
		this.nom = nom;
		this.description = description;
	}

	public String getNom () {
		return nom;
	}
	public void setNom (String nom) {
		if ( nom == null ) {
			throw new NullPointerException( "Le nom ne peut être nul !" );
		}
		nom = nom.trim();  
		if ( nom.equals( "" ) ) {
			throw new RuntimeException( "Le nom ne peut être vide !" );
		}

		this.nom = nom;
	}
	public String getDescription () {
		return description;
	}

	public void setDescription(String nom) {
		if ( nom == null ) {
			throw new NullPointerException( "La descrpition ne peut être nulle !" );
		}
		nom = nom.trim();  
		if ( nom.equals( "" ) ) {
			throw new RuntimeException( "La description ne peut être vide !" );
		}

		this.nom = nom;
	}

	@Override
	public String toString() {
		return String.format("--- Produit [nom = %s, description = %s  ]",

				this.nom,
				this.description);
	}

}
