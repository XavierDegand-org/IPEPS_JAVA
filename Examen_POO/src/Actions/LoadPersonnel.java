package Actions;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Console.Departement;
import Console.MyDate;
import Console.Personnel;
import Console.Sexe;

public class LoadPersonnel implements ActionListener {
	public static ArrayList<Personnel> personnels = new ArrayList<>();

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			File file = new File(
					System.getProperty("user.dir") + System.getProperty("file.separator") + "Personnel.txt");
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				String[] data = myReader.nextLine().split(",");
				String nom = data[0];
				String prenom = data[1];
				Sexe sexe = Sexe.valueOf(data[2]);
				String[] date = data[3].split("/");
				MyDate dateNaissance = new MyDate(Integer.parseInt(date[0]), Integer.parseInt(date[1]),
						Integer.parseInt(date[2]));
				String email = data[4];
				Departement departement = Departement.valueOf(data[5]);
				personnels.add(new Personnel(nom, prenom, sexe, dateNaissance, email, departement));
			}
			myReader.close();
			System.out.println("Personnel chargé");
		} catch (FileNotFoundException e1) {
			System.out.println("Erreur pendant le chargement du personnel");
			e1.printStackTrace();
		}
	}
}