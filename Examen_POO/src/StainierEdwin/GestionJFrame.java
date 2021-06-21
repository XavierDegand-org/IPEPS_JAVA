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
	
	Magasin mag;
	
	
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
				if (isPersonnelLoad)
					AffichagePersonnel();
				else
					System.out.println("Impossible, pas de personnel !");
			}
		});
		
		// Click on btnMag
		btnMag.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CreationMagasin();
			}
		});
		
		// Click on btnPret
		btnPret.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (isPersonnelLoad)
				{
					if (mag != null)
						PretMateriel();
					else
						System.out.println("Impossible, le magasin n'existe pas !");
				}
				else
					System.out.println("Impossible, pas de personnel !");
			}
		});
		
		// Click on btnRetour
		btnRetour.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (isPersonnelLoad)
				{
					if (mag != null)
						RetourMateriel();
					else
						System.out.println("Impossible, le magasin n'existe pas !");
				}
				else
					System.out.println("Impossible, pas de personnel !");
			}
		});
		
		// Click on btnPersonnel
		btnPersonnel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (isPersonnelLoad)
				{					
					AffichagePersonnel();
					GestionPersonnel();
				}					
				else
					System.out.println("Impossible, pas de personnel !");
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
		listIndividu.add(new Individu("Jacobs", "Charles", Sexe.HOMME, new MyDate(12, 12, 2009), "Charles.j#test.be", Departement.SEC));
		listIndividu.add(new Individu("Mertens", "Floriane", Sexe.FEMME, new MyDate(20, 8, 1996), "FloFlo.M@test", Departement.SEC));
		listIndividu.add(new Individu("Willems", "Francois-Xavier", Sexe.HOMME, new MyDate(28, 10, 1996), "Willems.F-X@test.be", Departement.PROD));
		listIndividu.add(new Individu("O'Neil", "Shan", Sexe.HOMME, new MyDate(1, 7, 2001), "ONeil.sh@test.be", Departement.PROD));
		listIndividu.add(new Individu("Goossen", "Stéphanie", Sexe.FEMME, new MyDate(25, 10, 2008), "NieNie@test.be", Departement.HR));
		listIndividu.add(new Individu("Dumont", "Charles", Sexe.HOMME, new MyDate(1, 4, 1969), "dumont.c@test.be", Departement.HR));
		listIndividu.add(new Individu("Van Moore", "Wilfrid", Sexe.HOMME, new MyDate(25, 2, 1998), "vanmoore.w@test.be", Departement.COMPTA));
		listIndividu.add(new Individu("Herman", "Nathalie", Sexe.FEMME, new MyDate(26, 7, 2001), "herman.n@test.be", Departement.PROD));
		listIndividu.add(new Individu("Bontemps", "Annie", Sexe.FEMME, new MyDate(23, 9, 1998), "bontemps.a@test.be", Departement.PROD));		
	
		isPersonnelLoad = true;
	}
	
	// Afficher personnel
	private void AffichagePersonnel()
	{		
		// Définir la taille des string dans la list pour l'affichage
		int dptLength = 17;
		int prenomLength = 17;
		int nomLength = 0;
		int sexeLength = 8;
		int naissanceLength = 11;
		int mailLength = 0;
		
		int prenomTemp = 0;
		int nomTemp = 0;
		int mailTemp = 0;
		
		for (int i = 0; i < listIndividu.size() - 1; i++)
		{
			if (listIndividu.get(i+1).getPrenom().length() > listIndividu.get(i).getPrenom().length())
			{
				prenomLength = listIndividu.get(i+1).getPrenom().length();
				if (prenomLength > prenomTemp)
					prenomTemp = prenomLength;
			}
			
			if (listIndividu.get(i+1).getNom().length() > listIndividu.get(i).getNom().length())
			{
				nomLength = listIndividu.get(i+1).getNom().length();
				if (nomLength > nomTemp)
					nomTemp = nomLength;
			}
			
			if (listIndividu.get(i+1).personnel.GetEmail().length() > listIndividu.get(i).personnel.GetEmail().length())
			{
				mailLength = listIndividu.get(i+1).personnel.GetEmail().length();
				if (mailLength > mailTemp)
					mailTemp = mailLength;
			}
		}
		prenomLength = prenomTemp;	
		nomLength = nomTemp;
		mailLength = mailTemp;
		
		
		String tiret = "----------------------------------------------";
		String espace = "                                              ";
		
		StringBuilder buildTab = new StringBuilder();
		
		try {
			// Ligne 1
			buildTab.append("+");	
			buildTab.append(tiret, 0, dptLength + 1);
			buildTab.append("+");	
			buildTab.append(tiret, 0, prenomLength + 1);
			buildTab.append("+");	
			buildTab.append(tiret, 0, nomLength + 1);		
			buildTab.append("+");	
			buildTab.append(tiret, 0, sexeLength + 1);
			buildTab.append("+");	
			buildTab.append(tiret, 0, naissanceLength + 1);
			buildTab.append("+");	
			buildTab.append(tiret, 0, mailLength + 1);
			buildTab.append("+\n");	
				
			// Ligne 2
			buildTab.append("| ");
			buildTab.append("Département");
			buildTab.append(espace, 0, dptLength-11);
			buildTab.append("| ");
			buildTab.append("Prénom");
			buildTab.append(espace, 0, prenomLength-6);
			buildTab.append("| ");
			buildTab.append("Nom");
			buildTab.append(espace, 0, nomLength-3);
			buildTab.append("| ");
			buildTab.append("Sexe");
			buildTab.append(espace, 0, sexeLength-4);
			buildTab.append("| ");
			buildTab.append("Naissance");
			buildTab.append(espace, 0, naissanceLength-9);
			buildTab.append("| ");
			buildTab.append("Email");
			buildTab.append(espace, 0, mailLength-5);
			buildTab.append("| \n");
			
			// Ligne 3
			buildTab.append("+");	
			buildTab.append(tiret, 0, dptLength + 1);
			buildTab.append("+");	
			buildTab.append(tiret, 0, prenomLength + 1);
			buildTab.append("+");	
			buildTab.append(tiret, 0, nomLength + 1);		
			buildTab.append("+");	
			buildTab.append(tiret, 0, sexeLength + 1);
			buildTab.append("+");	
			buildTab.append(tiret, 0, naissanceLength + 1);
			buildTab.append("+");	
			buildTab.append(tiret, 0, mailLength + 1);
			buildTab.append("+\n");	
			
			// Afficher la liste
			for (Individu individu : listIndividu)
			{
				buildTab.append(" " + individu.personnel.GetDepartement());
				buildTab.append(espace, 0, dptLength - individu.personnel.GetDepartement().length() + 2);
				buildTab.append(individu.getPrenom());
				buildTab.append(espace, 0, prenomLength - individu.getPrenom().length() + 2);
				buildTab.append(individu.getNom());
				buildTab.append(espace, 0, nomLength - individu.getNom().length() + 2);
				buildTab.append(individu.getSexe());
				buildTab.append(espace, 0, sexeLength - individu.getSexe().length() + 2);
				buildTab.append(individu.getDateddMMyyyy());
				buildTab.append(espace, 0, naissanceLength - individu.getDateddMMyyyy().length() + 2);
				buildTab.append(individu.personnel.GetEmail());
				buildTab.append("\n");
			}
			System.out.println(buildTab.toString());
		}
		catch (IndexOutOfBoundsException ex)
		{
			System.out.println(ex.toString());
		}
		// Afficher le tableau
		
	}
	
	// Modifier le personnel
	private void GestionPersonnel()
	{						
		boolean isEqual = false;
		int pass = 0;
		String texte = "";
		int individuActuel = 0;
		
		while(!isEqual)
		{
			if (pass > 0)
				System.out.println("\nAucun nom correspondant trouvé");
						
			System.out.println("\nIntroduire le nom de la personne à modifier : ");
			System.out.println("Entrer un nom : ");
			texte = Lire.texte();
			System.out.println(texte);
			
			
			for (Individu individu : listIndividu)
			{
				if (individu.getNom().equals(texte))
				{
					isEqual = true;
					System.out.println(individu.getNom() + " -- " + individu.getPrenom() + " -- " + individu.getSexe() + " -- " + individu.personnel.GetEmail() + " -- " + individu.personnel.GetDepartement());			

					System.out.println("Introduire les nouvelles valeurs : ");
					texte = "";					
					boolean isInput = false;
					
					while (!ControleSaisie.ValideNom(texte, isInput))
					{
						isInput = true;
						System.out.println("Entrer un nom : ");
						texte = Lire.texte();
					}
					individu.setNom(texte);
					texte = "";
					isInput = false;
					
					while(!ControleSaisie.ValideNom(texte, isInput))
					{
						isInput = true;
						System.out.println("Entrer un prénom : ");
						texte = Lire.texte();
					}
					individu.setPrenom(texte);
					texte = "";
					isInput = false;

					while (!ControleSaisie.valideEmail(texte, isInput))
					{
						isInput = true;
						System.out.println("Entrer une adresse mail : ");
						texte = Lire.texte();
					}
					individu.personnel.SetEmail(texte);					
				}	
				individuActuel++;
			}
			pass++;
		}						
	}
	
	// Créer le magasin	
	private void CreationMagasin()
	{	
		// Créer le magasin si il n'existe pas
		if (mag == null)
			mag = new Magasin();
		
		// Afficher le magasin
		if (mag != null)
		{
			System.out.println("Le magasin est composé de " + mag.listProduit.size() + " articles");
			for (int i = 0; i < mag.listProduit.size(); i++)
				System.out.println("ID_" + i + " --- Produit [nom = " + mag.listProduit.get(i).GetNom() + ", description = " + mag.listProduit.get(i).GetDescription() + " ]");
		}
	}
	
	// Prêt de matériel
	private void PretMateriel()
	{
		StringBuilder list = new StringBuilder();
		for (int i = 0; i < mag.listEmprunt.size(); i++)
		{
			list.append("Id : " + mag.listEmprunt.get(i).GetNombre() + " ");
			list.append(mag.listEmprunt.get(i).GetEmprunteur().getNom() + " " + mag.listEmprunt.get(i).GetEmprunteur().getPrenom());
			list.append(" sexe : " + mag.listEmprunt.get(i).GetEmprunteur().getSexe());
			list.append(" date de naissance : " + mag.listEmprunt.get(i).GetEmprunteur().getDateddMMyyyy() + ".");
			list.append(" Email : " + mag.listEmprunt.get(i).GetEmprunteur().personnel.GetEmail());
			list.append(" Département : " + mag.listEmprunt.get(i).GetEmprunteur().personnel.GetDepartement());
			list.append(" Produit ");
			list.append("[ " + mag.listEmprunt.get(i).GetProduit().GetNom() + ", ");
			list.append(mag.listEmprunt.get(i).GetProduit().GetDescription() + " ]\n\n");			
		}
		System.out.println(list.toString());
	}
	
	// Retour de matériel
	private void RetourMateriel()
	{
		AfficherListeEmprunt();
		System.out.println("Introduire le numéro d'emprunt à annuler : ");		
		int num = Lire.nbre();
		mag.listEmprunt.remove(num-1);
		AfficherListeEmprunt();		
	}
	
	// Afficher la liste des emprunts
	private void AfficherListeEmprunt()
	{
		String espace = "                            ";		
		StringBuilder list1 = new StringBuilder();
		for (Emprunt emprunt : mag.listEmprunt)
		{
			list1.append("\nN°" + emprunt.GetNombre() + " " + emprunt.GetEmprunteur().getNom());
			list1.append(espace, emprunt.GetEmprunteur().getNom().length(), 10);
			list1.append(emprunt.GetProduit().GetNom() + "  " + emprunt.GetProduit().GetDescription());
		}
		System.out.println(list1.toString());
	}
	
	
}
