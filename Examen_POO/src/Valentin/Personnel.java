package Valentin;

public class Personnel extends Individu {
	
	private int idPersonel;
	private  static int id = 1;
	private String email;
	protected Departement departement;
	private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	
	public Personnel(String nom,String prenom, Sexe sexe, MyDate dateNaissance,Departement departement, String email) {
		super(nom, prenom, sexe, dateNaissance);
		this.idPersonel = id++;
		this.departement = departement;
		this.email = email;
	}
	
	public int getIdPersonel() {
		return idPersonel;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"Département : "+departement+" @ mail : "+email;
	}
}
