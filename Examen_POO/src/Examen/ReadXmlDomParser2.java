package Examen;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ReadXmlDomParser2 {

    private static final String FILENAME = "./Sources/Personnel.xml";

    public static void main(String[] args) {

        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(FILENAME));

            // optional, but recommended
            // Permet de normaliser un noeud
            // Exemple noeud dénormalise
            //<foo>hello
            // wor
            // ld</foo>
            // Après normalisation <foo> hello world </foo>

            doc.getDocumentElement().normalize();

            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("------");

            // get <staff>
            NodeList list = doc.getElementsByTagName(" Liste du Personnel ");

            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    // get staff's attribute
                    String id = element.getAttribute("id");

                    // get text
                    String departement = element.getElementsByTagName("departement").item(0).getTextContent();
                    String prenom = element.getElementsByTagName("prenom").item(0).getTextContent();
                    String nom = element.getElementsByTagName("nom").item(0).getTextContent();
                    String sexe = element.getElementsByTagName("sexe").item(0).getTextContent();
                    String naissance = element.getElementsByTagName("naissance").item(0).getTextContent();
                    String email = element.getElementsByTagName("email").item(0).getTextContent();

                    System.out.println("Current Element :" + node.getNodeName());
                    System.out.println(" Id : " + id);
                    System.out.println("Département "+ departement);
                    System.out.println("Prenom : " + prenom);
                    System.out.println("Nom : " + nom);
                    System.out.println("sexe : " + sexe);
                    System.out.println("naissance : " + naissance);
                    System.out.println("email : " + email);

                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

}