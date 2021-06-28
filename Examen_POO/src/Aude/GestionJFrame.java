package Aude;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import javax.swing.JButton;

public class GestionJFrame extends JFrame implements ActionListener {
	
	private static ArrayList<Personnel> Person = new ArrayList<Personnel>();
	private Magasin mag =  new Magasin();
	
	// --- Cr�ation des boutons ---- 
	private JButton btnLoad = new JButton( "Chargement du personnel" );
	private JButton btnAffichage = new JButton( "Affichage liste du personnel" );
	private JButton btnMag = new JButton( "Cr�ation du magasin" );
	private JButton btnPret = new JButton( "Pr�t de mat�riel" );
	private JButton btnRetour = new JButton( "Retour de mat�riel" );
	private JButton btnPersonnel = new JButton( "Modification donn�es personnel" );
	private JButton btnSauvegarde = new JButton( "Sauvegarde" );
	private JButton btnClose = new JButton( "Fermer" );
	
	public GestionJFrame() {
		
		super("Gestion du Personnel et pr�t du mat�riel");
		
		this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );  // ferme le programme lorsque la fen�tre se ferme 
		
		JPanel contentPane = (JPanel) this.getContentPane(); 
		
		// ------ Ajout des boutons au panneau d'affichage------
		try {
			contentPane.add( btnLoad );
			contentPane.add( btnAffichage );
			contentPane.add( btnMag );
			contentPane.add( btnPret );
			contentPane.add( btnRetour );
			contentPane.add( btnPersonnel );
			contentPane.add( btnSauvegarde );
			contentPane.add( btnClose );
			}catch(NullPointerException e) {
				System.out.println("Il n'y a pas de contenu");
			}
		
		btnLoad.addActionListener(new LoadPersonnel());
		btnAffichage.addActionListener(new Affichage());
		btnMag.addActionListener(new magasin());
		btnPret.addActionListener(new Emprunt());
		btnRetour.addActionListener(new RetourEmprunt());
		btnPersonnel.addActionListener(this);
		btnSauvegarde.addActionListener(this);
		btnClose.addActionListener(e -> System.exit(0));
		
		// ---D�finition de l'emplacement et de la taille des boutons //
		
		contentPane.setLayout(null);      
		btnLoad.setBounds(2, 2, 250, 150);   
		btnAffichage.setBounds(254, 2, 250, 150);
		btnMag.setBounds(506, 2, 250, 150);
		btnPret.setBounds(2, 154, 250, 150);
		btnRetour.setBounds(254, 154, 250, 150);
		btnPersonnel.setBounds(506, 154, 250, 150);
		btnSauvegarde.setBounds(2, 306, 250, 150);
		btnClose.setBounds(254, 306, 250, 150);
		
		this.setSize( 775, 496 );
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	//------ Cr�ation du bouton chargement du personnel------// 
	public JButton LoadPersonnel() {
		return btnPersonnel;
	}
	
	private class LoadPersonnel implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
			 
			 Person.add(new Personnel("Collon","Albert",Sexe.HOMME, new MyDate(10, 8, 1990), "Collon.a@test.be",Departement.HR));
			 Person.add(new Personnel("Peeters","Marie",Sexe.FEMME, new MyDate(01, 5, 1985), "Peeters_M@@test.be", Departement.HR));	
			 Person.add(new Personnel("Janssens","Sarah",Sexe.FEMME, new MyDate(23, 5, 1999), "Sarah.Janssens@test",Departement.Compta));
			 Person.add(new Personnel("Maes","Henri",Sexe.HOMME, new MyDate(14, 9, 2009), "MaesHenri#test.be",Departement.Compta));
			 Person.add(new Personnel("Jacobs","Charles",Sexe.HOMME, new MyDate(12, 12, 2009), "Charles.j#test.be",Departement.SEC));
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

	//------ Cr�ation du bouton pour afficher le listing du personnel ------// 
	
