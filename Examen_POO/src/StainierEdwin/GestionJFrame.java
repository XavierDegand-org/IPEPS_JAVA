package StainierEdwin;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GestionJFrame extends JFrame {

	// Les diff�rents boutons
	private JButton btnLoad = new JButton("Chargement du personnel");
	private JButton btnAffichage = new JButton("Affichage liste du personnel");
	private JButton btnMag = new JButton("Cr�ation du magasin");
	private JButton btnPret = new JButton("Pr�t de mat�riel");
	private JButton btnRetour = new JButton("Retour de mat�riel");
	private JButton btnPersonnel = new JButton("Modification donn�es Personnel");
	private JButton btnSauvegarde = new JButton("Sauvegarde");
	private JButton btnClose = new JButton("Fermer");
	
	public GestionJFrame()
	{
		super("Implementation GestionJFrame");
		
		// Param�tres de la fen�tre
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Gestion Personnel & pr�t mat�riel.");
			
		// Cr�er JPanel
		JPanel container = (JPanel)this.getContentPane();
		container.setLayout(new FlowLayout());
		
		// Ajouter les boutons au JPanel
		container.add(btnLoad);
		container.add(btnAffichage);
		container.add(btnMag);
		container.add(btnPret);
		container.add(btnRetour);
		container.add(btnPersonnel);
		container.add(btnSauvegarde);
		container.add(btnClose);
		
		// Click on btnLoad
		btnLoad.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(((JButton)e.getSource()).getText());
			}
		});
		
		// Click on btnAffichage
		btnAffichage.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(((JButton)e.getSource()).getText());
			}
		});
		
		// Click on btnMag
		btnMag.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(((JButton)e.getSource()).getText());
			}
		});
		
		// Click on btnPret
		btnPret.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(((JButton)e.getSource()).getText());
			}
		});
		
		// Click on btnRetour
		btnRetour.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(((JButton)e.getSource()).getText());
			}
		});
		
		// Click on btnPersonnel
		btnPersonnel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(((JButton)e.getSource()).getText());
			}
		});
		
		// Click on btnSauvegarde
		btnSauvegarde.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(((JButton)e.getSource()).getText());
			}
		});
		
		// Click on btnClose
		btnClose.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(((JButton)e.getSource()).getText());
				System.exit(0);
			}
		});
		
	}
	
}
