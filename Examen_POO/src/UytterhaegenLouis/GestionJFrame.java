package UytterhaegenLouis;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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


public class GestionJFrame extends JFrame  {

	private static final long serialVersionUID = 1L;
	/* ******************************************************* 
	 *****Création des boutons et leurs dénominations******* */
	private JButton btnLoad = new JButton( "Chargement du personnel" );  
	private JButton btnAffichage = new JButton( "Affichage liste du Personnel" );
	private JButton btnMag = new JButton( "Création du magasin" );
	private JButton btnPret = new JButton( "Pret de matériel" );
	private JButton btnRetour = new JButton( "Retour de matériel" );
	private JButton btnPersonnel = new JButton( "Modification données Personnel" );
	private JButton btnSauvegarde = new JButton( "Sauvegarde" );
	private JButton btnClose = new JButton( "Fermer" );

	public static final int tailleNom = 30; // délimite la taille maximale des noms et prénoms lors de la saisie
	public static final int tailleFichier = 260; // délimite la taille maximale du nom d'un fichier lors de la saisie
	private static String fichier; // Variable pour attribuer un nom de fichier lors de la création de celui-ci
	private static String nom; // variable pour récupérer le nom d'une personne présent dans le personnel


	/* ******************************************************* 
	 *************Initialisation des listes,....************** */

	private static ArrayList<Personnel> Person = new ArrayList<>(); // initialisation de la liste Personnel
	private static Magasin mag =  new Magasin(); ; // initialisation du Magasin
	private static ArrayList<Emprunt> pret = new ArrayList<>(); // initialisation de la liste Emprunt





	public GestionJFrame() {
		super("Gestion d'une entreprise"); // permet d'attribuer un titre à la fenêtre 
		/* Mise en place de l'affichage des boutons et de la disposition*/
		this.setDefaultCloseOperation( DISPOSE_ON_CLOSE ); // Permet de fermer le programme quand on ferme la fenêtre

		JPanel contentPane = (JPanel) this.getContentPane();

		// Emplacements des différents boutons automatiquement
		contentPane.setLayout(new GridLayout(3,3));


		/* ******************************************************* 
		 ********** Ajout des bouton sur l'affichage************ */

		contentPane.add( btnLoad );
		contentPane.add( btnAffichage );
		contentPane.add( btnMag );
		contentPane.add( btnPret );
		contentPane.add( btnRetour );
		contentPane.add( btnPersonnel );
		contentPane.add( btnSauvegarde );
		contentPane.add( btnClose );

		this.setSize( 618 , 340 ); // Taille de l'écran de base
		this.setLocationRelativeTo( null ); // centre la fenêtre

		/* ******************************************************* 
		 ********** Ajout des fonctions liés au boutons********* */
		btnLoad.addActionListener(new btnLoadPersonnel());
		btnAffichage.addActionListener(new btnAffichagePersonnel());
		btnMag.addActionListener(new btnLoadMagasin());
		btnPret.addActionListener(new btnLoadEmprunt());
		btnRetour.addActionListener(new btnRetourEmprunt());
		btnPersonnel.addActionListener(new btnGestionPersonnel());
		btnSauvegarde.addActionListener(new btnSauvegardeFichier());
		btnClose.addActionListener(new btnCloseApp());

	}

	/* *******************************************************************
	 *******************Bouton Chargement Personnel********************* */

	private class btnLoadPersonnel implements ActionListener{ // Mise en place d'une classe interne qui possède les fonctions implémenter par la classe ActionListener

		@Override // Réécrit une fonction qui existe déjà en la réimplémentant comme on le souhaite
		public void actionPerformed (ActionEvent e) {  // Action lors de l'appui sur le Chargement Personnel

			LoadPersonnel();

		}
	}

	/* *******************************************************************
	 *******************Fonction Chargement Personnel******************* */

