package Model;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Vector;

public class ListeVoitures {

    public ListeVoitures() {
    }

    private static Vector<Voiture> voitures = new Vector<>();

    public void loadVoitures() {
        try {
            File xml = new File("Voitures.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document doc = builder.parse(xml);
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("Voiture");
            for (int x = 0; x < list.getLength(); x++) {
                Node nNode = list.item(x);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    double[] puissance = new double[15];
                    double[] ratioVit = new double[8];
                    puissance[0] = Double.parseDouble(eElement.getElementsByTagName("P1000").item(0).getTextContent());
                    puissance[1] = Double.parseDouble(eElement.getElementsByTagName("P1500").item(0).getTextContent());
                    puissance[2] = Double.parseDouble(eElement.getElementsByTagName("P2000").item(0).getTextContent());
                    puissance[3] = Double.parseDouble(eElement.getElementsByTagName("P2500").item(0).getTextContent());
                    puissance[4] = Double.parseDouble(eElement.getElementsByTagName("P3000").item(0).getTextContent());
                    puissance[5] = Double.parseDouble(eElement.getElementsByTagName("P3500").item(0).getTextContent());
                    puissance[6] = Double.parseDouble(eElement.getElementsByTagName("P4000").item(0).getTextContent());
                    puissance[7] = Double.parseDouble(eElement.getElementsByTagName("P4500").item(0).getTextContent());
                    puissance[8] = Double.parseDouble(eElement.getElementsByTagName("P5000").item(0).getTextContent());
                    puissance[9] = Double.parseDouble(eElement.getElementsByTagName("P5500").item(0).getTextContent());
                    puissance[10] = Double.parseDouble(eElement.getElementsByTagName("P6000").item(0).getTextContent());
                    puissance[11] = Double.parseDouble(eElement.getElementsByTagName("P6500").item(0).getTextContent());
                    puissance[12] = Double.parseDouble(eElement.getElementsByTagName("P7000").item(0).getTextContent());
                    puissance[13] = Double.parseDouble(eElement.getElementsByTagName("P7500").item(0).getTextContent());
                    puissance[14] = Double.parseDouble(eElement.getElementsByTagName("P8000").item(0).getTextContent());
                    ratioVit[0] = Double.parseDouble(eElement.getElementsByTagName("RV1").item(0).getTextContent());
                    ratioVit[1] = Double.parseDouble(eElement.getElementsByTagName("RV2").item(0).getTextContent());
                    ratioVit[2] = Double.parseDouble(eElement.getElementsByTagName("RV3").item(0).getTextContent());
                    ratioVit[3] = Double.parseDouble(eElement.getElementsByTagName("RV4").item(0).getTextContent());
                    ratioVit[4] = Double.parseDouble(eElement.getElementsByTagName("RV5").item(0).getTextContent());
                    ratioVit[5] = Double.parseDouble(eElement.getElementsByTagName("RV6").item(0).getTextContent());
                    ratioVit[6] = Double.parseDouble(eElement.getElementsByTagName("RV7").item(0).getTextContent());
                    ratioVit[7] = Double.parseDouble(eElement.getElementsByTagName("RV8").item(0).getTextContent());



                    voitures.add(x, new Voiture(
                            eElement.getElementsByTagName("Modele").item(0).getTextContent(),
                            Double.parseDouble(eElement.getElementsByTagName("Masse").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("Aire").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("CD").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("EF").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("Rayon").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("RD").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("RPM").item(0).getTextContent()),
                            ratioVit,
                            Integer.parseInt(eElement.getElementsByTagName("NV").item(0).getTextContent()),
                            puissance,
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

    static Voiture getVoiture() {
        return voitures.get(9);
    }
}
