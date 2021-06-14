package yacineFrimi;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import boutons.btnAffichageListener;
import boutons.btnLoadListener;
import boutons.btnMagListener;
import boutons.btnPersonnelListener;
import boutons.btnPretListener;
import boutons.btnRetourListener;
import boutons.btnSauvegardeListener;

public class GestionJFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton btnLoad = new JButton("Chargement du personnel");
	private JButton btnAffichage = new JButton("Affichage liste du personnel");
	private JButton btnPersonnel = new JButton("Modification données personnel");
	private JButton btnMag = new JButton("Création du magasin");
	private JButton btnPret = new JButton("Prêt de matériel");
	private JButton btnRetour = new JButton("Retour de matériel");
	private JButton btnSauvegarde = new JButton("Sauvegarde");
	private JButton btnClose = new JButton("Fermer");

	public GestionJFrame() {
		super("Gestion personnel & prêt matériel.");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel ecranPrincipal = (JPanel) this.getContentPane();
		ecranPrincipal.setLayout(new GridLayout(2, 2, 2, 2));

		ecranPrincipal.add(btnLoad);
		ecranPrincipal.add(btnAffichage);
		ecranPrincipal.add(btnPersonnel);
		ecranPrincipal.add(btnMag);
		ecranPrincipal.add(btnPret);
		ecranPrincipal.add(btnRetour);
		ecranPrincipal.add(btnSauvegarde);
		ecranPrincipal.add(btnClose);

		this.setSize(800, 400);
		this.setLocationRelativeTo(null);

		btnLoad.addActionListener(new btnLoadListener());
		btnAffichage.addActionListener(new btnAffichageListener());
		btnPersonnel.addActionListener(new btnPersonnelListener());
		btnMag.addActionListener(new btnMagListener());
		btnPret.addActionListener(new btnPretListener());
		btnRetour.addActionListener(new btnRetourListener());
		btnSauvegarde.addActionListener(new btnSauvegardeListener());
		btnClose.addActionListener((e) -> dispose());

	}

}
