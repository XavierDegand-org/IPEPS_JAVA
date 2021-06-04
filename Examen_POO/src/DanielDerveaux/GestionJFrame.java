package DanielDerveaux;

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
	 
	 public GestionJFrame() {
		super();
		this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		
		JPanel contentPane = (JPanel) this.getContentPane();
		
		contentPane.add(btnLoad);
		contentPane.add(btnAffichage);
		contentPane.add(btnMag);
		contentPane.add(btnPret);
		contentPane.add(btnRetour);
		contentPane.add(btnPersonnel);
		contentPane.add(btnSauvegarde);
		contentPane.add(btnClose);
		contentPane.setLayout(null);
		
		btnLoad.setBounds(0, 10, 250, 100);
		btnAffichage.setBounds(250, 10, 250, 100);
		btnMag.setBounds(500, 10, 250, 100);
		
		btnPret.setBounds(0, 110, 250, 100);
		btnRetour.setBounds(250, 110, 250, 100);
		btnPersonnel.setBounds(500, 110, 250, 100);
		
		btnSauvegarde.setBounds(0, 210, 250, 100);
		btnClose.setBounds(250, 210, 250, 100);
		
     
		this.setSize(770, 350);
		this.setLocationRelativeTo(null);
	 }
}
