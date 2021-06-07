package DanielDerveaux;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

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
		btnLoad.addActionListener( (e) -> System.out.println("En cours"));
		
		btnAffichage.addActionListener( (e) -> System.out.println("En cours"));
		
		btnMag.addActionListener( (e) -> System.out.println("En cours"));
		
		btnPret.addActionListener( (e) -> System.out.println("En cours"));
		
		btnRetour.addActionListener( (e) -> System.out.println("En cours"));
		
		btnPersonnel.addActionListener( (e) -> System.out.println("En cours"));
		
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
		
		public static void Sauvegarde() throws IOException {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			fichier = InputData.inputNomFichier();
			try(BufferedWriter bufWrite = new BufferedWriter(new FileWriter(new File("./src/DanielDerveaux/" + fichier)))) {
				bufWrite.write("DTG de la sauvegarde : " + timestamp);
				System.out.println("Sauvegarde réussie !");
			} catch (IOException io) {
				System.err.println("Une erreur est survenue : " + io.getMessage());
			}
		}
}
