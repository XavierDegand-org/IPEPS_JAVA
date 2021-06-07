package Abdoulaye;

import Abdoulaye.Buttons.Listeners.*;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GestionJFrame extends JFrame {

    private JButton btnLoad = new JButton("Chargement du Personnel");
    private JButton btnAffichage = new JButton("Affichage liste du Personnel");
    private JButton btnMag = new JButton("Création du Magasin");
    private JButton btnPret = new JButton("Prêt du matériel");
    private JButton btnRetour = new JButton("Retour du matériel");
    private JButton btnPersonnel = new JButton("Modification donées Personnel");
    private JButton btnSauvegarde = new JButton("Sauvegarde");
    private JButton btnClose = new JButton("Fermer");

    public GestionJFrame() {
        super("Gestion du Personnel et prêt du matériel");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel contentPane = (JPanel) this.getContentPane();

        // Un FlowLayout permet de positionner les boutons les uns à la suite des autres.
        contentPane.setLayout(new GridLayout(3,3));

        contentPane.add(btnLoad);
        contentPane.add(btnAffichage);
        contentPane.add(btnMag);
        contentPane.add(btnPret);
        contentPane.add(btnRetour);
        contentPane.add(btnPersonnel);
        contentPane.add(btnSauvegarde);
        contentPane.add(btnClose);

        this.setSize(800, 400);
        this.setLocationRelativeTo(null);

        btnLoad.addActionListener(new btnLoadListener());
        btnAffichage.addActionListener(new btnAffichageListener());
        btnMag.addActionListener(new btnMagListener());
        btnPret.addActionListener(new btnPretListener());
        btnRetour.addActionListener(new btnRetourListener());
        btnPersonnel.addActionListener(new btnPersonnelListener());
        btnSauvegarde.addActionListener(new btnSauvegardeListener());
        btnClose.addActionListener(new btnCloseListener());

    }
}
        /*try{
        Personnel personnel = new Personnel("Paul", "Mc Artur",  Sexe.HOMME, new MyDate(12, 02, 1975),"acisse@test.be", Departement.HR);
        List<Personnel> Personnel = new ArrayList<Personnel>();
        Personnel.add(personnel);

        for(Personnel personnel1 : Personnel){
            System.out.println(Personnel.getClass().toString());
            System.out.println(personnel);
        }

    } catch (NullPointerException e){
        e.printStackTrace();
    }

      	System.out.println();
}*/



