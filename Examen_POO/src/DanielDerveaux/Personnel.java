package DanielDerveaux;

public class Personnel extends Individu {
	public int IdPersonnel;
	public String email;
	public Departement departement;
	/*private static final String EMAIL_PATTERN = 
			"^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";*/
	
	public Personnel(int IdPersonnel, String nom, String prenom, Sexe sexe, MyDate dateNaissance, String email, Departement departement) {
		super(nom, prenom, sexe, dateNaissance);
		this.IdPersonnel = IdPersonnel;
		this.email = email;
		this.departement = departement;
	}
	
	public int getIdPersonnel() {
		return IdPersonnel;
	}
	
	public void setIdPersonnel(int IdPersonnel) {
		this.IdPersonnel = IdPersonnel;
	}
	
	public String getDepartement() {
		return departement.getDeptNom();
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
