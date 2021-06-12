package PierreGrulois;

public enum Departement {
	Compta ("Comptabilité"),
	HR ("Ressource Humaine"),
	Prod ("Production"),
	SEC ("Sécurité"),;
	
	private final String deptNom;
	Departement (String deptNom){
		
		this.deptNom = deptNom;
	}
	
	public String getDeptNom(){
		
		return deptNom;
	}
	
}
