package NathanaëlDuyck;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GestionJFrame extends JFrame {
	 
	 private JButton btnLoad = new JButton( "Chargement du personnel" );
	 private JButton btnAffichage = new JButton( "Affichage liste du  personnel" );
	 private JButton btnMag = new JButton( "Création du magasin" );
	 private JButton btnPret = new JButton( "Prêt de matériel" );
	 private JButton btnRetour = new JButton( "Retour de matériel" );
	 private JButton btnPersonnel = new JButton( "Modification données Personnel" );
	 private JButton btnSauvegarde = new JButton( "Sauvegarde" );
	 private JButton btnClose = new JButton( "Fermer" );
	 
	 private static String nom;
	 private static String fichier;
	 private static int tailleNom = 30;
	
	 private static ArrayList<Personnel> Person = new ArrayList<>();
	 
	 public GestionJFrame() {
		 super( "Gestion Personnel & prêt matériel" );
		 this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		 
		 JPanel contentPane = (JPanel) this.getContentPane();
		 contentPane.setLayout( new FlowLayout() );
		 contentPane.setLayout(null);
		 btnLoad.setBounds(10,20, 290, 150);
		 btnAffichage.setBounds(300,20, 290, 150);
		 btnMag.setBounds(590,20, 290, 150);
		 btnPret.setBounds(10,190,290,150);
		 btnRetour.setBounds(300,190, 290,150);
		 btnPersonnel.setBounds(590,190,290,150);
		 btnSauvegarde.setBounds(10,370,290,150);
		 btnClose.setBounds(300,370,290,150);
		 
		 contentPane.add( btnLoad );
		 contentPane.add( btnAffichage );
		 contentPane.add( btnMag );
		 contentPane.add( btnPret );
		 contentPane.add( btnRetour );
		 contentPane.add( btnPersonnel );
		 contentPane.add( btnSauvegarde );
		 contentPane.add( btnClose );
		 
		 MyDate DateNaissanceCollon = new MyDate(10,8,1990);
		 Personnel Collon = new Personnel("Collon","Albert",Sexe.HOMME,DateNaissanceCollon,"Collon.a@test.be",Departement.HR);
		 MyDate DateNaissancePeeters = new MyDate(1,5,1995);
		 Personnel Peeters = new Personnel("Peeters","Marie",Sexe.FEMME,DateNaissancePeeters,"Peeters_M@@test.be",Departement.HR);
		 MyDate DateNaissanceJanssens = new MyDate(23,5,1999);
		 Personnel Janssens = new Personnel("Janssens","Sarah",Sexe.FEMME,DateNaissanceJanssens,"Sarah.Janssens@test",Departement.Compta);
		 MyDate DateNaissanceMaes = new MyDate(14,9,2009);
		 Personnel Maes = new Personnel("Maes","Henri",Sexe.HOMME,DateNaissanceMaes,"MaesHenri#test.be",Departement.Compta);
		 MyDate DateNaissanceJacobs = new MyDate(10,8,1990);
		 Personnel Jacobs = new Personnel("Jacobs","Charles",Sexe.HOMME,DateNaissanceJacobs,"Charles.j#test.be",Departement.SEC);
		 MyDate DateNaissanceMertens = new MyDate(20,8,1996);
		 Personnel Mertens = new Personnel("Mertens","Floriane",Sexe.FEMME,DateNaissanceMertens,"FloFlo.M@test.be",Departement.SEC);
		 MyDate DateNaissanceWillems = new MyDate(28,10,1996);
		 Personnel Willems = new Personnel("Willems","Francois-Xavier",Sexe.HOMME,DateNaissanceWillems,"Willems.F-X@test.be",Departement.Prod);
		 MyDate DateNaissanceONeil = new MyDate(01,07,2001);
		 Personnel ONeil = new Personnel("O'Neil","Shan",Sexe.HOMME,DateNaissanceONeil,"ONeil.sh@test.be",Departement.Prod);
		 MyDate DateNaissanceGoossen= new MyDate(25,10,2008);
		 Personnel Goossen = new Personnel("Goossen","Stéphanie",Sexe.FEMME,DateNaissanceGoossen,"NieNieG@test.be",Departement.HR);
		 MyDate DateNaissanceDumont = new MyDate(01,04,1969);
		 Personnel Dumont = new Personnel("Dumont","Charles",Sexe.HOMME,DateNaissanceDumont,"dumont.c@test.be",Departement.HR);
		 MyDate DateNaissanceVanMoore = new MyDate(25,02,1998);
		 Personnel VanMoore = new Personnel("Moore","Wilfrid",Sexe.HOMME,DateNaissanceVanMoore,"vanmoore.w@test.te",Departement.Compta);
		 MyDate DateNaissanceHerman = new MyDate(26,07,2001);
		 Personnel Herman = new Personnel("Herman","Nathalie",Sexe.FEMME,DateNaissanceHerman,"herman.n@test,be",Departement.Prod);
		 MyDate DateNaissanceBontemps = new MyDate(23,9,1998);
		 Personnel Bontemps = new Personnel("Bontemps","Annie",Sexe.FEMME,DateNaissanceBontemps,"bontemps.a@test.be",Departement.Prod);
		 
		 btnLoad.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				LoadPersonnel();
			} 
		 });
		 
		 btnAffichage.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					if(Person.size() ==0) {
						System.out.println("Affichage impossible, pas de personnel !");
					}
					else {
						System.out.println("+--------------------+--------------+--------------+--------+---------------+---------------------+");
						System.out.println("| Département        | Prénom       | Nom          | Sexe   | Naissance     | Email               |");
						System.out.println("+--------------------+--------------+--------------+--------+---------------+---------------------+");
						
						for (Personnel personnel : Person) {
							
							System.out.println(personnel.toString());
						}
							
						}
					}
				
		 });
		 
		 btnMag.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Magasin");		
				} 
		 }); 
		 
		 btnPret.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Prêt");		
				} 
		 });
		 
		 btnRetour.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Retour");		
				} 
		 });
		 
		 btnPersonnel.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Personnel");		
				} 
		 });
		 
		 btnSauvegarde.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Sauvegarde");		
				} 
		 });
		 
		 btnClose.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					 System.exit(0);		
				} 
		 });
		 
		 this.setSize( 900 , 600 );
		 this.setLocationRelativeTo( null );
	 }
	 
	

	public static void setTailleNom(int tailleNom) {
		GestionJFrame.tailleNom = tailleNom;
	}

	public JButton getBtnLoad() {
		return btnLoad;
	}

	public JButton getBtnAffichage() {
		return btnAffichage;
	}

	public JButton getBtnMag() {
		return btnMag;
	}

	public JButton getBtnPret() {
		return btnPret;
	}

	public JButton getBtnRetour() {
		return btnRetour;
	}

	public JButton getBtnPersonnel() {
		return btnPersonnel;
	}

	public JButton getBtnSauvegarde() {
		return btnSauvegarde;
	}

	public JButton getBtnClose() {
		return btnClose;
	}

	public static String getNom() {
		return nom;
	}

	public static String getFichier() {
		return fichier;
	}

	public static ArrayList<Personnel> getPerson() {
		return Person;
	}

	public static void LoadPersonnel() {
			
		 MyDate DateNaissanceCollon = new MyDate(10,8,1990);
		 Personnel Collon = new Personnel("Collon","Albert",Sexe.HOMME,DateNaissanceCollon,"Collon.a@test.be",Departement.HR);
		 MyDate DateNaissancePeeters = new MyDate(1,5,1995);
		 Personnel Peeters = new Personnel("Peeters","Marie",Sexe.FEMME,DateNaissancePeeters,"Peeters_M@@test.be",Departement.HR);
		 MyDate DateNaissanceJanssens = new MyDate(23,5,1999);
		 Personnel Janssens = new Personnel("Janssens","Sarah",Sexe.FEMME,DateNaissanceJanssens,"Sarah.Janssens@test",Departement.Compta);
		 MyDate DateNaissanceMaes = new MyDate(14,9,2009);
		 Personnel Maes = new Personnel("Maes","Henri",Sexe.HOMME,DateNaissanceMaes,"MaesHenri#test.be",Departement.Compta);
		 MyDate DateNaissanceJacobs = new MyDate(10,8,1990);
		 Personnel Jacobs = new Personnel("Jacobs","Charles",Sexe.HOMME,DateNaissanceJacobs,"Charles.j#test.be",Departement.SEC);
		 MyDate DateNaissanceMertens = new MyDate(20,8,1996);
		 Personnel Mertens = new Personnel("Mertens","Floriane",Sexe.FEMME,DateNaissanceMertens,"FloFlo.M@test.be",Departement.SEC);
		 MyDate DateNaissanceWillems = new MyDate(28,10,1996);
		 Personnel Willems = new Personnel("Willems","Francois-Xavier",Sexe.HOMME,DateNaissanceWillems,"Willems.F-X@test.be",Departement.Prod);
		 MyDate DateNaissanceONeil = new MyDate(01,07,2001);
		 Personnel ONeil = new Personnel("O'Neil","Shan",Sexe.HOMME,DateNaissanceONeil,"ONeil.sh@test.be",Departement.Prod);
		 MyDate DateNaissanceGoossen= new MyDate(25,10,2008);
		 Personnel Goossen = new Personnel("Goossen","Stéphanie",Sexe.FEMME,DateNaissanceGoossen,"NieNieG@test.be",Departement.HR);
		 MyDate DateNaissanceDumont = new MyDate(01,04,1969);
		 Personnel Dumont = new Personnel("Dumont","Charles",Sexe.HOMME,DateNaissanceDumont,"dumont.c@test.be",Departement.HR);
		 MyDate DateNaissanceVanMoore = new MyDate(25,02,1998);
		 Personnel VanMoore = new Personnel("Moore","Wilfrid",Sexe.HOMME,DateNaissanceVanMoore,"vanmoore.w@test.te",Departement.Compta);
		 MyDate DateNaissanceHerman = new MyDate(26,07,2001);
		 Personnel Herman = new Personnel("Herman","Nathalie",Sexe.FEMME,DateNaissanceHerman,"herman.n@test,be",Departement.Prod);
		 MyDate DateNaissanceBontemps = new MyDate(23,9,1998);
		 Personnel Bontemps = new Personnel("Bontemps","Annie",Sexe.FEMME,DateNaissanceBontemps,"bontemps.a@test.be",Departement.Prod);
		 Person.add(Collon);
		 Person.add(Peeters);
		 Person.add(Janssens);
		 Person.add(Maes);
		 Person.add(Jacobs);
		 Person.add(Mertens);
		 Person.add(Mertens);
		 Person.add(Willems);
		 Person.add(ONeil);
		 Person.add(Goossen);
		 Person.add(Dumont);
		 Person.add(VanMoore);
		 Person.add(Herman);
		 Person.add(Bontemps);
		}
		 	 
	 }
	 

