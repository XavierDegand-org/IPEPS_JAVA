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
	
	
	// variables boutons
	private JButton btnLoad = new JButton( "Chargement du personnel" );
	private JButton btnAffichage = new JButton( "Affichage liste du personnel" );
	private JButton btnMag = new JButton( "Création du magasin" );
	private JButton btnPret = new JButton( "Prêt de matériel" );
	private JButton btnRetour = new JButton( "Retour de matériel" );
	private JButton btnPersonnel = new JButton( "Modification données personnel" );
	private JButton btnSauvegarde = new JButton( "Sauvegarde" );
	private JButton btnClose = new JButton( "Fermer" );
	 
	// variables listes
	private static ArrayList<Personnel> Person = new ArrayList<>();
	private static ArrayList<Emprunt> pret = new ArrayList<>();
	Magasin mag = new Magasin();
	
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
		
		btnLoad.addActionListener(new btnLoadListener());
		btnAffichage.addActionListener(new btnAffichageListener());
		btnMag.addActionListener(new btnMagasinListener());
		btnPret.addActionListener(new btnPretListener());
		btnRetour.addActionListener(new btnRetourListener());
		btnPersonnel.addActionListener(new btnPersonnelListener());
		btnSauvegarde.addActionListener(new btnSauvegardeListener());
		btnClose.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed (ActionEvent e) {
					System.exit(0);
				}
			});
     
		this.setSize( 600, 300 );
		this.setLocationRelativeTo( null );
	}
	
	//***************************** PARTIE CHARGEMENT PERSONNEL *****************************//
	
	public JButton getBtnLoad() {
	        return btnLoad;
	     }
	
	public class btnLoadListener implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			LoadPersonnel();
		}
			
	public void LoadPersonnel() {
		// charger l'arraylist personnel
		try{
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
	
	//***************************** PARTIE AFFICHAGE PERSONNEL *****************************//
	
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
	public static String setFixedLength(String s, int largeur){
		        StringBuilder ss = new StringBuilder(s);
		        // tant que la taille de ss est inférieure à largeur définie on ajoute un caractère blanc
		        while (ss.length() < largeur) {
		                String d = " ";
		                char c1 = d.charAt(0);
		                ss.insert(s.length(),c1);
		            }
		        String c = ss.substring(0, largeur);
		        return c;
		    }
	
	public void Affichage() {
		//si liste personnel est vide/strictement inférieure à 1
		if(Person.size() < 1) {
			System.out.println("Affichage impossible, pas de personnel !");
		}
		else {
		System.out.println("+-----------------------+-------------------+------------------+----------+-----------------+------------------------+");
		System.out.println("| Département           | Prénom            | Nom              | Sexe     | Naissance       | Email                  |");
		System.out.println("+-----------------------+-------------------+------------------+----------+-----------------+------------------------+");
		StringBuilder sb = new StringBuilder();
		    for (int temp = 0; temp < Person.size(); temp++) {
		    	sb.append(setFixedLength(Person.get(temp).getDepartement(), 25));
		    	sb.append(setFixedLength(Person.get(temp).getPrenom(), 20));
		    	sb.append(setFixedLength(Person.get(temp).getNom(), 20));
		    	sb.append(setFixedLength(Person.get(temp).getSexe(), 11));
		    	sb.append(setFixedLength(Person.get(temp).getDateddMMyyyy(), 18));
		    	sb.append(setFixedLength(Person.get(temp).getEmail(), 25));
                sb.append("\n");
		    		}		
		    // on affiche le contenu
		    System.out.println(sb.toString());
		    	}
	}
			
	
	//***************************** PARTIE CRÉATION MAGASIN *****************************//
	
	public JButton getBtnMag() {
        return btnMag;
        }
	
	public class btnMagasinListener implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			Magasin();
		}
	
	public void Magasin() {
		// charger le magasin/les produits
		try{
			mag.AjouterProduit(1,"HP","Elitebook 850 G7");
			mag.AjouterProduit(2,"HP","Elitebook 830 G7 X360");
			mag.AjouterProduit(3,"Dell","Inspiron 15 3000");
			mag.AjouterProduit(4,"Dell","XPS 13");
			mag.AjouterProduit(5,"Dell","XPS 15");
			mag.AjouterProduit(6,"Lenovo","Thinkpad E15 G2");
			mag.AjouterProduit(7,"Lenovo","IdeaPad 3 14IIL05 81WD00B2MH");
		}
		catch (NullPointerException err) {
			err.printStackTrace(); //- if the given pattern is null
			}
		catch (IllegalArgumentException err) {
			err.printStackTrace(); //- if the given pattern is invalid)
			}
		
		// pour afficher listeMap dans l'ordre
		//mag.listeMap();
		
		// pour afficher produit spécifique
		System.out.println("Le magasin est composé de " + Magasin.produits.size()+" articles");
		System.out.println("Id_6 --- " + mag.produits.get(6) +"\n");
		System.out.println("Id_7 --- " + mag.produits.get(7) +"\n");
		System.out.println("Id_4 --- " + mag.produits.get(4) +"\n");
		System.out.println("Id_5 --- " + mag.produits.get(5) +"\n");
		System.out.println("Id_2 --- " + mag.produits.get(2) +"\n");
		System.out.println("Id_3 --- " + mag.produits.get(3) +"\n");
		System.out.println("Id_1 --- " + mag.produits.get(1) +"\n");
		
	}
			
		
	}
	
	//***************************** PARTIE PRÊT DE MATÉRIEL *****************************//

	public JButton getBtnPret() {
        return btnPret;
        }
	
	public class btnPretListener implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			Emprunt();
		}
		
	}
	
	public void Emprunt() {
		
		// charger l'arraylist pret
		if(Person.size() < 1) {
			System.out.println("Veuillez d'abord charger le personnel.");
		}
		else if (mag.isEmpty()) {
			System.out.println("Le magasin est vide, veuillez d'abord créer le magasin.");
		}
		else if (pret.isEmpty()) {
			pret.add(new Emprunt(1, Person.get(0), mag.produits.get(1)));
			pret.add(new Emprunt(2, Person.get(1), mag.produits.get(3)));
			pret.add(new Emprunt(3, Person.get(2), mag.produits.get(4)));
			pret.add(new Emprunt(4, Person.get(3), mag.produits.get(6)));
			pret.add(new Emprunt(5, Person.get(6), mag.produits.get(7)));
			}
		
		// afficher prêt de matériel
		/*for (Emprunt emprunt : pret)
		{
		System.out.println(emprunt);
		}*/

	}
	
	//***************************** PARTIE RETOUR MATÉRIEL *****************************//
	
	public JButton getBtnRetour() {
        return btnRetour;
        }
	
	public class btnRetourListener implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			RetourEmprunt();
		}
	}
	
	public void RetourEmprunt() {
		
		if(Person.size() < 1) {
			System.out.println("Veuillez d'abord charger le personnel.");
		}
		else if (mag.isEmpty()) {
			System.out.println("Le magasin est vide, veuillez d'abord créer le magasin.");
		}
		else if (pret.isEmpty()) {
			System.out.println("Pas d'emprunt effectué, retour impossible.");
		}
		else {
			System.out.println("Liste des emprunts");
			System.out.println("N° "+ Emprunt.getNombre()+ " " + Emprunt.getEmprunteur().getNom() + " " + Emprunt.getMateriel() + " " + Emprunt.getArticle());
		
			System.out.println("Introduire le numéro d'emprunt à annuler :");
			int nbremprunt = Lire.nbre();
				
		}
		
	}
	
	//***************************** PARTIE MODIFICATION PERSONNEL *****************************//
	
	public JButton getBtnPersonnel() {
        return btnPersonnel;
        }
	
	public class btnPersonnelListener implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			Affichage();
			
			GestionPersonnel();
		}
	}
	
	public void GestionPersonnel() {
			
			if(Person.size() < 1) {
				System.out.println("Veuillez d'abord charger le personnel.");
			}
			else {
			System.out.println("\n");
			System.out.println("Introduire le nom de la personne à modifier :");
			InputData.nom = InputData.inputNomPrenom("nom");
			String nom = Lire.texte();
			
			for (int i = 0; i < Person.size(); i++) {
			
			if (Person.get(i).getNom() == nom) {
				
				System.out.println(i + 1 + "  " + Person.get(i).getNom() + " -- " + Person.get(i).getPrenom()
						+ " -- " + Person.get(i).getSexe() + " -- " + Person.get(i).getEmail() + " -- "
						+ Person.get(i).getDepartement());
				
				System.out.println("Introduire les nouvelles valeurs :");
				System.out.println("Entrer un nom :");
			
				System.out.println("Entrer un prénom :");
				System.out.println("Entrer une adresse mail :");}
			}

		}
		
	}
	
	//***************************** PARTIE SAUVEGARDE *****************************//
	
	public JButton getBtnSauvegarde() {
        return btnSauvegarde;
        }
	
	public class btnSauvegardeListener implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			Sauvegarde();
		}
		
	}
	
	public void Sauvegarde() {
		System.out.println("Sauvegarde");
	}
	
	//***************************** PARTIE FERMER *****************************//
	
	public JButton getBtnClose() {
        return btnClose;
        }

	}