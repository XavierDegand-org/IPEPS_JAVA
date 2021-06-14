package Abdoulaye;

import java.util.HashMap;

    public class Magasin {


        HashMap<String,Produit> liste;

        public Magasin() {
            liste = new HashMap<String,Produit>();
        }

        public void listeMap() {

            System.out.println("La taille de HashMap est :" + liste.size());
            System.out.println("Produits =" + liste.values());
        }


        public void AjouterProduit(String nom, String description) {
            Produit produit = new Produit (nom, description);
            liste.put(nom,produit);
        }


        public void getProduit() {

        }

        public void isEmpty() {

        }
    }
