package Dorian;

public class Emprunt {
	
	int nombre ;
	int Emprunteur ; 
	int article ; 
	
	
	public Emprunt (int nombre,int id_emprunteur, int article) 
	{
	       
		   this.nombre = nombre ;
	       this.Emprunteur =  id_emprunteur ; 
	       this.article= article; 
	    
	}
	

	public int getEmprunteur() // get emprunteur de l'objet
	{
        return Emprunteur ; 
    }
	
	public void setEmprunteur(int emprunteur) //set Emprunteur de l'objet
	{
        this.Emprunteur= emprunteur ; 
    }
	
	
	public String toString()  //string affichage tableau d'emprunt
	{
		return String.format(btnloadListener.Personne[Emprunteur].toString2() + " "+btnMagListener.Produit[article].toString3() );
				
    }
	
	
	public String toString2() //affichage juste le nom et prénom
	{
		return String.format(btnloadListener.Personne[Emprunteur].getNom() + " "+btnMagListener.Produit[article].toString2() );
				
    }
	
	
	public String toString3() //Affiche le nom prénom et l'aricle avec un espace 
	{
		return String.format("%s %s %s",
				
				btnloadListener.Personne[Emprunteur].getNom(),
				Personnel.setfixedLength(btnloadListener.Personne[Emprunteur].getPrenom(),24),	
				Personnel.setfixedLength(btnMagListener.Produit[article].toString2(),15) );
				
    }
	

	
	public int getArticle() //get article de l'objet
	{
		return article;
	}
	
	public void getMateriel()
	{
		
	}
	
	public void getnombre()
	{
		
	}
    
 
	

}
