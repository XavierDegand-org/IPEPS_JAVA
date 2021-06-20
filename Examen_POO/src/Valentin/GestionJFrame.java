package Valentin;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GestionJFrame extends JFrame implements ActionListener { // il implémentes le ActionListener qui estg une interface qui va recevoir des évenements
	
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
	
	private static String nom;
	private static String fichier;
	private static int tailleNom = 30;
	
	private static ArrayList<Personnel> Person = new ArrayList<>();
	private static final Magasin mag = new Magasin();
	
		
	// Création du constructeur GestionJFrame
	public GestionJFrame() {
		super("Gestion Personnel & prêt matériel"); // permet de mettre un titre pour la fenetre 
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // permet d'avoir une opération par défaut lors de la fermeture de la fenêtre 
		
		JPanel contentPanel = (JPanel) this.getContentPane(); // c'est un contenaire qui permet de stocker les boutons + permet de positionner les boutons les uns après les autres
		
		contentPanel.setLayout(new GridLayout(3,3)); // setLayout -> gestionaire du positionement des boutons et GridLayout -> 3 boutons sur 3 ligns
		
		contentPanel.add(btnLoad); // ajout des boutons dans le Panel 
		contentPanel.add(btnAffichage);
		contentPanel.add(btnMag);
		contentPanel.add(btnPret);
		contentPanel.add(btnRetour);
		contentPanel.add(btnPersonnel);
		contentPanel.add(btnSauvegarde);
		contentPanel.add(btnClose);
		
		btnLoad.addActionListener(new LoadPersonnel());
		btnAffichage.addActionListener(new btnAffichageListener());
		btnPersonnel.addActionListener(new GestionPersonnel());
		btnMag.addActionListener(new btnMagListener());
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
	
	
	public JButton getBtnLoad() {
		return btnLoad;
	}
		
	
	public class LoadPersonnel implements ActionListener  {
		@Override
		public void actionPerformed(ActionEvent e) {
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
			
		}
										
	}
		
	/****************************************
	 *********Affichage Personnel************ 
	 ****************************************/
	public class btnAffichageListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Affichage();
			
		}
	}
	
	
	public JButton getBtnAffichage() {
		return btnAffichage;
	}
	
	
	public static void Affichage() {
	
		
		if(Person.isEmpty()) {
			System.out.println("Affichage impossible , pas de personnel !");
		}
		else {
			System.out.println("+-----------------------+-------------------+--------------------+--------+--------------+-------------------------+");
			System.out.println("| Département           | Prénom            | Nom                | Sexe   | Naissance    | Email                   |");
			System.out.println("+-----------------------+-------------------+--------------------+--------+--------------+-------------------------+");
			
			StringBuilder builder = new StringBuilder(); // permet de concaténer des chaînes de caractères
			
			for(Personnel person : Person) {
				builder.append(" ");
				builder.append(setFixedLength(person.getDepartement()));
				builder.append(setFixedLength(person.getPrenom()));
				builder.append(setFixedLength(person.getNom()));
				builder.append(setFixedLength(person.getSexe()));
				builder.append(setFixedLength(person.getDateddMMyyyy()));
				builder.append(setFixedLength(person.getEmail()));
				builder.append("\n");
			}
			System.out.println(builder);
		}
	}
	
	public static String setFixedLength(String s ) {
		StringBuilder build = new StringBuilder(s);
		while(build.length()< tailleNom) {
			String d = " ";
			char c = d.charAt(0);
			build.insert(s.length(), c);
		}
		String c = build.substring(0,tailleNom);
		return c;
	}
	
	/****************************************
	 ****************Magasin***************** 
	 ****************************************/
	
	
	public JButton getBtnMag() {
		return btnMag;
	}
	
	
	
	public class btnMagListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Magasin();
		}
	}
	
	public static void Magasin(){

			mag.AjouterProduit(1, "HP", "Elitebook 850 G7");
			mag.AjouterProduit(2, "HP", "Elitebook 830 G7 X360");
			mag.AjouterProduit(3, "Dell", "Inspiron 15 3000");
			mag.AjouterProduit(4, "Dell", "XPS 15");
			mag.AjouterProduit(5, "Dell", "XPS 17");
			mag.AjouterProduit(6, "Lenovo", "Thinkpad E15 G2");
			mag.AjouterProduit(7, "Lenovo", "IdeaPad 3 14IIL05 81WD00B2MH");
			
			mag.listeMap();
			
			
		}
	
	
	/****************************************
	 *********Modification Personnel********* 
	 ****************************************/
	
	public JButton getBtnPersonnel() {
		return btnPersonnel;
	}
	

	
	public static class GestionPersonnel implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(Person.isEmpty()) {
				System.out.println("Veuillez charger le personnel");
			}
			else {
				Affichage();
				System.out.println("Introduire le nom de la personne à modifier");
				System.out.println("Quel est le nom ?");
				
				boolean arret = false;
				
				do{
					
					String entree = Lire.texte();
					
					for(int compteur = 0;compteur<Person.size();compteur++) {
						if(Person.get(compteur).getNom().equals(entree)) {
							System.out.println(Person.get(compteur).getIdPersonel()+"  "+Person.get(compteur).getNom()+" -- "+Person.get(compteur).getPrenom()
									+" -- "+Person.get(compteur).getSexe()+" -- "+Person.get(compteur).getEmail()+" -- "+Person.get(compteur).getDepartement());
							System.out.println("Introduire les nouvelles valeurs :");
							
							System.out.println("Entrer un nom : ");
							Person.get(compteur).setNom(InputData.inputNomPrenom());
							System.out.println("Entrer un prenom : ");
							Person.get(compteur).setPrenom(InputData.inputNomPrenom());
							System.out.println("Entrer une adresse mail ");
							Person.get(compteur).setEmail(InputData.inputEmail());
							
							arret = true;
							Affichage();
							return;
						}
						else {
							arret = false;
						}
						
					}
					System.out.println("Erreur, le nom n'est pas dans la liste, veuillez réessayer ");
				}while((!arret));
			}
		
		}
		
			
		

		}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
