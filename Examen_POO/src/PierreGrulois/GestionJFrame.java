package PierreGrulois;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GestionJFrame extends JFrame {
	
	
	private static final long serialVersionUID = 8342878258434229124L;
	private static ArrayList<Personnel> Pers = new ArrayList<Personnel>();
	private int listeCharger = 0;
	
	 private JButton btnLoad = new JButton( "Chargement du personnel" );  // Création et texte des bouttons
	 private JButton btnAffichage = new JButton( "Affichage liste du personnel" );
	 private JButton btnMag = new JButton( "Création du magasin" );
	 private JButton btnPret = new JButton( "Pret de matériel" );
	 private JButton btnRetour = new JButton( "Retour de matériel" );
	 private JButton btnPersonnel = new JButton( "Modification données personel" );
	 private JButton btnSauvegarde = new JButton( "Sauvgarde" );
	 private JButton btnClose = new JButton( "Fermer" );
	 
	 public GestionJFrame() {

			this.setDefaultCloseOperation( DISPOSE_ON_CLOSE ); // afin de fermer le programme losrqu'on ferme la fenêtre
			
			JPanel contentPane = (JPanel) this.getContentPane();
			
			contentPane.setLayout(null);      
			btnLoad.setBounds(2, 2, 250, 150);   // Emplacement et taille des bouttons 
			btnAffichage.setBounds(254, 2, 250, 150);
			btnMag.setBounds(506, 2, 250, 150);
			btnPret.setBounds(2, 154, 250, 150);
			btnRetour.setBounds(254, 154, 250, 150);
			btnPersonnel.setBounds(506, 154, 250, 150);
			btnSauvegarde.setBounds(2, 306, 250, 150);
			btnClose.setBounds(254, 306, 250, 150);
			
			try{
				contentPane.add( btnLoad );
				contentPane.add( btnAffichage );
				contentPane.add( btnMag );
				contentPane.add( btnPret );
				contentPane.add( btnRetour );
				contentPane.add( btnPersonnel );
				contentPane.add( btnSauvegarde );
				contentPane.add( btnClose );
				}catch(NullPointerException e) {
					System.out.println("Le contenu est nul");
				}
			
			btnLoad.addActionListener(new LoadPersonnel());
			btnAffichage.addActionListener(new Affichage());
			btnMag.addActionListener(new Magasin());
			btnPret.addActionListener(new Emprunt());
			btnRetour.addActionListener(new RetourEmprunt());
			btnPersonnel.addActionListener(new GestionPersonnel());
			btnSauvegarde.addActionListener(new Sauvegarde());
			btnClose.addActionListener(new Close());
				
			this.setSize( 775, 496 );
	 }

	 public void getnombre() {
		 
		  
		 
	 }
	 
	 /**************************************************
	  ************Boutton chargement Personnel**********
	  **************************************************/
	 
	 public JButton LoadPersonnel() {
		 return btnPersonnel;
	 }
	 
	 private class LoadPersonnel implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
			 
			 
			 
			 Pers.add(new Personnel("Collon","Albert",Sexe.HOMME, new MyDate(10, 8, 1990), "Collon.a@test.be",Departement.HR));
			 Pers.add(new Personnel("Peeters","Marie",Sexe.FEMME, new MyDate(01, 5, 1985), "Peeters_M@@test.be", Departement.HR));	
			 Pers.add(new Personnel("Janssens","Sarah",Sexe.FEMME, new MyDate(23, 5, 1999), "Sarah.Janssens@test",Departement.Compta));
			 Pers.add(new Personnel("Maes","Henri",Sexe.HOMME, new MyDate(14, 9, 2009), "MaesHenri#test.be",Departement.Compta));
			 Pers.add(new Personnel("Jacobs","Charles",Sexe.HOMME, new MyDate(12, 12, 2009), "Charles.j#test.be",Departement.SEC));
			 Pers.add(new Personnel("Mertens","Floriane",Sexe.FEMME, new MyDate(20, 8, 1996), "FloFlo.M@test.be",Departement.SEC));
			 Pers.add(new Personnel("Willems","Francois-Xavier",Sexe.HOMME, new MyDate(28, 10, 1996), "Willems.F-X@test.be", Departement.Prod));
			 Pers.add(new Personnel("O'Neil","Shan",Sexe.HOMME, new MyDate(1, 7, 2001), "ONeil.sh@test.be",Departement.Prod));
			 Pers.add(new Personnel("Goossen","Stéphanie",Sexe.FEMME, new MyDate(25, 10, 2008), "NieNieG@test.be",Departement.HR));
			 Pers.add(new Personnel("Dumont","Charles",Sexe.HOMME, new MyDate(1, 4, 1969), "dumont.c@test.be",Departement.HR));
			 Pers.add(new Personnel("Van Moore","Wilfrid",Sexe.HOMME,new MyDate(25, 2, 1998), "vanmoore.w@test.te",Departement.Compta));
			 Pers.add(new Personnel("Herman","Nathalie",Sexe.FEMME, new MyDate(26, 7, 2001), "herman.n@test,be",Departement.Prod));
			 Pers.add(new Personnel("Bontemps","Annie",Sexe.FEMME, new MyDate(23,9,1998), "bontemps.a@test.be",Departement.Prod));
			 listeCharger = 1;
		 }
	 }
	 
	 /*************************************************
	  ************Boutton création du magasin**********
	  *************************************************/
	 
	 public JButton Magasin(){
		 return btnMag;
	 }
	 
	 private class Magasin implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
			 System.exit(0);
			}
	 }
	 
	 /*************************************************
	  ************Boutton affichage personnel**********
	  *************************************************/
	 
	 public JButton Affichage() {
		 return btnAffichage;
	 }
	 
	 private class Affichage implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
			 
			 switch (listeCharger) {
			 
			 case 0:
				 System.out.println("Veuillez charger la liste du personnel pour effectuer cette action! ");
				 break;
			 case 1:
				 System.out.println("+-------------------+-------------------+-------------------+-------------------+-------------------+---------------------+");
				 System.out.println("| Département       | Prénom            | Nom               | Sexe              | Naissance         | Email               |");
				 System.out.println("+-------------------+-------------------+-------------------+-------------------+-------------------+---------------------+");
				 StringBuilder Afficher = new StringBuilder();
				 for(int cpt=0 ; cpt<Pers.size(); cpt++) {
					 
					 Afficher.append(setFixedLenght(Pers.get(cpt).getDepartement()));
					 Afficher.append(setFixedLenght(Pers.get(cpt).getPrenom()));
					 Afficher.append(setFixedLenght(Pers.get(cpt).getNom()));
					 Afficher.append(setFixedLenght(Pers.get(cpt).getSexe()));
					 Afficher.append(setFixedLenght(Pers.get(cpt).getDateddMMyyyy()));
					 Afficher.append(setFixedLenght(Pers.get(cpt).getEmail()));
					 Afficher.append("\n");
					 
				 }
				 System.out.println(Afficher.toString());
				 
				}
			 
			 }
			 
	 }

	 static String setFixedLenght(String element) {  //fonction permettant de calibrer la taille des strings à 20 caractères
		 
		 StringBuilder ss= new StringBuilder(element);
	        while (ss.length() < 20) {  
	                String d = " ";
	                char c1 = d.charAt(0);
	                ss.insert(element.length(),c1);
	            }
	        String c = ss.substring(0, 20);
	        return c;
		 
	 } 
	 
	 /**********************************************
	  ************Boutton pret de materiel**********
	  **********************************************/
	 
	 public JButton Emprunt() {
		 return btnPret;
	 }
	 
	 private class Emprunt implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
			 System.exit(0);
			}
	 }
	 
	 /********************************************
	  ************boutton retour article**********
	  ********************************************/
	 
	 public JButton RetourEmprunt() {
		 return btnRetour;
	 }
	 
	 private class RetourEmprunt implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
			 System.exit(0);
			}
	 }
	 
	 /****************************************************
	  ******** Boutton de modification du personnel ******
	  ****************************************************/
	 
	 public JButton getionPersonnel() {
		 return btnPersonnel;
	 }
	 
	 private class GestionPersonnel implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
			 System.exit(0);
			}
	 }
	 
	 /***************************************************
	  ************ Boutton de Sauvegarde  ***************
	  ***************************************************/
	 
	 public JButton Sauvegarder() {
		 
		 return btnSauvegarde;
		 
	 }
	 
	 private class Sauvegarde implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
			 System.exit(0);
			}
	 }
	 
	 /******************************************
	  *********** Boutton fermer ***************
	  *****************************************/
	 
	 public JButton Close() {
		 
		 return btnClose; 
	 }
	 
	 private class Close implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
				try{
					System.exit(0);  // forums.commentcamarche.net/forum/affich-3383988-java-fermer-une-fenetre-avec-un-jbutton
				}catch(SecurityException e1){
					System.out.println("Un gestionnaire de sécurité existe et sa méthode checkExixt n'autorise pas la sortie avec l'état spécifié.");
				}
			}
	 }
	 
}
	
