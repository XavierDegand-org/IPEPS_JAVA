package Ilyasse;
import java.util.ArrayList;

public class Emprunt {
	private int nombre;
	private Produit materiel;
	private String article;

	private Personnel emprunteur;


		

	public Emprunt(Personnel emprunteur , Produit matreiel, int nombre) {			
		setEmprunteur( emprunteur);
		setProduit(materiel);
		this.nombre=nombre;
	}
	  
	public Personnel getEmprunteur() {
		return emprunteur;
	}
	
	public Produit getMateriel() {
		return materiel;
	}
	
	public String getArticle() {
		return article;
	}
	public int getNombre() {
		return nombre;
	}	  
	public void setProduit(Produit materiel) {
		this.materiel = materiel;
	}
	public void setEmprunteur(Personnel emprunteur) {
		this.emprunteur = emprunteur;
	}
    @Override 
    public String toString() {
        return String.format( "%d: %s %s @ %s",
        		nombre, materiel, article, emprunteur );
    }



}
