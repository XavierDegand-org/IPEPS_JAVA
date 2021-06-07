package NathanaëlDuyck;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class ClassMain {

	public static void main(String[] args) throws Exception {
		// Try to set Nimbus look and feel
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
				
		// Start the demo
				
		GestionJFrame demo = new  GestionJFrame();
		demo.setVisible(true);

	}

}
