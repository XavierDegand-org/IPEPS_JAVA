package Valentin;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GestionJFrame extends JFrame {
	
	private JButton btnLoad = new JButton("Chargement du personnel"); //
	
	// Création du constructeur GestionJFrame
	public GestionJFrame() {
		super("Gestion Personnel & prêt matériel"); // permet de mettre un titre pour la fenetre 
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // permet d'avoir une opération par défaut lors de la fermeture de la fenêtre 
		
		JPanel contentPanel = (JPanel) this.getContentPane(); // c'est un contenaire qui permet de stocker les boutons 
		
	}

}
