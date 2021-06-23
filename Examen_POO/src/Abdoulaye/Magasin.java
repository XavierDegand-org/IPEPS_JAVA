package Abdoulaye;
import java.util.HashMap;

    public class Magasin {

        HashMap<String, Produit> liste;

        public Magasin() {
            liste = new HashMap<String, Produit>();
        }
        public void ajouterProduit( String nom, String description){
            Produit produit = new Produit(nom, description);
            liste.put(nom, produit);
        }

        public void listeHashMap() {
            System.out.println("Le magasin est composé de " + liste.size() + "articles");
            System.out.println("Produits =" + liste.values());
        }

        public void  getProduit() {
            if(liste.isEmpty()){
                System.out.println("Magasin vide!!!");
            }
            else{

            }

        }

        public boolean isEmpty() {

            if(liste.size()==0) {
                return true;
            }
            return false;

        }
    }
