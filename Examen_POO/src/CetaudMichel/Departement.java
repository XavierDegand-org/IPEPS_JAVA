package CetaudMichel;

public enum Departement {
	HR("Resources Humaines"), Compta("Comptabilité"), Securité("Sécurité"), Prod("Production"),;

	private final String label;

	Departement(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
