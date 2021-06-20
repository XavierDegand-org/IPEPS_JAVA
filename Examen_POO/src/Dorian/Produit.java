package Dorian;

public class Produit {
	
	     
	     private String IDProduit;
		 private String nom;
		 private String Description;
		 
		  public Produit(String IDProduit, String nom, String Description){
				
			    this.IDProduit= IDProduit ;
			    this.nom = nom;
				this.Description = Description;
	 
		  }


		  public int getID(int ID) {
				return ID;
		  }
		  
		  
		  public int setID(int ID) {
				return ID;
		  }
		  public String getNom() {
				return nom;
		  }

		  public void setNom(String nom) {
				this.nom = nom;
		  }
		  
		  public String getDescription(String Description) {
				return Description;
		  }

		  public void setDescription(String Description) {
				this.Description = Description;
		  }
		  
		  public String toString() {
				return String.format("Id_"+IDProduit+" --- Produit [nom = "+nom+" Description = "+Description+"]");
						
		  }
	}

