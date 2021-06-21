package StainierEdwin;

public class Produit {

	private String nom = "";
	private String description = "";
	
	public Produit(String nom, String description)
	{
		SetNom(nom);
		SetDescription(description);
	}
	
	public String GetNom()
	{
		return nom;
	}
	
	public String GetDescription()
	{
		return description;
	}
	
	public void SetNom(String nom)
	{
		this.nom = nom;
	}
	
	public void SetDescription(String description)
	{
		this.description = description;
	}
	
	@Override
	public String toString()
	{
		return this.nom + ", " + this.description;
	}
	
	
}
