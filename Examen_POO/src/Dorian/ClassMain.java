package Dorian;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class ClassMain {

	public static void main(String[] args) throws Exception
	{
	
      UIManager.setLookAndFeel(new NimbusLookAndFeel());
				
      JFrameInterface demo = new JFrameInterface ();
				demo.setVisible(true);
				
				
				
				
			}	
		
	}


