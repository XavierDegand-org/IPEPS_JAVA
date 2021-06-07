package UytterhaegenLouis;

public enum Departement {
	
	 Compta("Comptabilité"),
	 HR("Ressources Humaines"),
	 Prod("Production"),
	 SEC("Sécurité"),;
	 private final String DeptNom;
	
	 Departement(String DeptNom) {
		this.DeptNom = DeptNom;
	}

	 public  String getDeptNom() {
	        return DeptNom;
	 }
}