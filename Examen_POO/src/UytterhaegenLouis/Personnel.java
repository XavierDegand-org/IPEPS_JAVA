package UytterhaegenLouis;

public class Personnel extends Individu {
	private int IdPersonnel;
	private String Email;
	private static int id;
	private Departement Departement;

	public Personnel( String nom, String prenom, Sexe sexe, MyDate dateNaissance, String Email, Departement Departement) {
		super(nom, prenom, sexe, dateNaissance);
		//this.IdPersonnel = id++;
		this.Email = Email;
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
			return super.toString()+" %s "+ Email;
		}
	  

}
