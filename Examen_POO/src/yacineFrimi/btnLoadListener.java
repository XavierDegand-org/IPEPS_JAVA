package yacineFrimi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public  class btnLoadListener implements ActionListener {



@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	File fichierPersonnel = new File("C:\\Users\\yacin\\git\\IPEPS_JAVA\\Examen_POO\\src\\yacineFrimi\\Personnel.txt");
	List<Personnel> listePersonnel = new ArrayList<Personnel>();
	
	BufferedReader br = null;
    try{
        br = new BufferedReader(new FileReader(fichierPersonnel));
        String ligne;
        int id = 0;
        
        while ((ligne = br.readLine()) != null){
        	
            String tokens[] = ligne.split(",");
            String date[] =  tokens[3].split("/");
            
            int j = Integer.parseInt(date[0].trim());
            int m = Integer.parseInt(date[1].trim());
            int a = Integer.parseInt(date[2].trim());
            
            MyDate dateNaiss = new MyDate(j,m,a);
            
            listePersonnel.add(new Personnel(id,(tokens[0]),(tokens[1]), Sexe.valueOf(tokens[2]),dateNaiss,(tokens[4]),(tokens[5])));
            id++;
        }
        	System.out.println("Liste personnel chargée.");
        
    	}catch (NumberFormatException | IOException e1) {
    		System.out.println(e1.getMessage());
        } 

	    for (Personnel p : listePersonnel) {
	    	System.out.println(p);
	    }
}



	

}
