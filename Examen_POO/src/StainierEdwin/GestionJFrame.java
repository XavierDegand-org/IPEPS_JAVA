package StainierEdwin;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GestionJFrame extends JFrame {

	// Les différents boutons
	private JButton btnLoad = new JButton("Chargement du personnel");
	private JButton btnAffichage = new JButton("Affichage liste du personnel");
	private JButton btnMag = new JButton("Création du magasin");
	private JButton btnPret = new JButton("Prêt de matériel");
	private JButton btnRetour = new JButton("Retour de matériel");
	private JButton btnPersonnel = new JButton("Modification données Personnel");
	private JButton btnSauvegarde = new JButton("Sauvegarde");
	private JButton btnClose = new JButton("Fermer");
	
	private ArrayList<Individu> listIndividu = new ArrayList<>();
	private boolean isPersonnelLoad = false;
	
	public GestionJFrame()
	{
		super("Implementation GestionJFrame");
		
		// Paramètres de la fenêtre
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Gestion Personnel & prêt matériel.");
			
		// Créer JPanel
		JPanel container = (JPanel)this.getContentPane();
		container.setLayout(new FlowLayout());
		
		// Ajouter les boutons au JPanel
		container.add(btnLoad);
		container.add(btnAffichage);
		container.add(btnMag);
		container.add(btnPret);
		container.add(btnRetour);
		container.add(btnPersonnel);
		container.add(btnSauvegarde);
		container.add(btnClose);
		
		// Click on btnLoad
		btnLoad.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				LoadPersonnel();
			}
		});
		
		// Click on btnAffichage
		btnAffichage.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				AffichagePersonnel();
			}
		});
		
		// Click on btnMag
		btnMag.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(((JButton)e.getSource()).getText());
			}
		});
		
		// Click on btnPret
		btnPret.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(((JButton)e.getSource()).getText());
			}
		});
		
		// Click on btnRetour
		btnRetour.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(((JButton)e.getSource()).getText());
			}
		});
		
		// Click on btnPersonnel
		btnPersonnel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(((JButton)e.getSource()).getText());
			}
		});
		
		// Click on btnSauvegarde
		btnSauvegarde.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(((JButton)e.getSource()).getText());
			}
		});
		
		// Click on btnClose
		btnClose.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Close();
			}
		});
				
	}
	
	// Fermer la JFrame
	private void Close()
	{
		super.dispose();
	}
	
	// Charger le personnel
	private void LoadPersonnel()
	{
		listIndividu.add(new Individu("Collon", "Albert", Sexe.HOMME, new MyDate(10, 8, 1990), "Collon.a@test.be", Departement.HR));
		listIndividu.add(new Individu("Peeters", "Marie", Sexe.FEMME, new MyDate(1, 5, 1985), "Peeters_M@@test.be", Departement.HR));
		listIndividu.add(new Individu("Janssens", "Sarah", Sexe.FEMME, new MyDate(23, 5, 1999), "Sarah.Janssens@test", Departement.COMPTA));
		listIndividu.add(new Individu("Maes", "Henri", Sexe.HOMME, new MyDate(14, 9, 2009), "MaesHenri#test.be", Departement.COMPTA));
	
		isPersonnelLoad = true;
	}
	
	// Afficher personnel
	private void AffichagePersonnel()
	{
		if (isPersonnelLoad)
		{
			System.out.println("+---------------" + "+---------------" + "+---------------" + "+---------------" + "+---------------" + "+---------------+");
			System.out.println("| Département   " + "| Prénom        " + "| Nom           " + "| Sexe          " + "| Naissance     " + "| Email         |");
			System.out.println("+---------------" + "+---------------" + "+---------------" + "+---------------" + "+---------------" + "+---------------+");
			for (Individu individu : listIndividu)
			{
				System.out.println(individu.personnel.GetDepartement() + " " + individu.getPrenom() + " " + individu.getNom() + " " + individu.getSexe() + " " + individu.getDateddMMyyyy() + " " + individu.personnel.GetEmail());
			}
		}
		else
			System.out.println("Affichage impossible, pas de personnel !");
	}
	
}
