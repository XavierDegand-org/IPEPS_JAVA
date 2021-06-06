package CetaudMichel;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.io.*;



public class GestionJFrame extends JFrame {
	
	
	String [][] Values;
	
	public GestionJFrame(){
		
		//Personnel test = new Personnel();
		
		JButton btnLoad = new JButton("Chargement du personnel");
		btnLoad.setBounds(5,5,250,50);
		btnLoad.addActionListener(e -> Load());
		this.add(btnLoad);
		
		JButton btnAffichage = new JButton("Affichage liste du personnel");
		btnAffichage.setBounds(255,5,250,50);
		btnAffichage.addActionListener(e -> Affiche());
		this.add(btnAffichage);
		
		JButton btnMag = new JButton("Création du magasin");
		btnMag.setBounds(505,5,250,50);
		this.add(btnMag);
		
		JButton btnPret = new JButton("Prêt de matériel");
		btnPret.setBounds(5,55,250,50);
		this.add(btnPret);
		
		JButton btnRetour = new JButton("Retour de matériel");
		btnRetour.setBounds(255,55,250,50);
		this.add(btnRetour);
		
		JButton btnPersonnel = new JButton("Modification données Personnel");
		btnPersonnel.setBounds(505,55,250,50);
		this.add(btnPersonnel);
		
		JButton btnSauvegarde = new JButton("Sauvegarde");
		btnSauvegarde.setBounds(5,105,250,50);
		this.add(btnSauvegarde);
		
		JButton btnClose = new JButton("Fermer");
		btnClose.setBounds(255,105,250,50);
		btnClose.addActionListener(e -> System.exit(0));
		this.add(btnClose);
		
		btnClose.addActionListener(null);
		
		this.setLayout(null);
		this.setResizable(false);
		this.setSize(760,180);
		this.setLocation(350, 250);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void Load() {
		

		Values = Personnel.getValues();
		System.out.println("Chargement complet.");
		
	}


	public void Affiche() {
		
		//Charge avant d'afficher si pas appuyer sur load
		if(Values==null) {
			Load();
		}
		
		System.out.println("+------+----------------+----------------+------+----------------+-------------------------+");
		System.out.println("|Depar.|       Nom      |     Prénom     | Sex  |    Naissance   |          Email          |");
		System.out.println("+------+----------------+----------------+------+----------------+-------------------------+");
		
		for(int i = 0;i<Values[0].length;i++) {
		
			System.out.printf("|%-6s|%-16s|%-16s|%-6s|%-16s|%-25s|\n",Values[0][i],Values[1][i],Values[2][i],Values[3][i],Values[4][i],Values[5][i]);
		}
		System.out.println("+------+----------------+----------------+------+----------------+-------------------------+");
 }
	
		
}





