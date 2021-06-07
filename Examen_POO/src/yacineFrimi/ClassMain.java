package yacineFrimi;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class ClassMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		GestionJFrame demo=new GestionJFrame();
		demo.setVisible(true);

	}

}
