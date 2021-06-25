package Abdoulaye;
import java.util.HashMap;

    public class Magasin {

        public static HashMap<Integer, Produit> produits;

        public Magasin() {
            produits = new HashMap<>();
        }

        public void ajouterProduit(int identifiant, String nom, String description) {
            Produit produit = new Produit(nom, description);
            produits.put(identifiant, produit);
        }

        public void listeHashMap() {

            if (produits.isEmpty()) {
                System.out.println("le chargement des produits n'est pas possible !!!");
            } else {

            }
        }

            public void getProduit () {
                if (produits.isEmpty()) {
                    System.out.println("Magasin vide!!!");
                } else {

                }

            }

            public boolean isEmpty () {

                if (produits.size() == 0) {
                    return true;
                }
                return false;

            }
        }
    }
