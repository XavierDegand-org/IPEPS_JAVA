package yacineFrimi;

public class Personnel extends Individu {
	private int idPersonnel;
	private String email;
	private Departement departement;
	
	

	public Personnel(int idPersonnel, String nom, String prenom, Sexe sexe, MyDate dateNaissance,  String email, Departement departement) {
		super(nom, prenom, sexe, dateNaissance);
		// TODO Auto-generated constructor stub
		this.idPersonnel = idPersonnel;
		this.email = email;
		this.departement = departement;
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



	public Departement getDepartement() {
		return departement;
	}



	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	@Override
	public String toString() {
		return super.toString()+"email : "+email+" département : "+departement;
	}



}
