package PierreGrulois;

public class Emprunt {
	private Personnel emprunteur;
	private Produit produit ;
	
	private int nombre = 0;
	
	public Emprunt(Personnel emprunteur,Produit produit) {
		
		this.nombre = nombre++;
		this.emprunteur = emprunteur;
		this.produit = produit;
		
	}
	
	public Personnel getEmprunteur() {
		
		return emprunteur;	
		
	}
	
	public void setEmprunteur(Personnel emprunteur) {
		
		this.emprunteur= emprunteur;
	}
	
	@Override public String toString() {;
	
	try{
		return String.format( "Id : %s %s %s sexe : %s date de naissance : %s. Email : %s Département : %s \nProduit [nom = %s, description = %s  ]\n",

			emprunteur.getIdPersonnel(),
			emprunteur.getNom(),
			emprunteur.getPrenom(),
			emprunteur.getSexe(),
			emprunteur.getDateddMMyyyy(),
			emprunteur.getEmail(),
			emprunteur.getDepartement(),
			produit.getNom(),
			produit.getDescription() );
    
	}catch(java.util.IllegalFormatException e) {
		return "Une ou plusieurs entrées ne sont pas valide.";
	} 
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
