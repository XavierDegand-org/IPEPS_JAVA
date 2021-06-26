package Dorian;

public enum Sexe {
	 HOMME("Garçon"),
	 FEMME("Fille"),;
	 private final String label;
	
	 Sexe(String label) {
	        this.label = label; //fixe label dans un object
	 }

	 public String getLabel() { // donne label de l'object 
	        return label;
	 }
}
