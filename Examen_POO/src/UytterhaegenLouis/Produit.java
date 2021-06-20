package UytterhaegenLouis;

public class Produit {
	private String nom;
	private String description;


	public Produit( String description, String nom) {
		this.description = description;
		this.nom = nom;
	}
	
	public String getNom () {
		return nom;
	}
	public void setNom (String nom) {
        if ( nom == null ) {
            throw new NullPointerException( "nom cannot be null" );
        }
        nom = nom.trim();  
        if ( nom.equals( "" ) ) {
            throw new RuntimeException( "nom cannot be empty" );
        }
      
        this.nom = nom;
	}
	public String getDescription () {
		return description;
	}
	
	public void setDescription(String nom) {
        if ( nom == null ) {
            throw new NullPointerException( "nom cannot be null" );
        }
        nom = nom.trim();  
        if ( nom.equals( "" ) ) {
            throw new RuntimeException( "nom cannot be empty" );
        }
      
        this.nom = nom;
	}
	 public String toString() {
			return String.format("--- Produit [nom = %s, description = %s  ]",
					
					this.nom,
					this.description);
	 }

}
