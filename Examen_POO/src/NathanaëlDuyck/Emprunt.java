package NathanaëlDuyck;

public class Emprunt {

	private int nombre;
	private Personnel emprunteur;
	private Produit materiel;
	
	public Emprunt(int nombre,Personnel emprunteur, Produit materiel) {
		this.nombre=nombre;
		this.emprunteur = emprunteur;
		this.materiel = materiel;
	}
	
	public  Personnel getEmprunteur() {
		return emprunteur;
	}

	
	public void setEmprunteur(Personnel emprunteur) {
		this.emprunteur = emprunteur;
	}

	
	@Override
	public String toString() {
		return "Id : " + getEmprunteur().getIdPersonnel() +" "+getEmprunteur().getNom()+" "+getEmprunteur().getSexe()+" "+getEmprunteur().getDateddMMyyyy()+" "+getEmprunteur().getEmail()+" "+getEmprunteur().getDepartement()+"  "+getMateriel().toString();
	}

	public Produit getMateriel() {
		return materiel;
	}
	
	public int getNombre() {
		return nombre;
	}
	
	
}
