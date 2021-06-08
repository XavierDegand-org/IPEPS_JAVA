package yacineFrimi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.lang.model.element.Element;

public class btnAffichageListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		List<Personnel> listePersonnel = btnLoadListener.getList();
		
		
		
		System.out.println("+----------------------+-----------------------+-----------------------+----------------------+-----------------------+------------------------+");
		System.out.println("| Département          | Prénom                |  Nom                  |  Sexe                |  Naissance            | Email                  |");
		System.out.println("+----------------------+-----------------------+-----------------------+----------------------+-----------------------+------------------------+");
							      
		StringBuilder sb = new StringBuilder ();
		
		for (int temp = 0; temp < listePersonnel.size(); temp++) {
			
			sb.append(" ");
			sb.append(setFixedLength(listePersonnel.get(temp).getDepartement().toString()));
			sb.append("\t");
			sb.append(setFixedLength(listePersonnel.get(temp).getPrenom()));
			sb.append("\t");
			sb.append(setFixedLength(listePersonnel.get(temp).getNom()));
			sb.append("\t");
			sb.append(setFixedLength(listePersonnel.get(temp).getSexe().toString()));
			sb.append("\t");
			sb.append(setFixedLength(listePersonnel.get(temp).getDateddMMyyyy()));
			sb.append("\t");
			sb.append(setFixedLength(listePersonnel.get(temp).getEmail()));
			sb.append("\n");
			
			
		}
		
		System.out.println(sb);

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
