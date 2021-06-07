package yacineFrimi;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;

public class GestionJFrame extends JFrame {
	
	static Path pathPersonnel = Paths.get("C:\\Users\\yacin\\git\\IPEPS_JAVA\\Examen_POO\\src\\yacineFrimi\\Personnel.txt");
	static File fichierPersonnel = new File("C:\\Users\\yacin\\git\\IPEPS_JAVA\\Examen_POO\\src\\yacineFrimi\\Personnel.txt");
	static Path pathProduits = Paths.get("C:\\Users\\yacin\\git\\IPEPS_JAVA\\Examen_POO\\src\\yacineFrimi\\produits.txt");
	static File fichierProduits = new File("C:\\Users\\yacin\\git\\IPEPS_JAVA\\Examen_POO\\src\\yacineFrimi\\produits.txt");
	
	
	
	
	
	private JButton btnLoad = new JButton("Chargement du personnel");
	private JButton btnAffichage = new JButton("Affichage liste du personnel");
	private JButton btnPersonnel = new JButton("Création du magasin");
	private JButton btnMag = new JButton("Prêt de matériel");
	private JButton btnPret = new JButton("Retour de matériel");
	private JButton btnRetour = new JButton("Modification données personnel");
	private JButton btnSauvegarde = new JButton("Sauvegarde");
	private JButton btnClose = new JButton("Fermer");
	
	public GestionJFrame() {
		super("Gestion personnel & prêt matériel.");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel ecranPrincipal = (JPanel) this.getContentPane();
		ecranPrincipal.setLayout(new GridLayout(2,2,2,2));
		
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
		
		btnClose.addActionListener((e) -> dispose());
		
		
		
		
		
		
	}
	
	
	
	/*public void LoadPersonnel() throws IOException {
		
		List<Personnel> listePersonnel = new ArrayList<Personnel>();
		
		BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(fichierPersonnel));
            String ligne;
            int id = 0;
            while ((ligne = br.readLine()) != null){
                String tokens[] = ligne.split(",");
                String date[] =  tokens[3].split("/");
                
                int j = Integer.parseInt(date[0].trim());
                int m = Integer.parseInt(date[1].trim());
                int a = Integer.parseInt(date[2].trim());
                
                MyDate dateNaiss = new MyDate(j,m,a);
             
                
                
             
       
                listePersonnel.add(new Personnel(id,(tokens[0]),(tokens[1]), Sexe.valueOf(tokens[2]),dateNaiss,(tokens[4]),(tokens[5])));
                id++;
            }
        }  catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            } finally {
            	System.out.println("Liste personnel chargée.");
            }*/

		    /*for (Personnel p : listePersonnel) {
		    	System.out.println(p);
		    }*/
		    

		       
		    
		}

	
	
	


