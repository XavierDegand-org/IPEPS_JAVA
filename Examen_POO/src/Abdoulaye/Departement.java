package Abdoulaye;

public enum Departement {

        Compta("Comptabilité"),
        HR("ressources Humaines"),
        Prod("Production"),
        Sec("Sécurité");

        private final String deptNom;

        Departement(String deptNom) {
            this.deptNom = deptNom;
        }

        public String getDeptNom() {
            return deptNom;
        }


    }

