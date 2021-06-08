package michael;

public enum Departement {
Compta("Comptabilité"),
RH("Ressources Humaines"),
Prod("Production"),
SEC("Secrétariat");
private final String deptNom;

 Departement(String deptNom) {
// TODO Auto-generated constructor stub
this.deptNom = deptNom;
}
public String getdeptNom() {
return deptNom;
}
}