	private static void LoadPersonnel () {
		// Ajout des différents membres du personnel Si  la liste est vide au départ
		if (Person.isEmpty()) {
			Person.add(new Personnel("Collon","Albert",Sexe.HOMME, new MyDate(10, 8, 1990), "Collon.a@test.be",Departement.HR));
			Person.add(new Personnel("Peeters","Marie",Sexe.FEMME, new MyDate(01, 5, 1985), "Peeters_M@test.be", Departement.HR));	
			Person.add(new Personnel("Janssens","Sarah",Sexe.FEMME, new MyDate(23, 5, 1999), "Sarah.Janssens@test",Departement.Compta));
			Person.add(new Personnel("Jacobs","Charles",Sexe.HOMME, new MyDate(12, 12, 2009), "Charles.j@test.be",Departement.SEC));
			Person.add(new Personnel("Maes","Henri",Sexe.HOMME, new MyDate(14, 9, 2009), "MaesHenri@test.be",Departement.Compta));
			Person.add(new Personnel("Mertens","Floriane",Sexe.FEMME, new MyDate(20, 8, 1996), "FloFlo.M@test.be",Departement.SEC));
			Person.add(new Personnel("Willems","Francois-Xavier",Sexe.HOMME, new MyDate(28, 10, 1996), "Willems.F-X@test.be", Departement.Prod));
			Person.add(new Personnel("O'Neil","Shan",Sexe.HOMME, new MyDate(1, 7, 2001), "ONeil.sh@test.be",Departement.Prod));
			Person.add(new Personnel("Goossen","Stéphanie",Sexe.FEMME, new MyDate(25, 10, 2008), "NieNieG@test.be",Departement.HR));
			Person.add(new Personnel("Dumont","Charles",Sexe.HOMME, new MyDate(1, 4, 1969), "dumont.c@test.be",Departement.HR));
			Person.add(new Personnel("Van Moore","Wilfrid",Sexe.HOMME,new MyDate(25, 2, 1998), "vanmoore.w@test.te",Departement.Compta));
			Person.add(new Personnel("Herman","Nathalie",Sexe.FEMME, new MyDate(26, 7, 2001), "herman.n@test,be",Departement.Prod));
			Person.add(new Personnel("Bontemps","Annie",Sexe.FEMME, new MyDate(23,9,1998), "bontemps.a@test.be",Departement.Prod));
			System.out.println("   Personnel chargé !   ");
			System.out.println("------------------------");
		}
		else { // Si on a déjà chargé la liste auparavant
			System.out.println("Personnel déjà chargé !");
		}
	}

	/* *******************************************************************
	 *********************Bouton Affichage Personnel******************** */

	private class btnAffichagePersonnel implements ActionListener{ // Mise en place d'une classe interne pour l'affichage qui possède les fonctions implémenter par la classe ActionListener

		@Override
		public void actionPerformed (ActionEvent e) {  // Action lors de l'appui sur le bouton AffichagePersonnel

			System.out.println(Affichage().toString());


		}
	}


	/* *******************************************************************
	 ********************Fonction Affichage Personnel******************* */

	private static StringBuilder  Affichage() { // Fonction permettant d'afficher tout le personnel sous forme d'un tableau 

		StringBuilder SB = new StringBuilder(); // permet de concaténer des String de manière optimisé et d'allouer de l'espace en fonction de la taille des String

		if (Person.isEmpty()) { // si la liste du personnel est vide
			return SB.append("Affichage impossible, pas de personnel !\n");
		}
		else { // si la liste du personnel n'est pas vide

			SB.append("+---------------------+------------------------------+------------------------------+--------+------------+------------------------------+\n");
			SB.append("| Département         | Prénom                       | Nom                          | Sexe   | Naissance  | Email                        |\n");
			SB.append("+---------------------+------------------------------+------------------------------+--------+------------+------------------------------+\n");
			for (Personnel personne : Person) { // Boucle pour afficher les membres du personnel avec leurs attributs / Type objet   objet courant  : Arraylist 
				SB.append("  ");
				SB.append(setFixedLength(personne.getDepartement(),20) + "  ");
				SB.append(setFixedLength(personne.getPrenom(),tailleNom)+ " ");
				SB.append(setFixedLength(personne.getNom(),tailleNom)+ " ");
				SB.append(setFixedLength(personne.getSexe(),8)+ " ");
				SB.append(setFixedLength(personne.getDateddMMyyyy(),12)+ " ");
				SB.append(setFixedLength(personne.getEmail(),30)+ " ");
				SB.append("\n");
			}	
			return SB;
		}


	}


	/* ******************************************************************
	 **************Permet de calibrer la taille des Strings************ */

