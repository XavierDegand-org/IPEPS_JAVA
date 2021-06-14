package CetaudMichel;



public class Emprunt {
	
	Personnel personnel;
	Produit listProduit;
	
	public Emprunt(Personnel personnel,Produit produit) {
		
		this.personnel = personnel;
		this.listProduit = produit;
		
	}
	
	public Produit getNom() {
		return listProduit;
	}
	
	public Personnel getEmprunteur() {
		return personnel;
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