package yacineFrimi;

public enum Departement {
	Compta("Comptabilité"),
	HR("Ressources Humaines"),
	Securité("Sécurité"),
	Prod("Production");

	private final String label;

	Departement(String label) {
		// TODO Auto-generated constructor stub
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}

}
