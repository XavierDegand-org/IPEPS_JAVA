package Abdoulaye.Buttons.Listeners;

import Abdoulaye.Departement;
import Abdoulaye.MyDate;
import Abdoulaye.Personnel;
import Abdoulaye.Sexe;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class btnLoadListener implements ActionListener {
    public static org.w3c.dom.Element racine;

    @Override
    public void actionPerformed(ActionEvent e) throws NullPointerException, IllegalArgumentException {
        System.out.println("btnLoad works");
        //La liste du personnel à charger
    //    try{
            ArrayList<Personnel> personne = new ArrayList<>();

            Personnel personnel1 = new Personnel("Collon", "Albert", Sexe.HOMME, new MyDate(10, 8, 1990), "collon.a@test.be", Departement.HR);
            Personnel personnel2 = new Personnel("Peeters", "Marie", Sexe.FEMME, new MyDate(1, 5, 1985), "peeters.m@test.be", Departement.HR);
            Personnel personnel3 = new Personnel("Janssens", "Sarah", Sexe.FEMME, new MyDate(23, 5, 1999), "sarah.j@test.be", Departement.Compta);
            Personnel personnel4 = new Personnel("Maes", "Henri", Sexe.HOMME, new MyDate(14, 9, 2009), "henri.m@test.be", Departement.Compta);
            Personnel personnel5 = new Personnel("Jacobs", "Charles", Sexe.HOMME, new MyDate(12, 12, 2009), "charles.j@test.be", Departement.Sec);
            Personnel personnel6 = new Personnel("Mertens", "Floriane", Sexe.FEMME, new MyDate(20, 8, 1996), "Floriane.m@test.be", Departement.Sec);
            Personnel personnel7 = new Personnel("Willems", "Francois-Xavier", Sexe.HOMME, new MyDate(28, 10, 1996), "francois.w@test.be", Departement.Prod);
            Personnel personnel8 = new Personnel("O'neil", "Shan", Sexe.HOMME, new MyDate(1, 7, 2001), "oneil.s@test.be", Departement.Prod);
            Personnel personnel9 = new Personnel("Willems", "Francois-Xavier", Sexe.HOMME, new MyDate(28, 10, 1996), "francois.w@test.be", Departement.HR);
            Personnel personnel10 = new Personnel("Goossen", "Stéphanie", Sexe.FEMME, new MyDate(25, 10, 2008), "stephanie.g@test.be", Departement.Prod);
            Personnel personnel11 = new Personnel("Willems", "Francois-Xavier", Sexe.HOMME, new MyDate(28, 10, 1996), "francois.w@test.be", Departement.Prod);
            Personnel personnel12 = new Personnel("Van Moore", "Wilfrid", Sexe.HOMME, new MyDate(25, 2, 1998), "vanmoore.w@test.be", Departement.Compta);
            Personnel personnel13 = new Personnel("Herman", "Nathalie", Sexe.FEMME, new MyDate(26, 7, 2001), " herman.n@test.be", Departement.Prod);
            Personnel personnel14 = new Personnel("Bontemps", "Annie", Sexe.FEMME, new MyDate(23, 9, 1998), "bontemps.a@test.be", Departement.Prod);

            for (Personnel person : personne) {
                System.out.println(person);
            }
    //   }catch (NullPointerException e){
    //        e.printStackTrace();
   //     } catch (IllegalArgumentException e){
     //       e.printStackTrace();
    //    }


        //methode d'affichage du contenu du fichier
        display();

    }

    private static void display() {
        //Création d'une liste contenant tous les noeuds de l'élément racine
        NodeList listPersonnel = racine.getElementsByTagName("Personnel");
        System.out.println("+------------------+------------------+------------------+------------------+------------------+----------------------------+");
        System.out.println("|  Département     |  Prénom          |  Nom             |  Sexe            |  Naissance       |  Email                     |");
        System.out.println("+------------------+------------------+------------------+------------------+------------------+----------------------------+");
        StringBuilder sb = new StringBuilder();

        for (int temp = 0; temp < listPersonnel.getLength(); temp++){
            Node nNode = listPersonnel.item(temp);
            if(nNode.getNodeType() == Node.ELEMENT_NODE){
                Element courant = (Element)nNode;
                sb.append(" ");
                sb.append(setFixedLength(courant.getElementsByTagName("departement").item(0).getTextContent()));
                sb.append("\t");
                sb.append(setFixedLength(courant.getElementsByTagName("prenom").item(0).getTextContent()));
                sb.append("\t");
                sb.append(setFixedLength(courant.getElementsByTagName("nom").item(0).getTextContent()));
                sb.append("\t");
                sb.append(setFixedLength(courant.getElementsByTagName("sexe").item(0).getTextContent()));
                sb.append("\t");
                sb.append(setFixedLength(courant.getElementsByTagName("naissance").item(0).getTextContent()));
                sb.append("\t");
                sb.append(setFixedLength(courant.getElementsByTagName("email").item(0).getTextContent()));
                sb.append("\n");
            }

        }
        //affichage du contenu
        System.out.println(sb);
    }
    // calibrage de la taille des caractères
    static String setFixedLength(String s){
        StringBuilder ss = new StringBuilder(s);
        //tant que la taille de ss est inférieur à 20 on ajoute un caractère blanc
        while (ss.length()  < 20 ){
            String d =" ";
            char cl = d.charAt(0);
            ss.insert(s.length(), cl);
        }
        String c = ss.substring(0, 20);
        return c;
    }
}
