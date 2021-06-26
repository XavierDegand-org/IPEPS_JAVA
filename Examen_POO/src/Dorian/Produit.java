package Dorian;

public class Produit {
	
	     
	     private String IDProduit;
		 private String nom;
		 private String Description;
		 
	 
		 
		  public Produit(String IDProduit, String nom, String Description){ //constructeur de produit 
				
			    this.IDProduit= IDProduit ;
			    this.nom = nom;
				this.Description = Description;
	 
		  }


		  public int getID(int ID) { // get ID de l'object
				return ID;
		  }
		  
		  
		  public int setID(int ID) { // set Id de l'object
				return ID;
		  }
		  
		  public int getIDProduit() {
				return Integer.parseInt(IDProduit); //get ID produit en int 
		  }
		  

		  public String getNom() { // get nom de l'object 
				return nom;
		  }

		  public void setNom(String nom) { //set le nom de l'object
				this.nom = nom;
		  }
		  
		  public String getDescription(String Description) { // get le description de l'object
				return Description;
		  }

		  public void setDescription(String Description) { // set la decription
				this.Description = Description;
		  }
		  
		  public String toString() {
			    int IDProduit_int = Integer.parseInt(IDProduit); // tostring pour l'affichage de base dans prêt informate de l'id
			  	int temp = IDProduit_int + 1;
				return String.format("Id_"+temp+" --- Produit [nom = "+nom+" Description = "+Description+"]");
						
		  }
		  
		  public String toString2() {  // to string que donne que le nom + la description
				return String.format(nom+ " " +Description);	
						
		  }
		  
		  public String toString3()  // to string que donne que le nom + la description structuré
		  {
				return String.format("Produit [nom = "+nom+" Description = "+Description+"]");
		  }
		  
	}

