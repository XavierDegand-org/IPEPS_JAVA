package NathanaëlDuyck;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GestionJFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton btnLoad = new JButton( "Chargement du personnel" );
	 private JButton btnAffichage = new JButton( "Affichage liste du  personnel" );
	 private JButton btnMag = new JButton( "Création du magasin" );
	 private JButton btnPret = new JButton( "Prêt de matériel" );
	 private JButton btnRetour = new JButton( "Retour de matériel" );
	 private JButton btnPersonnel = new JButton( "Modification données Personnel" );
	 private JButton btnSauvegarde = new JButton( "Sauvegarde" );
	 private JButton btnClose = new JButton( "Fermer" );
	 
	 private static String nom;
	 private static String fichier;
	 private static int tailleNom = 30;
	 
	 private static ArrayList<Personnel> Person = new ArrayList<>();
	 private static ArrayList<Emprunt> pret = new ArrayList<>();
	 private static ArrayList<Magasin> mag = new ArrayList<>();
	 private static boolean initialisation = false;
	 
	 public GestionJFrame() {
		 super( "Gestion Personnel & prêt matériel" );
		 this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		 
		 JPanel contentPane = (JPanel) this.getContentPane();
		 contentPane.setLayout( new FlowLayout() );
		 contentPane.setLayout(null);
		 btnLoad.setBounds(10,20, 290, 150);
		 btnAffichage.setBounds(300,20, 290, 150);
		 btnMag.setBounds(590,20, 290, 150);
		 btnPret.setBounds(10,190,290,150);
		 btnRetour.setBounds(300,190, 290,150);
		 btnPersonnel.setBounds(590,190,290,150);
		 btnSauvegarde.setBounds(10,370,290,150);
		 btnClose.setBounds(300,370,290,150);
		 
		 contentPane.add( btnLoad );
		 contentPane.add( btnAffichage );
		 contentPane.add( btnMag );
		 contentPane.add( btnPret );
		 contentPane.add( btnRetour );
		 contentPane.add( btnPersonnel );
		 contentPane.add( btnSauvegarde );
		 contentPane.add( btnClose );
		 
		 btnLoad.addActionListener(new ActionListener(){

			 	@Override
				public void actionPerformed(ActionEvent e) {
					LoadPersonnel();
				} 
		 });
		 
		 btnAffichage.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					Affichage();
				}
		 });
		 
		 btnMag.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					Magasin();		
				} 
		 }); 
		 
		 btnPret.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					Emprunt();
				} 
		 });
		 
		 btnRetour.addActionListener(new ActionListener(){
				

				@Override
				public void actionPerformed(ActionEvent e) {
					RetourEmprunt();
				} 	
		 });
		 
		 btnPersonnel.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					GestionPersonnel();	
					Affichage();
				} 
		 });
		 
		 btnSauvegarde.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					Sauvegarde();		
				} 
		 });
		 
		 btnClose.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					 System.exit(0);		
				} 
		 });
		 
		 this.setSize( 900 , 600 );
		 this.setLocationRelativeTo( null );
	 }
	 
	public static void LoadPersonnel() {
		
		 Person.add(new Personnel(1,"Collon","Albert",Sexe.HOMME,new MyDate(10,8,1990),"Collon.a@test.be",Departement.HR));
		 Person.add(new Personnel(2,"Peeters","Marie",Sexe.FEMME,new MyDate(1,5,1995),"Peeters_M@@test.be",Departement.HR));
		 Person.add(new Personnel(3,"Janssens","Sarah",Sexe.FEMME,new MyDate(23,5,1999),"Sarah.Janssens@test",Departement.Compta));
		 Person.add(new Personnel(4,"Jacobs","Charles",Sexe.HOMME,new MyDate(10,8,1990),"Charles.j#test.be",Departement.SEC));
		 Person.add(new Personnel(5,"Maes","Henri",Sexe.HOMME,new MyDate(14,9,2009),"MaesHenri#test.be",Departement.Compta));
		 Person.add(new Personnel(6,"Mertens","Floriane",Sexe.FEMME,new MyDate(20,8,1996),"FloFlo.M@test.be",Departement.SEC));
		 Person.add(new Personnel(7,"Willems","Francois-Xavier",Sexe.HOMME,new MyDate(28,10,1996),"Willems.F-X@test.be",Departement.Prod));
		 Person.add(new Personnel(8,"O'Neil","Shan",Sexe.HOMME,new MyDate(01,07,2001),"ONeil.sh@test.be",Departement.Prod));
		 Person.add(new Personnel(9,"Goossen","Stéphanie",Sexe.FEMME,new MyDate(25,10,2008),"NieNieG@test.be",Departement.HR));
		 Person.add(new Personnel(10,"Dumont","Charles",Sexe.HOMME,new MyDate(01,04,1969),"dumont.c@test.be",Departement.HR));
		 Person.add(new Personnel(11,"Van Moore","Wilfrid",Sexe.HOMME,new MyDate(25,02,1998),"vanmoore.w@test.te",Departement.Compta));
		 Person.add(new Personnel(12,"Herman","Nathalie",Sexe.FEMME,new MyDate(26,07,2001),"herman.n@test,be",Departement.Prod));
		 Person.add(new Personnel(13,"Bontemps","Annie",Sexe.FEMME,new MyDate(23,9,1998),"bontemps.a@test.be",Departement.Prod));
		}
	
	public static void Magasin() {
		Magasin magasin= new Magasin();
		mag.add(magasin);
		
		magasin.AjouterProduit(1,"HP","Elitebook 850 G7");
		magasin.AjouterProduit(2,"HP","Elitebook 830 G7 X360");
		magasin.AjouterProduit(3,"Dell","Inspiron 15 3000");
		magasin.AjouterProduit(4,"Dell","XPS 13");
		magasin.AjouterProduit(5,"Dell","XPS 15");
		magasin.AjouterProduit(6,"Lenovo","Thinkpad E15 G2");
		magasin.AjouterProduit(7,"Lenovo","IdeaPad 3 14IIL05 81WD00B2MH ");
		
		magasin.listeMap();
	}
	
	public static void Affichage() {
		if(Person.size() ==0) {
			System.out.println("Affichage impossible, pas de personnel !");
		}
		else {
			System.out.println("+-----------------------+-----------------------------+-----------------------------+--------+----------------+---------------------------------------+");
			System.out.println("| Département           | Prénom                      | Nom                         | Sexe   |  Naissance     | Email                                 |");
			System.out.println("+-----------------------+-----------------------------+-----------------------------+--------+----------------+---------------------------------------+");
			StringBuilder sb = new StringBuilder();
			for (Personnel personnel : Person) {
				sb.append(" ");
				sb.append(setFixedLength(personnel.getDepartement(),25));
				sb.append(setFixedLength(personnel.getPrenom(),tailleNom));
				sb.append(setFixedLength(personnel.getNom(),tailleNom));		
				sb.append(setFixedLength(personnel.getSexe(),10));
				sb.append(setFixedLength(personnel.getDateddMMyyyy(),16));
				sb.append(setFixedLength(personnel.getEmail(),10));
				sb.append("\n");
				}	
			System.out.println(sb.toString());
			}
		}
	
	public static String setFixedLength(String s,int taille) {
		StringBuilder ss = new StringBuilder(s);
		while(ss.length() < taille) {
			String d =" ";
			char c1 = d.charAt(0);
			ss.insert(s.length(),c1);
		}
		String c = ss.substring(0,taille);
		return c;
	}

	public static void Emprunt() {
		if((Person.isEmpty()) || (mag.isEmpty())) {
			System.out.println("Veuillez charger le personnel et créer le magasin\n");
		}
		else if ((pret.isEmpty())&& (!initialisation)) {
			pret.add(new Emprunt(1,new Personnel(1,"Collon","Albert",Sexe.HOMME,new MyDate(10,8,1990),"Collon.a@test.be",Departement.HR),new Produit("HP","Elitebook 850 G7")));	
			pret.add(new Emprunt(2,new Personnel(2,"Peeters","Marie",Sexe.FEMME,new MyDate(1,5,1995),"Peeters_M@@test.be",Departement.HR),new Produit("Dell","Inspiron 15 3000")));	
			pret.add(new Emprunt(3,new Personnel(3,"Janssens","Sarah",Sexe.FEMME,new MyDate(23,5,1999),"Sarah.Janssens@test",Departement.Compta),new Produit("Dell","XPS 13")));	
			pret.add(new Emprunt(4,new Personnel(4,"Jacobs","Charles",Sexe.HOMME,new MyDate(10,8,1990),"Charles.j#test.be",Departement.SEC),new Produit("Lenovo","Thinkpad E15 G2")));	
			pret.add(new Emprunt(5,new Personnel(7,"Willems","Francois-Xavier",Sexe.HOMME,new MyDate(28,10,1996),"Willems.F-X@test.be",Departement.Prod),new Produit("Lenovo","IdeaPad 3 14IIL05 81WD00B2MH ")));	
			initialisation = true;
			for (Emprunt emprunt : pret)
			{
			System.out.println(emprunt);
			}
		} else {
			for (Emprunt emprunt : pret)
			{
			System.out.println(emprunt);
			}
		}
	}
	public static void RetourEmprunt() {
	boolean nombreValide =false;
	int compteur;
	if(pret.isEmpty()) {
		System.out.println("La liste des prêt est vide donc il n'y a rien à rendre\n");
	}
	else {
		System.out.println("Liste des emprunts");
		compteur=1;
		for (Emprunt emprunt : pret)
		{
		System.out.println("N° "+compteur+" "+emprunt.getEmprunteur().getNom()+" "+emprunt.getMateriel().getNom()+" "+emprunt.getMateriel().getDescription());
		compteur++;
		}
		System.out.println("Introduire le numéro d'emprunt à annuler : ");
		while(!nombreValide) {
		try { 
			int nbemprunt = Lire.nbre()-1;
			 pret.remove(nbemprunt);
			 compteur=1;
			 for (Emprunt emprunt : pret)
				{
				 System.out.println("N° "+compteur+" "+emprunt.getEmprunteur().getNom()+" "+emprunt.getMateriel().getNom()+" "+emprunt.getMateriel().getDescription());
				compteur++;
				}
			 nombreValide=true;
		}
		catch( java.lang.IndexOutOfBoundsException e) {
			 System.out.println("erreur,veuillez rentrer un nombre proposé dans la liste d'emprunt");
		}
		}
	}
	}
	
	public static void GestionPersonnel() {
		boolean nomValide = false;
		String nomChangement;
		String prenomChangement;
		String mailChangement;
		if(Person.size() ==0) {
			System.out.println("Affichage impossible, pas de personnel !");
		}
		else {
			System.out.println("+-----------------------+-----------------------------+-----------------------------+--------+----------------+---------------------------------------+");
			System.out.println("| Département           | Prénom                      | Nom                         | Sexe   |  Naissance     | Email                                 |");
			System.out.println("+-----------------------+-----------------------------+-----------------------------+--------+----------------+---------------------------------------+");
			StringBuilder sb = new StringBuilder();
			for (Personnel personnel : Person) {
				sb.append(" ");
				sb.append(setFixedLength(personnel.getDepartement(),25));
				sb.append(setFixedLength(personnel.getPrenom(),tailleNom));
				sb.append(setFixedLength(personnel.getNom(),tailleNom));		
				sb.append(setFixedLength(personnel.getSexe(),10));
				sb.append(setFixedLength(personnel.getDateddMMyyyy(),16));
				sb.append(setFixedLength(personnel.getEmail(),10));
				sb.append("\n");
				}	
			System.out.println(sb.toString());
			System.out.println("Introduire le nom de la personne à modifier :");
			System.out.println("Entrer un nom : ");
			nom=Lire.texte();
			while(!nomValide) {
			for (Personnel personnel : Person) {
				if(nom.equals(personnel.getNom())) {
					System.out.println(personnel.getIdPersonnel()+"  "+personnel.getNom()+"--"+personnel.getPrenom()+"--"+personnel.getSexe()+"--"+personnel.getEmail()+"--"+personnel.getDepartement());
					nomValide=true;
				}
			}
			if(!nomValide) { 
				System.out.println("Le nom que vous avez tapé n'est pas dans la liste du personnel ");
				System.out.println("Introduire le nom de la personne à modifier :");
				System.out.println("Essayer à nouveau d'entrer un nom : ");
				nom=Lire.texte();
			}
			}
			System.out.println("Introduire les nouvelles valeurs:");
			nomChangement = InputData.inputNomPrenom("Nom");
			prenomChangement = InputData.inputNomPrenom("Prénom");
			mailChangement = InputData.inputEmail();
			for (Personnel personnel : Person) {
				if(nom.equals(personnel.getNom())) {
					personnel.setNom(nomChangement);
					personnel.setPrenom(prenomChangement);
					personnel.setEmail(mailChangement);
				}
				
			}
		}
	}
	public static void Sauvegarde() {
		if((Person.isEmpty()) || (pret.isEmpty()) || (mag.isEmpty()))   {
			System.out.println("Affichage impossible, vous n'avez pas chargé toutes les données !");
		}
		else{
		System.out.println("Introduire le nom du fichier extension .txt! ");
		fichier=InputData.inputNomFichier();
		StringBuilder sb = new StringBuilder();
		for (Personnel personnel : Person) {
				sb.append(" ");
				sb.append(setFixedLength(personnel.getDepartement(),25));
				sb.append(setFixedLength(personnel.getPrenom(),tailleNom));
				sb.append(setFixedLength(personnel.getNom(),tailleNom));		
				sb.append(setFixedLength(personnel.getSexe(),10));
				sb.append(setFixedLength(personnel.getDateddMMyyyy(),16));
				sb.append(setFixedLength(personnel.getEmail(),10));
				sb.append("\n");
				}	
		int compteur=1;
		StringBuilder sbpret = new StringBuilder();
		for (Emprunt emprunt : pret)
		 {
			sbpret.append("  ");
			sbpret.append(compteur);
			sbpret.append("          ");
			sbpret.append(setFixedLength(emprunt.getEmprunteur().getNom(),tailleNom));
			sbpret.append(setFixedLength(emprunt.getEmprunteur().getPrenom(),tailleNom));
			sbpret.append("    ");
			sbpret.append(setFixedLength(emprunt.getMateriel().getNom(),7));
			sbpret.append(setFixedLength(emprunt.getMateriel().getDescription(),tailleNom));
			sbpret.append("\n");
			compteur++;
		}	
		try (BufferedWriter bufWrite = new BufferedWriter (new FileWriter(new File("./src/NathanaëlDuyck",fichier)))){
			
			bufWrite.write("+-----------------------+-----------------------------+-----------------------------+--------+----------------+---------------------------------------+");
			bufWrite.newLine();
			bufWrite.write("| Département           | Prénom                      | Nom                         | Sexe   |  Naissance     | Email                                 |");
			bufWrite.newLine();
			bufWrite.write("+-----------------------+-----------------------------+-----------------------------+--------+----------------+---------------------------------------+");																														
			bufWrite.newLine();
			bufWrite.write(sb.toString());
			bufWrite.write("+----------+--------------------------------------------------------------+-----------------------------------------+");
			bufWrite.newLine();
			bufWrite.write("| N°       | Nom - Prénom                                                 |  Matériel                               |");
			bufWrite.newLine();
			bufWrite.write("+----------+--------------------------------------------------------------+-----------------------------------------+");
			bufWrite.newLine();
			bufWrite.write(sbpret.toString());
			
		} catch (IOException io) {
			System.err.println("Une erreur est survenue : "+io.getMessage());
		}
		}
		}
}

	 

