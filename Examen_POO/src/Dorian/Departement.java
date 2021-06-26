package Dorian;

public enum Departement {
	
		 Compta("Comptabilité"),
		 HR    ("Ressource Humaines"),
		 Prod  ("Production"),
		 Securité ("Securité"),;
		 
		 
		 private final String label;
		
		 Departement(String label) { // constructeur avec label
		        this.label = label;
		 }

		 public String getLabelD() { // get le label de département
		        return label;
		 }
	}



