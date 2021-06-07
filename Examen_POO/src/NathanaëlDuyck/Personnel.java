package NathanaëlDuyck;

import java.util.regex.Pattern;

public class Personnel extends Individu {
	
	private int IdPersonnel;
	private static int id = 0;
	private String email;
	private static final Pattern EMAIL_PATTERN = Pattern.compile( 
			"^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
	private Departement departement;
	
	public Personnel(String nom, String prenom, Sexe sexe, MyDate dateNaissance, String email,Departement depart) {
		super(nom, prenom, sexe, dateNaissance);
		this.IdPersonnel = id++;
		this.email = email;
		this.departement=depart;
	}

	@Override
	public String toString() {
		return String.format(" %s %s %s %s %d-%d-%d %s"
				,getDepartement(),getPrenom(),getNom(),getSexe(),getDateNaissance().getJour(),getDateNaissance().getMois(),getDateNaissance().getAnnee(),getEmail());
	}

	public int getIdPersonnel() {
		return IdPersonnel;
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
