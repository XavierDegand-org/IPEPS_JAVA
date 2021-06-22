package Console;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Actions.EditPersonnel;
import Actions.LoadPersonnel;
import Actions.LoadProduit;
import Actions.ShowPersonnel;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton btnLoad = new JButton("Chargement du personnel");
	private JButton btnAffichage = new JButton("Affichage liste du personnel");
	private JButton btnPersonnel = new JButton("Modification données personnel");
	
	
	private JButton btnMag = new JButton("Création du magasin");
	private JButton btnPret = new JButton("Prêt de matériel");
	private JButton btnRetour = new JButton("Retour de matériel");
	private JButton btnSauvegarde = new JButton("Sauvegarde");
	private JButton btnClose = new JButton("Fermer");

	public Frame() {
		super("Gestion personnel & Prêt matériel");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel contentPane = (JPanel) this.getContentPane();
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);

		contentPane.setLayout(new GridLayout(3, 3));

		contentPane.add(btnLoad);
		contentPane.add(btnAffichage);
		contentPane.add(btnMag);
		contentPane.add(btnPret);
		contentPane.add(btnRetour);
		contentPane.add(btnPersonnel);
		contentPane.add(btnSauvegarde);
		contentPane.add(btnClose);
		
		
		LoadPersonnel personnelLoader = new LoadPersonnel();
		btnLoad.addActionListener(personnelLoader);
		
		ShowPersonnel showPersonnel = new ShowPersonnel(personnelLoader);
		btnAffichage.addActionListener(showPersonnel);
		
		EditPersonnel editPersonnel = new EditPersonnel(personnelLoader);
		btnPersonnel.addActionListener(editPersonnel);
		
		LoadProduit produitLoader = new LoadProduit();
		btnMag.addActionListener(produitLoader);
	}
}
