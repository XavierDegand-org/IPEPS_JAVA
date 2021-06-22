package Console;

import java.util.regex.Pattern;

public class Personnel extends Individu {
	private static int id = 1;
	private int IdPersonnel;
	private String email;
	private Departement departement;
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+[a-z]{2,}$");

	public Personnel(String nom, String prenom, Sexe sexe, MyDate dateNaissance, String email,
			Departement departement) {
		super(nom, prenom, sexe, dateNaissance);
		this.setIdPersonnel(id++);
		this.setEmail(email);
		this.setDepartement(departement);

	}

	public int getIdPersonnel() {
		return IdPersonnel;
	}

	public void setIdPersonnel(int idPersonnel) {
		IdPersonnel = idPersonnel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null) {
			throw new NullPointerException("L'adresse e-mail ne peut pas être nulle.");
		}
		if (!EMAIL_PATTERN.matcher(email).matches()) {
			System.out.println(email);
			throw new RuntimeException("L'adresse e-mail n'a pas un format valide.");
		}
		this.email = email;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

}
