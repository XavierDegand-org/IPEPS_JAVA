package Valentin;

public enum Departement {
	Compta("Comptabilité"),
	HR("Ressources Humaines"),
	Prod("Production"),
	SEC("Sécurité");
	
	private String deptNom = "";
	
	private Departement(String deptNom) {
		this.deptNom = deptNom;
	}
	
	public String getDeptNom(){
		return deptNom;
	}
	
	
	
	
}
