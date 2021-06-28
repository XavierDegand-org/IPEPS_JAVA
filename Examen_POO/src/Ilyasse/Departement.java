package Ilyasse;

public enum Departement {
	 COMPTA("Comptabilité"),
	 Prod("Prodution"),
	 HR("Ressources humaines"),
	 SEC("Sécurité"),;
	 private final String deptNom;
	
	 Departement(String deptNom) {
	        this.deptNom = deptNom;
	 }

	 public String getDeptNom() {
	        return deptNom;
	 }

}
