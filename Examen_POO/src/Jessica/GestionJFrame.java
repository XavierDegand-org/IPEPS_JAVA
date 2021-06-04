package Jessica;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GestionJFrame extends JFrame  {
	
	 private JButton btnLoad = new JButton( "Chargement du personnel" );
	 private JButton btnAffichage = new JButton( "Affichage liste du personnel" );
	 private JButton btnMag = new JButton( "Création du magasin" );
	 private JButton btnPret = new JButton( "Prêt de matériel" );
	 private JButton btnRetour = new JButton( "Retour de matériel" );
	 private JButton btnPersonnel = new JButton( "Modification données personnel" );
	 private JButton btnSauvegarde = new JButton( "Sauvegarde" );
	 private JButton btnClose = new JButton( "Fermer" );
	 
	public GestionJFrame() {
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
     
		this.setSize( 600, 300 );
		this.setLocationRelativeTo( null );
	}
	
	public JButton getBtnLoad() {
	        return btnLoad;
	     }
	
	public JButton getBtnAffichage() {
        return btnAffichage;
        }
	
	public JButton getBtnMag() {
        return btnMag;
        }
	
	public JButton getBtnPret() {
        return btnPret;
        }
	
	public JButton getBtnRetour() {
        return btnRetour;
        }
	
	public JButton getBtnPersonnel() {
        return btnPersonnel;
        }
	
	public JButton getBtnSauvegarde() {
        return btnSauvegarde;
        }
	
	public JButton getBtnClose() {
        return btnClose;
        }

	
}