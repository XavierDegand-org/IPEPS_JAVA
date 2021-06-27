package NathanaëlDuyck;

import java.awt.FlowLayout;
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

public class GestionJFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//Création des boutons et leurs noms
	
	private JButton btnLoad = new JButton( "Chargement du personnel" );
	private JButton btnAffichage = new JButton( "Affichage liste du  personnel" );
	private JButton btnMag = new JButton( "Création du magasin" );
	private JButton btnPret = new JButton( "Prêt de matériel" );
	private JButton btnRetour = new JButton( "Retour de matériel" );
	private JButton btnPersonnel = new JButton( "Modification données Personnel" );
	private JButton btnSauvegarde = new JButton( "Sauvegarde" );
	private JButton btnClose = new JButton( "Fermer" );
	 
	private static String nom;//variable pour le nom qui va être modifier dans Gestion Personnel
	private static String fichier;//variable pour le nom du fichier
	private static int tailleNom = 30;//variable pour la taille maximale des noms et prénoms 
	private static boolean initialisationEmprunt = false;//variable pour savoir si l'emprunt a déjà été initialiser ou pas  
	
	//Création des listes
	
	private static ArrayList<Personnel> Person = new ArrayList<>();// initialisation de la liste Personnel
	private static ArrayList<Emprunt> pret = new ArrayList<>();// initialisation de la liste Emprunt
	private static ArrayList<Magasin> mag = new ArrayList<>();// initialisation de la liste Magasin
	
	 
	 public GestionJFrame() {
		
		 super( "Gestion Personnel & prêt matériel" );//Mets un titre à la fenêtre
		 this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );//Ferme l'appliation si on ferme la fenêtre
		 
		 JPanel contentPane = (JPanel) this.getContentPane();
		 contentPane.setLayout( new FlowLayout() );
		 contentPane.setLayout(null);
		 
		 //Mise en disposition des boutons
		 
		 btnLoad.setBounds(10,20, 290, 150);
		 btnAffichage.setBounds(300,20, 290, 150);
		 btnMag.setBounds(590,20, 290, 150);
		 btnPret.setBounds(10,190,290,150);
		 btnRetour.setBounds(300,190, 290,150);
		 btnPersonnel.setBounds(590,190,290,150);
		 btnSauvegarde.setBounds(10,370,290,150);
		 btnClose.setBounds(300,370,290,150);
		 
		 //Ajout des boutons à la fenêtre
		 
		 contentPane.add( btnLoad );
		 contentPane.add( btnAffichage );
		 contentPane.add( btnMag );
		 contentPane.add( btnPret );
		 contentPane.add( btnRetour );
		 contentPane.add( btnPersonnel );
		 contentPane.add( btnSauvegarde );
		 contentPane.add( btnClose );
		 
		 //Ajout d'instruction quand on clique sur un bouton
		 
		 btnLoad.addActionListener(new ActionListener(){

			 	@Override
				public void actionPerformed(ActionEvent e) {
					LoadPersonnel();
				} 
		 });
		 
		 btnAffichage.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					Affichage();
				}
		 });
		 
		 btnMag.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					Magasin();		
				} 
		 }); 
		 
		 btnPret.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					Emprunt();
				} 
		 });
		 
		 btnRetour.addActionListener(new ActionListener(){
				

				@Override
				public void actionPerformed(ActionEvent e) {
					RetourEmprunt();
				} 	
		 });
		 
		 btnPersonnel.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					GestionPersonnel();	
				} 
		 });
		 
		 btnSauvegarde.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					Sauvegarde();		
				} 
		 });
		 
		 btnClose.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					 System.exit(0);		
				} 
		 });
		 
		 this.setSize( 900 , 600 );//Taille de la fenêtre
		 this.setLocationRelativeTo( null );//Centre la fenêtre
	 }
	
	/* *************************************************************************Chargement du personnel**************************************************** */ 
	
	 public static void LoadPersonnel() {
		if (Person.isEmpty()) { //charge le personnel si la liste du personnel est vide
		 Person.add(new Personnel(1,"Collon","Albert",Sexe.HOMME,new MyDate(10,8,1990),"Collon.a@test.be",Departement.HR));
		 Person.add(new Personnel(2,"Peeters","Marie",Sexe.FEMME,new MyDate(1,5,1995),"Peeters_M@@test.be",Departement.HR));
		 Person.add(new Personnel(3,"Janssens","Sarah",Sexe.FEMME,new MyDate(23,5,1999),"Sarah.Janssens@test",Departement.Compta));
		 Person.add(new Personnel(4,"Jacobs","Charles",Sexe.HOMME,new MyDate(10,8,1990),"Charles.j#test.be",Departement.SEC));
		 Person.add(new Personnel(5,"Maes","Henri",Sexe.HOMME,new MyDate(14,9,2009),"MaesHenri#test.be",Departement.Compta));
		 Person.add(new Personnel(6,"Mertens","Floriane",Sexe.FEMME,new MyDate(20,8,1996),"FloFlo.M@test.be",Departement.SEC));
		 Person.add(new Personnel(7,"Willems","Francois-Xavier",Sexe.HOMME,new MyDate(28,10,1996),"Willems.F-X@test.be",Departement.Prod));
		 Person.add(new Personnel(8,"O'Neil","Shan",Sexe.HOMME,new MyDate(01,07,2001),"ONeil.sh@test.be",Departement.Prod));
		 Person.add(new Personnel(9,"Goossen","Stéphanie",Sexe.FEMME,new MyDate(25,10,2008),"NieNieG@test.be",Departement.HR));
		 Person.add(new Personnel(10,"Dumont","Charles",Sexe.HOMME,new MyDate(01,04,1969),"dumont.c@test.be",Departement.HR));
		 Person.add(new Personnel(11,"Van Moore","Wilfrid",Sexe.HOMME,new MyDate(25,02,1998),"vanmoore.w@test.te",Departement.Compta));
		 Person.add(new Personnel(12,"Herman","Nathalie",Sexe.FEMME,new MyDate(26,07,2001),"herman.n@test,be",Departement.Prod));
		 Person.add(new Personnel(13,"Bontemps","Annie",Sexe.FEMME,new MyDate(23,9,1998),"bontemps.a@test.be",Departement.Prod));
		}
		else { // Sinon personnel déjà chargé
			System.out.println("Personnel déjà chargé !");
		}
	}
	/* **************************************************Création du magasin et ajout des produits**************************************************** */ 
	
	 public static void Magasin() {
		Magasin magasin= new Magasin();//crée un magasin
		mag.add(magasin);// ajoute à la liste des magasins
		
		//ajout des produits
		magasin.AjouterProduit(1,"HP","Elitebook 850 G7");
		magasin.AjouterProduit(2,"HP","Elitebook 830 G7 X360");
		magasin.AjouterProduit(3,"Dell","Inspiron 15 3000");
		magasin.AjouterProduit(4,"Dell","XPS 13");
		magasin.AjouterProduit(5,"Dell","XPS 15");
		magasin.AjouterProduit(6,"Lenovo","Thinkpad E15 G2");
		magasin.AjouterProduit(7,"Lenovo","IdeaPad 3 14IIL05 81WD00B2MH ");
		
		//affiche le nombre de produit dans le magasin + leur nom et descriptif
		magasin.listeMap();
	}
	
	/* **************************************************Affichage du personnel ************************************************************************** */
	
	 public static void Affichage() {
		if(Person.size() ==0) {//vérifie que le personnel a été chargé sinon il 'y a pas de personnel a afficher
			System.out.println("Affichage impossible, pas de personnel !");
		}
		else {
			System.out.println("+-----------------------+-----------------------------+-----------------------------+--------+----------------+---------------------------------------+");
			System.out.println("| Département           | Prénom                      | Nom                         | Sexe   |  Naissance     | Email                                 |");
			System.out.println("+-----------------------+-----------------------------+-----------------------------+--------+----------------+---------------------------------------+");
			StringBuilder sb = new StringBuilder();
			for (Personnel personnel : Person) {
				sb.append(" ");
				sb.append(setFixedLength(personnel.getDepartement(),25));
				sb.append(setFixedLength(personnel.getPrenom(),tailleNom));
				sb.append(setFixedLength(personnel.getNom(),tailleNom));		
				sb.append(setFixedLength(personnel.getSexe(),10));
				sb.append(setFixedLength(personnel.getDateddMMyyyy(),16));
				sb.append(setFixedLength(personnel.getEmail(),30));
				sb.append("\n");
				}	
			System.out.println(sb.toString());
			}
		}
	
	 /* ***************************************Mise en place d'une mise en page ************************************************************************** */
	
	 public static String setFixedLength(String s,int taille) {// fonction permettant de mettre une taille fixe pour un String
		StringBuilder ss = new StringBuilder(s);
		while(ss.length() < taille) {
			String d =" ";//Ajout d'espace pour remplir la taille fixe du string 
			char c1 = d.charAt(0);
			ss.insert(s.length(),c1);
		}
		String c = ss.substring(0,taille);
		return c;
	}
	
	/* ***************************************Chargement de la liste de prêt (emprunt) et affichage de celle-ci  ***************************************** */
	
	public static void Emprunt() {
		if((Person.isEmpty()) || (mag.isEmpty())) {//On ne peut pas faire un emprunt si la liste du personnel et la liste du magasin sont vide
			System.out.println("Veuillez charger le personnel et créer le magasin\n");
		}
		else if ((pret.isEmpty())&& (!initialisationEmprunt)) {//Verifie que la liste de prêt est vide et qu'on a pas déjà initialiser.L'initialisation empêche de recharger les emprunts quand tous les emprunts ont été retourner
			//Ajoute l'emprunteur et le matériel emprunté à la liste des emprunts
			pret.add(new Emprunt(Person.get(0),new Produit("HP","Elitebook 850 G7")));	
			pret.add(new Emprunt(Person.get(1),new Produit("Dell","Inspiron 15 3000")));	
			pret.add(new Emprunt(Person.get(2),new Produit("Dell","XPS 13")));	
			pret.add(new Emprunt(Person.get(3),new Produit("Lenovo","Thinkpad E15 G2")));	
			pret.add(new Emprunt(Person.get(6),new Produit("Lenovo","IdeaPad 3 14IIL05 81WD00B2MH ")));	
			initialisationEmprunt = true;//on a initialiser l'emprunt
			//Affichage de la liste de prêt
			for (Emprunt emprunt : pret)
			{
			System.out.println(emprunt);
			}
		} else {
			for (Emprunt emprunt : pret)
			{
			System.out.println(emprunt);
			}
		}
	}
	
	/* ******************************Retour d'un prêt (emprunt) et affichage la liste de prêt avant et après suppression  ******************************* */
	
	public static void RetourEmprunt() {
	boolean nombreValide =false;
	int compteur;
	if(pret.isEmpty()) {//Verifie que la liste de prêt n'est pas vide
		System.out.println("La liste des prêts est vide donc il n'y a rien à rendre!\n");
	}
	else {
		//Affichage de la liste des emprunts
		System.out.println("Liste des emprunts");
		compteur=1;//compteur pour le nombre d'emprunt
		for (Emprunt emprunt : pret)
		{
		System.out.println("N° "+compteur+" "+emprunt.getEmprunteur().getNom()+" "+emprunt.getMateriel().getNom()+" "+emprunt.getMateriel().getDescription());
		compteur++;
		}
		System.out.println("Introduire le numéro d'emprunt à annuler : ");
		while(!nombreValide) {//tant que le nombre n'est pas valide, on recommence
		try { 
			int nbemprunt = Lire.nbre()-1;//on lit le nombre,on retire -1 car la liste d'emprunt commence à 0 et le nombre d'emprunt à 1
			pret.remove(nbemprunt);//on retire l'emprunt si le chiffre est dans la liste sinon IndexOutOfBoundsException est lancé
			Lire.vider();
			compteur=1;
			//Affichage de la liste après suppression du retour
			for (Emprunt emprunt : pret)
				{
				 System.out.println("N° "+compteur+" "+emprunt.getEmprunteur().getNom()+" "+emprunt.getMateriel().getNom()+" "+emprunt.getMateriel().getDescription());
				compteur++;
				}
			 nombreValide=true;
		}
		catch( java.lang.IndexOutOfBoundsException e) {
			 System.out.println("erreur,veuillez rentrer un nombre proposé dans la liste d'emprunt");
		}
		}
	}
	}
	
	/* *******************************************************************Gestion du personnel  ********************************************************** */
	
	public static void GestionPersonnel() {
		boolean nomValide = false;
		String nomChangement;//variable pour le nom qui va remplacer le nom de la personne qu'on va modifier
		String prenomChangement;//variable pour le prénom qui va remplacer le prénom de la personne qu'on va modifier
		String mailChangement;//variable pour l'email qui va remplacer l'email de la personne qu'on va modifier
		Affichage();//Affichage de la liste du personnel
		if(Person.size() !=0) {//vérifie que le personnel a été chargé 
			System.out.println("Introduire le nom de la personne à modifier :");
			System.out.println("Entrer un nom : ");
			nom=Lire.texte();//On lit le nom de la personne qu'on veut modifier
		while(!nomValide) {
			for (Personnel personnel : Person) {
				if(nom.equals(personnel.getNom())) {//On verifie que le nom rentré est bien dans la liste et si c'est le cas on affiche ces données et on sort du tant que
					System.out.println(personnel.getIdPersonnel()+"  "+personnel.getNom()+"--"+personnel.getPrenom()+"--"+personnel.getSexe()+"--"+personnel.getEmail()+"--"+personnel.getDepartement());
					nomValide=true;
				}
			}
			if(nomValide) {//si le nom est validé, on demande les informations qui vont être modifié 
				System.out.println("Introduire les nouvelles valeurs:");
				nomChangement = InputData.inputNomPrenom("Nom");//Vérification que le nom entrée est correct
				prenomChangement = InputData.inputNomPrenom("Prénom");//Vérification que le prénom entrée est correct
				mailChangement = InputData.inputEmail();//Vérification que l'email entrée est correct
				for (Personnel personnel : Person) {//si c'est le cas,on change les données
					if(nom.equals(personnel.getNom())) {
						personnel.setNom(nomChangement);
						personnel.setPrenom(prenomChangement);
						personnel.setEmail(mailChangement);
					}
			}
			}
			else {//si le nom est pas correct,on en demande un nouvau
				System.out.println("Le nom que vous avez tapé n'est pas dans la liste du personnel ");
				System.out.println("Introduire le nom de la personne à modifier :");
				System.out.println("Essayer à nouveau d'entrer un nom : ");
				nom=Lire.texte();
			}	
			}
			Affichage();//afficahge de la liste après les changements
		}
	}
