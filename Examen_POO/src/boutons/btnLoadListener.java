package boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import yacineFrimi.Departement;
import yacineFrimi.MyDate;
import yacineFrimi.Personnel;
import yacineFrimi.Sexe;

public  class btnLoadListener implements ActionListener {

	static List<Personnel> listePersonnel = new ArrayList<Personnel>();


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		File fichierPersonnel = new File(System.getProperty("user.dir") + "/src/fichiersTexte/Personnel.txt");




		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(fichierPersonnel));
			String ligne;
			int id = 0;

			while ((ligne = br.readLine()) != null){

				String champs[] = ligne.split(",");
				String date[] =  champs[3].split("/");

				int j = Integer.parseInt(date[0].trim());
				int m = Integer.parseInt(date[1].trim());
				int a = Integer.parseInt(date[2].trim());

				MyDate dateNaiss = new MyDate(j,m,a);


				listePersonnel.add(new Personnel(id,(champs[0]),(champs[1]), Sexe.valueOf(champs[2]),dateNaiss,(champs[4]),Departement.valueOf(champs[5])));
				id++;

			}

			br.close();


			System.out.println("Liste personnel chargée.");


		}catch (NumberFormatException | IOException e1) {
			System.out.println(e1.getMessage());
		} 


	}

	public static List<Personnel> getListPersonnel() {
		return listePersonnel;

	}


}
