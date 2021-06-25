package DanielDerveaux;

public class Personnel extends Individu {
	public int IdPersonnel;
	public String email;
	public Departement departement;
	private static final String EMAIL_PATTERN = 
			"^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	
	public Personnel(int IdPersonnel, String nom, String prenom, Sexe sexe, MyDate dateNaissance, String email, Departement departement) {
		super(nom, prenom, sexe, dateNaissance);
		this.IdPersonnel = IdPersonnel;
		this.email = email;
		this.departement = departement;
	}
	
	@Override
	  public String toString() {
		return String.format("%s %s %s %s %s %s",
                this.getDepartement(),
                this.getPrenom(),
                this.getNom(),
                this.getSexe(),
                this.getDateddMMyyyy(),
                this.email );
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
		if(email == null) {
			throw new NullPointerException( "L'adresse e-mail ne peut pas être nulle." );
		} else if(!EMAIL_PATTERN.matches(email)) {
			throw new RuntimeException( "L'adresse e-mail n'a pas un format valide." );
		}
		this.email = email;
	}
}
