package Aude;

public enum Departement {
	Compta("Comptabilit�"),
	RH("Ressources Humaines"),
	Prod("Production"),
	SEC("Secr�tariat");
	private final String deptNom;
	

	Departement(String deptNom) {
		// TODO Auto-generated constructor stub
		this.deptNom = deptNom;
	}
	
	public String getdeptNom() {
		return deptNom;
	}
	
}
