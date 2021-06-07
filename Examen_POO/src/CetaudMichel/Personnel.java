package CetaudMichel;

public class Personnel extends Individu {
	
	private int idPersonnel;
	private String email;
	private Departement departement;
	

	public Personnel(int IdPersonnel, String nom, String prenom, Sexe sexe, MyDate dateNaissance, String Email, Departement departement) {
		
		super(nom, prenom, sexe,dateNaissance);
		
		this.idPersonnel = IdPersonnel;
		this.email = Email;
		this.departement = departement;
	}
	
	public int getIdPersonnel() {
		return idPersonnel;
	}
	
	public Departement getDepartement(){
		return departement;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	
	}
	
	@Override
	  public String toString() {
		return String.format(" %-20s %-16s %-16s %-6s %-16s %-25s\n",departement.getLabel(),super.getPrenom(),super.getNom(),super.getSexe(),super.getDateddMMyyyy(),email);
	}
	
}