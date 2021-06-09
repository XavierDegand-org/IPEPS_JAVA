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
		
		 Person.add(new Personnel("Collon","Albert",Sexe.HOMME,new MyDate(10,8,1990),"Collon.a@test.be",Departement.HR));
		 Person.add(new Personnel("Peeters","Marie",Sexe.FEMME,new MyDate(1,5,1995),"Peeters_M@@test.be",Departement.HR));
		 Person.add(new Personnel("Janssens","Sarah",Sexe.FEMME,new MyDate(23,5,1999),"Sarah.Janssens@test",Departement.Compta));
		 Person.add(new Personnel("Maes","Henri",Sexe.HOMME,new MyDate(14,9,2009),"MaesHenri#test.be",Departement.Compta));
		 Person.add(new Personnel("Jacobs","Charles",Sexe.HOMME,new MyDate(10,8,1990),"Charles.j#test.be",Departement.SEC));
		 Person.add(new Personnel("Mertens","Floriane",Sexe.FEMME,new MyDate(20,8,1996),"FloFlo.M@test.be",Departement.SEC));
		 Person.add(new Personnel("Willems","Francois-Xavier",Sexe.HOMME,new MyDate(28,10,1996),"Willems.F-X@test.be",Departement.Prod));
		 Person.add(new Personnel("O'Neil","Shan",Sexe.HOMME,new MyDate(01,07,2001),"ONeil.sh@test.be",Departement.Prod));
		 Person.add(new Personnel("Goossen","Stéphanie",Sexe.FEMME,new MyDate(25,10,2008),"NieNieG@test.be",Departement.HR));
		 Person.add(new Personnel("Dumont","Charles",Sexe.HOMME,new MyDate(01,04,1969),"dumont.c@test.be",Departement.HR));
		 Person.add(new Personnel("Van Moore","Wilfrid",Sexe.HOMME,new MyDate(25,02,1998),"vanmoore.w@test.te",Departement.Compta));
		 Person.add(new Personnel("Herman","Nathalie",Sexe.FEMME,new MyDate(26,07,2001),"herman.n@test,be",Departement.Prod));
		 Person.add(new Personnel("Bontemps","Annie",Sexe.FEMME,new MyDate(23,9,1998),"bontemps.a@test.be",Departement.Prod));
		}
	
	public static String setFixedLength(String s) {
		StringBuilder ss = new StringBuilder(s);
		while(ss.length() < tailleNom) {
			String d =" ";
			char c1 = d.charAt(0);
			ss.insert(s.length(),c1);
		}
		String c = ss.substring(0,tailleNom);
		return c;
	}
	public static void Affichage() {
		if(Person.size() ==0) {
			System.out.println("Affichage impossible, pas de personnel !");
		}
		else {
			System.out.println("+----------------------------+-----------------------------+-----------------------------+-----------------------------+-----------------------------+-----------------------------+");
			System.out.println("| Département                | Prénom                      | Nom                         | Sexe                        | Naissance                   | Email                       |");
			System.out.println("+----------------------------+-----------------------------+-----------------------------+-----------------------------+-----------------------------+-----------------------------+");
			StringBuilder sb = new StringBuilder();
			for (int temp = 0; temp < Person.size();temp++) {
				sb.append(" ");
				sb.append(setFixedLength(Person.get(temp).getDepartement()));
				sb.append(setFixedLength(Person.get(temp).getPrenom()));
				sb.append(setFixedLength(Person.get(temp).getNom()));		
				sb.append(setFixedLength(Person.get(temp).getSexe()));
				sb.append(setFixedLength(Person.get(temp).getDateddMMyyyy()));
				sb.append(setFixedLength(Person.get(temp).getEmail()));
				sb.append("\n");
				
				}	
			System.out.println(sb.toString());
			}
		}


}
	 

