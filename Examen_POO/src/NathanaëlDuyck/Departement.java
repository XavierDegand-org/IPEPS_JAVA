package NathanaëlDuyck;

public enum Departement {
	
	Compta("Comptabilité"),
	HR("Ressources Humaines"),
	Prod("Prodution"),
	SEC("Section"),;
	
	
	 private final String deptNom; 
	
	Departement(String deptNom) {
        this.deptNom = deptNom;
 }

	public String getDeptNom() {
		return deptNom;
	}

}
