package NathanaëlDuyck;

public class Emprunt {

	private Personnel emprunteur;
	private Produit materiel;

	
	public Emprunt(Personnel emprunteur, Produit materiel) {
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
	
}
