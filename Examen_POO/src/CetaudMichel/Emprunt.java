package CetaudMichel;



public class Emprunt {
	
	Personnel personnel;
	Produit listProduit;
	
	public Emprunt(Personnel personnel,Produit produit) {
		
		this.personnel = personnel;
		this.listProduit = produit;
		
	}
	
	public String getPrenom() {
		return personnel.getPrenom();
	}
	
	public String getEmprunteur() {
		return personnel.getNom();
	}
	
	public void setEmprunteur() {
		
		
	}
	
	public String getArticles() {
		
		return listProduit.getNom();
	}
	
public String getProduit() {
		
		return listProduit.getDescription();
	}
	
	
	@Override
	public String toString() {
	
		return String.format("Id : %s %s %s sexe : %s date de naissance : %s. Email : %s Département : %s Produit : %s", 
				personnel.getIdPersonnel() +1,personnel.getNom(),personnel.getPrenom(),
				personnel.getSexe(),
				personnel.getDateddMMyyyy(),personnel.getEmail(),personnel.getDepartement(),
				listProduit.toString());
	}


}