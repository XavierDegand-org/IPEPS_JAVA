package Jessica;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
	 
	// arraylist personnel accessible à toute la classe
	private static ArrayList<Personnel> Person = new ArrayList<>();
					
	Personnel Collon = new Personnel("Collon","Albert",Sexe.HOMME, new MyDate(10, 8, 1990), "Collon.a@test.be",Departement.HR);
	Personnel Peeters = new Personnel("Peeters","Marie",Sexe.FEMME, new MyDate(01, 5, 1985), "Peeters_M@@test.be", Departement.HR);
	Personnel Janssens = new Personnel("Janssens","Sarah",Sexe.FEMME, new MyDate(23, 5, 1999), "Sarah.Janssens@test",Departement.Compta);
	Personnel Maes = new Personnel("Maes","Henri",Sexe.HOMME, new MyDate(14, 9, 2009), "MaesHenri#test.be",Departement.Compta);
	Personnel Jacobs = new Personnel("Jacobs","Charles",Sexe.HOMME, new MyDate(12, 12, 2009), "Charles.j#test.be",Departement.SEC);
	Personnel Mertens = new Personnel("Mertens","Floriane",Sexe.FEMME, new MyDate(20, 8, 1996), "FloFlo.M@test.be",Departement.SEC);
	Personnel Willems = new Personnel("Willems","Francois-Xavier",Sexe.HOMME, new MyDate(28, 10, 1996), "Willems.F-X@test.be", Departement.Prod);
	Personnel ONeil = new Personnel("O'Neil","Shan",Sexe.HOMME, new MyDate(1, 7, 2001), "ONeil.sh@test.be",Departement.Prod);
	Personnel Goossen = new Personnel("Goossen","Stéphanie",Sexe.FEMME, new MyDate(25, 10, 2008), "NieNieG@test.be",Departement.HR);
	Personnel Dumont = new Personnel("Dumont","Charles",Sexe.HOMME, new MyDate(1, 4, 1969), "dumont.c@test.be",Departement.HR);
	Personnel VanMoore = new Personnel("Van Moore","Wilfrid",Sexe.HOMME,new MyDate(25, 2, 1998), "vanmoore.w@test.te",Departement.Compta);
	Personnel Herman = new Personnel("Herman","Nathalie",Sexe.FEMME, new MyDate(26, 7, 2001), "herman.n@test,be",Departement.Prod);
	Personnel Bontemps = new Personnel("Bontemps","Annie",Sexe.FEMME, new MyDate(23,9,1998), "bontemps.a@test.be",Departement.Prod);
	
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
	
	public class LoadPersonnel implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {	
			
			// charger l'arraylist personnel
			try{
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
	
	public class Affichage implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			
			//si liste personnel est vide/strictement inférieure à 1
			if(Person.size() < 1) {
				System.out.println("Il n'y a aucun membre du personnel, affichage impossible.");
			}
			else {
			
			System.out.println("+---------------------+-----------------------+----------------------+------------+----------------+---------------------+");
			System.out.println("| Département         | Prénom                | Nom                  | Sexe       | Naissance      | Email               |");
			System.out.println("+---------------------+-----------------------+----------------------+------------+----------------+---------------------+");
			for(Personnel Pers : Person) {
				System.out.println(Pers);
			}
			}
			
		}
		
	}
	
	//***************************** PARTIE MAGASIN *****************************//
	
	public JButton getBtnMag() {
        return btnMag;
        }
	
	public class Magasin implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			System.out.println("test");
		}
		
	}
	
	//***************************** PARTIE PRÊT *****************************//
	
	public JButton getBtnPret() {
        return btnPret;
        }
	
	public class Emprunt implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			System.out.println("test");
		}
		
	}
	
	//***************************** PARTIE RETOUR *****************************//
	
	public JButton getBtnRetour() {
        return btnRetour;
        }
	
	public class RetourEmprunt implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			System.out.println("test");
		}
		
	}
	
	//***************************** PARTIE MODIFICATION PERSONNEL *****************************//
	
	public JButton getBtnPersonnel() {
        return btnPersonnel;
        }
	
	public class GestionPersonnel implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			System.out.println("test");
		}
		
	}
	
	//***************************** PARTIE SAUVEGARDE *****************************//
	
	public JButton getBtnSauvegarde() {
        return btnSauvegarde;
        }
	
	public class Sauvegarde implements ActionListener {
		
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