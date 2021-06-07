package StainierEdwin;

public enum Departement {
	
	COMPTA("Comptabilit�"),
	HR("Ressource humaine"),
	PROD("Production"),
	SEC("Securit�"),
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
