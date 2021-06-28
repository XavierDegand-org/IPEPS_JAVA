package Abdoulaye;

import java.util.HashMap;


public class Magasin  {

    public static HashMap<Integer, Produit> produits;

    public Magasin() {
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
            for (HashMap.Entry<Integer, Produit> liste : produits.entrySet()) {
                System.out.println("Id_" + liste.getKey() + "---"+liste.getValue().toString());
            }
        }
    }


    public HashMap<Integer, Produit> getProduit(int nombre) {

        if (produits.isEmpty()) {
            System.out.println("Magasin vide!!!");

        } else {
            for (HashMap.Entry<Integer, Produit> liste : produits.entrySet()) {

                if (liste.getKey().equals(nombre)) {
                    System.out.println("Id_" + liste.getKey() + "---" + liste.getValue().toString());
                }
            }
        }
        return produits;
    }

            public boolean isEmpty () {

                if (produits.size() == 0) {
                    return true;
                }
                return false;
            }
        }

