package Valentin;

public class Emprunt {
	
	public int nombre;
	public Personnel emprunteur;
	public Produit materiel;
	
	public Emprunt(int nombre, Personnel emprunteur,Produit materiel) {
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
		
		return String.format("Id : %i %s %s sexe : %s date de naissance : %s. Email : %S Département : %s",
				getEmprunteur().getIdPersonel(),
				getEmprunteur().getNom(),
				getEmprunteur().getPrenom(),
				getEmprunteur().getSexe(),
				getEmprunteur().getDateddMMyyyy(),
				getEmprunteur().getEmail(),
				getEmprunteur().getDepartement());
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
