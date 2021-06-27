package PierreGrulois;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class ClassMain {

	public static void main(String[] args) throws UnsupportedLookAndFeelException {

		try {
			UIManager.setLookAndFeel ( new NimbusLookAndFeel());
		}catch(UnsupportedLookAndFeelException e) {
			System.out.println("newLookAndFeel est non nul et newLookAndFeel.isSupportedLookAndFeel() renvoie false");
		}
		
		// Start the demo
		GestionJFrame demo = new GestionJFrame();
		demo.setVisible(true);

	}

}
