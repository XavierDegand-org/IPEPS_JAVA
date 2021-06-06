package Dorian;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class JFrameInterface extends JFrame 
{
  //mise en place des Jbutton
	
  private JButton btnload       = new JButton( "Chargement du personnel");
  private JButton btnAffichage  = new JButton( "Affichage liste du personnel" );
  private JButton btnMag        = new JButton( "Création du magasin" );
  private JButton btnpret       = new JButton( "prêt de matériel");
  private JButton btnRetour     = new JButton( "Retour du matériel");
  private JButton btnPersonnel  = new JButton( "Modification données Personnel");
  private JButton btnSauvegarde = new JButton( "Sauvegarde");
  private JButton btnClose      = new JButton( "Fermer");
  
		 
 public JFrameInterface() 
 {
	super( "Gestion personnel & Prêt matériel " );
	this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );    
	JPanel contentPane = (JPanel) this.getContentPane();
	
	// Un FlowLayout permet de positionner les boutons les uns  la suite des autres.
	        contentPane.setLayout(null);
	        //position des Button
	        btnload.setBounds      (0,0,250,125);
	        btnAffichage.setBounds (250,0,250,125); 
	        btnMag.setBounds       (500,0,250,125);
	        btnpret.setBounds      (0,125,250,125);
	        btnRetour.setBounds    (250,125,250,125);
	        btnPersonnel.setBounds (500,125,250,125);
	        btnSauvegarde.setBounds(0,250,250,125);
	        btnClose.setBounds     (250,250,250,125);
	        
			contentPane.add( btnload       );
			contentPane.add( btnAffichage  );
			contentPane.add( btnMag        );
			contentPane.add( btnpret       );
			contentPane.add( btnRetour     );
			contentPane.add( btnPersonnel  );
			contentPane.add( btnSauvegarde );
			contentPane.add( btnClose      );
			
			btnload.addActionListener      (new btnloadListener());
			btnAffichage.addActionListener (new btnAffichageListener());
			btnMag.addActionListener       (new btnMagListener());
			btnpret.addActionListener      (new btnpretListener());
			btnRetour.addActionListener    (new btnRetourListener());
			btnPersonnel.addActionListener (new btnPersonnelListener());
			btnSauvegarde.addActionListener(new btnSauvegardeListener());
			btnClose.addActionListener     (new btnCloseListener());
			
			
			this.setSize( 765, 415 );
			this.setLocationRelativeTo( null );
		}
		
	}


