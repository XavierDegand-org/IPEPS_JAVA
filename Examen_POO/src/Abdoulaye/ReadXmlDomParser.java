package Abdoulaye;

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

public class ReadXmlDomParser {

    private static final String FILENAME = "./Sources/Personnel.xml";

    public static void main(String[] args) {

        // Instantiation du Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(FILENAME));



            doc.getDocumentElement().normalize();

            System.out.println("Promsoc :" + doc.getDocumentElement().getNodeName());
            System.out.println("------");

            // get <Personnel>
            NodeList list = doc.getElementsByTagName("Personnel");

            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    // get personnel's attribute
                    String id = element.getAttribute("id");

                    // get text
                    String nom = element.getElementsByTagName("nom").item(0).getTextContent();
                    String prenom = element.getElementsByTagName("prenom").item(0).getTextContent();
                    String sexe = element.getElementsByTagName("sexe").item(0).getTextContent();
                    String naissance = element.getElementsByTagName("naissance").item(0).getTextContent();
                    String email = element.getElementsByTagName("email").item(0).getTextContent();
                    String departement = element.getElementsByTagName("departement").item(0).getTextContent();

                    System.out.println("Current Element : " + node.getNodeName());
                    System.out.println("Département: " + departement);
                    System.out.println("Prénom: " + prenom);
                    System.out.println("Nom : " + nom);
                    System.out.println("Naissance :"+naissance);
                    System.out.println("Sexe : " + sexe);
                    System.out.println("Email : " + email);

                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

}
