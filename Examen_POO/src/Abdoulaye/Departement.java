package Abdoulaye;

public enum Departement {

        Compta("Comptabilité"),
        HR("ressources Humaines"),
        Prod("Production"),
        Sec("Sécurité");

        private final String label;

        Departement(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

