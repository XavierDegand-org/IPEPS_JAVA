package PierreGrulois;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GestionJFrame extends JFrame {
	
	
	private static final long serialVersionUID = 8342878258434229124L;
	private static ArrayList<Personnel> Person = new ArrayList<Personnel>();
	private static ArrayList<Emprunt> pret = new ArrayList<Emprunt>();
	private Magasin mag =  new Magasin();
	private  StringBuilder Afficher = new StringBuilder();
	private int nombre;
	
	 private JButton btnLoad = new JButton( "Chargement du personnel" );  // Création et texte des bouttons
	 private JButton btnAffichage = new JButton( "Affichage liste du personnel" );
	 private JButton btnMag = new JButton( "Création du magasin" );
	 private JButton btnPret = new JButton( "Pret de matériel" );
	 private JButton btnRetour = new JButton( "Retour de matériel" );
	 private JButton btnPersonnel = new JButton( "Modification données personel" );
	 private JButton btnSauvegarde = new JButton( "Sauvgarde" );
	 private JButton btnClose = new JButton( "Fermer" );
	 
	 public GestionJFrame() {

			this.setDefaultCloseOperation( DISPOSE_ON_CLOSE ); // afin de fermer le programme losrqu'on ferme la fenêtre
			
			JPanel contentPane = (JPanel) this.getContentPane();
			
			contentPane.setLayout(null);      
			btnLoad.setBounds(2, 2, 250, 150);   // Emplacement et taille des bouttons 
			btnAffichage.setBounds(254, 2, 250, 150);
			btnMag.setBounds(506, 2, 250, 150);
			btnPret.setBounds(2, 154, 250, 150);
			btnRetour.setBounds(254, 154, 250, 150);
			btnPersonnel.setBounds(506, 154, 250, 150);
			btnSauvegarde.setBounds(2, 306, 250, 150);
			btnClose.setBounds(254, 306, 250, 150);
			
			try{
				contentPane.add( btnLoad );
				contentPane.add( btnAffichage );
				contentPane.add( btnMag );
				contentPane.add( btnPret );
				contentPane.add( btnRetour );
				contentPane.add( btnPersonnel );
				contentPane.add( btnSauvegarde );
				contentPane.add( btnClose );
				}catch(NullPointerException e) {
					System.out.println("Le contenu est nul");
				}
			
			btnLoad.addActionListener(new LoadPersonnel());
			btnAffichage.addActionListener(new Affichage());
			btnMag.addActionListener(new Shop());                // nom changé pour éviter le conflit avec la classe Magasin()
			btnPret.addActionListener(new Emprunter());
			btnRetour.addActionListener(new RetourEmprunt());
			btnPersonnel.addActionListener(new GestionPersonnel());
			btnSauvegarde.addActionListener(new Sauvegarde());
			btnClose.addActionListener(new Close());
				
			this.setSize( 775, 496 );
	 }

	 public int getNombre() {
		 
		  return nombre;
		 
	 }
	 
	 public void Affiche() {
		 Afficher.append("+------------------+------------------------------+------------------------------+--------+---------------+---------------------+");
		 Afficher.append("\n");
		 Afficher.append("| Département      | Prénom                       | Nom                          | Sexe   | Naissance     | Email               |");
		 Afficher.append("\n");
		 Afficher.append("+------------------+------------------------------+------------------------------+--------+---------------+---------------------+");
		 Afficher.append("\n");
		 for(int cpt=0 ; cpt<Person.size(); cpt++) {
			 
			 Afficher.append(" ");
			 Afficher.append(setFixedLenght(Person.get(cpt).getDepartement(),19," "));
			 Afficher.append(setFixedLenght(Person.get(cpt).getPrenom(),31," "));
			 Afficher.append(setFixedLenght(Person.get(cpt).getNom(),31," "));
			 Afficher.append(setFixedLenght(Person.get(cpt).getSexe(),9," "));
			 Afficher.append(setFixedLenght(Person.get(cpt).getDateddMMyyyy(),16," "));
			 Afficher.append(setFixedLenght(Person.get(cpt).getEmail(),22," "));
			 Afficher.append("\n");
		 
		 }
		 
	 }
	 
	 /**************************************************
	  ************Boutton chargement Personnel**********
	  **************************************************/
	 
	 public JButton LoadPersonnel() {
		 return btnPersonnel;
	 }
	 
	 private class LoadPersonnel implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
			 
			 
			if(Person.isEmpty()==true) {
				
			
				 Person.add(new Personnel("Collon","Albert",Sexe.HOMME, new MyDate(10, 8, 1990), "Collon.a@test.be",Departement.HR));
				 Person.add(new Personnel("Peeters","Marie",Sexe.FEMME, new MyDate(01, 5, 1985), "Peeters_M@@test.be", Departement.HR));	
				 Person.add(new Personnel("Janssens","Sarah",Sexe.FEMME, new MyDate(23, 5, 1999), "Sarah.Janssens@test",Departement.Compta));
				 Person.add(new Personnel("Maes","Henri",Sexe.HOMME, new MyDate(14, 9, 2009), "MaesHenri#test.be",Departement.Compta));
				 Person.add(new Personnel("Jacobs","Charles",Sexe.HOMME, new MyDate(12, 12, 2009), "Charles.j#test.be",Departement.SEC));
				 Person.add(new Personnel("Mertens","Floriane",Sexe.FEMME, new MyDate(20, 8, 1996), "FloFlo.M@test.be",Departement.SEC));
				 Person.add(new Personnel("Willems","Francois-Xavier",Sexe.HOMME, new MyDate(28, 10, 1996), "Willems.F-X@test.be", Departement.Prod));
				 Person.add(new Personnel("O'Neil","Shan",Sexe.HOMME, new MyDate(1, 7, 2001), "ONeil.sh@test.be",Departement.Prod));
				 Person.add(new Personnel("Goossen","Stéphanie",Sexe.FEMME, new MyDate(25, 10, 2008), "NieNieG@test.be",Departement.HR));
				 Person.add(new Personnel("Dumont","Charles",Sexe.HOMME, new MyDate(1, 4, 1969), "dumont.c@test.be",Departement.HR));
				 Person.add(new Personnel("Van Moore","Wilfrid",Sexe.HOMME,new MyDate(25, 2, 1998), "vanmoore.w@test.te",Departement.Compta));
				 Person.add(new Personnel("Herman","Nathalie",Sexe.FEMME, new MyDate(26, 7, 2001), "herman.n@test,be",Departement.Prod)); //adresse Mail non valide
				 Person.add(new Personnel("Bontemps","Annie",Sexe.FEMME, new MyDate(23,9,1998), "bontemps.a@test.be",Departement.Prod));
				 nombre=Person.size();
			 
			 }
		 }
	 }
	 
	 /*************************************************
	  ************Boutton création du magasin**********
	  *************************************************/
	 
	 public JButton Magasin(){
		 return btnMag;
	 }
	 
	 private class Shop implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
			 
			 if (mag.isEmpty()){
				 
				mag.AjouterProduit("HP","Elitebook 850 G7");
				mag.AjouterProduit("HP","Elitebook 830 G7 X360");
				mag.AjouterProduit("Dell","Inspiron 15 3000");
				mag.AjouterProduit("Dell","XPS 13");
				mag.AjouterProduit("Dell","XPS 15");
				mag.AjouterProduit("Lenovo","Thinkpad E15 G2");
				mag.AjouterProduit("Lenovo","IdeaPad 3 14IIL05 81WD00B2MH");
				mag.ListeMap();
				
			 }
			 else {
				 System.out.println("Vous avez déjà charger le magasin");
			 }
			 	
			 
			}
			
	 }
	 
	 /*************************************************
	  ************Boutton affichage personnel**********
	  *************************************************/
	 
	 public JButton Affichage() {
		 return btnAffichage;
	 }
	 
	 private class Affichage implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
			 if(Person.isEmpty()==true) {
				 System.out.println("Veuillez charger la liste du personnel pour effectuer cette action! ");
			 }
			 else {
				 Affiche();		
				 System.out.println(Afficher.toString());
				 Afficher.setLength(0);
			 }
			 
		 }

				 
	 }

	 static String setFixedLenght(String element, int longueur, String caractere) {  //fonction permettant de calibrer la taille des strings à 20 caractères
		 
		 StringBuilder ss= new StringBuilder(element);
	        while (ss.length() < longueur) {  
	                String d = caractere;
	                try {
	                	char c1 = d.charAt(0);
	                	ss.insert(element.length(),c1);
	                }catch(IndexOutOfBoundsException e) {
	                	System.out.println("l'argument index est négatif ou non inférieur à la longueur de cette chaîne.");
	                }
	                
	               
	            }
	        String c = ss.substring(0, longueur);
	        return c;
		 
	 } 
	 
	 /**********************************************
	  ************Boutton pret de materiel**********
	  **********************************************/
	 
	 public JButton Emprunt() {
		 return btnPret;
	 }
	 
	 private class Emprunter implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
			 
			 if(Person.isEmpty()==true){
				 System.out.println("Veuillez charger la liste du personnel pour effectuer cette action! \n");
			 }
			 else if (mag.isEmpty()==true) {
				 System.out.println("Veuillez charger le magasin pour effectuer cette action! \n");
			 }
			 else if (pret.isEmpty()== true) {
				 
				 	pret.add(new Emprunt(Person.get(0),mag.map.get(1)));
				 	pret.add(new Emprunt(Person.get(1),mag.map.get(3)));
			    	pret.add(new Emprunt(Person.get(2),mag.map.get(4)));
					pret.add(new Emprunt(Person.get(3),mag.map.get(6)));
					pret.add(new Emprunt(Person.get(6),mag.map.get(7)));
					for (int cpt = 0; cpt < pret.size(); cpt++) {
						System.out.println(pret.get(cpt).toString());
					}
				
				 
			 }
			 else {
				 for (int cpt = 0; cpt < pret.size(); cpt++) {
						System.out.println(pret.get(cpt).toString());
				 
				 }
			 } 
			
			}
	 }
	 
	 /********************************************
	  ************boutton retour article**********
	  ********************************************/
	 
	 public JButton RetourEmprunt() {
		 return btnRetour;
	 }
	 
	 private class RetourEmprunt implements ActionListener{
		 
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
			 if(Person.isEmpty()==true){
				 System.out.println("Veuillez charger la liste du personnel pour effectuer cette action! \n");
			 }
			 else if (mag.isEmpty()==true) {
				 System.out.println("Veuillez charger le magasin pour effectuer cette action! \n");
			 }
			 else if (pret.isEmpty()== true) {
				 
				 	System.out.println("Veuillez charger la liste des emprunts pour effectuer cette action! \n");
			 }
			 else {
				 int indice;
				 boolean verrif = false;
				 
				 System.out.println("liste des emprunts");
				 for (int cpt = 0; cpt < pret.size(); cpt++) {
					 
					 Afficher.append("N° "+(cpt+1)+"   ");
					 Afficher.append(setFixedLenght(pret.get(cpt).getEmprunteur().getNom(),15," "));
					 Afficher.append(setFixedLenght(pret.get(cpt).getMateriel(),8," "));
					 Afficher.append(pret.get(cpt).getArticle()+"\n");
				 }
				 System.out.println(Afficher.toString());
				 Afficher.setLength(0);
				 System.out.println("introduire le numéro d'emprunt à annuler:");
				 do {
					 indice=Lire.nbre();
					 if(indice > pret.size() ) {
						 System.out.println("L'indice est trop grand, veuillez recommencer:");
					 }
					 else if (indice == 0) {
						 System.out.println("L'indice entré est inexistant. Modification annulèe!");
						 verrif = true;
					 }
					 else {
						 pret.remove(indice-1);
						 Lire.vider();
						 for (int cpt = 0; cpt < pret.size(); cpt++) {
						 
							 Afficher.append("N° "+(cpt+1)+"   ");
							 Afficher.append(setFixedLenght(pret.get(cpt).getEmprunteur().getNom(), 15," "));
							 Afficher.append(setFixedLenght(pret.get(cpt).getMateriel(), 8, " "));
							 Afficher.append(pret.get(cpt).getArticle()+"\n");
						 }
						 System.out.println(Afficher.toString());
						 Afficher.setLength(0);
					 }
				 }while(verrif == false);	 
			}		
		 }
	 }
	 
	 /****************************************************
	  ******** Boutton de modification du personnel ******
	  ****************************************************/
	 
	 public JButton getionPersonnel() {
		 return btnPersonnel;
	 }
	 
	 private class GestionPersonnel implements ActionListener{
		 int indiceIndividu;
		 @Override
			public void actionPerformed (ActionEvent e) {
			 if(Person.isEmpty()==true){
				 System.out.println("Veuillez charger la liste du personnel pour effectuer cette action! \n");
			 }
			 else {
				 String individu;
				 boolean trouver= false;
				 
				 Affiche();
				 System.out.println(Afficher.toString());
				 Afficher.setLength(0);;
				 System.out.println("Intriduire le nom de la personne a modifier:");
				 System.out.println("Entrer un nom:");
				 individu = Lire.texte();
				 for (int cpt = 0; cpt < getNombre();cpt++) {
					 if(Person.get(cpt).getNom().equals(individu)) {
						 this.indiceIndividu=cpt;
						 trouver = true;
					 }
				 }
				 
				 if(trouver == false) {
					 System.out.println("Aucune correspndance trouvé!");
				 }
				 else {
					 System.out.println(getNombre());
					 
					 Person.get(indiceIndividu).setNom(InputData.InputNom());
					 Person.get(indiceIndividu).setPrenom(InputData.InputPrenom());
					 Person.get(indiceIndividu).setEmail(InputData.InputEmail());
					 System.out.println("Modification effectué avec succés");
					 
				 }
				 System.out.println("Appyer sur 'Enter'.");
				 individu = Lire.vider();
				 
			 }
			 
		 }
	 }
	 
	 /***************************************************
	  ************ Boutton de Sauvegarde  ***************
	  ***************************************************/
	 
	 public JButton Sauvegarder() {
		 
		 return btnSauvegarde;
		 
	 }
	 
	 private class Sauvegarde implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
			 			 			 
			 if(Person.isEmpty()==true){
				 System.out.println("Veuillez charger la liste du personnel pour effectuer cette action! \n");
			 }
			 else if (mag.isEmpty()==true) {
				 System.out.println("Veuillez charger le magasin pour effectuer cette action! \n");
			 }
			 else if (pret.isEmpty()== true) {
				 
				 	System.out.println("Veuillez charger la liste des emprunts pour effectuer cette action! \n");
			 }
			 else {
				 String nomFile = InputData.InputNomFichier();
				 File folder = new File("src/PierreGrulois/Fichier");
				 File file= new File("./src/PierreGrulois/Fichier/"+nomFile+".txt");
				 Date date = new Date();
				 if (folder.exists()==false) {
					 folder.mkdir();
				 }
				 if (file.exists()==false) {
					 
						 try {
							file.createNewFile();
						} catch (IOException e1) {
							System.out.println("une erreur d'entrée/sortie c'est produite");
						} catch (SecurityException e1) {
							System.out.println("un gestionnaire de sécurité existe et sa méthode refuse l'accès en écriture au fichier");
						}
						 try {
							FileWriter write = new FileWriter(file);
							BufferedWriter buffWrite = new BufferedWriter(write);
							try{
								 SimpleDateFormat dateSauvegarde = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
								 buffWrite.write("DTG de la sauvegarde : "+ dateSauvegarde.format(date));
								 
							 }catch(NullPointerException e1) {
								 System.out.println("Le motif donné est nul");
							 }catch(IllegalArgumentException e1) {
								 System.out.println("Le modèle donné est invalide");
							 }
							
							buffWrite.newLine();
							
							Affiche();							
							buffWrite.append(Afficher.toString());
							Afficher.setLength(0);
							buffWrite.newLine();
							buffWrite.newLine();
							buffWrite.write("+-----+------------------------------+----------------------------------------+");
							buffWrite.newLine();
							buffWrite.write("| N°  | Nom - Prénom                 | Matèriel                               |");
							buffWrite.newLine();
							buffWrite.write("+-----+------------------------------+----------------------------------------+");
							buffWrite.newLine();
							
							for (int cpt = 0; cpt < pret.size(); cpt++) {
								 Afficher.append("   "+(cpt+1)+"    ");
								 Afficher.append(setFixedLenght(pret.get(cpt).getEmprunteur().getNom() + " " + pret.get(cpt).getEmprunteur().getPrenom(), 30," "));
								 Afficher.append(setFixedLenght(pret.get(cpt).getMateriel(), 8, " "));
								 Afficher.append(pret.get(cpt).getArticle()+"\n");
							 }
							buffWrite.append(Afficher.toString());
							Afficher.setLength(0);
							buffWrite.close();
							System.out.println("Sauvegade effectué avec succés.");
								
							
						} catch (IOException e1) {
							System.out.println("Le fichier est un répretoire, n'existe pas , ne peux être créé ou ne peux être ouvert");
						}
						 
					 
				 }
				 else {
					 System.out.println("Le fichier existe déja.");
				 }
				 
			 }
			}
	 }
	 
	 /******************************************
	  *********** Boutton fermer ***************
	  *****************************************/
	 
	 public JButton Close() {
		 
		 return btnClose; 
	 }
	 
	 private class Close implements ActionListener{
		 
		 @Override
			public void actionPerformed (ActionEvent e) {
				try{
					System.exit(0);  // forums.commentcamarche.net/forum/affich-3383988-java-fermer-une-fenetre-avec-un-jbutton
				}catch(SecurityException e1){
					System.out.println("Un gestionnaire de sécurité existe et sa méthode checkExit n'autorise pas la sortie avec l'état spécifié.");
				}
		 	}
	 }
	 
}
	
