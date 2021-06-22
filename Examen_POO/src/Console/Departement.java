package Console;

public enum Departement {
	Compta("Compta"), HR("HR"), Prod("Prod"), Securité("Securité");

	private final String deptNom;

	Departement(String deptNom) {
		this.deptNom = deptNom;
	}

	public String getDeptNom() {
		return deptNom;
	}

}