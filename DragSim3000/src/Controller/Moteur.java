package Controller;

import Model.Voiture;

public class Moteur {
    private static Voiture choixVoiture;
    private double accelX;

    public Moteur(){}

   // public double calculVitesseX(){}




    public static Voiture getChoixVoiture() {
        return choixVoiture;
    }

    public static void setChoixVoiture(Voiture v) {
        choixVoiture = v;
    }
}
