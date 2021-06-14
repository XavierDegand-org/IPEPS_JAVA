package CetaudMichel;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
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
	static ArrayList<Emprunt> emprunt = new ArrayList<Emprunt>();

	public GestionJFrame() {

		btnLoad.setBounds(5, 5, 250, 50);
		btnLoad.addActionListener(e -> {
			try {
				LoadPersonnel();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		this.add(btnLoad);

		btnAffichage.setBounds(255, 5, 250, 50);
		btnAffichage.addActionListener(e -> System.out.println(Affichage()));
		this.add(btnAffichage);

		btnMag.setBounds(505, 5, 250, 50);
		btnMag.addActionListener(e -> {
			try {
				Magasin();
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
		this.add(btnMag);

		btnPret.setBounds(5, 55, 250, 50);
		btnPret.addActionListener(e -> Enprunt());
		this.add(btnPret);

		btnRetour.setBounds(255, 55, 250, 50);
		btnRetour.addActionListener(e -> RetourEmprunt());
		this.add(btnRetour);

		btnPersonnel.setBounds(505, 55, 250, 50);
		btnPersonnel.addActionListener(e -> GestionPersonnel());
		this.add(btnPersonnel);

		btnSauvegarde.setBounds(5, 105, 250, 50);
		btnSauvegarde.addActionListener(e -> {
			try {
				Sauvegarde();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		this.add(btnSauvegarde);

		btnClose.setBounds(255, 105, 250, 50);
		btnClose.addActionListener(e -> System.exit(0));
		this.add(btnClose);

		this.setTitle("Gestion de Personnel & Prêt de matériel");
		this.setLayout(null);
		this.setResizable(false);
		this.setSize(760, 180);
		this.setLocation(350, 250);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void RetourEmprunt() {
		System.out.println("Liste des emprunts");
		int item;
		for (item = 0; item < emprunt.size(); item++) {
			System.out.printf("N° %d %s\t%s %s\n", item + 1, emprunt.get(item).getEmprunteur(),
					emprunt.get(item).getArticles(), emprunt.get(item).getProduit());
		}
		System.out.print("Entroduire le numero d'emprunt à annuler : ");
		boolean stop = true;
		while (stop) {

			int input = Lire.nbre();

			if (input < item + 1) {
				emprunt.remove(input - 1);

				for (item = 0; item < emprunt.size(); item++) {
					System.out.printf("N° %d %s\t%s %s\n", item + 1, emprunt.get(item).getEmprunteur(),
							emprunt.get(item).getArticles(), emprunt.get(item).getProduit());
				}
				stop = false;

			} else {
				System.out.print("Données invalide !\nEntroduire le numero d'emprunt à annuler : ");
			}
		}

	}

	public void LoadPersonnel() throws FileNotFoundException {

		if (!personnel.isEmpty()) {
			System.out.println("La liste personnel est déjà chargée !");
			return;
		}

		File file = new File(System.getProperty("user.dir") + "/Sources/Personnel.txt");
		Scanner scan = new Scanner(file);

		String[] tab;
		String[] date;

		int id = 0;

		while (scan.hasNextLine()) {

			tab = scan.nextLine().split(",");
			date = tab[3].split("/");

			int jour = Integer.parseInt(date[0].trim());
			int mois = Integer.parseInt(date[1].trim());
			int annee = Integer.parseInt(date[2].trim());

			personnel.add(new Personnel(id, tab[0], tab[1], Sexe.valueOf(tab[2]), new MyDate(jour, mois, annee), tab[4],
					Departement.valueOf(tab[5])));

			id++;

		}
		scan.close();

	}

	public StringBuilder Affichage() {

		StringBuilder tab = new StringBuilder();

		if (personnel.isEmpty()) {
			return tab.append("Veuilliez charger le fichier !");
		}

		tab.append(
				"+--------------------+------------------------------+------------------------------+--------+-----------+------------------------------+\n");
		tab.append(
				"|    Département     |             Prénom           |              nom             |  Sex   | Naissance |             Email            |\n");
		tab.append(
				"+--------------------+------------------------------+------------------------------+--------+-----------+------------------------------+\n");

		for (int i = 0; i < personnel.size(); i++) {
			tab.append("  ");
			tab.append(setFixedLength(personnel.get(i).getDepartement().getLabel(), 21));
			tab.append(setFixedLength(personnel.get(i).getPrenom(), 31));
			tab.append(setFixedLength(personnel.get(i).getNom(), 31));
			tab.append(setFixedLength(personnel.get(i).getSexe().toString(), 9));
			tab.append(setFixedLength(personnel.get(i).getDateddMMyyyy(), 12));
			tab.append(setFixedLength(personnel.get(i).getEmail(), 31));
			tab.append("\n");

		}

		return tab;
	}

	public void GestionPersonnel() {

		if (personnel.isEmpty()) {
			System.out.println("Veuilliez charger le fichier !");
			return;
		}

		System.out.println(Affichage());

		System.out.println("Introduire le nom de la personne à modifier ! \n Quel est le nom ? : ");

		boolean stop = true;

		while (stop) {

			String input = Lire.texte();

			for (int i = 0; i < personnel.size(); i++) {

				if (personnel.get(i).getNom().equals(input)) {

					System.out.println(i + 1 + "  " + personnel.get(i).getNom() + " -- " + personnel.get(i).getPrenom()
							+ " -- " + personnel.get(i).getSexe() + " -- " + personnel.get(i).getEmail() + " -- "
							+ personnel.get(i).getDepartement());
					System.out.println("Introduire les nouvelles valeurs ...");

					System.out.print("Nouveau nom : ");
					personnel.get(i).setNom(InputData.inputNomPrenom());
					System.out.print("Nouveau prenom : ");
					personnel.get(i).setPrenom(InputData.inputNomPrenom());
					System.out.print("Nouveau email : ");
					personnel.get(i).setEmail(InputData.inputEmail());

					System.out.println(Affichage());

					return;
				}

			}
			System.out.println("Nom introuvable ! Veuillez réessayer.");

		}
	}

	public void Sauvegarde() throws IOException {

		if (personnel.isEmpty()) {
			System.out.println("Le fichier n'a pas été modifié !");
			return;
		}

		// Afichage Personnels
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();

		System.out.print("Introduire le nom du fichier ! : ");
		String name = InputData.inputNomFichier();

		FileWriter writer = new FileWriter(
				System.getProperty("user.dir") + "/Saves/" + name + " " + format.format(date) + ".txt");

		writer.append("DTG de la sauvegarde : " + format.format(date));
		writer.append("\n");
		writer.append(Affichage());

		// Retour pret
		StringBuilder tab = new StringBuilder();
		String nomPrenom;

		tab.append("+-----------+--------------------------+-------------------------+\n");
		tab.append("|    N°     |       Nom - Prénom       |        Matériel         |\n");
		tab.append("+-----------+--------------------------+-------------------------+\n");

		for (int i = 0; i < emprunt.size(); i++) {

			nomPrenom = emprunt.get(i).getEmprunteur() + " " + emprunt.get(i).getPrenom();

			tab.append("  ");
			tab.append(setFixedLength(String.valueOf(i + 1), 12));
			tab.append(setFixedLength(nomPrenom, 27));
			tab.append(setFixedLength(emprunt.get(i).getProduit(), 26));
			tab.append("\n");
		}
		writer.append("\n\n\n");
		writer.append(tab);

		writer.close();

		System.out.println("Fichier '" + name + ".txt' a bien été créé ! ");
	}

	public void Magasin() throws FileNotFoundException {
		if (personnel.isEmpty()) {
			System.out.println("Veuilliez d'abord Charger le personnel !");
			return;
		} else if (!emprunt.isEmpty()) {
			System.out.println("Magasin déjà créé !");
			return;
		}
		new Magasin();

		Map<Integer, Produit> listProduit = Magasin.listProduit;

		emprunt.add(new Emprunt(personnel.get(0), listProduit.get(2)));
		emprunt.add(new Emprunt(personnel.get(1), listProduit.get(3)));
		emprunt.add(new Emprunt(personnel.get(2), listProduit.get(4)));
		emprunt.add(new Emprunt(personnel.get(4), listProduit.get(6)));
		emprunt.add(new Emprunt(personnel.get(6), listProduit.get(7)));

	}

	public String setFixedLength(String string, int size) {
		StringBuilder fullString = new StringBuilder(string);

		while (fullString.length() < size) {
			String d = " ";
			char c1 = d.charAt(0);
			fullString.insert(string.length(), c1);
		}

		String c = fullString.substring(0, size);
		return c;

	}

	public void Enprunt() {
		if (Magasin.getProduit().isEmpty()) {
			System.out.println("Veuilliez d'abord créer le magasin !");
			return;
		} else if (personnel.isEmpty()) {
			System.out.println("Veuilliez d'abord Charger le personnel !");
			return;
		}

		for (int i = 0; i < emprunt.size(); i++) {
			System.out.println(emprunt.get(i).toString());
		}

	}
}
