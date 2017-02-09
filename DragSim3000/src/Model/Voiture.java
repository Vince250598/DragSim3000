package Model;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Voiture {
    String modele;
    double masse;
    double efficaciteTransmission;
    double rayonRoue;
    double ratioDiff;
    double vitesseMax;
    double rpmMax;
    double ratioVit1;
    double ratioVit2;
    double ratioVit3;
    double ratioVit4;
    double ratioVit5;
    double ratioVit6;
    double ratioVit7;
    double ratioVit8;
    int nombreVit;
    double puissance1000rpm;
    double puissance1500rpm;
    double puissance2000rpm;
    double puissance2500rpm;
    double puissance3000rpm;
    double puissance3500rpm;
    double puissance4000rpm;
    double puissance4500rpm;
    double puissance5000rpm;
    double puissance5500rpm;
    double puissance6000rpm;
    double puissance6500rpm;
    double puissance7000rpm;
    double puissance7500rpm;
    double puissance8000rpm;
    String URL;
    ImageView image = new ImageView();

    public Voiture(String modele,
                   double masse,
                   double efficaciteTransmission,
                   double rayonRoue,
                   double ratioDiff,
                   double vitesseMax,
                   double rpmMax,
                   double ratioVit1,
                   double ratioVit2,
                   double ratioVit3,
                   double ratioVit4,
                   double ratioVit5,
                   double ratioVit6,
                   double ratioVit7,
                   double ratioVit8,
                   int nombreVit,
                   double puissance1000rpm,
                   double puissance1500rpm,
                   double puissance2000rpm,
                   double puissance2500rpm,
                   double puissance3000rpm,
                   double puissance3500rpm,
                   double puissance4000rpm,
                   double puissance4500rpm,
                   double puissance5000rpm,
                   double puissance5500rpm,
                   double puissance6000rpm,
                   double puissance6500rpm,
                   double puissance7000rpm,
                   double puissance7500rpm,
                   double puissance8000rpm,
                   String URL

    ) {
        this.modele = modele;
        this.efficaciteTransmission = efficaciteTransmission;
        this.masse = masse;
        this.nombreVit = nombreVit;
        this.puissance1000rpm = puissance1000rpm;
        this.puissance1500rpm = puissance1500rpm;
        this.puissance2000rpm = puissance2000rpm;
        this.puissance2500rpm = puissance2500rpm;
        this.puissance3000rpm = puissance3000rpm;
        this.puissance3500rpm = puissance3500rpm;
        this.puissance4000rpm = puissance4000rpm;
        this.puissance4500rpm = puissance4500rpm;
        this.puissance5000rpm = puissance5000rpm;
        this.puissance5500rpm = puissance5500rpm;
        this.puissance6000rpm = puissance6000rpm;
        this.puissance6500rpm = puissance6500rpm;
        this.puissance7000rpm = puissance7000rpm;
        this.puissance7500rpm = puissance7500rpm;
        this.puissance8000rpm = puissance8000rpm;
        this.ratioDiff = ratioDiff;
        this.ratioVit1 = ratioVit1;
        this.ratioVit2 = ratioVit2;
        this.ratioVit3 = ratioVit3;
        this.ratioVit4 = ratioVit4;
        this.ratioVit5 = ratioVit5;
        this.ratioVit6 = ratioVit6;
        this.ratioVit7 = ratioVit7;
        this.ratioVit8 = ratioVit8;
        this.rayonRoue = rayonRoue;
        this.rpmMax = rpmMax;
        this.vitesseMax = vitesseMax;
        this.URL = URL;
        image.setImage(new Image(URL));
    }

    public ImageView getImage() {
        return image;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public double getMasse() {
        return masse;
    }

    public void setMasse(double masse) {
        this.masse = masse;
    }

    public double getEfficaciteTransmission() {
        return efficaciteTransmission;
    }

    public void setEfficaciteTransmission(double efficaciteTransmission) {
        this.efficaciteTransmission = efficaciteTransmission;
    }

    public double getRayonRoue() {
        return rayonRoue;
    }

    public void setRayonRoue(double rayonRoue) {
        this.rayonRoue = rayonRoue;
    }

    public double getRatioDiff() {
        return ratioDiff;
    }

    public void setRatioDiff(double ratioDiff) {
        this.ratioDiff = ratioDiff;
    }

    public double getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(double vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    public double getRpmMax() {
        return rpmMax;
    }

    public void setRpmMax(double rpmMax) {
        this.rpmMax = rpmMax;
    }

    public double getRatioVit1() {
        return ratioVit1;
    }

    public void setRatioVit1(double ratioVit1) {
        this.ratioVit1 = ratioVit1;
    }

    public double getRatioVit2() {
        return ratioVit2;
    }

    public void setRatioVit2(double ratioVit2) {
        this.ratioVit2 = ratioVit2;
    }

    public double getRatioVit3() {
        return ratioVit3;
    }

    public void setRatioVit3(double ratioVit3) {
        this.ratioVit3 = ratioVit3;
    }

    public double getRatioVit4() {
        return ratioVit4;
    }

    public void setRatioVit4(double ratioVit4) {
        this.ratioVit4 = ratioVit4;
    }

    public double getRatioVit5() {
        return ratioVit5;
    }

    public void setRatioVit5(double ratioVit5) {
        this.ratioVit5 = ratioVit5;
    }

    public double getRatioVit6() {
        return ratioVit6;
    }

    public void setRatioVit6(double ratioVit6) {
        this.ratioVit6 = ratioVit6;
    }

    public double getRatioVit7() {
        return ratioVit7;
    }

    public void setRatioVit7(double ratioVit7) {
        this.ratioVit7 = ratioVit7;
    }

    public double getRatioVit8() {
        return ratioVit8;
    }

    public void setRatioVit8(double ratioVit8) {
        this.ratioVit8 = ratioVit8;
    }

    public int getNombreVit() {
        return nombreVit;
    }

    public void setNombreVit(int nombreVit) {
        this.nombreVit = nombreVit;
    }

    public double getPuissance1000rpm() {
        return puissance1000rpm;
    }

    public void setPuissance1000rpm(double puissance1000rpm) {
        this.puissance1000rpm = puissance1000rpm;
    }

    public double getPuissance1500rpm() {
        return puissance1500rpm;
    }

    public void setPuissance1500rpm(double puissance1500rpm) {
        this.puissance1500rpm = puissance1500rpm;
    }

    public double getPuissance2000rpm() {
        return puissance2000rpm;
    }

    public void setPuissance2000rpm(double puissance2000rpm) {
        this.puissance2000rpm = puissance2000rpm;
    }

    public double getPuissance2500rpm() {
        return puissance2500rpm;
    }

    public void setPuissance2500rpm(double puissance2500rpm) {
        this.puissance2500rpm = puissance2500rpm;
    }

    public double getPuissance3000rpm() {
        return puissance3000rpm;
    }

    public void setPuissance3000rpm(double puissance3000rpm) {
        this.puissance3000rpm = puissance3000rpm;
    }

    public double getPuissance3500rpm() {
        return puissance3500rpm;
    }

    public void setPuissance3500rpm(double puissance3500rpm) {
        this.puissance3500rpm = puissance3500rpm;
    }

    public double getPuissance4000rpm() {
        return puissance4000rpm;
    }

    public void setPuissance4000rpm(double puissance4000rpm) {
        this.puissance4000rpm = puissance4000rpm;
    }

    public double getPuissance4500rpm() {
        return puissance4500rpm;
    }

    public void setPuissance4500rpm(double puissance4500rpm) {
        this.puissance4500rpm = puissance4500rpm;
    }

    public double getPuissance5000rpm() {
        return puissance5000rpm;
    }

    public void setPuissance5000rpm(double puissance5000rpm) {
        this.puissance5000rpm = puissance5000rpm;
    }

    public double getPuissance5500rpm() {
        return puissance5500rpm;
    }

    public void setPuissance5500rpm(double puissance5500rpm) {
        this.puissance5500rpm = puissance5500rpm;
    }

    public double getPuissance6000rpm() {
        return puissance6000rpm;
    }

    public void setPuissance6000rpm(double puissance6000rpm) {
        this.puissance6000rpm = puissance6000rpm;
    }

    public double getPuissance6500rpm() {
        return puissance6500rpm;
    }

    public void setPuissance6500rpm(double puissance6500rpm) {
        this.puissance6500rpm = puissance6500rpm;
    }

    public double getPuissance7000rpm() {
        return puissance7000rpm;
    }

    public void setPuissance7000rpm(double puissance7000rpm) {
        this.puissance7000rpm = puissance7000rpm;
    }

    public double getPuissance7500rpm() {
        return puissance7500rpm;
    }

    public void setPuissance7500rpm(double puissance7500rpm) {
        this.puissance7500rpm = puissance7500rpm;
    }

    public double getPuissance8000rpm() {
        return puissance8000rpm;
    }

    public void setPuissance8000rpm(double puissance8000rpm) {
        this.puissance8000rpm = puissance8000rpm;
    }

    public String getURL() {
        return URL;
    }
}
