package UytterhaegenLouis;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
	private  ArrayList<Personnel> ListePersonnel = new ArrayList<Personnel>(); // initialisation de la liste Personnel
	private Magasin magasin =  new Magasin(); ; // initialisation du Magasin
	private ArrayList<Emprunt> ListeEmprunt = new ArrayList<>(); // initialisation de la liste Emprunt





	public GestionJFrame() {
		super("Gestion d'une entreprise"); // permet d'attribuer un titre à la fenêtre 
		/* Mise en place de l'affichage des boutons et de la disposition*/
		this.setDefaultCloseOperation( DISPOSE_ON_CLOSE ); // Permet de fermer le programme quand on ferme la fenêtre

		JPanel contentPane = (JPanel) this.getContentPane();

		contentPane.setLayout(null); 
		// Emplacements des différents boutons
		btnLoad.setBounds(1, 1, 200, 100);
		btnAffichage.setBounds(201, 1, 200, 100);
		btnMag.setBounds(402, 1, 200, 100);
		btnPret.setBounds(1, 101, 200, 100);
		btnRetour.setBounds(201, 101, 200, 100);
		btnPersonnel.setBounds(402, 101, 200, 100);
		btnSauvegarde.setBounds(1,202 ,200, 100);
		btnClose.setBounds(201,202, 200, 100);

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
		btnLoad.addActionListener(new LoadPersonnel());
		btnAffichage.addActionListener(new Affichage());
		btnMag.addActionListener(new LoadMagasin());
		btnPret.addActionListener(new LoadEmprunt());
		btnRetour.addActionListener(new RetourEmprunt());
		btnPersonnel.addActionListener(new GestionPersonnel());
		btnSauvegarde.addActionListener(new Sauvegarde());
		btnClose.addActionListener(new Close());

	}

	/* *******************************************************************
	 *******************Bouton Chargement Personnel********************* */								

	private class LoadPersonnel implements ActionListener{ // Mise en place d'une classe interne qui possède les fonctions implémenter par la classe ActionListener

		@Override // Réécrit une fonction qui existe déjà en la réimplémentant comme on le souhaite
		public void actionPerformed (ActionEvent e) {
			// Ajout des différents membres du personnel Si  la liste est vide au départ
			if (ListePersonnel.isEmpty()) {
				ListePersonnel.add(new Personnel("Collon","Albert",Sexe.HOMME, new MyDate(10, 8, 1990), "Collon.a@test.be",Departement.HR));
				ListePersonnel.add(new Personnel("Peeters","Marie",Sexe.FEMME, new MyDate(01, 5, 1985), "Peeters_M@test.be", Departement.HR));	
				ListePersonnel.add(new Personnel("Janssens","Sarah",Sexe.FEMME, new MyDate(23, 5, 1999), "Sarah.Janssens@test",Departement.Compta));
				ListePersonnel.add(new Personnel("Jacobs","Charles",Sexe.HOMME, new MyDate(12, 12, 2009), "Charles.j@test.be",Departement.SEC));
				ListePersonnel.add(new Personnel("Maes","Henri",Sexe.HOMME, new MyDate(14, 9, 2009), "MaesHenri@test.be",Departement.Compta));
				ListePersonnel.add(new Personnel("Mertens","Floriane",Sexe.FEMME, new MyDate(20, 8, 1996), "FloFlo.M@test.be",Departement.SEC));
				ListePersonnel.add(new Personnel("Willems","Francois-Xavier",Sexe.HOMME, new MyDate(28, 10, 1996), "Willems.F-X@test.be", Departement.Prod));
				ListePersonnel.add(new Personnel("O'Neil","Shan",Sexe.HOMME, new MyDate(1, 7, 2001), "ONeil.sh@test.be",Departement.Prod));
				ListePersonnel.add(new Personnel("Goossen","Stéphanie",Sexe.FEMME, new MyDate(25, 10, 2008), "NieNieG@test.be",Departement.HR));
				ListePersonnel.add(new Personnel("Dumont","Charles",Sexe.HOMME, new MyDate(1, 4, 1969), "dumont.c@test.be",Departement.HR));
				ListePersonnel.add(new Personnel("Van Moore","Wilfrid",Sexe.HOMME,new MyDate(25, 2, 1998), "vanmoore.w@test.te",Departement.Compta));
				ListePersonnel.add(new Personnel("Herman","Nathalie",Sexe.FEMME, new MyDate(26, 7, 2001), "herman.n@test,be",Departement.Prod));
				ListePersonnel.add(new Personnel("Bontemps","Annie",Sexe.FEMME, new MyDate(23,9,1998), "bontemps.a@test.be",Departement.Prod));
			}
			else { // Si on a déjà chargé la liste auparavant
				System.out.println("Personnel déjà chargé !");
			}
		}
	}

	/* *******************************************************************
	 ********************Bouton Affichage Personnel********************* */

	private  StringBuilder  Affichage() { // Fonction permettant d'afficher tout le personnel sous forme d'un tableau 

		StringBuilder SB = new StringBuilder(); // permet de concaténer des chaînes de caractères pour que cela soit plus propre et permet de tout afficher

		if (ListePersonnel.isEmpty()) { // si la liste du personnel est vide
			return SB.append("Affichage impossible, pas de personnel !");
		}
		else { // si la liste du personnel n'est pas vide

			SB.append("+---------------------+------------------------------+------------------------------+--------+------------+---------------------------+\n");
			SB.append("| Département         | Prénom                       | Nom                          | Sexe   | Naissance  | Email                     |\n");
			SB.append("+---------------------+------------------------------+------------------------------+--------+------------+---------------------------+\n");
			for (Personnel personne : ListePersonnel) { // Boucle pour afficher les membres du personnel avec leurs attributs / Type objet   objet courant  : Arraylist 
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

	private class Affichage implements ActionListener{ // Mise en place d'une classe interne pour l'affichage qui possède les fonctions implémenter par la classe ActionListener

		@Override
		public void actionPerformed (ActionEvent e) { // Lorsque l'on appuie sur le bouton Affichage 

			System.out.println(Affichage().toString());


		}
	}

	/* ******************************************************************
	 **************Permet de calibrer la taille des Strings***************/
	private String setFixedLength(String s, int taille) { // fonction permettant de mettre une taille fixe pour un String
		StringBuilder stringtest= new StringBuilder(s);
		while (stringtest.length()< taille) { 	// Rajouter des espaces jusqu'à ce qu'on atteigne le nombre de caractères demandés pour l'affichage 									
			stringtest.insert(s.length(),' ');
		}
		return stringtest.substring(0,taille); // Permet de renvoyer la chaîne avec le nombre d'espace en fonction de la taille demandée

	}	

	/* *******************************************************************
	 ***********************Bouton Création Magasin********************* */


	private class LoadMagasin implements ActionListener{ // Mise en place d'une classe interne  pour la création du magasin qui possède les fonctions implémenter par la classe ActionListener

		@Override
		public void actionPerformed (ActionEvent e) {  // Lorsque l'on appuie sur le bouton création du magasin

			if (magasin.isEmpty()) {	// Si le magasin est vide
				magasin.ajouterProduit("HP1", "Elitebook 850 G7");
				magasin.ajouterProduit("HP2", "Elitebook 830 G7 X360");
				magasin.ajouterProduit("Dell1", "Inspiron 15 3000");
				magasin.ajouterProduit("Dell2", "XPS 13");
				magasin.ajouterProduit("Dell3", "XPS 15");
				magasin.ajouterProduit("Lenovo", "Thinkpad E15 G2");
				magasin.ajouterProduit("Lenovo", "IdeaPad 3 14IIL05 81WD00B2MH");
				magasin.listeMap();
				System.out.println("\n");
			}
			else {	// Si le magasin a déjà été créé
				System.out.println("Magasin déjà chargé !");
			}

		}
	}



	/* *******************************************************************
	 ***************Fonction Affichage prêt du matériel***************** */

	private void Emprunt () { // Fonction permettant l'affichage des différents emprunts
		System.out.println("   Prêt de Matériel   ");
		System.out.println("----------------------");
		for (int CompteurList = 0; CompteurList < ListeEmprunt.size(); CompteurList++) {
			System.out.println(ListeEmprunt.get(CompteurList).toString());
		}
		System.out.println("\n");
	}

	
	/* *******************************************************************
	 ***********************Bouton Prêt du Matériel********************* */
	
	private class LoadEmprunt implements ActionListener{  // Lorsque l'on appuie sur le bouton prêt matériel

		@Override
		public void actionPerformed (ActionEvent e) {
			if (ListePersonnel.isEmpty()){
				System.out.println("Le personnel n'a pas encore été chargé. Veuillez le charger d'abord !");
			}
			else if(magasin.isEmpty()) {
				System.out.println("Le magasin n'a pas encore été chargé. Veuillez le charger d'abord !");
			}
			else if (ListeEmprunt.isEmpty()) {

				ListeEmprunt.add(new Emprunt(ListePersonnel.get(0),magasin.listeProduit.get(1)));
				ListeEmprunt.add(new Emprunt(ListePersonnel.get(1),magasin.listeProduit.get(3)));
				ListeEmprunt.add(new Emprunt(ListePersonnel.get(2),magasin.listeProduit.get(4)));
				ListeEmprunt.add(new Emprunt(ListePersonnel.get(3),magasin.listeProduit.get(6)));
				ListeEmprunt.add(new Emprunt(ListePersonnel.get(6),magasin.listeProduit.get(7)));
				Emprunt();

			}
			else
			{
				Emprunt();	
			}

		}
	}

	/* *******************************************************************
	 ********************Bouton Retour Emprunt************************** */

	private class RetourEmprunt implements ActionListener{

		@Override
		public void actionPerformed (ActionEvent e) {
			if (ListePersonnel.isEmpty()){
				System.out.println("Le personnel n'a pas encore été chargé. Veuillez le charger d'abord !");
			}
			else if(magasin.isEmpty()) {
				System.out.println("Le magasin n'a pas encore été chargé. Veuillez le charger d'abord !");
			}
			else if(ListeEmprunt.isEmpty()) {
				System.out.println("Aucun prêt n'a été chargé !");
			}
			else {
				System.out.println("   Liste des emprunts   ");
				System.out.println("------------------------");
				for (int CompteurList = 0 ; CompteurList < ListeEmprunt.size(); CompteurList++) {
					Emprunt emprunteur = ListeEmprunt.get(CompteurList); // création d'un objet de type Emprunt pour récupérer les informations dans la liste
					System.out.println("N° "+(CompteurList+1)+" "+emprunteur.getEmprunteur()+" "+emprunteur.getMateriel()+" "+emprunteur.getArticle());
				}
				System.out.println("Introduire le numéro d'emprunt à annuler");
				int InputEmpruntToCancel=-1; // j'initialise la variable pour ne pas qu'elle garde la dernière valeure enregistrée
				Boolean loop = false;
				while (!loop) {
					InputEmpruntToCancel = Lire.nbre();
					if (InputEmpruntToCancel <1 || InputEmpruntToCancel> ListeEmprunt.size()) { // Si le numéro d'emprunt à annuler n'existe pas
						System.out.println("Veuillez entrer un numéro d'emprunt existant");
					}
					else {
						loop = true;
						ListeEmprunt.remove(InputEmpruntToCancel-1);
					}
				}
				for (int CompteurList = 0 ; CompteurList < ListeEmprunt.size(); CompteurList++) {
					Emprunt emprunteur = ListeEmprunt.get(CompteurList); // création d'un objet de type Emprunt pour récupérer les informations dans la liste
					System.out.println("N° "+(CompteurList+1)+" "+emprunteur.getEmprunteur()+" "+emprunteur.getMateriel()+" "+emprunteur.getArticle());
				}
				System.out.println("--------------------------");
				System.out.println("  Modifications validées  ");
			}
		}
	}

	/* ******************************************************************
	 ********Fonction Affichage Emprunt pour la sauvegarde************* */

	private StringBuilder AffichageEmprunt () {
		StringBuilder SB = new StringBuilder(); 
		SB.append("+------+------------------------------------------------------------+----------------------------------------------+\n");
		SB.append("| N°   | Nom-Prénom                                                 | Matériel                                     |\n");
		SB.append("+------+------------------------------------------------------------+----------------------------------------------+\n");
		for (int CompteurList = 0 ; CompteurList < ListeEmprunt.size(); CompteurList++) { // Boucle pour afficher les différents emprunts
			Emprunt emprunteur = ListeEmprunt.get(CompteurList); // création d'un objet de type Personnel pour récupérer les informations dans la liste
			SB.append("  ");
			SB.append((CompteurList+1) + "      ");
			SB.append(setFixedLength(emprunteur.getEmprunteur(),60)+ " ");
			SB.append(setFixedLength(emprunteur.getMateriel(),8 )+ " ");
			SB.append(setFixedLength(emprunteur.getArticle(),30)+ " ");
			SB.append("\n");
		}	
		return SB;	
	}

	/* ******************************************************************
	 ********************Bouton Modification Personnel********************/

	private class GestionPersonnel implements ActionListener{


		@Override
		public void actionPerformed (ActionEvent e) {
			if (ListePersonnel.isEmpty())
			{
				System.out.println("Vous ne pouvez pas modifier le personnel tant que vous n'avez pas charger celui-ci");
			}
			else
			{
				System.out.println(Affichage().toString());
				System.out.println("Introduire le nom de la personne à modifier :");
				// On demande le nom de la personne à modifier
				String s = InputData.inputNomPrenom("Nom");
				Boolean loop = false;
				int indice = 0;
				while (!loop) { // Boucle pour trouver dans la boucle si le nom se trouve dans la liste et à quel indice
					for (int CompteurList=0;CompteurList<ListePersonnel.size();CompteurList++){
						if (ListePersonnel.get(CompteurList).getNom().equals(s)){ // Si le nom à l'indice X est égal au nom introduit 
							loop = true;
							indice = CompteurList;
						}
					}
					if (!loop) { // Si le nom introduit n'existe pas dans la liste
						System.out.println("Il n'existe personne ayant ce nom. Veuillez entrer un nom correct existant");
						s = InputData.inputNomPrenom("Nom");
					}
				}
				Personnel personne = ListePersonnel.get(indice); // création d'un objet de type Personnel pour récupérer les informations dans la liste
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
	}


	/* ******************************************************************
	 *************************Bouton Sauvegarde***************************/


	private class Sauvegarde implements ActionListener{

		@Override
		public void actionPerformed (ActionEvent e) {
			if (ListePersonnel.isEmpty()) {
				System.out.println("Le personnel n'a pas encore été chargé. Veuillez le charger d'abord !");
			}
			else if(magasin.isEmpty()){
				System.out.println("Le magasin n'a pas encore été chargé. Veuillez le charger d'abord !");
			}
			else if(ListeEmprunt.isEmpty()) {
				System.out.println("Aucun prêt n'a été chargé !");
			}
			else {
				try (BufferedWriter bufWrite = new BufferedWriter (new FileWriter(new File("./src/UytterhaegenLouis","TEST.txt"))))
				{
					bufWrite.write(Affichage().toString());
					bufWrite.newLine();
					bufWrite.newLine();
					bufWrite.write(AffichageEmprunt().toString());
					bufWrite.newLine();

				} catch (IOException io) {
					System.err.println("Une erreur est survenue : "+io.getMessage());
				}
				System.out.println("---------------------------");
				System.out.println("   Sauvegarde réussite !   ");
			}
		}
	}

	/* ******************************************************************
	 ***************************Bouton Fermeture**************************/


	private class Close implements ActionListener{

		@Override
		public void actionPerformed (ActionEvent e) {
			System.exit(0);
		}





	}

}
