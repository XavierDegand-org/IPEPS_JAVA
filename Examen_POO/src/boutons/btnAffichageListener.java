package boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.lang.model.element.Element;

import yacineFrimi.GestionJFrame;
import yacineFrimi.Personnel;

public class btnAffichageListener implements ActionListener {



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		List<Personnel> listePersonnel = btnLoadListener.getListPersonnel();



		if ( listePersonnel.isEmpty()) { 
			System.out.println("Affichage impossible. Pas de personnel !");
			
		} else {

		StringBuilder sb = new StringBuilder ();

		for (int index = 0; index < listePersonnel.size(); index++) {

			sb.append(" ");
			sb.append(setFixedLength(listePersonnel.get(index).getDepartement().getDeptNom()));
			sb.append("\t");
			sb.append(setFixedLength(listePersonnel.get(index).getPrenom()));
			sb.append("\t");
			sb.append(setFixedLength(listePersonnel.get(index).getNom()));
			sb.append("\t");
			sb.append(setFixedLength(listePersonnel.get(index).getSexe().toString()));
			sb.append("\t");
			sb.append(setFixedLength(listePersonnel.get(index).getDateddMMyyyy()));
			sb.append("\t");
			sb.append(setFixedLength(listePersonnel.get(index).getEmail()));
			sb.append("\n");


		}



		System.out.println("+----------------------+-----------------------+-----------------------+----------------------+-----------------------+------------------------+");
		System.out.println("| Département          | Prénom                |  Nom                  |  Sexe                |  Naissance            | Email                  |");
		System.out.println("+----------------------+-----------------------+-----------------------+----------------------+-----------------------+------------------------+");

		System.out.println(sb);
		}



	}


	static String setFixedLength (String s) {
		StringBuilder ss = new StringBuilder(s);

		while (ss.length() < 22) {
			String d = " ";
			char c1 = d.charAt(0);
			ss.insert(s.length(), c1);
		}

		String c = ss.substring(0,22);
		return c;
	}
}