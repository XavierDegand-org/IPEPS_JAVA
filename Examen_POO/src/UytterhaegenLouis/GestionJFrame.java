package UytterhaegenLouis;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	 
	public static final int tailleNom = 30;
	private static ArrayList<Personnel> Person = new ArrayList<Personnel>();

	public GestionJFrame() {
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
		btnMag.addActionListener(new Magasin());
		btnPret.addActionListener(new Emprunt());
		btnRetour.addActionListener(new RetourEmprunt());
		btnPersonnel.addActionListener(new GestionPersonnel());
		btnSauvegarde.addActionListener(new Sauvegarde());
		btnClose.addActionListener(new Close());
		
	}
		
		/* ******************************************************************
		*******************Bouton Chargement Personnel***********************/								
		 public JButton LoadPersonnel() {
			 return btnPersonnel;
		 }
		 
		
		 
		private class LoadPersonnel implements ActionListener{
			 
			 @Override
				public void actionPerformed (ActionEvent e) {
				 				 
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
				}
		 }
		
		/* ******************************************************************
		********************Bouton Affichage Personnel***********************/
		 
		 public JButton Affichage() {
			 return btnAffichage;
		 }
		 private static void Affichage1() {
			 
			 if (Person.isEmpty()) {
					System.out.println("Affichage impossible, pas de personnel !");
				}
					else {
					System.out.println("+---------------------+-------------------------------+-------------------------------+---------------+---------------+---------------------------+");
					System.out.println("| Département         | Prénom                        | Nom                           | Sexe   	      | Naissance     | Email                     |");
					System.out.println("+---------------------+-------------------------------+-------------------------------+---------------+---------------+---------------------------+");
					StringBuilder SB = new StringBuilder(); // Permet de concaténer les String
						for (Personnel person : Person) {
							SB.append("  ");
							SB.append(setFixedLength(person.getDepartement(),20));
							SB.append("\t");
							SB.append(setFixedLength(person.getPrenom(),30));
							SB.append("\t");
							SB.append(setFixedLength(person.getNom(),30));
							SB.append("\t");
							SB.append(setFixedLength(person.getSexe(),8));
							SB.append("\t");
							SB.append(setFixedLength(person.getDateddMMyyyy(),10));
							SB.append("\t");
							SB.append(setFixedLength(person.getEmail(),30));
							SB.append("\n");
							}
						System.out.println(SB);
						}
				
		 }
		// Mise en place de classes Anonymes pour les actions des boutons
		 private class Affichage implements ActionListener{
			
			 @Override
				public void actionPerformed (ActionEvent e) {
				 Affichage1();
			 }
		 }
		 
			/* ******************************************************************
			**************Permet de calibrer la taille des Strings***************/
		 public static String setFixedLength(String s, int taille) {
			 StringBuilder stringtest= new StringBuilder(s);
			 while (stringtest.length()< taille) {
				 String d =" ";
				 char C1=d.charAt(0);
				 stringtest.insert(s.length(),C1);
			 }
			 String c = stringtest.substring(0,taille);
			 return c;
		 }	
		 
			/* ******************************************************************
			***********************Bouton Création Magasin***********************/
		 
		 public JButton Magasin(){
			 return btnMag;
		 }
		 
		 private class Magasin implements ActionListener{
			 
			 @Override
				public void actionPerformed (ActionEvent e) {
				 
				}
		 }
		 

		 
			/* ******************************************************************
			***********************Bouton Prêt du Matériel***********************/
		 
		 public JButton Emprunt() {
			 return btnPret;
		 }
		 
		 private class Emprunt implements ActionListener{
			 
			 @Override
				public void actionPerformed (ActionEvent e) {
				 
				}
		 }
		 
			/* ******************************************************************
			********************Bouton Retour Emprunt****************************/
		 
		 public JButton RetourEmprunt() {
			 return btnRetour;
		 }
		 
		 private class RetourEmprunt implements ActionListener{
			 
			 @Override
				public void actionPerformed (ActionEvent e) {

				}
		 }
		 
			/* ******************************************************************
			********************Bouton Modification Personnel********************/
		 
		 public JButton getionPersonnel() {
			 return btnPersonnel;
		 }
		 
		 private class GestionPersonnel implements ActionListener{
			 
			
			 @Override
				public void actionPerformed (ActionEvent e) {
				 if (Person.isEmpty())
				 {
					 System.out.println("Vous ne pouvez pas modifier le personnel tant que vous n'avez pas charger celui-ci");
				 }
				 else
				 {
				 		Affichage1();
							System.out.println("Introduire le nom de la personne à modifier :");
							// On demande le nom de la personne à modifier
							String s = InputData.inputNomPrenom("Nom");
							Boolean loop = false;
							int indice = 0;
							while (!loop) {
								for (int CompteurList=0;CompteurList<Person.size();CompteurList++){
									if (Person.get(CompteurList).getNom().equals(s)){
										loop = true;
									    indice = CompteurList;
									}
								}
								if (!loop) {
									System.out.println("Il n'existe personne ayant ce nom. Veuillez entrer un nom correct existant");
									s = InputData.inputNomPrenom("Nom");
								}
							}
							Personnel Pers = Person.get(indice);
							System.out.println(Pers.getIdPersonnel()+"   "+Pers.getNom()+" -- "+Pers.getPrenom()+" -- "+Pers.getSexe()+" -- "+Pers.getEmail()+" -- "+Pers.getDepartement());
							System.out.println("Introduire les nouvelles valeurs :");
							// On Demande le Nom
							Pers.setNom(InputData.inputNomPrenom("Nom"));
							// On Demande le Prénom
							Pers.setPrenom(InputData.inputNomPrenom("Prénom"));
							// On Demande l'adresse mail
							Pers.setEmail(InputData.inputEmail());
							
							}
			 			}
			 }
		 
		 
			/* ******************************************************************
			*************************Bouton Sauvegarde***************************/
		 
		 public JButton Sauvegarder() {
			 
			 return btnSauvegarde;
			 
		 }
		 
		 private class Sauvegarde implements ActionListener{
			 
			 @Override
				public void actionPerformed (ActionEvent e) {
			
				}
		 }
		 
			/* ******************************************************************
			***************************Bouton Fermeture**************************/
		 
		 public JButton Close() {
			 
			 return btnClose; 
		 }
		 
		 private class Close implements ActionListener{
			 
			 @Override
				public void actionPerformed (ActionEvent e) {
				 System.exit(0);
				}
			 
	
		 
		
		
	}

}
