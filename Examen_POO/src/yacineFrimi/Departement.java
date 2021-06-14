package yacineFrimi;

public enum Departement {
	Compta("Comptabilité"), HR("Ressources Humaines"), Securité("Sécurité"), Prod("Production");

	private final String deptNom;

	Departement(String deptNom) {
		this.deptNom = deptNom;
	}

	public String getDeptNom() {
		return deptNom;
	}

}