/* **************************************************Sauvegarde du personnel et des emprunts  ************************************************************ */
	
	public static void Sauvegarde() {
		SimpleDateFormat DTG = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");//Fonction qui permet d'afficher la date et l'heure de la sauvegarde
		Date date = new Date();
		if((Person.isEmpty()) || (pret.isEmpty()) || (mag.isEmpty()))   {//Verification que les listes personnel,pret et magasin sont pas vide
			System.out.println("Affichage impossible, vous n'avez pas chargé toutes les données (personnel,emprunt et magasin) !");
		}
		else{
		System.out.println("Introduire le nom du fichier extension .txt! ");
		fichier=InputData.inputNomFichier();//Vérification du nom de fichier
		StringBuilder sb = new StringBuilder();
		for (Personnel personnel : Person)//Affichage de la liste du personnel 
		{
				sb.append(" ");
				sb.append(setFixedLength(personnel.getDepartement(),25));
				sb.append(setFixedLength(personnel.getPrenom(),tailleNom));
				sb.append(setFixedLength(personnel.getNom(),tailleNom));		
				sb.append(setFixedLength(personnel.getSexe(),10));
				sb.append(setFixedLength(personnel.getDateddMMyyyy(),16));
				sb.append(setFixedLength(personnel.getEmail(),30));
				sb.append("\n");
				}	
		int compteur=1;
		StringBuilder sbpret = new StringBuilder();
		for (Emprunt emprunt : pret)//Affichage de la liste du prêt
		{
			sbpret.append("  ");
			sbpret.append(compteur);
			sbpret.append("          ");
			sbpret.append(setFixedLength(emprunt.getEmprunteur().getNom(),tailleNom));
			sbpret.append(setFixedLength(emprunt.getEmprunteur().getPrenom(),tailleNom));
			sbpret.append("    ");
			sbpret.append(setFixedLength(emprunt.getMateriel().getNom(),7));
			sbpret.append(setFixedLength(emprunt.getMateriel().getDescription(),tailleNom));
			sbpret.append("\n");
			compteur++;
		}	
		try (BufferedWriter bufWrite = new BufferedWriter (new FileWriter(new File("./src/NathanaëlDuyck/Fichier",fichier)))){
			bufWrite.write("DTG de la sauvegarde : "+ DTG.format(date));//Affichage du DTG
			bufWrite.newLine();//Affichage des titres pour le personnel
			bufWrite.write("+-----------------------+-----------------------------+-----------------------------+--------+----------------+---------------------------------------+");
			bufWrite.newLine();
			bufWrite.write("| Département           | Prénom                      | Nom                         | Sexe   |  Naissance     | Email                                 |");
			bufWrite.newLine();
			bufWrite.write("+-----------------------+-----------------------------+-----------------------------+--------+----------------+---------------------------------------+");																														
			bufWrite.newLine();
			bufWrite.write(sb.toString());
			//Affichage des titres pour l'emprunt
			bufWrite.write("+----------+--------------------------------------------------------------+-----------------------------------------+");
			bufWrite.newLine();
			bufWrite.write("| N°       | Nom - Prénom                                                 |  Matériel                               |");
			bufWrite.newLine();
			bufWrite.write("+----------+--------------------------------------------------------------+-----------------------------------------+");
			bufWrite.newLine();
			bufWrite.write(sbpret.toString());
			
		} catch (IOException io) {
			System.err.println("Une erreur est survenue : "+io.getMessage());
		}
		}
		}
}

	 

