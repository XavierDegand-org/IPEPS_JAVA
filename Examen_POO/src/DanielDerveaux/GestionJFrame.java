package DanielDerveaux;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GestionJFrame extends JFrame {
	 private JButton btnLoad = new JButton("Chargement du personnel");
	 private JButton btnAffichage = new JButton("Affichage liste du personnel");
	 private JButton btnMag = new JButton("Création du magasin");
	 private JButton btnPret = new JButton("Prêt de matériel");
	 private JButton btnRetour = new JButton("Retour de matériel");
	 private JButton btnPersonnel = new JButton("Modification données Personnel");
	 private JButton btnSauvegarde = new JButton("Sauvegarde");
	 private JButton btnClose = new JButton("Fermer");
	 
	 List<Personnel> Person = new ArrayList<Personnel>();
	 Magasin mag = new Magasin();
	 List<Emprunt> pret = new ArrayList<Emprunt>();
	 
	 private static String nom = null;
	 private static String fichier = null;
	 private static int tailleNom;
	 
	 public GestionJFrame() {
		super("Gestion personnel & matériel");
		this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		
		JPanel contentPane = (JPanel) this.getContentPane();
		
		/* Mise en place des boutons */
		contentPane.add(btnLoad);
		contentPane.add(btnAffichage);
		contentPane.add(btnMag);
		contentPane.add(btnPret);
		contentPane.add(btnRetour);
		contentPane.add(btnPersonnel);
		contentPane.add(btnSauvegarde);
		contentPane.add(btnClose);
		contentPane.setLayout(null);
		
		/* 1re ligne */
		btnLoad.setBounds(0, 10, 250, 100);
		btnAffichage.setBounds(250, 10, 250, 100);
		btnMag.setBounds(500, 10, 250, 100);
		
		/* 2e ligne */
		btnPret.setBounds(0, 110, 250, 100);
		btnRetour.setBounds(250, 110, 250, 100);
		btnPersonnel.setBounds(500, 110, 250, 100);
		
		/* 3e ligne */
		btnSauvegarde.setBounds(0, 210, 250, 100);
		btnClose.setBounds(250, 210, 250, 100);
		
		/* Utilisation de Lambda pour les évènements liés aux boutons */
		btnLoad.addActionListener( (e) -> {
			try {
				LoadPersonnel();
			} catch (IOException io) {
				System.err.println("Une erreur est survenue : " + io.getMessage());
			}
		});
		
		btnAffichage.addActionListener( (e) -> {
			try {
				Affichage();
				System.out.println(Affichage());
			} catch (IOException io) {
				System.err.println("Une erreur est survenue : " + io.getMessage());
			}
		});
		
		btnMag.addActionListener( (e) -> {
			try {
				Magasin();
			} catch (IOException io) {
				System.err.println("Une erreur est survenue : " + io.getMessage());
			}
		});
		
		btnPret.addActionListener( (e) -> {
			try {
				Emprunt();
				for(Emprunt Pret : pret) {
					System.out.println(Pret.toString() + "\n");
				}
			} catch (IOException io) {
				System.err.println("Une erreur est survenue : " + io.getMessage());
			}
		});
		
		btnRetour.addActionListener( (e) -> {
			try {
				RetourEmprunt();
			} catch (IOException io) {
				System.err.println("Une erreur est survenue : " + io.getMessage());
			}
		});
		
		btnPersonnel.addActionListener( (e) -> {
			try {
				GestionPersonnel();
			} catch (IOException io) {
				System.err.println("Une erreur est survenue : " + io.getMessage());
			}
		});
		
		btnSauvegarde.addActionListener( (e) -> {
			try {
				Sauvegarde();
			} catch (IOException io) {
				System.err.println("Une erreur est survenue : " + io.getMessage());
			}
		});
		
		btnClose.addActionListener( (e) -> dispose());
     
		this.setSize(770, 360);
		this.setLocationRelativeTo(null);
	 }
		
	 	/* Chargement du personnel */
		private void LoadPersonnel() throws IOException {
			if (Person.isEmpty()) {
				Person.add(new Personnel(1, "Collon", "Albert", Sexe.HOMME, new MyDate(10, 8, 1990), "Collon.a@test.be", Departement.HR));
				Person.add(new Personnel(2, "Peeters", "Marie", Sexe.FEMME, new MyDate(1, 5, 1985), "Peeters_M@test.be", Departement.HR));
				Person.add(new Personnel(3, "Janssens", "Sarah", Sexe.FEMME, new MyDate(23, 5, 1999), "Sarah.Jannssens@test.be", Departement.Compta));
				Person.add(new Personnel(4, "Maes", "Henri", Sexe.HOMME, new MyDate(14, 9, 2009), "MaesHenri@test.be", Departement.Compta));
				Person.add(new Personnel(5, "Jacobs", "Charles", Sexe.HOMME, new MyDate(12, 12, 2009), "Charles.j@test.be", Departement.SEC));
				Person.add(new Personnel(6, "Mertens", "Floriane", Sexe.FEMME, new MyDate(20, 8, 1996), "FloFlo@test.be", Departement.SEC));
				Person.add(new Personnel(7, "Willems", "François-Xavier", Sexe.HOMME, new MyDate(28, 10, 1996), "Willems.F-X@test.be", Departement.Prod));
				Person.add(new Personnel(8, "O'Neil", "Shan", Sexe.HOMME, new MyDate(1, 7, 2001), "ONeil.sh@test.be", Departement.Prod));
				Person.add(new Personnel(9, "Goossen", "Stéphanie", Sexe.FEMME, new MyDate(25, 10, 2008), "NieNieG@test.be", Departement.HR));
				Person.add(new Personnel(10, "Dumont", "Charles", Sexe.HOMME, new MyDate(1, 4, 1969), "dumont.c@test.be", Departement.HR));
				Person.add(new Personnel(11, "Van Moore", "Wilfrid", Sexe.HOMME, new MyDate(25, 2, 1998), "vanmoore.w@test.be", Departement.Compta));
				Person.add(new Personnel(12, "Herman", "Nathalie", Sexe.FEMME, new MyDate(26, 7, 2001), "herman.n@test.be", Departement.Prod));
				Person.add(new Personnel(13, "Bontemps", "Annie", Sexe.FEMME, new MyDate(23, 9, 1998), "bontemps.a@test.be", Departement.Prod));
				
				System.out.println("Chargement du personnel réussi !");
			} else {
				System.out.println("La liste du personnel a déjà été chargée !");
			}
		}

		/* Création du magasin */
		private void Magasin() throws IOException {			
			mag.ajouterProduit(1, "HP", "Elitebook 850 G7");
			mag.ajouterProduit(2, "HP", "Elitebook 830 G7 X360");
			mag.ajouterProduit(3, "Dell", "Inspiron 15 3000");
			mag.ajouterProduit(4, "Dell", "XPS 13");
			mag.ajouterProduit(5, "Dell", "XPS 15");
			mag.ajouterProduit(6, "Lenovo", "Thinkpad E15 G2");
			mag.ajouterProduit(7, "Lenovo", "IdeaPad 3 14IIL05 81WD00B2MH");

			mag.listeMap();
		}
		
		/* Affichage personnel */
		private StringBuilder Affichage() throws IOException {
			StringBuilder builder = new StringBuilder();
			if (Person.isEmpty()) {
				return builder.append("Affichage impossible, pas de personnel !");
			} else {
				builder.append("+------------------------+------------------------+------------------------+---------+--------------+--------------------------+\n");
				builder.append("| Département            | Prénom                 | Nom                    | Sexe    | Naissance    | Email                    |\n");
				builder.append("+------------------------+------------------------+------------------------+---------+--------------+--------------------------+\n");
				
				for(Personnel person : Person) {
					builder.append("  ");
					builder.append(setFixedLength(person.getDepartement(), 25));
					builder.append(setFixedLength(person.getPrenom(), 25));
					builder.append(setFixedLength(person.getNom(), 25));
					builder.append(setFixedLength(person.getSexe(), 10));
					builder.append(setFixedLength(person.getDateddMMyyyy(), 15));
					builder.append(setFixedLength(person.getEmail(), 30));
					builder.append("\n");
				}
				return builder;
			}
		}
		
	    static String setFixedLength(String s, int tailleNom) {
	        StringBuilder ss = new StringBuilder(s);
	        //tant que la taille de ss est inférieur à tailleNom on ajoute un caractère blanc
	        while (ss.length() < tailleNom) {
	            String d = " ";
	            char c1 = d.charAt(0);
	            ss.insert(s.length(), c1);
	        }
	            String c = ss.substring(0, tailleNom);
	        return c;
	        }
		
		/* Prêt de matériel */
		private StringBuilder Emprunt() throws IOException {
			StringBuilder builder = new StringBuilder();
			if(Person.isEmpty() && mag.isEmpty()) {
				return builder.append("Veuillez charger le personnel et le magasin !");
			} else if(Person.isEmpty() && mag.isEmpty() == false) {
				return builder.append("Veuillez charger le personnel !");
			} else if(Person.isEmpty() == false && mag.isEmpty()) {
				return builder.append("Veuillez charger le magasin !");
			} else if(pret.isEmpty()) {
				pret.add(new Emprunt(1, Person.get(0), mag.produits.get(1)));
				pret.add(new Emprunt(2, Person.get(1), mag.produits.get(3)));
				pret.add(new Emprunt(3, Person.get(2), mag.produits.get(4)));
				pret.add(new Emprunt(4, Person.get(3), mag.produits.get(6)));
				pret.add(new Emprunt(5, Person.get(6), mag.produits.get(7)));
			}
			
			builder.append("+------+-----------------------------+----------------------------------------+\n");
			builder.append("| N°   | Nom - Prénom                | Matériel                               |\n");
			builder.append("+------+-----------------------------+----------------------------------------+\n");
			
			for(Emprunt Pret : pret) {
				builder.append("  ");
				builder.append(setFixedLength(String.valueOf(Pret.getNombre()), 7));
				builder.append(setFixedLength(Pret.getEmprunteur().getNom() + " " + Pret.getEmprunteur().getPrenom(), 30));
				builder.append(setFixedLength(Pret.getMateriel() + "  " + Pret.getArticle(), 30));
				builder.append("\n");
			}
			return builder;
		}
		
		/* Retour de matériel */
		private void RetourEmprunt() throws IOException {
			StringBuilder builder = new StringBuilder();
			int numero_emprunt = 0;
			if(pret.isEmpty()) {
				System.out.println("Veuillez charger les emprunts !");
			} else {
				for(Emprunt Pret : pret) {
					builder.append("N° ");
					builder.append(setFixedLength(String.valueOf(Pret.getNombre()), 3));
					builder.append(setFixedLength(Pret.getEmprunteur().getNom(), 10));
					builder.append(setFixedLength(Pret.getMateriel(), 10));
					builder.append(setFixedLength(Pret.getArticle(), 30));
					builder.append("\n");
				}
				System.out.println("Liste des emprunts");
				System.out.println(builder);
				
				System.out.println("Introduire le numéro d'emprunt à annuler : ");
				numero_emprunt = Lire.nbre();
				
				if(numero_emprunt > pret.size() || numero_emprunt <= 0) {
					System.out.println("Le numéro n'est pas valide");
					return;
				}
				
				pret.remove(numero_emprunt-1); // l'index commençant à zéro, on soustrait 1 à la valeur entrée pour retirer le bon emprunt
				builder.setLength(0); // on vide le builder pour le recréer sans l'emprunt retiré
				for(int Compteur = 0; Compteur < pret.size(); Compteur++) {
					pret.set(Compteur, new Emprunt(Compteur + 1, pret.get(Compteur).emprunteur, pret.get(Compteur).materiel));
				}
				for(Emprunt Pret : pret) {
					builder.append("N° ");
					builder.append(setFixedLength(String.valueOf(Pret.getNombre()), 3));
					builder.append(setFixedLength(String.valueOf(Pret.getEmprunteur().getNom()), 10));
					builder.append(setFixedLength(Pret.getMateriel(), 10));
					builder.append(setFixedLength(Pret.getArticle(), 30));
					builder.append("\n");
				}
				System.out.println(builder);
			}
			return;
		}
		
		/* Modification données Personnel */
		private void GestionPersonnel() throws IOException {
			if(Person.isEmpty()) {
				System.out.println("Veuillez charger le personnel !");
			} else {
				System.out.println(Affichage());
				System.out.println("Introduire le nom de la personne à modifier :\nEntrer un nom : ");
				nom = Lire.texte();
				for(int i = 1; i < Person.size(); i++) {
					if(nom.equals(Person.get(i).getNom())) {
						System.out.println(Person.get(i).getIdPersonnel() + " -- " + Person.get(i).getNom() + " -- " + Person.get(i).getPrenom() + " -- " + Person.get(i).getSexe() + " -- " + Person.get(i).getEmail() + " -- " + Person.get(i).getDepartement());
						System.out.println("Introduire les nouvelles valeurs :");
						Person.get(i).setNom(InputData.inputNomPrenom("nom"));
						Person.get(i).setPrenom(InputData.inputNomPrenom("prénom"));
						Person.get(i).setEmail(InputData.inputEmail());
						System.out.println("Modification réussie !");
						System.out.println(Person.get(i).getIdPersonnel() + " -- " + Person.get(i).getNom() + " -- " + Person.get(i).getPrenom() + " -- " + Person.get(i).getSexe() + " -- " + Person.get(i).getEmail() + " -- " + Person.get(i).getDepartement());
						return;
					}
				}
				System.out.println("Le nom n'existe pas dans la base de donnée !");
			}
			return;
		}

		/* Sauvegarde */
		private void Sauvegarde() throws IOException {
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = new Date();
			fichier = InputData.inputNomFichier();
			try(BufferedWriter bufWrite = new BufferedWriter(new FileWriter(new File("./src/DanielDerveaux/" + fichier)))) {
				bufWrite.write("DTG de la sauvegarde : " + format.format(date));
				bufWrite.newLine();
				bufWrite.write(Affichage().toString());
				bufWrite.newLine();
				bufWrite.newLine();
				bufWrite.write(Emprunt().toString());
				System.out.println("Sauvegarde réussie !\n");
			} catch (IOException io) {
				System.err.println("Une erreur est survenue : " + io.getMessage());
			}
			
			Path path = Paths.get("./src", "DanielDerveaux", fichier);
			List<String> Lignes = Files.readAllLines(path,Charset.forName("utf-8"));
			for (String element : Lignes) {
				System.out.println(element);
			}
			return;
		}
}
