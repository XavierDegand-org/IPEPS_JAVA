package Dorian;

public enum Departement {
	
		 Compta("Comptabilité"),
		 HR    ("Ressource Humaines"),
		 Prod  ("Production"),
		 Securité ("Securité"),;
		 
		 
		 private final String label;
		
		 Departement(String label) {
		        this.label = label;
		 }

		 public String getLabelD() {
		        return label;
		 }
	}



