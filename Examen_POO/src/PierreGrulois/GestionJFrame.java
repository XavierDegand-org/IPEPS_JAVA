package PierreGrulois;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GestionJFrame extends JFrame {
	
 	 private static final long serialVersionUID = 1L;
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
			 System.exit(0);
			}
	 }
	 
	 /**************************************************
	  ************Boutton création du magasin***********
	  **************************************************/
	 
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
			 System.exit(0);
			}
	 }

	 public void setFixedLenght() {
		 
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
	
