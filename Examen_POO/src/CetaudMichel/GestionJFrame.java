package CetaudMichel;

import javax.swing.JFrame;
import javax.swing.JButton;

public class GestionJFrame extends JFrame{
	
	
	public GestionJFrame(){
		
		JButton btnLoad = new JButton("Chargement du personnel");
		btnLoad.setBounds(5,5,250,50);
		btnLoad.addActionListener(e -> new Personnel());
		this.add(btnLoad);
		
		JButton btnAffichage = new JButton("Affichage liste du personnel");
		btnAffichage.setBounds(255,5,250,50);
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
	
		
	}


	
}






