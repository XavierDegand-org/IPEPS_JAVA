package UytterhaegenLouis;

public class Personnel extends Individu {
	private int IdPersonnel;
	private String Email;
	private static int id=1;
	private Departement Departement;
	

	public Personnel(String nom, String prenom, Sexe sexe, MyDate dateNaissance, String Email, Departement Departement) {
		super(nom, prenom, sexe, dateNaissance);
		this.IdPersonnel = id++;
		if ( ControleSaisie.valideEmail(Email)) { // Permet qu'en cas de mauvaise écriture de l'email, d'automatiquement écrire le mail dans un bon format
			this.Email = Email;
			} else {
			this.Email = nom+"."+prenom.charAt(0) +"@test.be";
					}
		this.Departement= Departement;
		}
		
	
	 public int getIdPersonnel() {
			return IdPersonnel;
	  }

	  public String getEmail() {
			return Email;
	  }

	  public void setEmail(String Email) {
			this.Email = Email;
	  }
	  public String getDepartement() {
			return Departement.getDeptNom();
	  }
	  @Override
		public String toString() {
		  return String.format( "%s %s %s %s %s %s",
	                this.getDepartement(),
	                this.getPrenom(),
	                this.getNom(),
	                this.getSexe(),
	                this.getDateNaissance(),
	                this.Email );
		}
	  

}