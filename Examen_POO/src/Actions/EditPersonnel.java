package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Console.Lire;
import Console.Personnel;

public class EditPersonnel implements ActionListener {
	LoadPersonnel personnelLoader;

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Indroduire le nom de la personne à modifier:\n");
		Lire.vider();
		String nom = Lire.texte();
		Personnel personne = null;
		int position = 1;
		for (Personnel p : LoadPersonnel.personnels) {
			if (p.getNom().equals(nom)) {
				personne = p;
				position++;
				break;
			}
		}
		if (personne == null)
			System.out.println("Personne inexistant dans le personnel");
		else {
			System.out.println(position +"  "+personne.getNom()+" -- "+personne.getPrenom()+" -- "+personne.getSexe()+
					" -- "+personne.getEmail()+" -- "+personne.getDepartement().getDeptNom());
			System.out.println("Introduire les nouvelles valeurs :");
			System.out.print("Entrer un nom : ");
			personne.setNom(Lire.texte());
			System.out.print("");
			System.out.print("Entrer un prénom : ");
			personne.setPrenom(Lire.texte());
			System.out.print("");
			System.out.print("Entrer un email : ");
			personne.setEmail(Lire.texte());
			System.out.print("");
		}
	}

	public EditPersonnel(LoadPersonnel personnelLoader) {
		super();
		this.personnelLoader = personnelLoader;
	}
}