package Jessica;

public enum Departement {
	 Compta("Comptabilité"),
	 HR("Ressources Humaines"),
	 Prod("Production"),
	 SEC("Sécurité"),;
	 private final String deptNom;
	
	 Departement(String deptNom) {
	        this.deptNom = deptNom;
	 }

	 public String getDeptNom() {
	        return deptNom;
	 }
}
