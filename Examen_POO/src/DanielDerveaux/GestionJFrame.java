package DanielDerveaux;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
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
	 
	 private static String fichier = null;
	 
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
			System.out.println("En cours");
		}
		
		/* Création du magasin */
		private void Magasin() throws IOException {
			System.out.println("En cours");
		}
		
		/* Affichage personnel */
		private void Affichage() throws IOException {
			System.err.println("Affichage impossible, pas de personnel !");
		}
		
		/* Prêt de matériel */
		private void Emprunt() throws IOException {
			System.out.println("En cours");
		}
		
		/* Retour de matériel */
		private void RetourEmprunt() throws IOException {
			System.out.println("En cours");
		}
		
		/* Modification données Personnel */
		private void GestionPersonnel() throws IOException {
			System.out.println("En cours");
		}

		/* Sauvegarde */
		private static void Sauvegarde() throws IOException {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			fichier = InputData.inputNomFichier();
			try(BufferedWriter bufWrite = new BufferedWriter(new FileWriter(new File("./src/DanielDerveaux/" + fichier)))) {
				bufWrite.write("DTG de la sauvegarde : " + timestamp);
				System.out.println("Sauvegarde réussie !\n");
			} catch (IOException io) {
				System.err.println("Une erreur est survenue : " + io.getMessage());
			}
			
			Path path = Paths.get("./src", "DanielDerveaux", fichier);
			List<String> Lignes = Files.readAllLines(path,Charset.forName("utf-8"));
			for (String element : Lignes) {
				System.out.println(element);
			}
			
		}
}
