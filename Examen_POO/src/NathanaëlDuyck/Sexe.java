package NathanaëlDuyck;

public enum Sexe {
	 HOMME("GarÃ§on"),
	 FEMME("Fille"),;
	 private final String label;
	
	 Sexe(String label) {
	        this.label = label;
	 }

	 public String getLabel() {
	        return label;
	 }
}
