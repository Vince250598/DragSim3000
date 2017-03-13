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
    private Vector puissance = new Vector();
    private double actualPower;
    private boolean max = false;
    private int increase;

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
        if (max)
            rpm = (int) v.getRpmMax();
        if (!max) {
            RPMincrease(v);
            rpm += increase;
        }
        if (rpm >= v.getRpmMax()) {
            findWheelSpeed(rpm, v);
            if (actualGear < v.getNombreVit()) {
                actualGear++;
                rpm = (int) (wheelSpeed * v.getRatioDiff() * (double) gearRatio.get(actualGear - 1) * 60 / (2 * Math.PI));
            } else max = true;
        }
    }

    private void RPMincrease(Voiture v) {
        int div = rpm / 500;
        switch (div) {
            case 2:
                actualPower = (double) puissance.get(div - 2);
                break;
            case 3:
                actualPower = (double) puissance.get(div - 2);
                break;
            case 4:
                actualPower = (double) puissance.get(div - 2);
                break;
            case 5:
                actualPower = (double) puissance.get(div - 2);
                break;
            case 6:
                actualPower = (double) puissance.get(div - 2);
                break;
            case 7:
                actualPower = (double) puissance.get(div - 2);
                break;
            case 8:
                actualPower = (double) puissance.get(div - 2);
                break;
            case 9:
                actualPower = (double) puissance.get(div - 2);
                break;
            case 10:
                actualPower = (double) puissance.get(div - 2);
                break;
            case 11:
                actualPower = (double) puissance.get(div - 2);
                break;
            case 12:
                actualPower = (double) puissance.get(div - 2);
                break;
            case 13:
                actualPower = (double) puissance.get(div - 2);
                break;
            case 14:
                actualPower = (double) puissance.get(div - 2);
                break;
            case 15:
                actualPower = (double) puissance.get(div - 2);
                break;
            case 16:
                actualPower = (double) puissance.get(div - 2);
                break;
        }
        increase = (int) (((double) gearRatio.get(actualGear - 1) * actualPower) / (6 * v.getRatioDiff()));
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
            if ((double) gearRatio.get(x) == 0) {
                gearRatio.remove(gearRatio.size() - 1);
            }
        }

        puissance.add(choixVoiture.getPuissance1000rpm());
        puissance.add(choixVoiture.getPuissance1500rpm());
        puissance.add(choixVoiture.getPuissance2000rpm());
        puissance.add(choixVoiture.getPuissance2500rpm());
        puissance.add(choixVoiture.getPuissance3000rpm());
        puissance.add(choixVoiture.getPuissance3500rpm());
        puissance.add(choixVoiture.getPuissance4000rpm());
        puissance.add(choixVoiture.getPuissance4500rpm());
        puissance.add(choixVoiture.getPuissance5000rpm());
        puissance.add(choixVoiture.getPuissance5500rpm());
        puissance.add(choixVoiture.getPuissance6000rpm());
        puissance.add(choixVoiture.getPuissance6500rpm());
        puissance.add(choixVoiture.getPuissance7000rpm());
        puissance.add(choixVoiture.getPuissance7500rpm());
        puissance.add(choixVoiture.getPuissance8000rpm());
        for (int x = 0; x < puissance.size(); x++) {
            if ((double) puissance.get(x) == 0) {
                puissance.remove(puissance.size() - 1);
            }
        }
    }

    public static Voiture getChoixVoiture() {
        return choixVoiture;
    }

    public static void setChoixVoiture(Voiture v) {
        choixVoiture = v;
    }
}
