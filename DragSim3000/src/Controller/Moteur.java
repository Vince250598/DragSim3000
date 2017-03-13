package Controller;

import Model.Voiture;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.Vector;

public class Moteur {
    private static Voiture choixVoiture;
    private double accelX;
    private int rpm = 1000;
    private int actualGear = 1;
    private double wheelSpeed;
    private Vector gearRatio = new Vector();
    private boolean max = false;

    public Moteur() {
    }

    public void test() {
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(15), a -> {
            System.out.println(rpm + "              " + actualGear);
            RPM(choixVoiture);
        }));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();
    }

    public void RPM(Voiture v) {
        //TODO: faire augmenter les rpm avec la formule que vince recherche
        if (max)
            rpm = (int)v.getRpmMax();
        if (!max)
            rpm += 60;
        if (rpm >= v.getRpmMax()) {
            findWheelSpeed(rpm, v);
            if (actualGear < v.getNombreVit()) {
                actualGear++;
                rpm = (int) (wheelSpeed * v.getRatioDiff() * (double) gearRatio.get(actualGear - 1) * 60 / (2 * Math.PI));
            } else max = true;
        }
    }

    private void findWheelSpeed(int rpm, Voiture v) {
        wheelSpeed = (rpm / (60 / (2 * Math.PI) * v.getRatioDiff() * (double) gearRatio.get(actualGear - 1)));
    }

    public void tableauData() {
        gearRatio.add(choixVoiture.getRatioVit1());
        gearRatio.add(choixVoiture.getRatioVit2());
        gearRatio.add(choixVoiture.getRatioVit3());
        gearRatio.add(choixVoiture.getRatioVit4());
        gearRatio.add(choixVoiture.getRatioVit5());
        gearRatio.add(choixVoiture.getRatioVit6());
        gearRatio.add(choixVoiture.getRatioVit7());
        gearRatio.add(choixVoiture.getRatioVit8());
        for (int x = 0; x < gearRatio.size(); x++) {
            if ((double) gearRatio.get(x) == 0)
                gearRatio.remove(x);
        }
    }

    public static Voiture getChoixVoiture() {
        return choixVoiture;
    }

    public static void setChoixVoiture(Voiture v) {
        choixVoiture = v;
    }
}
