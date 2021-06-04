package Jessica;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class ClassMain {

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		
		// set Nimbus Look and Feel
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		
		// start demo
		GestionJFrame demo = new GestionJFrame();
		demo.setVisible(true);

	}

}
