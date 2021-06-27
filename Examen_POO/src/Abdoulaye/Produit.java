package Abdoulaye;

public class Produit {
     private static int id = 1;
     private int identifiant = 0;
     private String nom =" ";
     private String description = " ";


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

        return String.format("Produit [nom = %s, Description = %s ]",
                this.nom, this.description);
    }
}
