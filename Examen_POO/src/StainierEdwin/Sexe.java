package StainierEdwin;

public enum Sexe {
	 HOMME("Gar�on"),
	 FEMME("Fille"),;
	 private final String label;
	
	 Sexe(String label) {
	        this.label = label;
	 }

	 public String getLabel() {
	        return label;
	 }
}