	private static String setFixedLength(String s, int taille) { // fonction permettant de mettre une taille fixe pour un String pour permettre une mise en page correcte

		StringBuilder stringtest= new StringBuilder(s);
		while (stringtest.length()< taille) { 	// Rajouter des espaces jusqu'à ce qu'on atteigne le nombre de caractères demandés pour l'affichage 									
			stringtest.insert(s.length(),' ');
		}
		return stringtest.substring(0,taille); // Permet de renvoyer la chaîne avec le nombre d'espace en fonction de la taille demandée

	}

	/* *******************************************************************
	 ***********************Bouton Création Magasin********************* */


	private class btnLoadMagasin implements ActionListener{ // Mise en place d'une classe interne  pour la création du mag qui possède les fonctions implémenter par la classe ActionListener
		// Action lors de l'appui sur le bouton Création du Magasin
		@Override
		public void actionPerformed (ActionEvent e) {  // Action lors de l'appui sur le bouton création du Magasin

			LoadMagasin();

		}
	}

	/* *******************************************************************
	 **********************Fonction Création Magasin******************** */

	private static void LoadMagasin () {

		if (mag.isEmpty()) {	// Si le mag est vide
			mag.ajouterProduit("HP1", "Elitebook 850 G7"); // ajout des produits dans le magasin
			mag.ajouterProduit("HP2", "Elitebook 830 G7 X360");
			mag.ajouterProduit("Dell1", "Inspiron 15 3000");
			mag.ajouterProduit("Dell2", "XPS 13");
			mag.ajouterProduit("Dell3", "XPS 15");
			mag.ajouterProduit("Lenovo", "Thinkpad E15 G2");
			mag.ajouterProduit("Lenovo", "IdeaPad 3 14IIL05 81WD00B2MH");
			System.out.println("   Magasin créé!   ");
			System.out.println("-------------------");
			mag.listeMap(); // affichage des produits du magasin
			System.out.println("\n");
		}
		else {	// Si le mag a déjà été créé
			System.out.println("Magasin déjà chargé !\n");
		}

	}

	/* *******************************************************************
	 ***********************Bouton Prêt du Matériel********************* */

	private class btnLoadEmprunt implements ActionListener{   

		@Override
		public void actionPerformed (ActionEvent e) { // Action lors de l'appui sur le bouton Prêt du Matériel

			Emprunt();

		}
	}

	/* *******************************************************************
	 ****************Fonction Création prêt de matériel***************** */

	private static void Emprunt () {
		if (Person.isEmpty()){  // si la liste du personnel est vide
			System.out.println("Le personnel n'a pas encore été chargé. Veuillez le charger d'abord !\n");
		}
		else if(mag.isEmpty()) { // si le magasin est vide
			System.out.println("Le magasin n'a pas encore été chargé. Veuillez le charger d'abord !\n");
		}
		else if (pret.isEmpty()) { // Si la liste des prêts n'a pas été chargée
			pret.add(new Emprunt(Person.get(0),mag.produits.get(1))); // Ajout des emprunts
			pret.add(new Emprunt(Person.get(1),mag.produits.get(3)));
			pret.add(new Emprunt(Person.get(2),mag.produits.get(4)));
			pret.add(new Emprunt(Person.get(3),mag.produits.get(6)));
			pret.add(new Emprunt(Person.get(6),mag.produits.get(7)));
			System.out.println("   Prêt de Matériel   ");
			System.out.println("----------------------");
			for (int CompteurList = 0; CompteurList < pret.size(); CompteurList++) { // boucle pour l'affichage de la liste des emprunts nom prénom,..
				System.out.println(pret.get(CompteurList).toString());
			}
			System.out.println("\n");
		}
		else // si la liste des prêts a été chargée
		{
			System.out.println("   Prêt de Matériel   ");
			System.out.println("----------------------");
			for (int CompteurList = 0; CompteurList < pret.size(); CompteurList++) { // affichage de la liste des emprunts nom prénom,..
				System.out.println(pret.get(CompteurList).toString());
			}
			System.out.println("\n");	
		}

	}


	/* *******************************************************************
	 ********************Bouton Retour Emprunt************************** */

	private class btnRetourEmprunt implements ActionListener{ 

		@Override
		public void actionPerformed (ActionEvent e) { // Action lors de l'appui sur le bouton Retour Emprunt

			RetourEmprunt();

		}
	}

