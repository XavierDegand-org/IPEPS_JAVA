package yacineFrimi;

import javax.swing.JFrame;
import javax.swing.JPanel;

import boutons.btnAffichageListener;
import boutons.btnLoadListener;
import boutons.btnMagListener;
import boutons.btnPersonnelListener;
import boutons.btnPretListener;
import boutons.btnRetourListener;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;

public class GestionJFrame extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static File fichierPersonnel = new File("C:\\Users\\yacin\\git\\IPEPS_JAVA\\Examen_POO\\src\\yacineFrimi\\Personnel.txt");

	static File fichierProduits = new File("C:\\Users\\yacin\\git\\IPEPS_JAVA\\Examen_POO\\src\\yacineFrimi\\produits.txt");





	private JButton btnLoad = new JButton("Chargement du personnel");
	private JButton btnAffichage = new JButton("Affichage liste du personnel");
	private JButton btnPersonnel = new JButton("Modification données personnel");
	private JButton btnMag = new JButton("Création du magasin");
	private JButton btnPret = new JButton("Prêt de matériel");
	private JButton btnRetour = new JButton("Retour de matériel");
	private JButton btnSauvegarde = new JButton("Sauvegarde");
	private JButton btnClose = new JButton("Fermer");

	public GestionJFrame() {
		super("Gestion personnel & prêt matériel.");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel ecranPrincipal = (JPanel) this.getContentPane();
		ecranPrincipal.setLayout(new GridLayout(2,2,2,2));

		ecranPrincipal.add(btnLoad);
		ecranPrincipal.add(btnAffichage);
		ecranPrincipal.add(btnPersonnel);
		ecranPrincipal.add(btnMag);
		ecranPrincipal.add(btnPret);
		ecranPrincipal.add(btnRetour);
		ecranPrincipal.add(btnSauvegarde);
		ecranPrincipal.add(btnClose);

		this.setSize(800, 400);
		this.setLocationRelativeTo(null);

		btnLoad.addActionListener(new btnLoadListener());
		btnAffichage.addActionListener(new btnAffichageListener());
		btnPersonnel.addActionListener(new btnPersonnelListener());
		btnMag.addActionListener(new btnMagListener());
		btnPret.addActionListener(new btnPretListener());
		btnRetour.addActionListener(new btnRetourListener());
		btnSauvegarde.addActionListener(new btnSauvegardeListener());
		btnClose.addActionListener((e) -> dispose());






	}
	
	
		    

		       
		    
}

	
	
	


