package Abdoulaye;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class ClassMain {


	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel( new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		//start GestionJFrame
		GestionJFrame gestionJFrame = new GestionJFrame();
		gestionJFrame.setVisible(true);
	}

}