	/* ******************************************************************
	 ******************Fonction retour des emprunts********************** */

	private static void RetourEmprunt() {
		int CompteurEmprunt = 1; // utilisé comme compteur dans la boucle
		if(pret.isEmpty()) { // si aucun prêt de matériel n'a été encodé
			System.out.println("Aucun prêt en cours actuellement !\n");
		}
		else {
			System.out.println("   Liste des emprunts   ");
			System.out.println("------------------------");
			for (Emprunt emprunt : pret) { // boucle pour afficher la liste d'emprunt
				System.out.println("N° "+(CompteurEmprunt)+" "+emprunt.getEmprunteur().getNom()+" "+emprunt.getMateriel()+" "+emprunt.getArticle());
				CompteurEmprunt++;
			}
			System.out.println("\nIntroduire le numéro d'emprunt à annuler :");
			int inputEmpruntToRemove=0; // j'initialise la variable pour ne pas qu'elle garde la dernière valeure enregistrée
			Boolean loop = false;
			while (!loop) {
				inputEmpruntToRemove = Lire.nbre();
				if (inputEmpruntToRemove <1 || inputEmpruntToRemove> pret.size()) { // Si le numéro d'emprunt à annuler n'existe pas
					System.out.println("Veuillez entrer un numéro d'emprunt existant");
				}
				else {
					loop = true; // si le numéro introduit correspond à un numéro d'emprunt existant
					pret.remove(inputEmpruntToRemove-1); // Retirer l'emprunt de la liste
				}
			}
			CompteurEmprunt = 1;
			for (Emprunt emprunt : pret) { // boucle pour afficher la liste d'emprunt
				System.out.println("N° "+(CompteurEmprunt)+" "+emprunt.getEmprunteur().getNom()+" "+emprunt.getMateriel()+" "+emprunt.getArticle());
				CompteurEmprunt++;
			}
			System.out.println("------------------------");
			System.out.println("  Modification validée  ");
		}

	}

	/* ******************************************************************
	 ********Fonction Affichage Emprunt pour la sauvegarde************* */

	private static StringBuilder AffichageEmpruntSauvegarde () {
		int CompteurEmprunt =0; // utilisé comme numéro pour le numéro d'emprunt
		StringBuilder SB = new StringBuilder(); //permet de concaténer des String de manière optimisé et d'allouer de l'espace en fonction de la taille des String
		SB.append("+------+------------------------------------------------------------+----------------------------------------------+\n");
		SB.append("| N°   | Nom-Prénom                                                 | Matériel                                     |\n");
		SB.append("+------+------------------------------------------------------------+----------------------------------------------+\n");
		for (Emprunt emprunteur : pret) { // Boucle pour afficher les différents emprunts // création d'un objet de type Emprunt pour récupérer les informations dans la liste
			SB.append("  ");
			SB.append((CompteurEmprunt+1) + "      "); // affichage du N°
			SB.append(setFixedLength(emprunteur.getEmprunteur().getNom(),tailleNom)+ " "); // Affichage du nom
			SB.append(setFixedLength(emprunteur.getEmprunteur().getPrenom(),tailleNom)+ " "); // affichage du préonom
			SB.append(setFixedLength(emprunteur.getMateriel(),8 )+ " "); // affichage du nom du matériel
			SB.append(setFixedLength(emprunteur.getArticle(),30)+ " "); // affichage de la description du matériel
			SB.append("\n");
			CompteurEmprunt++;
		}	
		return SB;	
	}

	/* ******************************************************************
	 ********************Bouton Modification Personnel***************** */

	private class btnGestionPersonnel implements ActionListener{ 


		@Override
		public void actionPerformed (ActionEvent e) { // Action lors de l'appui sur le bouton Gestion Personel

			GestionPersonnel();

		}
	}

	/* ******************************************************************
	 ******************Fonction Modification Personnel***************** */

