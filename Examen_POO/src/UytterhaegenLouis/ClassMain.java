package UytterhaegenLouis;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class ClassMain {



	public static void main(String[] args) throws Exception {

		UIManager.setLookAndFeel(new NimbusLookAndFeel());


		// Démarre la présentation
		GestionJFrame Gestion = new  GestionJFrame();
		Gestion.setVisible(true);
	}

}
