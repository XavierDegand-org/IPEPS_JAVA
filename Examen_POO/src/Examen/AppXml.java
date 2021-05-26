package Examen;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AppXml {    
	
    static org.w3c.dom.Document document;
    static org.w3c.dom.Element racine;
    
public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

	
		File inputFile = new File("./Sources/Exemple.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = null;
	    Document doc = null;
		
		dBuilder = dbFactory.newDocumentBuilder();
		doc = (Document) dBuilder.parse(inputFile);
		    
	    ((Node) doc.getDocumentElement()).normalize();
        racine = (Element) doc.getDocumentElement();
       
    //Méthode d'affichage du contenu du fichier xml
        display();
    }
static void display() {
    //On crée une List contenant tous les noeuds "Runner" de l'Element racine
    NodeList listRunner = racine.getElementsByTagName("Runner");

    //On affiche les attributs comme nom des colonnes
    System.out.println("+---------------------+-----------------------+----------------------+-----------------------+----------------+");
    System.out.println("| Team                | Firstname             | Name                 |  Birthdate            | Nationality    |");
    System.out.println("+---------------------+-----------------------+----------------------+-----------------------+----------------+");
    StringBuilder sb = new StringBuilder();
    for (int temp = 0; temp < listRunner.getLength(); temp++) {
    	Node nNode = listRunner.item(temp);
    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			    Element courant = (Element)nNode;
			    sb.append(" ") ;
			    sb.append(setFixedLength(courant.getElementsByTagName("Team").item(0).getTextContent()));
			    sb.append("\t");
			    sb.append(setFixedLength(courant.getElementsByTagName("Firstname").item(0).getTextContent()));
			    sb.append("\t");
			    sb.append(setFixedLength(courant.getElementsByTagName("Name").item(0).getTextContent()));
			    sb.append("\t");
			    sb.append(setFixedLength(courant.getElementsByTagName("Birthdate").item(0).getTextContent()));
			    sb.append("\t");
			    sb.append(setFixedLength(courant.getElementsByTagName("Nationality").item(0).getTextContent()));
			    sb.append("\n");
    		}		
    	}
	 // on affiche le contenu
		System.out.println(sb.toString());
	}
// fonction permettant de calbrer la taille des strings
static String setFixedLength(String s){
        StringBuilder ss = new StringBuilder(s);
        // tant que la taille de ss est infèrieur à 20 on ajoute un caractère blanc
        while (ss.length() < 20) {
                String d = " ";
                char c1 = d.charAt(0);
                ss.insert(s.length(),c1);
            }
        String c = ss.substring(0, 20);
        return c;

    }
}