	private static void GestionPersonnel() {

		if (Person.isEmpty()) // si la liste du personne est vide
		{
			System.out.println("Vous ne pouvez pas modifier le personnel tant que vous n'avez pas charger celui-ci !\n");
		}
		else
		{
			System.out.println(Affichage().toString()); // affiche la liste du personnel
			System.out.println("Introduire le nom de la personne à modifier :");
			// On demande le nom de la personne à modifier
			Boolean loop = false;
			int indice = 0; // permet de récupérer l'indice de la personne dont on voudra changer le nom, le prénom, l'adresse e-mail
			while (!loop) { // Boucle pour trouver dans la boucle si le nom se trouve dans la liste et à quel indice
				nom = InputData.inputNomPrenom("Nom"); // Vérifie que le nom correspond à un nom correct
				for (int CompteurList=0;CompteurList<Person.size();CompteurList++){
					if (Person.get(CompteurList).getNom().equals(nom)){ // Si le nom à l'indice X est égal au nom introduit 
						loop = true;
						indice = CompteurList;
					}
				}
				if (!loop) { // Si le nom introduit n'existe pas dans la liste
					System.out.println("Il n'existe personne ayant ce nom. Veuillez entrer un nom correct existant");
				}
			}
			Personnel personne = Person.get(indice); // création d'un objet de type Personnel pour récupérer les informations dans la liste à l'indice (indice)
			// On affiche L'iD du personne, le nom, ... de la personne dont on souhaite changer les informations
			System.out.println(personne.getIdPersonnel()+"   "+personne.getNom()+" -- "+personne.getPrenom()+" -- "+personne.getSexe()+" -- "+personne.getEmail()+" -- "+personne.getDepartement());
			System.out.println("Introduire les nouvelles valeurs :");
			// On Demande le Nom
			personne.setNom(InputData.inputNomPrenom("Nom")); // Changement du nom et vérification de celui-ci
			// On Demande le Prénom
			personne.setPrenom(InputData.inputNomPrenom("Prénom")); // Changement du prénom et vérification de celui-ci
			// On Demande l'adresse mail
			personne.setEmail(InputData.inputEmail()); // Changement de l'email et vérification de celui-ci
			System.out.println("--------------------------");
			System.out.println("  Modifications validées  ");
		}

	}

	/* ******************************************************************
	 *************************Bouton Sauvegarde************************ */

	private class btnSauvegardeFichier implements ActionListener{ 

		@Override
		public void actionPerformed (ActionEvent e) { // Action lors de l'appui sur le bouton Sauvegarde

			Sauvegarde();

		}
	}

	/* ******************************************************************
	 *************************Fonction Sauvegarde********************** */

	private static void Sauvegarde  () {
		if (Person.isEmpty()) { // si la liste du personne est vide
			System.out.println("Le personnel n'a pas encore été chargé. Veuillez le charger d'abord !\n");
		}
		else {
			fichier = InputData.inputNomFichier(); // Verifie que le nom du fichier correspond au format demandé
			System.out.println("\n");
			SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); // permet de formater une date
			Date date = new Date();
			try (BufferedWriter bufWrite = new BufferedWriter (new FileWriter(new File("./src/UytterhaegenLouis/fichier",fichier)))) // Chemin d'accès où le fichier doit être créé
			{
				bufWrite.newLine();
				bufWrite.write("DTG de la sauvegarde : "+ formatDate.format(date)); // Ecriture de la date et de l'heure actuel dans le fichier
				bufWrite.newLine();
				bufWrite.write(Affichage().toString()); // Ecriture du Stringbuilder affichage Personnel dans le fichier
				if (!pret.isEmpty()) { // si aucun prêt n'a été chargé
					bufWrite.newLine();
					bufWrite.newLine();
					bufWrite.write(AffichageEmpruntSauvegarde().toString()); // Ecriture du Stringbuilder AffichageEmprunt dans le fichier
					bufWrite.newLine();
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Sauvegarde Réussie ! La liste du personnel et du matériel emprunté ont bien été enregistrés dans le fichier "+fichier + " !\n");
				}else {
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("Sauvegarde Réussie ! Seule la liste du personnel a été enregistré dans le fichier "+fichier +" car il n'y a pas d'emprunt en cours !\n");
				}
			} catch (IOException io) {
				System.err.println("Une erreur est survenue : "+io.getMessage());
			}
 // Affichage du message de la sauvegarde réussite
		}

	}

	/* ******************************************************************
	 ***************************Bouton Fermeture*********************** */


	private class btnCloseApp implements ActionListener{

		@Override
		public void actionPerformed (ActionEvent e) { // Action lors de l'appui sur le bouton fermer
			System.exit(0);
		}





	}

}
