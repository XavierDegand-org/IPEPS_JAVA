package DanielDerveaux;

public enum Departement {
	HR("Ressources Humaines"),
	Compta("Comptabilité"),
	Prod("Production"),
	SEC("Sécurité");
	private final String deptNom;
	
	Departement(String deptNom) {
		this.deptNom = deptNom;
	}

	public String getDeptNom() {
	       return deptNom;
	}
}
