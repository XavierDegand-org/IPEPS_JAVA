package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Console.Personnel;

public class ShowPersonnel implements ActionListener {
	LoadPersonnel personnelLoader;

	@Override
	public void actionPerformed(ActionEvent e) {
		if(LoadPersonnel.personnels.size() == 0) {
			System.out.print("Personnel pas chargé\n");
			return;
		}
		System.out.println(
				"+-----------------------+------------------------+------------------------+------------------------+------------------------+------------------------+");
		System.out.println(
				"| Département           | Prénom                 | Nom                    | Sexe                   | Naissance              | Email                  |");
		System.out.println(
				"+-----------------------+------------------------+------------------------+------------------------+------------------------+------------------------+");
		StringBuilder sb = new StringBuilder();
		for (Personnel p : LoadPersonnel.personnels) {
			sb.append(setFixedLength(p.getDepartement().getDeptNom()));
			sb.append(setFixedLength(p.getPrenom()));
			sb.append(setFixedLength(p.getNom()));
			sb.append(setFixedLength(p.getSexe()));
			sb.append(setFixedLength(p.getDateddMMyyyy()));
			sb.append(setFixedLength(p.getEmail()));
			sb.append("\n");
		}
		System.out.println(sb.toString());
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

	public ShowPersonnel(LoadPersonnel personnelLoader) {
		super();
		this.personnelLoader = personnelLoader;
	}
}