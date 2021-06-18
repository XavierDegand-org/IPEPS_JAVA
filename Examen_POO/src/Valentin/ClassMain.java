package Valentin;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class ClassMain {

	public static void main(String[] args) throws Exception {
		
		UIManager.setLookAndFeel(new NimbusLookAndFeel()); // permettre de faire en sorte de rendre l'apparance au niveau des écrans 
															// setLookAndFeel -> interface entre OS et Java
		
		GestionJFrame g1 = new GestionJFrame();
		g1.setVisible(true); // par défaut une representation graphique n'est pas representé donc il faut mettre le setVisible en true
	}

}
