package StainierEdwin;

public enum Departement {
	
	COMPTA("Comptabilité"),
	HR("Ressource humaine"),
	PROD("Production"),
	SEC("Securité"),
	;
	
	private final String deptNom;
		
	Departement(String deptNom) {
		this.deptNom = deptNom;
	}
	
	public String GetDeptNom()
	{
		return deptNom;
	}
	
}
