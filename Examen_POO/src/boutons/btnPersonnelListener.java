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
		
		
		if(listePersonnel.isEmpty()) {
			System.out.println("Veuilliez charger le fichier !");
			return;
		}
	
		
		
		System.out.println("Introduire le nom de la personne à modifier :");
		boolean arret = false;
		while (!arret) {
			
			String input = InputData.miseEnForme(InputData.inputNomPrenom());
		
		for(int i=0;i<listePersonnel.size();i++){
			
			if(listePersonnel.get(i).getNom().equals(input)){
				
				System.out.println(i + 1 + "  " + listePersonnel.get(i).getNom() + " -- " + listePersonnel.get(i).getPrenom() + " -- " + listePersonnel.get(i).getSexe() + " -- " + listePersonnel.get(i).getEmail() + " -- " + listePersonnel.get(i).getDepartement());
				System.out.println("Introduisez les nouvelles valeurs.");
				
		
				System.out.println("Entrez un nom : ");
				String Nom = InputData.inputNomPrenom();
				System.out.println("Entrez un prénom : ");
				String Prenom = InputData.inputNomPrenom();
				System.out.println("Entrez un email : ");
				String Email = InputData.inputEmail();
				
				
				
				listePersonnel.get(i).setNom(InputData.miseEnForme(Nom));
				listePersonnel.get(i).setPrenom(InputData.miseEnForme(Prenom));
				listePersonnel.get(i).setEmail(Email.toLowerCase());
				System.out.println(listePersonnel.get(i));
				arret = true;
			}else {
				arret = false;
				
				
				
			}
		}
		System.out.println("Aucune personne trouvée. Veuillez réessayer : ");
		}
		

	}
}


