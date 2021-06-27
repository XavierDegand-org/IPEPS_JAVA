package NathanaëlDuyck;

public enum Departement {
	
	//Nom des différents départements
	
	Compta("Comptabilité"),
	HR("Ressources Humaines"),
	Prod("Prodution"),
	SEC("Securité"),;
	
	
	private final String deptNom; 
	
	Departement(String deptNom) {
        this.deptNom = deptNom;
 }

	public String getDeptNom() {
		return deptNom;
	}
	
}