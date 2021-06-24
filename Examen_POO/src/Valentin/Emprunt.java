package Valentin;

public class Emprunt {
	
	public int nombre;
	Personnel emprunteur;
	Produit materiel;
	
	public Emprunt(Personnel emprunteur,Produit materiel) {
		this.nombre = nombre;
		this.emprunteur =emprunteur;
		this.materiel = materiel;
	}
	
	
	public Personnel getEmprunteur() {
		return emprunteur;
	}
	
	public void setEmprunteur(Personnel emprunteur) {
		this.emprunteur = emprunteur;
	}
	
	@Override
	public String toString() {
		return String.format("Id : %s %s %s sexe : %s date de naissance : %s. Email : %s Département : %s    Produit \n [nom = %s, description = %s  ] ",
				emprunteur.getIdPersonel(),
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
