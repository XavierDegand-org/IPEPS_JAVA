package Valentin;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GestionJFrame extends JFrame  { 
	
	private static final long serialVersionUID = 1L;
	// il implémente le ActionListener qui estg une interface qui va recevoir des évenements
	
	/****************************************
	 *********Création de boutons************ 
	 ****************************************/
	private JButton btnLoad = new JButton("Chargement du personnel");
	private JButton btnAffichage = new JButton("Affichage liste du personnel");
	private JButton btnMag = new JButton("Création du magasin");
	private JButton btnPret = new JButton("Prêt du matériel");
	private JButton btnRetour = new JButton("Retour du matériel");
	private JButton btnPersonnel = new JButton("Modification données personnel");
	private JButton btnSauvegarde = new JButton("Sauvegarde");
	private JButton btnClose = new JButton("Fermer"); // Les boutons sont des objets
	
	private  String nom;
	private  String fichier;
	public static int tailleNom = 30;
	
	private static ArrayList<Personnel> Person = new ArrayList<>(); // création d'une ArrayList de Personnel 
	private static Magasin mag = new Magasin();						// Instancation de la classe Magasin 
	private static ArrayList<Emprunt> pret = new ArrayList<>();		// création d'une ArrayList d'Emprunt
	
		
	// Création du constructeur GestionJFrame
	public GestionJFrame() {
		super("Gestion Personnel & prêt matériel"); // permet de mettre un titre pour la fenetre 
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // permet d'avoir une opération par défaut lors de la fermeture de la fenêtre 
		
		JPanel contentPanel = (JPanel) this.getContentPane(); // c'est un contenaire qui permet de stocker les boutons + permet de positionner les boutons les uns après les autres
		
		contentPanel.setLayout(new GridLayout(3,3)); // setLayout -> gestionaire du positionement des boutons et GridLayout -> 3 boutons sur 3 ligns
		
		contentPanel.add(btnLoad); 					// ajout des boutons dans le Panel 
		contentPanel.add(btnAffichage);
		contentPanel.add(btnMag);
		contentPanel.add(btnPret);
		contentPanel.add(btnRetour);
		contentPanel.add(btnPersonnel);
		contentPanel.add(btnSauvegarde);
		contentPanel.add(btnClose);
		
		
		btnLoad.addActionListener(new LoadPersonnel());		// addActionListener --> permet d'ajouter une action sur le btnLoad 
		btnAffichage.addActionListener(new btnAffichageListener());
		btnPersonnel.addActionListener(new GestionPersonnel());
		btnMag.addActionListener(new btnMagListener());
		btnPret.addActionListener(new GestionEmprunt());
		btnRetour.addActionListener(new RetourEmprunt());
		btnSauvegarde.addActionListener(new Sauvegarde());
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		
		this.setSize(700, 250); // ici on donne une taille à la fenêtre 
		this.setLocationRelativeTo(null); // cela va nous permettre de centrer la fenêtre sur l'écran
		
	}
	
	/****************************************
	 ********Chargement du personnel********* 
	 ****************************************/
	
		
	public class LoadPersonnel implements ActionListener  { 
		@Override
		public void actionPerformed(ActionEvent e) { // pour savoir comment exécuter l'action, Swing impose que l'objet LoadPersonnel possède cette méthode
			
			Person.add(new Personnel("Collon", "Albert", Sexe.HOMME, new MyDate(10, 8, 1990),Departement.HR,"Collon.a@test.be"));
			Person.add(new Personnel("Peeters", "Marie", Sexe.FEMME, new MyDate(8, 5, 1985),Departement.HR,"Peeters_M@test.be"));
			Person.add(new Personnel("Jannsens", "Sarah", Sexe.FEMME, new MyDate(23, 5, 1999),Departement.Compta,"Sarah.Janssens@test.be"));
			Person.add(new Personnel("Jacobs", "Charles", Sexe.HOMME, new MyDate(12, 12, 2009),Departement.Prod,"Charles.j@test.be"));
			Person.add(new Personnel("Maes", "Henri", Sexe.HOMME, new MyDate(14, 9, 2009),Departement.Compta,"MaesHenri@test.be"));
			Person.add(new Personnel("Mertens", "Floriane", Sexe.FEMME, new MyDate(20, 8, 1996),Departement.Prod,"FloFlo.M@test.be"));
			Person.add(new Personnel("Willems", "Francois-Xavier", Sexe.HOMME, new MyDate(28, 10, 1996),Departement.Prod,"Willems.FX@test.be"));
			Person.add(new Personnel("O'Neil", "Shan", Sexe.HOMME, new MyDate(1, 7, 2001),Departement.Prod,"ONeil.sh@test.be"));
			Person.add(new Personnel("Goossen", "Stéphanie", Sexe.FEMME, new MyDate(25, 10, 2008),Departement.HR,"NieNieG@test.be"));
			Person.add(new Personnel("Dumont", "Charles", Sexe.HOMME, new MyDate(1, 4, 1969),Departement.HR,"dumont.c@test.be"));
			Person.add(new Personnel("Van Moore", "Wilfrid", Sexe.HOMME, new MyDate(25, 2, 1998),Departement.Compta,"vanmoore.w@test.be"));
			Person.add(new Personnel("Herman", "Nathalie", Sexe.FEMME, new MyDate(26, 7, 2001),Departement.Prod,"herman.n@test.be"));
			Person.add(new Personnel("Bontemps", "Annie", Sexe.FEMME, new MyDate(23, 9, 1998),Departement.Prod,"bontemps.a@test.be"));
			
			// On ajoute les différents collaboraturs du personnel avec leur différents attributs qu'on a initailisé dans le constructeur Personnel() 
		}
										
	}
		
	/****************************************
	 *********Affichage Personnel************ 
	 ****************************************/
	public class btnAffichageListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {		// Lors de l'évenement, le bouton va exécuter la méthode sur l'objet que je lui aid donné 
			System.out.println(Affichage().toString());
			
		}
	}
	

		
	public StringBuilder Affichage() { 		// fonction de type StringBuilder qui permet d'afficher les membres du personnel
	
		StringBuilder builder = new StringBuilder(); 		// Instanciation de l'objet builder --> générateur de chaîne vide et permet de concaténer des chaînes de caractères 
		
		if(Person.isEmpty()) {								// si l'ArrayList de Person est vide --> Affichage impossible car pas de Personnel
			System.out.println("Affichage impossible , pas de personnel !"); 
		}
		else {
			builder.append("+------------------------+-------------------------------+-------------------------------+--------+--------------+-------------------------+");
			builder.append("\n");
			builder.append("| Département            | Prénom                        | Nom                           | Sexe   | Naissance    | Email                   |");
			builder.append("\n");
			builder.append("+------------------------+-------------------------------+-------------------------------+--------+--------------+-------------------------+");
			builder.append("\n");
			// .append permet de d'ajouter les éléments spécifiés à la chaîne existante 
			
			for(Personnel person : Person) {   					// utilisation de la boucle for pour permettre d'afficher les membres du personnel avec leurs différents attributs 
				builder.append(" ");
				builder.append(setFixedLength(person.getDepartement(),27));
				builder.append(setFixedLength(person.getPrenom(),31));
				builder.append(setFixedLength(person.getNom(),31));
				builder.append(setFixedLength(person.getSexe(),10));
				builder.append(setFixedLength(person.getDateddMMyyyy(),15));
				builder.append(setFixedLength(person.getEmail(),30));
				builder.append("\n");
			}
			
		}
		return builder;
	}
	
	
	/**************************************************************************
	 *********Fonction permettant de calibrer la taille des Strings************ 
	 **************************************************************************/
	
	
	public String setFixedLength(String s, int taille ) { 		
		StringBuilder build = new StringBuilder(s);
		while(build.length()< taille) { 		// tant que la taille du StringBuilder build est inférieure à la taille définie on rajoute un caractère blanc 
			String d = " ";
			char c = d.charAt(0);
			build.insert(s.length(), c);
		}
		String c = build.substring(0,taille);
		return c;
	}
	
	/****************************************
	 ****************Magasin***************** 
	 ****************************************/
	

	public class btnMagListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Magasin();
		}
	}
	
	public static void Magasin(){
			if(mag.isEmpty()) {			// si le magasin est vide on rajoute les produit avec la méthode AjouterProduit()
				
				mag.AjouterProduit(1, "HP", "Elitebook 850 G7");
				mag.AjouterProduit(2, "HP", "Elitebook 830 G7 X360");
				mag.AjouterProduit(3, "Dell", "Inspiron 15 3000");
				mag.AjouterProduit(4, "Dell", "XPS 15");
				mag.AjouterProduit(5, "Dell", "XPS 17");
				mag.AjouterProduit(6, "Lenovo", "Thinkpad E15 G2");
				mag.AjouterProduit(7, "Lenovo", "IdeaPad 3 14IIL05 81WD00B2MH");
				
				mag.listeMap();
			}
			else {
				
				System.out.println("Le magasin a déjà été crée");
			}
			
			
			
		}
	
	
	/****************************************
	 *****************Pret******************* 
	 ****************************************/
	
	
	public static class GestionEmprunt implements ActionListener{


		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(Person.isEmpty()) { 			// si le personnel est vide 
				System.out.println("Erreur, veuilez charger le personnel");
			}
			else if(mag.getProduit().isEmpty() ){  // si magasin est vide 
				System.out.println("Erreur, veuillez créer le magasin");
			}
			else if(pret.isEmpty()) {			  // si L'arrayList pret est vide on rajoute les emprunts à l'ArrayList 
				pret.add(new Emprunt(Person.get(0), mag.produits.get(1)));
				pret.add(new Emprunt(Person.get(1), mag.produits.get(3)));
				pret.add(new Emprunt(Person.get(2), mag.produits.get(4)));
				pret.add(new Emprunt(Person.get(3), mag.produits.get(6)));
				pret.add(new Emprunt(Person.get(6), mag.produits.get(7)));
				
				for (Emprunt emprunt : pret) { 		// utilisation de la boucle for afin d'afficher les éléments de l'ArrayList pret 
					System.out.println(emprunt);
				}
			}
			else {
				for (Emprunt emprunt : pret) {
					System.out.println(emprunt);
				}
			}
			
			System.out.println("\n");
			
		}
		
		
	}
	
	/****************************************
	 ************Retour Emprunt************** 
	 ****************************************/
	
	public static class RetourEmprunt implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(pret.isEmpty()) {  // si l'ArrayList pret est vide 
				System.out.println("Erreur, veuillez charger le prêt");
			}
			else { 
				System.out.println("Liste des emprunts");
				
				for(int compteur=0; compteur<pret.size();compteur++) { 			// utilisation de la boucle for afin de récupérer le Nom de l'emprunteur aisni que le matériel et l'article qui lui a été alloué 
					System.out.println("N° "+(compteur+1)+" "+pret.get(compteur).getEmprunteur().getNom()+"  "+pret.get(compteur).getMateriel()+
							" "+pret.get(compteur).getArticle());
				}
				
				System.out.println("Introduire le numéro d'emprunt à annuler : ");
				
				int NumeroEmpruntAnnuler = 0;
				Boolean arret = false;
				do {
					
					
					try {
						NumeroEmpruntAnnuler = Lire.nbre() - 1;
						pret.remove(NumeroEmpruntAnnuler); // remove permet de retirer le numéro introduit 
						for(int compteur=0; compteur<pret.size();compteur++) {
							System.out.println("N° "+(compteur+1)+" "+pret.get(compteur).getEmprunteur().getNom()+"  "+pret.get(compteur).getMateriel()+
									" "+pret.get(compteur).getArticle());
							
							arret = true;
						}
						
					}
					catch(IndexOutOfBoundsException e1){
						System.out.println("Veuillez réessayer, le numéro n'est pas dans la liste");
						
					}
					
				}while(!arret);
				
				System.out.println("\n");
			}
			
		}
		
	}
	
	
		
	/****************************************
	 *********Modification Personnel********* 
	 ****************************************/

	public class GestionPersonnel implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(Person.isEmpty()) { 				// si le personnel est vide 
				System.out.println("Erreur, veuille charger le personnel");
			}
			else {
				Boolean arret = false;
				System.out.println(Affichage().toString());
				System.out.println("Introduire le nom de la personne à modifier :");
				
				do {						// boucle do while afin de vérifier si le nom introduit est dans l'ArrayList Person
					nom = InputData.inputNomPrenom("nom");
					
					for(int compteur=0; compteur<Person.size();compteur++) {
						if(nom.equals(Person.get(compteur).getNom())) {
							System.out.println(Person.get(compteur).getIdPersonel()+" "+Person.get(compteur).getNom()+" -- "+Person.get(compteur).getPrenom()+" -- "
									+Person.get(compteur).getSexe()+" -- "+Person.get(compteur).getEmail()+" -- "+Person.get(compteur).getDepartement());
							
							
							System.out.println("Introduire les nouvelles valeurs");
							Person.get(compteur).setNom(InputData.inputNomPrenom("nom")); 	// changement du nom avec le setter
							Person.get(compteur).setPrenom(InputData.inputNomPrenom("prénom"));	// changement du prénom avec setter
							Person.get(compteur).setEmail(InputData.inputEmail());	// changement email avec le setter 
							
							System.out.println(Affichage().toString());
							
							arret=true;
							return;
						}
						else {
							arret=false;
						}
					}
					System.out.println("Erreur, veuillez réessayer le nom introduit n'est pas dans la liste ");
				}while(!arret);
			}
		}
		
	}
	
	
	/****************************************
	 ***********Sauvegarde Fichier*********** 
	 ****************************************/
	
	
	public class Sauvegarde implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if(Person.isEmpty()) {	// si le personnel est vide 
				System.out.println("Erreur, veuillez charger le personnel");
			}
			else if(mag.isEmpty()) { // si le magasin est vide 
				System.out.println("Veuillez charger le magasin");
			}
			else if(pret.isEmpty()) { // si les prêts sont vides 
				System.out.println("Erreur, veuillez charger le prêt");
			}
			else {
				
				SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss a"); // Utilisation de la classe SimpleDateFormat qui permet de formater les dates
				Date date = new Date();		// utilisation de la classe Date 
				System.out.println("Introduire le nom du fichier extension .txt ! ");
				fichier = InputData.inputNomFichier();
				
				
				StringBuilder builderpret = new StringBuilder();
				
				builderpret.append("+-------+-----------------------------------------------------------+-----------------------------------------+\n");
				builderpret.append("| N°    | Nom  - Prénom                                             | Matériel                                |\n");
				builderpret.append("+-------+-----------------------------------------------------------+-----------------------------------------+\n");
				
				for(int compteur = 0; compteur < pret.size();compteur++) {
					builderpret.append(" ");
					builderpret.append(setFixedLength(String.valueOf(compteur+1),9));  // renvoie la représentation sous forme de chaîne de caractères 
					builderpret.append(setFixedLength(pret.get(compteur).getEmprunteur().getNom() +" "+pret.get(compteur).getEmprunteur().getPrenom(), 60)); // récuperation du nom et prénom de l'emprunteur
					builderpret.append(setFixedLength(pret.get(compteur).getMateriel() +" "+pret.get(compteur).getArticle(),40)); // récuperation du matériel 
					builderpret.append("\n");
				}
				
				
				// BufferedWriter permet d'écrire et modifier des donées textuelles 
				try(BufferedWriter bufferwrite = new BufferedWriter(new FileWriter(new File("./src/Valentin/Fichier",fichier)))) {
					bufferwrite.write("DTG de la sauvegarde : "+format.format(date));
					bufferwrite.newLine();
					bufferwrite.write(Affichage().toString()); // write --> permet d'écrire la partie Affichage dans le fichier 
					bufferwrite.newLine();
					bufferwrite.newLine();
					bufferwrite.write(builderpret.toString());
					System.out.println("Sauvegarde réussie");
					
				}catch(IOException io) {
					System.out.println("Une erreur est survenue : "+io.getMessage());
				}
				
				
			}
			
			
			
			
			
			
			
			
			
		}
		
	}

	
}
	

