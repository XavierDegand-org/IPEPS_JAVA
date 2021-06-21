package DanielDerveaux;

public class Emprunt {
	public int nombre;
	public Personnel emprunteur;
	public Produit materiel;
	public String article;
	
	public Emprunt() {
		
	}
	
	public Personnel getEmprunteur() {
		return emprunteur;
	}
	
	public void setEmprunter(Personnel emprunteur) {
		this.emprunteur = emprunteur;
	}

	  @Override
	  public String toString() {
			return String.format("emprunteur : ", emprunteur);
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
}
