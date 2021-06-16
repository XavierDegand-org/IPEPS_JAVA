package Jessica;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
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
	 
	private static ArrayList<Personnel> Person = new ArrayList<>();
	private static HashMap<Integer,Produit> produits = new HashMap<>();
	
	private static int tailleNom = 30;
	
	//***************************** DEBUT GESTIONJFRAME *****************************//
					
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
		btnAffichage.addActionListener(new btnAffichageListener());
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
			Person.add(new Personnel("Collon","Albert",Sexe.HOMME, new MyDate(10, 8, 1990), "Collon.a@test.be",Departement.HR));
			Person.add(new Personnel("Collon","Albert",Sexe.HOMME, new MyDate(10, 8, 1990), "Collon.a@test.be",Departement.HR));
			Person.add(new Personnel("Peeters","Marie",Sexe.FEMME, new MyDate(01, 5, 1985), "Peeters_M@test.be", Departement.HR));
			Person.add(new Personnel("Janssens","Sarah",Sexe.FEMME, new MyDate(23, 5, 1999), "Sarah.Janssens@test",Departement.Compta));
			Person.add(new Personnel("Maes","Henri",Sexe.HOMME, new MyDate(14, 9, 2009), "MaesHenri@test.be",Departement.Compta));
			Person.add(new Personnel("Jacobs","Charles",Sexe.HOMME, new MyDate(12, 12, 2009), "Charles.j@test.be",Departement.SEC));
			Person.add(new Personnel("Mertens","Floriane",Sexe.FEMME, new MyDate(20, 8, 1996), "FloFlo.M@test.be",Departement.SEC));
			Person.add(new Personnel("Willems","Francois-Xavier",Sexe.HOMME, new MyDate(28, 10, 1996), "Willems.F-X@test.be", Departement.Prod));
			Person.add(new Personnel("O'Neil","Shan",Sexe.HOMME, new MyDate(1, 7, 2001), "ONeil.sh@test.be",Departement.Prod));
			Person.add(new Personnel("Goossen","Stéphanie",Sexe.FEMME, new MyDate(25, 10, 2008), "NieNieG@test.be",Departement.HR));
			Person.add(new Personnel("Dumont","Charles",Sexe.HOMME, new MyDate(1, 4, 1969), "dumont.c@test.be",Departement.HR));
			Person.add(new Personnel("Van Moore","Wilfrid",Sexe.HOMME,new MyDate(25, 2, 1998), "vanmoore.w@test.te",Departement.Compta));
			Person.add(new Personnel("Herman","Nathalie",Sexe.FEMME, new MyDate(26, 7, 2001), "herman.n@test,be",Departement.Prod));
			Person.add(new Personnel("Bontemps","Annie",Sexe.FEMME, new MyDate(23,9,1998), "bontemps.a@test.be",Departement.Prod));
			}
			catch (NullPointerException err) {
				err.printStackTrace(); //- if the given pattern is null
			}
			catch (IllegalArgumentException err) {
				err.printStackTrace(); //- if the given pattern is invalid)
			}
			System.out.println("Personnel bien chargé");
		
		}
	}
	
	//***************************** PARTIE AFFICHAGE *****************************//
	
	public JButton getBtnAffichage() {
        return btnAffichage;
        }
	
	public class btnAffichageListener implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			Affichage();
		}
	}
	
	//fonction permettant de calibrer la taille des strings
	public static String setFixedLength(String s){
		        StringBuilder ss = new StringBuilder(s);
		        // tant que la taille de ss est inférieure à 25 on ajoute un caractère blanc
		        while (ss.length() < 25) {
		                String d = " ";
		                char c1 = d.charAt(0);
		                ss.insert(s.length(),c1);
		            }
		        String c = ss.substring(0, 25);
		        return c;

		    }
	
	public static void Affichage() {
		//si liste personnel est vide/strictement inférieure à 1
		if(Person.size() < 1) {
			System.out.println("Affichage impossible, pas de personnel !");
		}
		else {
		System.out.println("+-----------------------+------------------------+------------------------+------------------------+------------------------+------------------------+");
		System.out.println("| Département           | Prénom                 | Nom                    | Sexe                   | Naissance              | Email                  |");
		System.out.println("+-----------------------+------------------------+------------------------+------------------------+------------------------+------------------------+");
		StringBuilder sb = new StringBuilder();
		    for (int temp = 0; temp < Person.size(); temp++) {
		    	sb.append(setFixedLength(Person.get(temp).getDepartement()));
		    	sb.append(setFixedLength(Person.get(temp).getPrenom()));
		    	sb.append(setFixedLength(Person.get(temp).getNom()));
		    	sb.append(setFixedLength(Person.get(temp).getSexe()));
		    	sb.append(setFixedLength(Person.get(temp).getDateddMMyyyy()));
		    	sb.append(setFixedLength(Person.get(temp).getEmail()));
                sb.append("\n");
		    		}		
		    // on affiche le contenu
		    System.out.println(sb.toString());
		    	}
	}
			
	
	//***************************** PARTIE MAGASIN *****************************//
	
	public JButton getBtnMag() {
        return btnMag;
        }
	
	public class Magasin implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
		
			Magasin mag = new Magasin();
			
			// charger le magasin/les produits
			try{
			produits.put(1, new Produit("HP", "Elitebook 850 G7"));
			produits.put(2, new Produit("HP", "Elitebook 830 G7 X360"));
			produits.put(3, new Produit("Dell","Inspiron 15 3000"));
			produits.put(4, new Produit("Dell","XPS 13"));
			produits.put(5, new Produit("Dell","XPS 15"));
			produits.put(6, new Produit("Lenovo","Thinkpad E15 G2"));
			produits.put(7, new Produit("Lenovo","IdeaPad 3 14IIL05 81WD00B2MH"));
			}
			catch (NullPointerException err) {
				err.printStackTrace(); //- if the given pattern is null
				}
			catch (IllegalArgumentException err) {
				err.printStackTrace(); //- if the given pattern is invalid)
				}
			
			
			// afficher les produits
			for (int i = 1; i <= produits.size(); i++) {
				System.out.println("Id_" + i +" --- " + produits.get(i));
			}
		
	}
	}
	
	//***************************** PARTIE PRÊT *****************************//

	public JButton getBtnPret() {
        return btnPret;
        }
	
	public class Emprunt implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			System.out.println("Prêt de matériel");
		}
		
	}
	
	//***************************** PARTIE RETOUR *****************************//
	
	public JButton getBtnRetour() {
        return btnRetour;
        }
	
	public class RetourEmprunt implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			System.out.println("Retour matériel");
		}
		
	}
	
	//***************************** PARTIE MODIFICATION PERSONNEL *****************************//
	
	public JButton getBtnPersonnel() {
        return btnPersonnel;
        }
	
	public class GestionPersonnel implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			Affichage();
			
			if(Person.size() < 1) {
				System.out.println(" ");
			}
			else {
			System.out.println("\n");
			System.out.println("Introduire le nom de la personne à modifier :");
			System.out.println("Entrer un nom :");
			System.out.println("Introduire les nouvelles valeurs :");
			System.out.println("Entrer un nom :");
			System.out.println("Entrer un prénom :");
			System.out.println("Entrer une adresse mail :");
		}
		
		}
	}
	
	//***************************** PARTIE SAUVEGARDE *****************************//
	
	public JButton getBtnSauvegarde() {
        return btnSauvegarde;
        }
	
	public class Sauvegarde implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			System.out.println("Sauvegarde");
		}
		
	}
	
	//***************************** PARTIE FERMER *****************************//
	
	public JButton getBtnClose() {
        return btnClose;
        }

	
}