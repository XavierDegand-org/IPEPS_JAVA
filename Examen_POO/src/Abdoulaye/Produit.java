package Abdoulaye;

public class Produit {
    public static int id = 1;
     private String nom =" ";
     private String description = " ";
     private int identifiant = 0;

    // constructeur du Produit
    public Produit(String nom, String description) {
        this.identifiant = id++;
        this.nom = nom;
        this.description = description;
    }

    public String getNom() { return nom; }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdentifiant() { return identifiant; }

    @Override
    public String toString() {

        return "Id_"+identifiant +" --- Produit [" +
                "nom= " + nom +
                ", description = " + description  +
                ']';
    }
}
