package Abdoulaye;

import java.util.regex.Pattern;

public class Personnel extends Individu{

    // En définissant une expression régulière compilé une fois pour toute, elle est partagée par toutes les instances de Personne
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+[a-z]{2,}$");
    private static int id = 1;
    private int idPersonnel;
    private String email;
    private Departement departement;

    public Personnel(String nom, String prenom, Sexe sexe, MyDate dateNaissance, String email, Departement departement) {
        super(nom, prenom, sexe, dateNaissance);
        this.idPersonnel = id++;
        this.email = email;
        this.departement = departement;
    }

    public void setIdPersonnel( int idPersonnel ) {
        if ( idPersonnel < 0 )  {
            throw new RuntimeException( "l'identification doit être possitive." );
        }
        this.idPersonnel = idPersonnel;
    }

    public int getIdPersonnel() {
        return idPersonnel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if ( email == null ) {
            throw new NullPointerException( "email ne peut pas être nul" );
        }
        if ( ! EMAIL_PATTERN.matcher( email ).matches() ) {
            throw new RuntimeException( "Le format de l'email ne correspond pas aux patterns." );
        }
        this.email = email;
    }

    public Departement getDepartement() {
        return departement;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "idPersonnel=" + idPersonnel +
                ", email='" + email + '\'' +
                '}';
    }
}
