package Console;

public class Emprunt {
	private int nombre = 0;
	private Personnel emprunteur;
	private Produit materiel;
	
	
	public Emprunt(int nombre, Personnel personne, Produit produit) {
		this.nombre = nombre;
		this.emprunteur = personne;
		this.materiel = produit;
		
	}


	public int getNombre() {
		return nombre;
	}


	public void setNombre(int nombre) {
		this.nombre = nombre;
	}


	public Produit getMateriel() {
		return materiel;
	}


	public void setMateriel(Produit materiel) {
		this.materiel = materiel;
	}


	public Personnel getEmprunteur() {
		return emprunteur;
	}


	public void setEmprunteur(Personnel emprunteur) {
		this.emprunteur = emprunteur;
	}
	
	public String toString() {
		return "Id : "+this.nombre+" "+this.emprunteur.getNom()+" "+this.emprunteur.getPrenom()+" sexe : "+this.emprunteur.getSexe()+" date de naissance : "+this.emprunteur.getDateddMMyyyy()+". Email : "+this.emprunteur.getEmail()+" Département : "+this.emprunteur.getDepartement().getDeptNom()+"    Produit "+this.materiel;
	}
	
	
}