	public JButton Affichage() {
		 return btnAffichage;
	 }
	
	private class Affichage implements ActionListener{
		@Override
		public void actionPerformed (ActionEvent e) {
			
			if (Person.size() < 1) {
				System.out.println("Une erreur est survenue lors de l'affichage du personnel");
			}else {
				 System.out.println("+-------------------+-------------------+-------------------+-------------------+-------------------+---------------------+");
				 System.out.println("| D�partement       | Pr�nom            | Nom               | Sexe              | Naissance         | Email               |");
				 System.out.println("+-------------------+-------------------+-------------------+-------------------+-------------------+---------------------+");
				 
				StringBuilder stringBuilder = new StringBuilder(); 
				
				for(int compteurListePerson=0 ; compteurListePerson<Person.size(); compteurListePerson++) {
					stringBuilder.append(setFixedLenght("  "+Person.get(compteurListePerson).getDepartement()));
					stringBuilder.append(setFixedLenght("  "+Person.get(compteurListePerson).getPrenom()));
					stringBuilder.append(setFixedLenght("  "+Person.get(compteurListePerson).getNom()));
					stringBuilder.append(setFixedLenght("  "+Person.get(compteurListePerson).getSexe()));
					stringBuilder.append(setFixedLenght("  "+Person.get(compteurListePerson).getDateddMMyyyy()));
					stringBuilder.append(setFixedLenght("  "+Person.get(compteurListePerson).getEmail()));
					stringBuilder.append("\n");
				}
				
				System.out.println(stringBuilder);
				 
			}
		}
		
	}
	
	// ------ Cr�ation d'une fonction permettant d'imposer le nombre de 20 caract�res aux �l�ments du tableau � afficher 
	// ------ Un caract�re blanc sera ajout� tant que les 20 caract�res ne seront pas atteints 
	
	static String setFixedLenght(String element) {  
		 
		 StringBuilder ss= new StringBuilder(element);
	        while (ss.length() < 20) {  
	                String d = " ";
	                char c1 = d.charAt(0);
	                ss.insert(element.length(),c1);
	            }
	        String c = ss.substring(0, 20);
	        return c;
		 
	 } 
	
	
	
	//------ Cr�ation du bouton magasin------// 
	
	public JButton Magasin(){
		 return btnMag;
	 }
	 
	 private class magasin implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
			 // --- import des �l�ments dans le magasin
			 if (mag.isEmpty()){
				 
					mag.AjouterProduit(1,"HP","Elitebook 850 G7");
					mag.AjouterProduit(2,"HP","Elitebook 830 G7 X360");
					mag.AjouterProduit(3,"Dell","Inspiron 15 3000");
					mag.AjouterProduit(4,"Dell","XPS 13");
					mag.AjouterProduit(5,"Dell","XPS 15");
					mag.AjouterProduit(6,"Lenovo","Thinkpad E15 G2");
					mag.AjouterProduit(7,"Lenovo","IdeaPad 3 14IIL05 81WD00B2MH");
					mag.ListeMap();
					//System.out.println(mag.getProduit(1));
				
			 }
			 else {
				 System.out.println("Le magasin a d�j� �t� charg�");
			 }
			 	
			 
			}
			
	 }
	 
	//------ Cr�ation du bouton emprunt du mat�riel ------// 
	 
	 public JButton Emprunt() {
		 return btnPret;
	 }
	 
	 private class Emprunt implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
			 
			}
	 }
		
	//------ Cr�ation du bouton de retour d'un article ------// 
	 
	 public JButton RetourEmprunt() {
		 return btnRetour;
	 }
	 
	 private class RetourEmprunt implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
			 
			}
	 }
	 
	//------ Cr�ation du bouton de fermeture de la fen�tre ------//
	 
	 /*public JButton Fermer() {		//--- n'est pas n�cessaire 
		 return btnClose;
	 }*/
	 
}
