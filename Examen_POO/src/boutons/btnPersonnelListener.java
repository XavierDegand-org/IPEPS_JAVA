package boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import yacineFrimi.ControleSaisie;
import yacineFrimi.InputData;
import yacineFrimi.Lire;
import yacineFrimi.Personnel;

public class btnPersonnelListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		List<Personnel> listePersonnel = btnLoadListener.getListPersonnel();
		if (listePersonnel.isEmpty()) {
			System.out.println("Veuilliez charger le fichier !");
		} else {

			System.out.println("Introduire le nom de la personne à modifier :");
			boolean arret = false;
			while (!arret) {

				String input = InputData.miseEnForme(InputData.inputNomPrenom());

				for (int index = 0; index < listePersonnel.size(); index++) {

					if (listePersonnel.get(index).getNom().equals(input)) {

						System.out.println(index + 1 + "  " + listePersonnel.get(index).getNom() + " -- "
								+ listePersonnel.get(index).getPrenom() + " -- " + listePersonnel.get(index).getSexe() + " -- "
								+ listePersonnel.get(index).getEmail() + " -- " + listePersonnel.get(index).getDepartement());
						System.out.println("Introduisez les nouvelles valeurs.");

						System.out.println("Entrez un nom : ");
						String Nom = InputData.inputNomPrenom();
						System.out.println("Entrez un prénom : ");
						String Prenom = InputData.inputNomPrenom();
						System.out.println("Entrez un email : ");
						String Email = InputData.inputEmail();

						listePersonnel.get(index).setNom(Nom);
						listePersonnel.get(index).setPrenom(Prenom);
						listePersonnel.get(index).setEmail(Email);

						System.out.println("Nouvelles données pour " + listePersonnel.get(index).getPrenom() + " "
								+ listePersonnel.get(index).getNom() + "\n" + listePersonnel.get(index));
						arret = true;
						return;
					} else {
						arret = false;
					}

				}
				System.out.println("Aucune personne trouvée. Veuillez réessayer : ");
			}
			

		}

	}
}
