package Ilyasse;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.w3c.dom.events.Event;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestionJFrame extends JFrame  {
	
	 private JButton btnLoad = new JButton( "Chargement du personnel" );
	 private JButton btnAffichage = new JButton( "Affichage liste du personnel" );
	 private JButton btnMag = new JButton( "Création du magasin" );
	 private JButton btnPret = new JButton( "Prêt de matériel" );
	 private JButton btnRetour = new JButton( "Retour de matériel" );
	 private JButton btnSauvegarde = new JButton( "Sauvegarde" );
	 private JButton btnPersonnel = new JButton( "Modification données personnel" );
	 private JButton btnClose = new JButton( "Fermer" );
	 private ArrayList<Personnel> listPersonnel = new ArrayList<>();
	 private boolean PersonnelLoaded=false;
	 
	 
	 
	 public GestionJFrame() {
		super( "Gestion Personnel & prêt de matériel. " );
		this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
     
		JPanel contentPane = (JPanel) this.getContentPane();
		// Un FlowLayout permet de positionner les boutons les uns à la suite des autres.
		contentPane.setLayout( new FlowLayout() );
		/*contentPane.setLayout(null);
		btnActivateMe.setBounds(10, 10, 120, 30);
		btnClickMe.setBounds(10, 50, 120, 30);
		btnPushMe.setBounds(10, 90, 120, 30);
		*/
		 
		contentPane.add( btnLoad );
		contentPane.add( btnAffichage );
		contentPane.add( btnMag );
		contentPane.add( btnPret );
		contentPane.add( btnRetour );
		contentPane.add( btnPersonnel );
		contentPane.add( btnSauvegarde );		
		contentPane.add( btnClose );	
		btnLoad.addActionListener(new ButtonLoadListener()); 
		btnAffichage.addActionListener(new ButtonAffichageListener()); 
		btnMag.addActionListener(new ButtonMagasinListener()); 
		btnPret.addActionListener(new ButtonPretListener()); 
		btnRetour.addActionListener(new ButtonretourListener()); 
		btnSauvegarde.addActionListener(new ButtonSauvegardeListener()); 
		btnClose.addActionListener(new ButtonCloseListener());
		btnPersonnel.addActionListener(new ButtonPersonnelListener()); 
		btnAffichage.setSize(50, 50);
		this.setSize( 500, 400 );
		this.setLocationRelativeTo( null );
	}
	

	public void LoadPersonnel() {
		listPersonnel.add(new Personnel(1,"Collon","Albert", Sexe.HOMME, new MyDate(10, 8, 1990), "Collon.a@test.be",Departement.HR));
		listPersonnel.add(new Personnel(2,"Peeters","Marie",Sexe.FEMME, new MyDate( 1, 5,1985),"Peeters_M@@test.be",Departement.HR));
		listPersonnel.add(new Personnel(3,"Janssens","Sarah",Sexe.FEMME, new MyDate(23,5,1999),"Sarah.Janssens@test.be",Departement.COMPTA));
		listPersonnel.add(new Personnel(4,"Maes","Henri",Sexe.HOMME, new MyDate(14,9,2009),"MaesHenri#test.be",Departement.COMPTA));
		listPersonnel.add(new Personnel(5,"Jacobs","Charles",Sexe.HOMME, new MyDate(12,12,2009),"Charles.j#test.be",Departement.SEC));
		listPersonnel.add(new Personnel(6,"Mertens","Floriane",Sexe.FEMME, new MyDate(20, 8,1996),"FloFlo.M@test.be",Departement.SEC));
		listPersonnel.add(new Personnel(7,"Willems","Francois-Xavier",Sexe.HOMME, new MyDate(28, 10, 1996),"Willems.F-X@test.be",Departement.Prod));
		listPersonnel.add(new Personnel(8,"O'Neil","Shan",Sexe.HOMME, new MyDate( 1, 7,2001),"ONeil.sh@test.be",Departement.Prod));
		listPersonnel.add(new Personnel(9,"Goossen","Stéphanie",Sexe.FEMME, new MyDate(25 ,10 ,2008),"NieNieG@test.be",Departement.HR));
		listPersonnel.add(new Personnel(10,"Dumont","Charles",Sexe.HOMME, new MyDate(01,04,1969),"dumont.c@test.be",Departement.HR));
		listPersonnel.add(new Personnel(11,"Van Moore","Wilfrid",Sexe.HOMME, new MyDate(25,02,1998),"vanmoore.w@test.te",Departement.COMPTA));
		listPersonnel.add(new Personnel(12,"Herman","Nathalie",Sexe.FEMME, new MyDate(26,07,2001),"herman.n@test,be",Departement.Prod));
		listPersonnel.add(new Personnel(13,"Bontemps","Annie",Sexe.FEMME, new MyDate(23, 9,1998),"bontemps.a@test.be",Departement.Prod));
		PersonnelLoaded = true;
		
	}
	
	
	
	private void Close(){
		super.dispose();
	}
	
	
	
	
	
	Magasin magasin;
	public void Magasin() {
		if (magasin == null)
			magasin = new Magasin();
		
		// Afficher le magasin s'il existe déjà
		if (magasin != null)
		{
			System.out.println("Le magasin est composé de " + magasin.listProduit.size() + " articles");
			for (int i = 0; i < magasin.listProduit.size(); i++)
				System.out.println("ID_" + i + " --- Produit [nom = " + magasin.listProduit.get(i).getNom() + ", description = " + magasin.listProduit.get(i).getDescription() + " ]");
		}
	}	
	
	
	
	
	
	 public void Affichage() {
		// Définir la taille des string dans la list pour l'affichage
		int nameLength = 30;
		int sexeLength = 10;
		int dateLength = 10;
		int mailLength = 30;
		String longline = "------------------------------";
		String line = "-----------";	
		System.out.print(longline + "+");
		System.out.print(longline + "+" + longline + "+");
		System.out.print(line + "+" + line + "---" + "+" + line + "+" + line+line);
		System.out.print("| "+"         Département          " +"| "+"          Prénom           " );
		System.out.print("         Nom                "  +"| "+ " Sexe  ");
		System.out.println("| "+"  Naissance  " + "          Email             ");;
		for (int i = 0; i < listPersonnel.size(); i++) 
			System.out.println(listPersonnel.get(i));
	}
				
	public ArrayList<Emprunt> listEmprunt = new ArrayList<>();	
	
	public void Emprunt() {	
		
		
	}

		// Retour du matériel emprunté 
		private void RetourEmprunt()
		{
			AfficherListeEmprunt();
			System.out.println("Introduire le numéro d'emprunt à annuler : ");		
			int num = Lire.nbre();
			magasin.listEmprunt.remove(num-1);
			AfficherListeEmprunt();		
		}
		
		// Afficher la liste du matériel emprunté
		private void AfficherListeEmprunt()
		{
			String espace = "                            ";		
			StringBuilder list1 = new StringBuilder();
			for (int i = 0; i < listEmprunt.size(); i++) 
				System.out.println(listEmprunt.get(i));
	
		}
	
	public void GestionPersonnel() {
		
		boolean isEqual = false;
		int test = 0;
		String texte = "";

		while(!isEqual)
		{
			if (test > 0)
				System.out.println("\nAucun nom correspondant trouvé");
			
			System.out.println("\nIntroduire le nom de la personne à modifier : ");
			System.out.println("Entrer un nom : ");
			texte = Lire.texte();

			for (Personnel personnel : listPersonnel)
			{
				if (personnel.individu.getNom().equals(texte))
				{
					isEqual = true;
					System.out.println(personnel.individu.getNom() + " -- " + personnel.individu.getPrenom() + " -- " + personnel.individu.getSexe() + " -- " + personnel.getEmail() + " -- " + personnel.getDepartement());			

					System.out.println("Introduire les nouvelles valeurs : ");
					texte = "";					
					boolean isInput = false;
		
					// Demander le nom
					while (!ControleSaisie.ValideNom(texte, isInput))
					{
						isInput = true;
						System.out.println("Entrer un nom : ");
						texte = Lire.texte();
					}
					personnel.individu.setNom(texte);
					texte = "";
					isInput = false;
		
					// Demander le prénom
					while(!ControleSaisie.ValideNom(texte, isInput))
					{
						isInput = true;
						System.out.println("Entrer un prénom : ");
						texte = Lire.texte();
					}
					personnel.individu.setPrenom(texte);
					texte = "";
					isInput = false;

					// Demander adresse mail
					while (!ControleSaisie.valideEmail(texte, isInput))
					{
						isInput = true;
						System.out.println("Entrer une adresse mail : ");
						texte = Lire.texte();
					}
					personnel.setEmail(texte);					
				}		
			}
			test++;
		}		
	}

	
	
	// Sauvegarde
	private void Sauvegarde() throws IOException
	{		
		String fileName = "";
		String pathName = "Fichier/";
		String appendText = "";
		boolean isInput = false;
						
		while(!ControleSaisie.ValideNom(fileName, isInput))
		{
			isInput = true;
			System.out.println("Introduire le nom du fichier : ");
			fileName = Lire.texte();
		}
		
	//	String dtgSave = "DTG de la sauvegarde : " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
	//	appendText = dtgSave + "\n" + Affichage() + "\n\n" + RecupererPret() + "\n\n";
	//
		try 
		{
			String finalName = pathName + fileName + ".txt";
			File file = new File(finalName);
			if (!file.exists())
				file.createNewFile();
			
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(appendText);
			
			bw.close();
			fw.close();		
		}
		catch (IOException ex)
		{
			System.out.println(ex.toString());
		}
		
	}
	
	// Afficher les prêts pour la sauvegarde
	private String RecupererPret()
	{		
		int nomTemp = 0;
		int nomLength = 0;				
		int materielTemp = 0;
		int materielLength = 0;
		
		for (int i = 0; i < magasin.listEmprunt.size() - 1; i++)
		{
			if (magasin.listEmprunt.get(i+1).getEmprunteur().individu.getNom().length() + 1 + 
					magasin.listEmprunt.get(i+1).getEmprunteur().individu.getPrenom().length() > 
			magasin.listEmprunt.get(i).getEmprunteur().individu.getNom().length() + 1 
			+ magasin.listEmprunt.get(i).getEmprunteur().individu.getPrenom().length())
			{
				nomLength = magasin.listEmprunt.get(i+1).getEmprunteur().individu.getNom().length() + 1 + 
						magasin.listEmprunt.get(i+1).getEmprunteur().individu.getPrenom().length();
				if (nomLength > nomTemp)
					nomTemp = nomLength;
			}
		
		//	if (magasin.listEmprunt.get(i+1).getProduit().individu.GetNom().length() + 1 + 
		//			magasin.listEmprunt.get(i+1).getProduit().GetDescription().length() > 
		//	magasin.listEmprunt.get(i).getMateriel().individu.GetNom().length() + 1 +
		//	magasin.listEmprunt.get(i).getProduit().GetDescription().length())
		//	{
		//		materielLength = magasin.listEmprunt.get(i+1).getProduit().GetNom().length() 
		//				+ 1 + magasin.listEmprunt.get(i+1).getProduit().GetDescription().length();
		//		if (materielLength > materielTemp)
	//				materielTemp = materielLength;
		//	}/
		}
		
		String tiret = "---------------------------------------------------------------------------------------";
		String espace = "                                                                                       ";
		StringBuilder builder = new StringBuilder();
		
		int numLength = 6;
		try 
		{
			builder.append("+");
			builder.append(tiret, 0, numLength + 1);
			builder.append("+");
			builder.append(tiret, 0, nomLength + 1);
			builder.append("+");
			builder.append(tiret, 0, materielLength + 1);
			builder.append("+\n");
			builder.append("| N°");
			builder.append(espace, 0, numLength-2);
			builder.append("| Nom - Prénom");
			builder.append(espace, 0, nomLength-12);
			builder.append("| Matériel");
			builder.append(espace, 0, materielLength-8);
			builder.append("|\n");
			builder.append("+");
			builder.append(tiret, 0, numLength + 1);
			builder.append("+");
			builder.append(tiret, 0, nomLength + 1);
			builder.append("+");
			builder.append(tiret, 0, materielLength + 1);
			builder.append("+\n");
			
			for (int i = 0; i < magasin.listEmprunt.size(); i++)
			{
				builder.append(" " + magasin.listEmprunt.get(i).getNombre());
				builder.append(espace, 0, numLength);
				builder.append(" " + magasin.listEmprunt.get(i).getEmprunteur().individu.getNom() + " " 
				+ magasin.listEmprunt.get(i).getEmprunteur().individu.getPrenom());
				builder.append(espace, 0, nomLength - (magasin.listEmprunt.get(i).getEmprunteur().individu.getNom()
						.length() +  magasin.listEmprunt.get(i).getEmprunteur().individu.getPrenom().length()) + 1);
		//		builder.append(" " + magasin.listEmprunt.get(i).getProduit().GetNom() + " "
		//				+ magasin.listEmprunt.get(i).getProduit().getDescription());
				builder.append("\n");
			}
					
			return builder.toString();
		}
		catch (IndexOutOfBoundsException ex)
		{
			System.out.println(ex.toString());
		}
				
		return "";
	}
	
	
	
	public JButton getBtnLoad() {
	        return btnLoad;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Click Button");

	} 
	

	
}
