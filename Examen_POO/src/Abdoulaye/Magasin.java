package Abdoulaye;
import java.util.HashMap;

    public class Magasin {

        HashMap<String, Produit> liste;

        public void ajouterProduit(String nom, String description) {
            Produit produit = new Produit(nom, description);
            liste.put(nom, produit);
        }

        public Magasin() {
            liste = new HashMap<String, Produit>(); }

        public void listeMap() {
            System.out.println("Le magasin est composé de " + liste.size()+"articles");
            System.out.println("Produits =" + liste.values());
        }


        public void getProduit() {

        }

        public void isEmpty() {

        }
    }
