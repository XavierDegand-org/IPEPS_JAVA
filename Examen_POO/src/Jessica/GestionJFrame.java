package Jessica;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionJFrame extends JFrame {
	
	 private JButton btnLoad = new JButton( "Chargement du personnel" );
	 private JButton btnAffichage = new JButton( "Affichage liste du personnel" );
	 private JButton btnMag = new JButton( "Création du magasin" );
	 private JButton btnPret = new JButton( "Prêt de matériel" );
	 private JButton btnRetour = new JButton( "Retour de matériel" );
	 private JButton btnPersonnel = new JButton( "Modification données personnel" );
	 private JButton btnSauvegarde = new JButton( "Sauvegarde" );
	 private JButton btnClose = new JButton( "Fermer" );
	 
	public GestionJFrame() {
		
		//***************************** PARTIE BOUTONS *****************************//
		
		super( "Gestion personnel & Prêt matériel" );
		this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
     
		JPanel contentPane = (JPanel) this.getContentPane();
		// GridLayout pour afficher 3 boutons sur 3 lignes
		contentPane.setLayout (new GridLayout(3,3));
		
		contentPane.add( btnLoad );
		contentPane.add( btnAffichage );
		contentPane.add( btnMag );
		contentPane.add( btnPret );
		contentPane.add( btnRetour );
		contentPane.add( btnPersonnel );
		contentPane.add( btnSauvegarde );
		contentPane.add( btnClose );
		
		btnLoad.addActionListener(new LoadPersonnel());
		btnAffichage.addActionListener(new Affichage());
		btnMag.addActionListener(new Magasin());
		btnPret.addActionListener(new Emprunt());
		btnRetour.addActionListener(new RetourEmprunt());
		btnPersonnel.addActionListener(new GestionPersonnel());
		btnSauvegarde.addActionListener(new Sauvegarde());
		btnClose.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed (ActionEvent e) {
					System.exit(0);
				}
			});
     
		this.setSize( 600, 300 );
		this.setLocationRelativeTo( null );
	}
	
	//***************************** PARTIE LOAD *****************************//
	
	public JButton getBtnLoad() {
	        return btnLoad;
	     }
	
	private class LoadPersonnel implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			try{
				ArrayList<Personnel> Person = new ArrayList<>();
				
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

					//pour d'abord tester si liste bien chargée/créée, ira ensuite dans "affichage"
					for(Personnel Pers : Person) {
						System.out.println(Pers);
					}
					
				}
				catch (NullPointerException err) {
					err.printStackTrace(); //- if the given pattern is null
				}
				catch (IllegalArgumentException err) {
					err.printStackTrace(); //- if the given pattern is invalid)
				}
		}
		
	}
	
	//***************************** PARTIE AFFICHAGE *****************************//
	
	public JButton getBtnAffichage() {
        return btnAffichage;
        }
	
	private class Affichage implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			System.out.println("+---------------------+-----------------------+----------------------+------------+----------------+---------------------+");
			System.out.println("| Département         | Prénom                | Nom                  | Sexe       | Naissance      | Email               |");
			System.out.println("+---------------------+-----------------------+----------------------+------------+----------------+---------------------+");
		}
		
	}
	
	//***************************** PARTIE MAGASIN *****************************//
	
	public JButton getBtnMag() {
        return btnMag;
        }
	
	private class Magasin implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			System.out.println("test");
		}
		
	}
	
	//***************************** PARTIE PRÊT *****************************//
	
	public JButton getBtnPret() {
        return btnPret;
        }
	
	private class Emprunt implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			System.out.println("test");
		}
		
	}
	
	//***************************** PARTIE RETOUR *****************************//
	
	public JButton getBtnRetour() {
        return btnRetour;
        }
	
	private class RetourEmprunt implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			System.out.println("test");
		}
		
	}
	
	//***************************** PARTIE MODIFICATION PERSONNEL *****************************//
	
	public JButton getBtnPersonnel() {
        return btnPersonnel;
        }
	
	private class GestionPersonnel implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			System.out.println("test");
		}
		
	}
	
	//***************************** PARTIE SAUVEGARDE *****************************//
	
	public JButton getBtnSauvegarde() {
        return btnSauvegarde;
        }
	
	private class Sauvegarde implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			System.out.println("test");
		}
		
	}
	
	//***************************** PARTIE FERMER *****************************//
	
	public JButton getBtnClose() {
        return btnClose;
        }

	
}