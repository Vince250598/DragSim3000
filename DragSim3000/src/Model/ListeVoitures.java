package Model;

import Model.Voiture;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Vector;

public class ListeVoitures {
    public Vector<Voiture> voitures = new Vector<Voiture>();

    public ListeVoitures() {
        loadVoitures();
    }

    public void loadVoitures() {
        try {
            File xml = new File("C:/Users/Public/Documents/Voitures.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document doc = builder.parse(xml);
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("Voiture");
            for (int x = 0; x < list.getLength(); x++) {
                Node nNode = list.item(x);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    voitures.add(x, new Voiture(eElement.getElementsByTagName("Modele").item(0).getTextContent(),
                            Double.parseDouble(eElement.getElementsByTagName("Masse").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("EF").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("Rayon").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("RD").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("VM").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("RPM").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("RV1").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("RV2").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("RV3").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("RV4").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("RV5").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("RV6").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("RV7").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("RV8").item(0).getTextContent()),
                            Integer.parseInt(eElement.getElementsByTagName("NV").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("P1000").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("P1500").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("P2000").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("P2500").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("P3000").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("P3500").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("P4000").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("P4500").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("P5000").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("P5500").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("P6000").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("P6500").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("P7000").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("P7500").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("P8000").item(0).getTextContent()),
                            eElement.getElementsByTagName("URL").item(0).getTextContent()));
                }
            }
        } catch (Exception e) {
            System.out.println("erreur loadage voitures");
        }
    }

    public Vector<Voiture> getVoitures() {
        return voitures;
    }
}
