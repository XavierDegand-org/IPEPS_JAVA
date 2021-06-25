package Actions;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import Console.Emprunt;
import Console.InputData;
import Console.Personnel;

public class Sauvegarder implements ActionListener {
	LoadPersonnel personnelLoader;
	PreterPersonnel pretPersonnel;

	public Sauvegarder(LoadPersonnel personnelLoader, PreterPersonnel pretPersonnel) {
		this.personnelLoader = personnelLoader;
		this.pretPersonnel = pretPersonnel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (LoadPersonnel.personnels.size() == 0) {
			System.out.print("Personnel pas chargé\n");
			return;
		}
		System.out.println("Introduire le nom du fichier extension .txt !");
		String nomFichier = InputData.inputNomFichier();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		StringBuilder sb = new StringBuilder();
		sb.append("DTC de la sauvegarde : " + dtf.format(now) + "\n");
		sb.append(
				"+-----------------------+------------------------+------------------------+------------------------+------------------------+------------------------+\n");
		sb.append(
				"| Département           | Prénom                 | Nom                    | Sexe                   | Naissance              | Email                  |\n");
		sb.append(
				"+-----------------------+------------------------+------------------------+------------------------+------------------------+------------------------+\n");
		for (Personnel p : LoadPersonnel.personnels) {
			sb.append(setFixedLength(p.getDepartement().getDeptNom()));
			sb.append(setFixedLength(p.getPrenom()));
			sb.append(setFixedLength(p.getNom()));
			sb.append(setFixedLength(p.getSexe()));
			sb.append(setFixedLength(p.getDateddMMyyyy()));
			sb.append(setFixedLength(p.getEmail()));
			sb.append("\n");
		}
		sb.append("\n");
		sb.append("\n");

		sb.append("+-----------------------+-----------------------+-----------------------+\n");
		sb.append("| N�                    | Nom - Pr�nom          | Mat�riel              |\n");
		sb.append("+-----------------------+-----------------------+-----------------------+\n");

		ArrayList<Emprunt> emprunt = PreterPersonnel.listEmprunt;
		for (int i = 0; i <= emprunt.size() - 1; i++) {
			sb.append(setFixedLength(Integer.toString(i)));
			sb.append(setFixedLength(
					emprunt.get(i).getEmprunteur().getNom() + " " + emprunt.get(i).getEmprunteur().getPrenom()));
			sb.append(setFixedLength(
					emprunt.get(i).getMateriel().getNom() + " " + emprunt.get(i).getMateriel().getDescription()));
			sb.append("\n");
		}

		String path = System.getProperty("user.dir") + System.getProperty("file.separator") + nomFichier;
		try {
			File myObj = new File(path);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e1) {
			System.out.println("An error occurred.");
			e1.printStackTrace();
		}
		
		try {
		      FileWriter myWriter = new FileWriter(path);
		      myWriter.write(sb.toString());
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e1) {
		      System.out.println("An error occurred.");
		      e1.printStackTrace();
		    }
		
	}

	// fonction permettant de calibrer la taille des strings
	public static String setFixedLength(String s) {
		StringBuilder ss = new StringBuilder(s);
		// tant que la taille de ss est inférieure à 25 on ajoute un caractére blanc
		while (ss.length() < 25) {
			String d = " ";
			char c1 = d.charAt(0);
			ss.insert(s.length(), c1);
		}
		String c = ss.substring(0, 25);
		return c;

	}
}