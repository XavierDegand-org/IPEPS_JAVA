package CetaudMichel;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class GestionJFrame extends JFrame {
	
	private JButton btnLoad = new JButton("Chargement du personnel");
	private JButton btnAffichage = new JButton("Affichage liste du personnel");
	private JButton btnMag = new JButton("Création du magasin");
	private JButton btnPret = new JButton("Prêt de matériel");
	private JButton btnRetour = new JButton("Retour de matériel");
	private JButton btnPersonnel = new JButton("Modification données Personnel");
	private JButton btnSauvegarde = new JButton("Sauvegarde");
	private JButton btnClose = new JButton("Fermer");
	
	static ArrayList<Personnel> personnel = new ArrayList<Personnel>();
	
	public GestionJFrame(){
		
		btnLoad.setBounds(5,5,250,50);
		
		btnLoad.addActionListener(e -> {
			try {
				LoadPersonnel();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		this.add(btnLoad);
			
		btnAffichage.setBounds(255,5,250,50);
		btnAffichage.addActionListener(e -> Affichage());
		this.add(btnAffichage);
			
		btnMag.setBounds(505,5,250,50);
		btnMag.addActionListener(e -> Magasin.Magasin());
		this.add(btnMag);
			
		btnPret.setBounds(5,55,250,50);
		btnPret.addActionListener(e -> Emprunt.getValues());
		this.add(btnPret);
			
		btnRetour.setBounds(255,55,250,50);
		this.add(btnRetour);
				
		btnPersonnel.setBounds(505,55,250,50);
		btnPersonnel.addActionListener(e -> GestionPersonnel());
		this.add(btnPersonnel);
				
		btnSauvegarde.setBounds(5,105,250,50);
		btnSauvegarde.addActionListener(e -> {
			try {
				Sauvegarde();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		this.add(btnSauvegarde);
		
		btnClose.setBounds(255,105,250,50);
		btnClose.addActionListener(e -> System.exit(0));
		this.add(btnClose);
		
		this.setLayout(null);
		this.setResizable(false);
		this.setSize(760,180);
		this.setLocation(350, 250);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	public void LoadPersonnel() throws FileNotFoundException {
		
		File file = new File("/Users/Cetaud/Desktop/test.txt");
		Scanner scan = new Scanner(file);
	
		String[] tab ;
		String[] date ;
		
		int id =0;
		
		while(scan.hasNextLine()) {
			
			tab = scan.nextLine().split(",");
			date = tab[3 ].split("/");
	
			int jour = Integer.parseInt(date[0].trim());
			int mois = Integer.parseInt(date[1].trim());
			int annee = Integer.parseInt(date[2].trim());
			
			personnel.add(new Personnel(id,tab[0],tab[1],Sexe.valueOf(tab[2]),
					new MyDate(jour,mois,annee),tab[4],Departement.valueOf(tab[5])));
			
			id++;
				
			}
			
	}
		
	public void Affichage() {
			
			if(personnel.isEmpty()) {
				System.out.println("Veuilliez charger le fichier !");
				return;
			}
			
			System.out.println("+--------------------+----------------+----------------+------+----------------+-------------------------+");
			System.out.println("|    Département     |    Prénom      |       nom      | Sex  |    Naissance   |          Email          |");
			System.out.println("+--------------------+----------------+----------------+------+----------------+-------------------------+");
		
			StringBuilder tab = new StringBuilder();
			
			for(int i=0; i<personnel.size();i++) {
				tab.append(setFixedLength(personnel.get(i).getDepartement().toString()));
				tab.append(setFixedLength(personnel.get(i).getPrenom()));
				tab.append(setFixedLength(personnel.get(i).getNom()));
				tab.append(setFixedLength(personnel.get(i).getSexe().toString()));
				tab.append(setFixedLength(personnel.get(i).getDateddMMyyyy()));
				tab.append(setFixedLength(personnel.get(i).getEmail()));
				tab.append("\n");
			
			}
			
			System.out.println(tab);
			
			/*
			for(int i=0;i<personnel.size();i++) {
				System.out.println(personnel.get(i));
			}	*/
	}
	
	public void GestionPersonnel() {
		
			if(personnel.isEmpty()) {
				System.out.println("Veuilliez charger le fichier !");
				return;
			}
		
			Affichage();
			
			System.out.println("Introduire le nom de la personne à modifier :");
			System.out.print("Quel est le nom ? : ");
			
			String input = InputData.InputData();
			
			for(int i=0;i<personnel.size();i++){
				
				if(personnel.get(i).getNom().equals(input)){
					
					System.out.println(i + 1 + "  " + personnel.get(i).getNom() + " -- " + personnel.get(i).getPrenom() + " -- " + personnel.get(i).getSexe() + " -- " + personnel.get(i).getEmail() + " -- " + personnel.get(i).getDepartement());
					System.out.println("Introduire les nouvelles valeurs :");
					
					System.out.print("Nouveau nom : ");
					String Nom = InputData.InputData();
					
					System.out.print("Nouveau prénom : ");
					String Prenom = InputData.InputData();
					
					System.out.print("Adresse mail : ");
					String Email = InputData.InputData();
					
					personnel.get(i).setNom(Nom);
					personnel.get(i).setPrenom(Prenom);
					personnel.get(i).setEmail(Email);

					return;
				}
			}
			System.out.println("Nom introuvable !");

		}
	
	public void Sauvegarde() throws IOException {
		
		if(personnel.isEmpty()) {
			System.out.println("Le fichier n'a pas été modifié !");
			return;
		}
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		
		System.out.print("Introduire le nom du fichier ! : ");
		String name = InputData.InputData();
		
		FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/" + name + " " + format.format(date) + ".txt");
		
		writer.write("DTG de la sauvegarde : " + format.format(date));
		writer.write(System.getProperty( "line.separator" ));
		writer.write("+--------------------+----------------+----------------+------+----------------+-------------------------+");
		writer.write(System.getProperty( "line.separator" ));
		writer.write("|    Département     |    Prénom      |       nom      | Sex  |    Naissance   |          Email          |");
		writer.write(System.getProperty( "line.separator" ));
		writer.write("+--------------------+----------------+----------------+------+----------------+-------------------------+");
		writer.write(System.getProperty( "line.separator" ));
		
		for(int i=0;i<personnel.size();i++) {
			
			writer.write(personnel.get(i).toString());
			writer.write(System.getProperty( "line.separator" ));
			
		}
		
		writer.close();
		
		System.out.println("Fichier '" + name + ".txt' a bien été créé ! ");
	}
	
	
	public String setFixedLength(String string) {
		StringBuilder fullString = new StringBuilder(string);
		
		while (fullString.length()< 30) {
			String d = " ";
			char c1 = d.charAt(0);
			fullString.insert(string.length(), c1);
		}
		//TODO size en fonction des colonnes
		String c = fullString.substring(0,30);
		return c;
	}
}





