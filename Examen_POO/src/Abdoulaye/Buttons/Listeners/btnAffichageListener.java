package Abdoulaye.Buttons.Listeners;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class btnAffichageListener implements ActionListener {
    public static org.w3c.dom.Element racine;

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("btnAffichage works");

        NodeList listPersonnel = racine.getElementsByTagName("Personnel");
        System.out.println("+---------------------+-----------------------+----------------------+------------+----------------+---------------------+");
        System.out.println("| Département         | Prénom                | Nom                  | Sexe       | Naissance      | Email               |");
        System.out.println("+---------------------+-----------------------+----------------------+------------+----------------+---------------------+");

        StringBuilder sb = new StringBuilder();

        for (int temp = 0; temp < listPersonnel.getLength(); temp++) {
            Node nNode = listPersonnel.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element courant = (Element) nNode;
                sb.append(" ");
                sb.append(setFixedLength(courant.getElementsByTagName("departement").item(0).getTextContent()));
                //sb.append("\t");
                sb.append(setFixedLength(courant.getElementsByTagName("prenom").item(0).getTextContent()));
                //sb.append("\t");
                sb.append(setFixedLength(courant.getElementsByTagName("nom").item(0).getTextContent()));
                //sb.append("\t");
                sb.append(setFixedLength(courant.getElementsByTagName("sexe").item(0).getTextContent()));
                //sb.append("\t");
                sb.append(setFixedLength(courant.getElementsByTagName("naissance").item(0).getTextContent()));
                //sb.append("\t");
                sb.append(setFixedLength(courant.getElementsByTagName("email").item(0).getTextContent()));
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
        // calibrage de la taille des caractères
        static String setFixedLength (String s){
        StringBuilder ss = new StringBuilder(s);
        //tant que la taille de ss est inférieur à 20 on ajoute un caractère blanc
        while (ss.length() < 20) {
            String d = " ";
            char cl = d.charAt(0);
            ss.insert(s.length(), cl);
        }
        String c = ss.substring(0, 20);
        return c;
    }
}
