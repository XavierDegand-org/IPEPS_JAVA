package Abdoulaye.Buttons;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MainJFrame {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new NimbusLookAndFeel());
        }catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        MonMenu monMenu = new MonMenu();
        monMenu.isVisible();

    }
}
