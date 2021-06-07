package yacineFrimi;

public class Personnel extends Individu {
	private int idPersonnel;
	private String email;
	private String departement;
	
	

	public Personnel(int idPersonnel, String nom, String prenom, Sexe sexe, MyDate dateNaissance,  String email, String departement) {
		super(nom, prenom, sexe, dateNaissance);
		// TODO Auto-generated constructor stub
		
		}



	public int getIdPersonnel() {
		return idPersonnel;
	}



	public void setIdPersonnel(int idPersonnel) {
		this.idPersonnel = idPersonnel;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getDepartement() {
		return departement;
	}



	public void setDepartement(String departement) {
		this.departement = departement;
	}

}
