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
	
	@Override
	 public String toString() {
			return String.format("--- Produit [nom = %s, description = %s  ]",
					
					this.nom,
					this.description);
	 }

}
