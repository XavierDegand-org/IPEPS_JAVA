package boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import yacineFrimi.Emprunt;
import yacineFrimi.InputData;
import yacineFrimi.Personnel;

public class btnSauvegardeListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		System.out.print("Entrez nom fichier : ");
		String nomFichier = InputData.inputNomFichier();
		List<Personnel> listePersonnel = btnLoadListener.getListPersonnel();
		List<Emprunt> listeEmprunt = btnPretListener.getListEmprunt();

		if (listePersonnel.isEmpty() || listeEmprunt.isEmpty()) {
			System.out.println("Sauvegarde impossible. Pas de personnel et/ou d'emprunts !");

		} else {

			StringBuilder sb = new StringBuilder();

			sb.append(
					"+----------------------+-----------------------+-----------------------+----------------------+-----------------------+------------------------+");
			sb.append("\n");
			sb.append(
					"| Département          | Prénom                |  Nom                  |  Sexe                |  Naissance            | Email                  |");
			sb.append("\n");
			sb.append(
					"+----------------------+-----------------------+-----------------------+----------------------+-----------------------+------------------------+");
			sb.append("\n");

			for (int index = 0; index < listePersonnel.size(); index++) {

				sb.append(" ");
				sb.append(btnAffichageListener.setFixedLength(listePersonnel.get(index).getDepartement().getDeptNom()));
				sb.append("\t");
				sb.append(btnAffichageListener.setFixedLength(listePersonnel.get(index).getPrenom()));
				sb.append("\t");
				sb.append(btnAffichageListener.setFixedLength(listePersonnel.get(index).getNom()));
				sb.append("\t");
				sb.append(btnAffichageListener.setFixedLength(listePersonnel.get(index).getSexe().toString()));
				sb.append("\t");
				sb.append(btnAffichageListener.setFixedLength(listePersonnel.get(index).getDateddMMyyyy()));
				sb.append("\t");
				sb.append(btnAffichageListener.setFixedLength(listePersonnel.get(index).getEmail()));
				sb.append("\n");

			}

			sb.append("+------+-----------------------+-----------------------+");
			sb.append("\n");
			sb.append("| N°   | Nom - Prénom          |  Matériel             |");
			sb.append("\n");
			sb.append("+------+-----------------------+-----------------------+");
			sb.append("\n");

			for (int index = 0; index < listeEmprunt.size(); index++) {

				sb.append(" ");
				sb.append(index);
				sb.append("\t");
				sb.append(btnAffichageListener.setFixedLength(listeEmprunt.get(index).getEmprunteur().getNom() + " "
						+ listeEmprunt.get(index).getEmprunteur().getPrenom()));
				sb.append("\t");
				sb.append(btnAffichageListener.setFixedLength(listeEmprunt.get(index).getProduit().getDescription()));
				sb.append("\n");

			}

			FileWriter writer;
			try {
				writer = new FileWriter(
						System.getProperty("user.dir") + "/src/" + "/fichiersTexte/" + nomFichier + ".txt");

				writer.append("DTG de la sauvegarde : " + LocalDateTime.now());
				writer.append("\n");
				writer.append((sb).toString());
				writer.close();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		System.out.println("Fichier '" + nomFichier + ".txt' a bien été créé ! ");
	}

}
