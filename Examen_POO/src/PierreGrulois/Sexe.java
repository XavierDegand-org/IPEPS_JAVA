package master;

public enum Sexe {
	 HOMME("Garçon"),
	 FEMME("Fille"),;
	 private final String label;
	
	 Sexe(String label) {
	        this.label = label;
	 }

	 public String getLabel() {
	        return label;
	 }
}
