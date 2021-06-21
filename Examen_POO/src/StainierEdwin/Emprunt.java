package StainierEdwin;

public class Emprunt {

	private int nombre;
	Individu individu;
	Produit produit;
		
	public Emprunt(Individu individu, Produit produit, int nombre)
	{
		SetEmprunteur(individu);
		SetProduit(produit);
		this.nombre = nombre;
	}
	
	public void SetEmprunteur(Individu individu)
	{
		this.individu = individu;
	}
	
	public Individu GetEmprunteur()
	{
		return this.individu;
	}
	
	public void SetProduit(Produit produit)
	{
		this.produit = produit;
	}
	
	public Produit GetProduit()
	{
		return this.produit;
	}
	
	public int GetNombre()
	{
		return this.nombre;
	}

}
