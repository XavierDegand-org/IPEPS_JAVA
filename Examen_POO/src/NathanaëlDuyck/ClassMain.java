package NathanaëlDuyck;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class ClassMain {

	public static void main(String[] args) throws Exception {
		// Try to set Nimbus look and feel
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
				
		// Lance la démonstration du JFrame
				
		GestionJFrame demo = new  GestionJFrame();
		demo.setVisible(true);

	}

}
