package Abdoulaye;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GestionJFrame extends JFrame {

    private JButton btnLoad = new JButton("Chargement du Personnel");
    private JButton btnAffichage = new JButton("Affichage liste du Personnel");
    private JButton btnMag = new JButton("Création du Magasin");
    private JButton btnPret = new JButton("Prêt du matériel");
    private JButton btnRetour = new JButton("Retour du matériel");
    private JButton btnPersonnel = new JButton("Modification données Personnel");
    private JButton btnSauvegarde = new JButton("Sauvegarde");
    private JButton btnClose = new JButton("Fermer");

    private static ArrayList<Personnel> Person = new ArrayList<>();
    private static Magasin magasin = new Magasin();




    public GestionJFrame() {
        super("Gestion du Personnel et prêt du matériel");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel contentPane = (JPanel) this.getContentPane();

        // Un GridLayout permet de créer les boutons 3 sur la même ligne.
        contentPane.setLayout(new GridLayout(3, 3));

        contentPane.add(btnLoad);
        contentPane.add(btnAffichage);
        contentPane.add(btnMag);
        contentPane.add(btnPret);
        contentPane.add(btnRetour);
        contentPane.add(btnPersonnel);
        contentPane.add(btnSauvegarde);
        contentPane.add(btnClose);

        btnLoad.addActionListener(new LoadPersonnel());
        btnAffichage.addActionListener(new Affichage());
        btnMag.addActionListener(new magasin());
        /*btnPret.addActionListener(new Emprunt());
        btnRetour.addActionListener(new RetourEmprunt());
        btnPersonnel.addActionListener(new GestionPersonnel());
        btnSauvegarde.addActionListener(new Sauvegarde());*/
        btnClose.addActionListener(e -> System.exit(0));

        this.setSize(800, 400);
        this.setLocationRelativeTo(null);

    }

    //Chargement liste personnel
    public JButton getBtnLoad() {
        return btnLoad;
    }

    public class LoadPersonnel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("btnLoad works");
            //La liste du personnel à charger

            try {

                Person.add(new Personnel("Collon", "Albert", Sexe.HOMME, new MyDate(10, 8, 1990), "collon.a@test.be", Departement.HR));
                Person.add(new Personnel("Peeters", "Marie", Sexe.FEMME, new MyDate(1, 5, 1985), "peeters.m@test.be", Departement.HR));
                Person.add(new Personnel("Janssens", "Sarah", Sexe.FEMME, new MyDate(23, 5, 1999), "sarah.j@test.be", Departement.Compta));
                Person.add(new Personnel("Maes", "Henri", Sexe.HOMME, new MyDate(14, 9, 2009), "henri.m@test.be", Departement.Compta));
                Person.add(new Personnel("Jacobs", "Charles", Sexe.HOMME, new MyDate(12, 12, 2009), "charles.j@test.be", Departement.Sec));
                Person.add(new Personnel("Mertens", "Floriane", Sexe.FEMME, new MyDate(20, 8, 1996), "Floriane.m@test.be", Departement.Sec));
                Person.add(new Personnel("Willems", "Francois-Xavier", Sexe.HOMME, new MyDate(28, 10, 1996), "francois.w@test.be", Departement.Prod));
                Person.add(new Personnel("O'neil", "Shan", Sexe.HOMME, new MyDate(1, 7, 2001), "oneil.s@test.be", Departement.Prod));
                Person.add(new Personnel("Willems", "Francois-Xavier", Sexe.HOMME, new MyDate(28, 10, 1996), "francois.w@test.be", Departement.HR));
                Person.add(new Personnel("Goossen", "Stéphanie", Sexe.FEMME, new MyDate(25, 10, 2008), "stephanie.g@test.be", Departement.Prod));
                Person.add(new Personnel("Willems", "Francois-Xavier", Sexe.HOMME, new MyDate(28, 10, 1996), "francois.w@test.be", Departement.Prod));
                Person.add(new Personnel("Van Moore", "Wilfrid", Sexe.HOMME, new MyDate(25, 2, 1998), "vanmoore.w@test.be", Departement.Compta));
                Person.add(new Personnel("Herman", "Nathalie", Sexe.FEMME, new MyDate(26, 7, 2001), " herman.n@test.be", Departement.Prod));
                Person.add(new Personnel("Bontemps", "Annie", Sexe.FEMME, new MyDate(23, 9, 1998), "bontemps.a@test.be", Departement.Prod));

                for (Personnel person : Person) {
                    System.out.println(person);
                }

            } catch (NullPointerException | IllegalArgumentException e1) {
                e1.printStackTrace();
            }
        }

    }


    //Affichage du Personnel
    public JButton getBtnAffichage() {
        return btnAffichage;
    }

    public static class Affichage implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //si la liste personnel ne contient aucune ligne
            if (Person.size() < 1) {
                System.out.println("Une erreur est survenue pendant l'affichage du personnel !");
            } else {
                System.out.println("+-----------------------+---------------------+-----------------------+---------------------+------------------------+------------------------+");
                System.out.println("| Département           |    Prénom           |    Nom                |       Sexe          |    Naissance           |    Email               |");
                System.out.println("+-----------------------+---------------------+-----------------------+---------------------+------------------------+------------------------+");

                StringBuilder stringBuilder = new StringBuilder();
                for (Personnel person : Person) {

                    stringBuilder.append(" ");
                    stringBuilder.append(setFixedLength(person.getDepartement().getDeptNom()));
                    stringBuilder.append("\t");
                    stringBuilder.append("\t");
                    stringBuilder.append(setFixedLength(person.getPrenom()));
                    stringBuilder.append("\t");
                    stringBuilder.append(setFixedLength(person.getNom()));
                    stringBuilder.append("\t");
                    stringBuilder.append(setFixedLength(person.getSexe()));
                    stringBuilder.append("\t");
                    stringBuilder.append(setFixedLength(person.getDateddMMyyyy()));
                    stringBuilder.append("\t");
                    stringBuilder.append(setFixedLength(person.getEmail()));
                    stringBuilder.append("\n");
                }
                // on affiche le contenu
                System.out.println(stringBuilder);
            }
        }
    }

    // calibrage de la taille des caractères
    static String setFixedLength(String s) {
        StringBuilder ss = new StringBuilder(s);
        //tant que la taille de ss est inférieur à 20 on ajoute un caractère blanc
        while (ss.length() < 20) {
            String d = " ";
            char c1 = d.charAt(0);
            ss.insert(s.length(), c1);
        }
            String c = ss.substring(0, 20);
        return c;
        }

    //Création du Magasin
    public JButton getBtnMag() {
        return btnMag;
    }

    private static class magasin implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            Magasin();
        }

    public void Magasin(){

            try { // chargement des produits du magasin avec leur ajout par la methode ajouterProduit
                magasin.ajouterProduit(1,"Lenovo", "ThinkPad E15 G2");
                magasin.ajouterProduit(2, "Dell", "IdeaPad 3 14IIL05 81WD00B2MH");
                magasin.ajouterProduit(3, "Dell", "XPS 13");
                magasin.ajouterProduit(4,"Dell", "XPS 15");
                magasin.ajouterProduit(5,"HP", "Elitebook 830 G7 X360");
                magasin.ajouterProduit(6,"Dell", "Inspiron 15 3000");
                magasin.ajouterProduit(7,"HP", "Elitebook 850 G7");

            } catch (NullPointerException | IllegalArgumentException e1) {
                e1.printStackTrace();
            }
            //Affichage du nombre de produits
            System.out.println("Le magasin est composé de "+Magasin.produits.size()+" articles");

            magasin.getProduit(6);
            magasin.getProduit(7);
            magasin.getProduit(4);
            magasin.getProduit(5);
            magasin.getProduit(2);
            magasin.getProduit(3);
            magasin.getProduit(1);

        }
    }
    //Prêt matériel
    public JButton getBtnPret() {
        return btnPret;
    }
    public static class Pret implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("btnPret works");

        }
    }


    //Retour matériel
    public JButton getBtnRetour() {
        return btnRetour;
    }
    public static class RetourPret implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    // Modification Personnel
    public JButton getBtnPersonnel() {
        return btnPersonnel;
    }

    // Sauvegarde
    public JButton getBtnSauvegarde() {
        return btnSauvegarde;
    }

}



