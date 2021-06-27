package Abdoulaye;

import java.util.HashMap;
import java.util.Map;

public class Magasin {

        public static HashMap<Integer, Produit> produits;

        public void mag() {
            produits = new HashMap<>();
        }

        public void ajouterProduit(int id, String nom, String description) {
            Produit produit = new Produit(nom, description);
            produits.put(id, produit);
        }

        public void listeHashMap() {

            if (produits.isEmpty()) {
                System.out.println("le chargement des produits n'est pas possible !!!");
            } else {

            }
        }

            public void getProduit (int nombre) {
                if (produits.isEmpty()) {
                    System.out.println("Magasin vide!!!");
                } else {

                    for (Map.Entry liste : produits.entrySet()) {
                        System.out.println("Id_"+liste.getKey()+liste.getValue().toString());
                    }
                }

            }

            public boolean isEmpty () {

                if (produits.size() == 0) {
                    return true;
                }
                return false;

            }
        }

