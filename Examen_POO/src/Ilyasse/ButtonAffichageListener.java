package Ilyasse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAffichageListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Affichage liste du personnel");
		Affichage();
	}
}