package Jessica;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	 
	// variables listes, compteur
	private static ArrayList<Personnel> Person = new ArrayList<>();
	private static ArrayList<Emprunt> pret = new ArrayList<>();
	Magasin mag = new Magasin();
	int i; // compteur pour boucle for
	private String fichier = "";
	
	//***************************** DEBUT GESTIONJFRAME *****************************//
					
	public GestionJFrame() {
		
		//***************************** PARTIE BOUTONS *****************************//
		
		super( "Gestion personnel & prêt matériel" );
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
					System.out.println("L'entrée ne peut être nulle.");
				}
				catch (IllegalArgumentException err) {
					System.out.println("L'entrée est invalide.");
				}
				catch (IndexOutOfBoundsException err) {
				System.out.println("Valeur en-dehors des limites autorisées.");
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
				System.out.println(Affichage());
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
		
		public StringBuilder Affichage() {
			//si liste personnel est vide/strictement inférieure à 1
			StringBuilder sb = new StringBuilder();
			if(Person.size() < 1) {
				System.out.println("Affichage impossible, pas de personnel !");
			}
			else {
			System.out.println("+-----------------------+-------------------+------------------+----------+-----------------+------------------------+");
			System.out.println("| Département           | Prénom            | Nom              | Sexe     | Naissance       | Email                  |");
			System.out.println("+-----------------------+-------------------+------------------+----------+-----------------+------------------------+");
			
			    for (i = 0; i < Person.size(); i++) {
			    	sb.append(setFixedLength(Person.get(i).getDepartement(), 25));
			    	sb.append(setFixedLength(Person.get(i).getPrenom(), 20));
			    	sb.append(setFixedLength(Person.get(i).getNom(), 20));
			    	sb.append(setFixedLength(Person.get(i).getSexe(), 11));
			    	sb.append(setFixedLength(Person.get(i).getDateddMMyyyy(), 18));
			    	sb.append(setFixedLength(Person.get(i).getEmail(), 25));
	                sb.append("\n");
			    		}		
			}
			// on affiche le contenu
			return sb;
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
				System.out.println("L'entrée ne peut être nulle.");
			}
			catch (IllegalArgumentException err) {
				System.out.println("L'entrée est invalide.");
			}
			catch (IndexOutOfBoundsException err) {
			System.out.println("Valeur en-dehors des limites autorisées.");
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
				try {
				pret.add(new Emprunt(1, Person.get(0), mag.produits.get(1)));
				pret.add(new Emprunt(2, Person.get(1), mag.produits.get(3)));
				pret.add(new Emprunt(3, Person.get(2), mag.produits.get(4)));
				pret.add(new Emprunt(4, Person.get(3), mag.produits.get(6)));
				pret.add(new Emprunt(5, Person.get(6), mag.produits.get(7)));
				}
				catch (NullPointerException err) {
					System.out.println("L'entrée ne peut être nulle.");
				}
				catch (IllegalArgumentException err) {
					System.out.println("L'entrée est invalide.");
				}
				catch (IndexOutOfBoundsException err) {
				System.out.println("Valeur en-dehors des limites autorisées.");
				}
			}
			
			// afficher prêt de matériel
			for (Emprunt emprunt : pret)
			{
			System.out.println(emprunt);
			}

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
				// mettre un stringbuilder pour aligner les colonnes
				
				System.out.println(listeEmprunt());
					
				System.out.println("Introduire le numéro d'emprunt à annuler : ");
				int nbremprunt = Lire.nbre();
	
				try { 
						//si nombre de l'emprunt = nombre saisi
						if(pret.get(i).getNombre() == nbremprunt-1) {
							pret.remove(nbremprunt-1);
							
							System.out.println(listeEmprunt());
				   
						}
						else {
							System.out.println("Le nombre saisi n'est pas correct, veuillez ressaisir un nombre correct");
						}
					 }
				catch (IndexOutOfBoundsException e) {
					 System.out.println("Erreur, le numéro n'est pas dans la liste d'emprunt, entrez un numéro correct.");
				}
			}
		}
			
			public StringBuilder listeEmprunt() {
				StringBuilder pretcol = new StringBuilder();
			    for (i = 1; i < pret.size(); i++) {
			    	pretcol.append("N° ");
			    	pretcol.append(setFixedLength(String.valueOf(pret.get(i).getNombre()), 3));
				   	pretcol.append(setFixedLength(pret.get(i).getEmprunteur().getNom(), 12));
				   	pretcol.append(setFixedLength(pret.get(i).getMateriel()+"   "+pret.get(i).getArticle(), 40));
	                pretcol.append("\n");
			    		}
			    // on affiche lecontenu
			   return pretcol;
				
			}
						
		
		
		//***************************** PARTIE MODIFICATION PERSONNEL *****************************//
		
		public JButton getBtnPersonnel() {
	        return btnPersonnel;
	        }
		
		public class btnPersonnelListener implements ActionListener {
			
			@Override
			public void actionPerformed (ActionEvent e) {
				System.out.println(Affichage()); // affiche la liste du personnel sans modifications d'abord
				
				GestionPersonnel();
			}
		}
		
		public void GestionPersonnel() {
			
			String nom;
				
				if(Person.size() < 1) {
					System.out.println("Veuillez d'abord charger le personnel.");
				}
				else {
				System.out.println("\n");
				System.out.println("Introduire le nom de la personne à modifier :");
				InputData.nom = InputData.inputNomPrenom("nom");
				nom = Lire.texte();
				
				for(i = 1; i < Person.size(); i++) {
					//si nom = nom saisi
					if(Person.get(i).getNom().equals(nom)) {
						
						//montrer les données liées au nom saisi
						System.out.println(Person.get(i).getIdPersonnel() + " -- " + Person.get(i).getNom() + " -- " + Person.get(i).getPrenom() 
						+ " -- " + Person.get(i).getSexe() + " -- " + Person.get(i).getEmail() + " -- " + Person.get(i).getDepartement());
						System.out.println("Introduire les nouvelles valeurs :");
						
						// on remplace les données via les setters
						Person.get(i).setNom(InputData.inputNomPrenom("nom"));
						Person.get(i).setPrenom(InputData.inputNomPrenom("prénom"));
						Person.get(i).setEmail(InputData.inputEmail());
						System.out.println("Nouvelles valeurs :");
						System.out.println(Person.get(i).getIdPersonnel() + " -- " + Person.get(i).getNom() + " -- " + Person.get(i).getPrenom() + " -- " + Person.get(i).getSexe() + " -- " + Person.get(i).getEmail() + " -- " + Person.get(i).getDepartement());
						return;
					}
					else {
						System.out.println("Le nom n'est pas dans la liste du personnel, saisissez un autre nom.");
					}
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
		
		public StringBuilder listeEmprunt2() {
			StringBuilder pretcol = new StringBuilder();
		    for (i = 0; i < pret.size(); i++) {
		    	pretcol.append("N° ");
		    	pretcol.append(setFixedLength(String.valueOf(pret.get(i).getNombre()), 5));
			   	pretcol.append(setFixedLength(pret.get(i).getEmprunteur().getNom()+" "+pret.get(i).getEmprunteur().getPrenom(), 32));
			   	pretcol.append(setFixedLength(pret.get(i).getMateriel()+"   "+pret.get(i).getArticle(), 40));
	            pretcol.append("\n");
		    		}
		    // on affiche lecontenu
		   return pretcol;
			
		}
		
		public void Sauvegarde() {
			
			SimpleDateFormat DTG = new SimpleDateFormat("MM/dd/yyyy HH:mm:s");
			Date date = new Date();
		    
			if(Person.size() < 1) {
				System.out.println("Impossible de sauvegarder, veuillez d'abord charger le personnel.");
			}
			else if (mag.isEmpty()) {
				System.out.println("Impossible de sauvegarder, veuillez d'abord créer le magasin.");
			}
			else if (pret.isEmpty()) {
				System.out.println("Impossible de sauvegarder, veuillez d'abord effectuer des emprunts.");
			}
			else {
				System.out.println("Veuillez introduire le nom du fichier en extension .txt !");
				InputData.nomFichier = Lire.texte();
				fichier = InputData.inputNomFichier();
				
				try {
			
					String path = "./src/Jessica/Fichier/";			
					String content = path + fichier;	
						
					 File file = new File(content);

				    	// crée le fichier si pas encore présent
				    	if(!file.exists()){
				    	   file.createNewFile();
				    	}

				    	//true pour ajouter du contenu au fichier
				    	FileWriter fw = new FileWriter(fichier,true);
				    	BufferedWriter bw = new BufferedWriter(fw);
				
				    	
			    	//affiche date de la sauvegarde
			    	bw.newLine();
					bw.write("DTG de la sauvegarde : "+ DTG.format(date));
					bw.newLine();
					bw.write("+-----------------------+-------------------+------------------+----------+-----------------+------------------------+");
					bw.newLine();
					bw.write("| Département           | Prénom            | Nom              | Sexe     | Naissance       | Email                  |");
					bw.newLine();
					bw.write("+-----------------------+-------------------+------------------+----------+-----------------+------------------------+");
					bw.newLine();
					//on affiche le contenu de personnel
					bw.write(Affichage().toString());
					bw.newLine();
					
					bw.write("+-----+-------------------------------+----------------------------------------+");
					bw.newLine();
					bw.write("| N°  | Nom - Prénom                  | Matériel                               |");
					bw.newLine();
					bw.write("+-----+-------------------------------+----------------------------------------+");
					bw.newLine();
					// on affiche le contenu de prêt
					bw.write(listeEmprunt2().toString());
					
			    	bw.close();

				System.out.println("Sauvegarde bien effectuée.");
				
			      }
			catch(IOException io){
			         System.err.print("Une erreur est survenue : "+io.getMessage());
			       }
				
			}
		}
		
		//***************************** PARTIE FERMER *****************************//
		
		public JButton getBtnClose() {
	        return btnClose;
	        }

		}