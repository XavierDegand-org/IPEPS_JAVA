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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Création des boutons et des textes des boutons
	private JButton btnLoad = new JButton( "Chargement du personnel" );  
	private JButton btnAffichage = new JButton( "Affichage liste du Personnel" );
	private JButton btnMag = new JButton( "Création du magasin" );
	private JButton btnPret = new JButton( "Pret de matériel" );
	private JButton btnRetour = new JButton( "Retour de matériel" );
	private JButton btnPersonnel = new JButton( "Modification données Personnel" );
	private JButton btnSauvegarde = new JButton( "Sauvegarde" );
	private JButton btnClose = new JButton( "Fermer" );

	public final static int tailleNom = 30;
	private  ArrayList<Personnel> ListePersonnel = new ArrayList<Personnel>();
	private Magasin magasin =  new Magasin(); ;


	public GestionJFrame() {
		super("Gestion d'une entreprise");
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

		/* ******************************************************* */
		/* Ajout des fonctions liés au boutons */
		btnLoad.addActionListener(new LoadPersonnel());
		btnAffichage.addActionListener(new Affichage());
		btnMag.addActionListener(new LoadMagasin());
		btnPret.addActionListener(new Emprunt());
		btnRetour.addActionListener(new RetourEmprunt());
		btnPersonnel.addActionListener(new GestionPersonnel());
		btnSauvegarde.addActionListener(new Sauvegarde());
		btnClose.addActionListener(new Close());

	}
	
	/* ******************************************************************
	 *******************Bouton Chargement Personnel***********************/								

	private class LoadPersonnel implements ActionListener{ // Mise en place d'une classe interne 

		@Override
		public void actionPerformed (ActionEvent e) {
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
			else {
				System.out.println("Magasin déjà chargé !");
			}
		}
	}

	/* ******************************************************************
	 ********************Bouton Affichage Personnel***********************/

	private  StringBuilder  Affichage() {
		StringBuilder SB = new StringBuilder();
		SB.append("+---------------------+------------------------------+------------------------------+-------+------------+---------------------------+\n");
		SB.append("| Département         | Prénom                       | Nom                          | Sexe  | Naissance  | Email                     |\n");
		SB.append("+---------------------+------------------------------+------------------------------+-------+------------+---------------------------+\n");
		for (Personnel personne : ListePersonnel) {
			SB.append("  ");
			SB.append(setFixedLength(personne.getDepartement(),20) + " ");
			SB.append(setFixedLength(personne.getPrenom(),30)+ " ");
			SB.append(setFixedLength(personne.getNom(),30)+ " ");
			SB.append(setFixedLength(personne.getSexe(),7)+ " ");
			SB.append(setFixedLength(personne.getDateddMMyyyy(),12)+ " ");
			SB.append(setFixedLength(personne.getEmail(),30)+ " ");
			SB.append("\n");
		}	



		return SB;
	}
	
	private class Affichage implements ActionListener{

		@Override
		public void actionPerformed (ActionEvent e) {
			if (ListePersonnel.isEmpty()) {
				System.out.println("Affichage impossible, pas de personnel !");
			}
			else {
				StringBuilder texteAAfficher = Affichage();
				System.out.println(texteAAfficher.toString());
			}

		}
	}

	/* ******************************************************************
	 **************Permet de calibrer la taille des Strings***************/
	private String setFixedLength(String s, int taille) {
		StringBuilder stringtest= new StringBuilder(s);
		while (stringtest.length()< taille) { 	// Rajouter des espaces jusqu'à ce qu'on atteigne le nombre de caractères demandés pour l'affichage 									
			stringtest.insert(s.length(),' ');
		}
		return stringtest.substring(0,taille);

	}	

	/* ******************************************************************
	 ***********************Bouton Création Magasin***********************/


	private class LoadMagasin implements ActionListener{

		@Override
		public void actionPerformed (ActionEvent e) {
			
			if (magasin.isEmpty()) {
				magasin.ajouterProduit("HP1", "Elitebook 850 G7");
				magasin.ajouterProduit("HP2", "Elitebook 830 G7 X360");
				magasin.ajouterProduit("Dell1", "Inspiron 15 3000");
				magasin.ajouterProduit("Dell2", "XPS 13");
				magasin.ajouterProduit("Dell3", "XPS 15");
				magasin.ajouterProduit("Dell", "Thinkpad E15 G2");
				magasin.ajouterProduit("Dell", "IdeaPad 3 14IIL05 81WD00B2MH");
				magasin.listeMap();
			}
			else {
				System.out.println("Magasin déjà chargé !");
			}

		}
	}



	/* ******************************************************************
	 ***********************Bouton Prêt du Matériel***********************/

	private class Emprunt implements ActionListener{

		@Override
		public void actionPerformed (ActionEvent e) {

		}
	}

	/* ******************************************************************
	 ********************Bouton Retour Emprunt****************************/

	private class RetourEmprunt implements ActionListener{

		@Override
		public void actionPerformed (ActionEvent e) {

		}
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
				Affichage();
				System.out.println("Introduire le nom de la personne à modifier :");
				// On demande le nom de la personne à modifier
				String s = InputData.inputNomPrenom("Nom");
				Boolean loop = false;
				int indice = 0;
				while (!loop) {
					for (int CompteurList=0;CompteurList<ListePersonnel.size();CompteurList++){
						if (ListePersonnel.get(CompteurList).getNom().equals(s)){
							loop = true;
							indice = CompteurList;
						}
					}
					if (!loop) {
						System.out.println("Il n'existe personne ayant ce nom. Veuillez entrer un nom correct existant");
						s = InputData.inputNomPrenom("Nom");
					}
				}
				Personnel personne = ListePersonnel.get(indice);
				System.out.println(personne.getIdPersonnel()+"   "+personne.getNom()+" -- "+personne.getPrenom()+" -- "+personne.getSexe()+" -- "+personne.getEmail()+" -- "+personne.getDepartement());
				System.out.println("Introduire les nouvelles valeurs :");
				// On Demande le Nom
				personne.setNom(InputData.inputNomPrenom("Nom"));
				// On Demande le Prénom
				personne.setPrenom(InputData.inputNomPrenom("Prénom"));
				// On Demande l'adresse mail
				personne.setEmail(InputData.inputEmail());
				System.out.println("----------------------");
				System.out.println("Modifications validées");
			}
		}
	}


	/* ******************************************************************
	 *************************Bouton Sauvegarde***************************/


	private class Sauvegarde implements ActionListener{

		@Override
		public void actionPerformed (ActionEvent e) {
			try (BufferedWriter bufWrite = new BufferedWriter (new FileWriter(new File("./src/UytterhaegenLouis","TEST.txt"))))
			{
				bufWrite.write(Affichage().toString());
				bufWrite.newLine();

			} catch (IOException io) {
				System.err.println("Une erreur est survenue : "+io.getMessage());
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
