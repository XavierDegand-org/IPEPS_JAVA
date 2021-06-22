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

	public final static int tailleNom = 30;
	private String fichier;
	private String nom;


	/* ******************************************************* 
	 *************Initialisation des listes,....************** */

	private  ArrayList<Personnel> Person = new ArrayList<>(); // initialisation de la liste Personnel
	private Magasin mag =  new Magasin(); ; // initialisation du Magasin
	private ArrayList<Emprunt> pret = new ArrayList<>(); // initialisation de la liste Emprunt


	


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
		btnSauvegarde.addActionListener(new btnSauvegarde());
		btnClose.addActionListener(new btnClose());

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

	private void LoadPersonnel () {
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

	private  StringBuilder  Affichage() { // Fonction permettant d'afficher tout le personnel sous forme d'un tableau 

		StringBuilder SB = new StringBuilder(); // permet de concaténer des String de manière optimisé et d'allouer de l'espace en fonction de la taille des String

		if (Person.isEmpty()) { // si la liste du personnel est vide
			return SB.append("Affichage impossible, pas de personnel !");
		}
		else { // si la liste du personnel n'est pas vide

			SB.append("+---------------------+------------------------------+------------------------------+--------+------------+---------------------------+\n");
			SB.append("| Département         | Prénom                       | Nom                          | Sexe   | Naissance  | Email                     |\n");
			SB.append("+---------------------+------------------------------+------------------------------+--------+------------+---------------------------+\n");
			for (Personnel personne : Person) { // Boucle pour afficher les membres du personnel avec leurs attributs / Type objet   objet courant  : Arraylist 
				SB.append("  ");
				SB.append(setFixedLength(personne.getDepartement(),20) + "  ");
				SB.append(setFixedLength(personne.getPrenom(),30)+ " ");
				SB.append(setFixedLength(personne.getNom(),30)+ " ");
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

	private String setFixedLength(String s, int taille) { // fonction permettant de mettre une taille fixe pour un String pour permettre une mise en page correcte

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
		public void actionPerformed (ActionEvent e) {  // Lorsque l'on appuie sur le bouton création du mag

			LoadMagasin();

		}
	}

	/* *******************************************************************
	 **********************Fonction Création Magasin******************** */

	private void LoadMagasin () {

		if (mag.isEmpty()) {	// Si le mag est vide
			mag.ajouterProduit("HP1", "Elitebook 850 G7");
			mag.ajouterProduit("HP2", "Elitebook 830 G7 X360");
			mag.ajouterProduit("Dell1", "Inspiron 15 3000");
			mag.ajouterProduit("Dell2", "XPS 13");
			mag.ajouterProduit("Dell3", "XPS 15");
			mag.ajouterProduit("Lenovo", "Thinkpad E15 G2");
			mag.ajouterProduit("Lenovo", "IdeaPad 3 14IIL05 81WD00B2MH");
			System.out.println("   Magasin créé!   ");
			System.out.println("-------------------");
			mag.listeMap();
			System.out.println("\n");
		}
		else {	// Si le mag a déjà été créé
			System.out.println("Magasin déjà chargé !");
		}

	}

	/* *******************************************************************
	 ***********************Bouton Prêt du Matériel********************* */

	private class btnLoadEmprunt implements ActionListener{   // Action lors de l'appui sur le bouton Prêt du Matériel

		@Override
		public void actionPerformed (ActionEvent e) {

			LoadEmprunt();

		}
	}

	/* *******************************************************************
	 ****************Fonction Création prêt et affichage**************** */

	private void LoadEmprunt () {

		if (Person.isEmpty()){
			System.out.println("Le personnel n'a pas encore été chargé. Veuillez le charger d'abord !");
		}
		else if(mag.isEmpty()) {
			System.out.println("Le magasin n'a pas encore été chargé. Veuillez le charger d'abord !");
		}
		else if (pret.isEmpty()) {

			pret.add(new Emprunt(Person.get(0),mag.produits.get(1)));
			pret.add(new Emprunt(Person.get(1),mag.produits.get(3)));
			pret.add(new Emprunt(Person.get(2),mag.produits.get(4)));
			pret.add(new Emprunt(Person.get(3),mag.produits.get(6)));
			pret.add(new Emprunt(Person.get(6),mag.produits.get(7)));
			AffichagePret();

		}
		else
		{
			AffichagePret();	
		}

	}
	/* *******************************************************************
	 ***************Fonction Affichage prêt du matériel***************** */

	private void AffichagePret () { // Fonction permettant l'affichage des différents emprunts
		System.out.println("   Prêt de Matériel   ");
		System.out.println("----------------------");
		for (int CompteurList = 0; CompteurList < pret.size(); CompteurList++) {
			System.out.println(pret.get(CompteurList).toString());
		}
		System.out.println("\n");
	}

	/* *******************************************************************
	 ********************Bouton Retour Emprunt************************** */

	private class btnRetourEmprunt implements ActionListener{  // Action lors de l'appui sur le bouton Retour Emprunt

		@Override
		public void actionPerformed (ActionEvent e) {

			RetourEmprunt();

		}
	}

	/* ******************************************************************
	 ******************Fonction retour des emprunts********************** */

	private void RetourEmprunt() {

		if(pret.isEmpty()) {
			System.out.println("Aucun prêt n'a été chargé !");
		}
		else {
			System.out.println("   Liste des emprunts   ");
			System.out.println("------------------------");
			AffichageListeEmprunt();
			System.out.println("Introduire le numéro d'emprunt à annuler");
			int inputEmpruntToRemove=0; // j'initialise la variable pour ne pas qu'elle garde la dernière valeure enregistrée
			Boolean loop = false;
			while (!loop) {
				inputEmpruntToRemove = Lire.nbre();
				if (inputEmpruntToRemove <1 || inputEmpruntToRemove> pret.size()) { // Si le numéro d'emprunt à annuler n'existe pas
					System.out.println("Veuillez entrer un numéro d'emprunt existant");
				}
				else {
					loop = true;
					pret.remove(inputEmpruntToRemove-1);
				}
			}
			AffichageListeEmprunt();
			System.out.println("--------------------------");
			System.out.println("  Modifications validées  ");
		}

	}

	/* ******************************************************************
	 ********Fonction Affichage Emprunt pour le retour matériel******** */

	private void AffichageListeEmprunt() { 
		for (int CompteurList = 0 ; CompteurList < pret.size(); CompteurList++) {
			Emprunt emprunteur = pret.get(CompteurList); // création d'un objet de type Emprunt pour récupérer les informations dans la liste
			System.out.println("N° "+(CompteurList+1)+" "+emprunteur.getEmprunteur().getNom()+" "+emprunteur.getMateriel()+" "+emprunteur.getArticle());
		}
	}

	/* ******************************************************************
	 ********Fonction Affichage Emprunt pour la sauvegarde************* */

	private StringBuilder AffichageEmpruntSauvegarde () {
		StringBuilder SB = new StringBuilder(); 
		SB.append("+------+------------------------------------------------------------+----------------------------------------------+\n");
		SB.append("| N°   | Nom-Prénom                                                 | Matériel                                     |\n");
		SB.append("+------+------------------------------------------------------------+----------------------------------------------+\n");
		for (int CompteurList = 0 ; CompteurList < pret.size(); CompteurList++) { // Boucle pour afficher les différents emprunts
			Emprunt emprunteur = pret.get(CompteurList); // création d'un objet de type Emprunt pour récupérer les informations dans la liste
			SB.append("  ");
			SB.append((CompteurList+1) + "      ");
			SB.append(setFixedLength(emprunteur.getEmprunteur().getNom(),30)+ " ");
			SB.append(setFixedLength(emprunteur.getEmprunteur().getPrenom(),30)+ " ");
			SB.append(setFixedLength(emprunteur.getMateriel(),8 )+ " ");
			SB.append(setFixedLength(emprunteur.getArticle(),30)+ " ");
			SB.append("\n");
		}	
		return SB;	
	}

	/* ******************************************************************
	 ********************Bouton Modification Personnel***************** */

	private class btnGestionPersonnel implements ActionListener{ // Action lors de l'appui sur le bouton Gestion Personel


		@Override
		public void actionPerformed (ActionEvent e) {

			GestionPersonnel();

		}
	}

	/* ******************************************************************
	 ******************Fonction Modification Personnel***************** */

	private void GestionPersonnel() {

		if (Person.isEmpty())
		{
			System.out.println("Vous ne pouvez pas modifier le personnel tant que vous n'avez pas charger celui-ci");
		}
		else
		{
			System.out.println(Affichage().toString());
			System.out.println("Introduire le nom de la personne à modifier :");
			// On demande le nom de la personne à modifier
			nom = InputData.inputNomPrenom("Nom");
			Boolean loop = false;
			int indice = 0;
			while (!loop) { // Boucle pour trouver dans la boucle si le nom se trouve dans la liste et à quel indice
				for (int CompteurList=0;CompteurList<Person.size();CompteurList++){
					if (Person.get(CompteurList).getNom().equals(nom)){ // Si le nom à l'indice X est égal au nom introduit 
						loop = true;
						indice = CompteurList;
					}
				}
				if (!loop) { // Si le nom introduit n'existe pas dans la liste
					System.out.println("Il n'existe personne ayant ce nom. Veuillez entrer un nom correct existant");
					nom = InputData.inputNomPrenom("Nom");
				}
			}
			Personnel personne = Person.get(indice); // création d'un objet de type Personnel pour récupérer les informations dans la liste à l'indice (indice)
			// On affiche L'iD du personne, le nom, ... de la personne dont on souhaite changer les informations
			System.out.println(personne.getIdPersonnel()+"   "+personne.getNom()+" -- "+personne.getPrenom()+" -- "+personne.getSexe()+" -- "+personne.getEmail()+" -- "+personne.getDepartement());
			System.out.println("Introduire les nouvelles valeurs :");
			// On Demande le Nom
			personne.setNom(InputData.inputNomPrenom("Nom"));
			// On Demande le Prénom
			personne.setPrenom(InputData.inputNomPrenom("Prénom"));
			// On Demande l'adresse mail
			personne.setEmail(InputData.inputEmail());
			System.out.println("--------------------------");
			System.out.println("  Modifications validées  ");
		}

	}

	/* ******************************************************************
	 *************************Bouton Sauvegarde************************ */

	private class btnSauvegarde implements ActionListener{ // Action lors de l'appui sur le bouton Sauvegarde

		@Override
		public void actionPerformed (ActionEvent e) {

			Sauvegarde();

		}
	}

	/* ******************************************************************
	 *************************Fonction Sauvegarde********************** */

	private void Sauvegarde  () {

		if (Person.isEmpty()) {
			System.out.println("Le personnel n'a pas encore été chargé. Veuillez le charger d'abord !");
		}
		else if(mag.isEmpty()){
			System.out.println("Le magasin n'a pas encore été chargé. Veuillez le charger d'abord !");
		}
		else if(pret.isEmpty()) {
			System.out.println("Aucun prêt n'a été chargé !");
		}
		else {
			fichier = InputData.inputNomFichier(); // Verifie que le nom du fichier correspond au format demandé
			SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = new Date();
			try (BufferedWriter bufWrite = new BufferedWriter (new FileWriter(new File("./src/UytterhaegenLouis/fichier",fichier))))
			{
				bufWrite.newLine();
				bufWrite.write("DTG de la sauvegarde : "+ formatDate.format(date));
				bufWrite.newLine();
				bufWrite.write(Affichage().toString()); // Ecriture du Stringbuilder affichage Personnel dans le fichier
				bufWrite.newLine();
				bufWrite.newLine();
				bufWrite.write(AffichageEmpruntSauvegarde().toString()); // Ecriture du Stringbuilder AffichageEmprunt dans le fichier
				bufWrite.newLine();

			} catch (IOException io) {
				System.err.println("Une erreur est survenue : "+io.getMessage());
			}
			System.out.println("---------------------------");
			System.out.println("Le fichier de nom "+fichier+" a bien été créé !");
			System.out.println("---------------------------");
			System.out.println("   Sauvegarde réussite !   ");
		}

	}

	/* ******************************************************************
	 ***************************Bouton Fermeture*********************** */


	private class btnClose implements ActionListener{

		@Override
		public void actionPerformed (ActionEvent e) {
			System.exit(0);
		}





	}

}
