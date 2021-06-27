package UytterhaegenLouis;



public class Personnel extends Individu {
	private int IdPersonnel;
	private String email;
	private Departement Departement;
	private static int id=1;

	private static final String EMAIL_PATTERN
	= "^[\\w._-]{2,64}@[\\w.-]{2,}.[a-zA-Z]{2,}$";	

	public Personnel(String nom, String prenom, Sexe sexe, MyDate dateNaissance, String email, Departement departement) {
		super(nom, prenom, sexe, dateNaissance);
		this.IdPersonnel = id++;
		if ( ControleSaisie.valideEmail(email)) { // Permet qu'en cas de mauvaise écriture de l'email, d'automatiquement écrire le mail dans un bon format
			this.email = email;
		} else {
			this.email = nom+"."+prenom.charAt(0) +"@test.be";
		}
		this.Departement= departement;
	}


	public int getIdPersonnel() {
		return IdPersonnel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if ( email == null ) { // si l'email est nul
            throw new NullPointerException( "L'email ne peut-être nul !" );
        }
        if ( !email.matches(EMAIL_PATTERN) ) { // si le format de l'email ne correspond pas au pattern
            throw new RuntimeException( "Le format de l'email ne correspond pas à un format d'email !" );
        }
        this.email = email;
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
				this.email );
	}


}
