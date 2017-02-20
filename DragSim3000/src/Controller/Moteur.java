package Controller;

import Model.Voiture;

public class Moteur {
    private static Voiture choixVoiture;

    public static Voiture getChoixVoiture() {
        return choixVoiture;
    }

    public static void setChoixVoiture(Voiture v) {
        choixVoiture = v;
    }
}
