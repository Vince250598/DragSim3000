package Controller;

import Model.Voiture;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.Vector;

public class Moteur {
    private static Voiture choixVoiture;
    private double accel;
    private int rpm = 1000;
    private int actualGear = 1;
    private double wheelSpeed;
    private Vector gearRatio = new Vector();
    private Vector puissance = new Vector();
    private double actualPower;
    private boolean max = false;
    private int increase;
    private double currentSpeed = 1;
    private double currentPosition;
    private double wheelForce;
    private double torque;
    private double maxWheelForce;
    private double totalForces;
    private double frictionForce;

    public Moteur() {
    }

    public void test() {
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(15), a -> {
            CalculateCurrentPosition(choixVoiture);
            System.out.println(currentSpeed * 3.6 + "      ///////     " + currentPosition + "     ///////     " + actualGear + "      ///////     " + rpm);
            a.consume();
        }));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();
    }

    private double CalculateTorque(Voiture v) {
        //calcul en lb.in jusqu'à n.m
        torque = (63025 * (CalculatePower(v) / RPM(v))) * 0.112984829333;
        return torque;
    }

    private double CalculateMaxWheelForce(Voiture v) {
        maxWheelForce = 0.85 * v.getMasse() * 9.8;
        return maxWheelForce;
    }

    private double CalculateWheelForce(Voiture v) {
        wheelForce = (CalculateTorque(v) * (double) gearRatio.get(actualGear - 1) * v.getRatioDiff() * (v.getEfficaciteTransmission() / v.getRayonRoue()));
        if (wheelForce > CalculateMaxWheelForce(v))
            wheelForce = maxWheelForce;
        return wheelForce;
    }

    private double CalculateForces(Voiture v) {
        totalForces = CalculateWheelForce(v) - CalculateFriction(v);
        return totalForces;
    }

    private double CalculateFriction(Voiture v) {
        frictionForce = (0.02 * v.getMasse() * 9.8);
        return frictionForce;
    }

    private double CalculateAcceleration(Voiture v) {
        accel = (CalculateForces(v) / v.getMasse());
        return accel;
    }

    public double CalculateCurrentSpeed(Voiture v) {
        if (currentSpeed >= (v.getVitesseMax()/3.6) /*de km/h en m/s*/) {
            currentSpeed = (v.getVitesseMax()/3.6);
            return currentSpeed;
        } else currentSpeed = (currentSpeed + (0.015 * CalculateAcceleration(v)));
        {
            return currentSpeed;
        }

    }

    public double CalculateCurrentPosition(Voiture v) {
        //TODO: l'image ne se déplace pas
        v.getImage().setX(currentPosition + CalculateCurrentSpeed(v));
        currentPosition = v.getImage().getX();
        return v.getImage().getX();
    }

    public int RPM(Voiture v) {
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
        return rpm;
    }

    private double CalculatePower(Voiture v) {
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
        return actualPower;
    }

    private int RPMincrease(Voiture voiture) {
        increase = (int) (((double) gearRatio.get(actualGear - 1) * CalculatePower(voiture)) * accel * 0.5 / (currentSpeed * (voiture.getRatioDiff())));
        /*switch (actualGear) {
            case 0:
                increase = (int) (((double) gearRatio.get(actualGear - 1) * CalculatePower(voiture)) / ((voiture.getVitesseMax()/currentSpeed) * voiture.getRatioDiff()));
                break;
            case 1:
                increase = (int) (((double) gearRatio.get(actualGear - 1) * CalculatePower(voiture)) / (4 * voiture.getRatioDiff()));
                break;
            case 2:
                increase = (int) (((double) gearRatio.get(actualGear - 1) * CalculatePower(voiture)) / (6 * voiture.getRatioDiff()));
                break;
            case 3:
                increase = (int) (((double) gearRatio.get(actualGear - 1) * CalculatePower(voiture)) / (7 * voiture.getRatioDiff()));
                break;
            case 4:
                increase = (int) (((double) gearRatio.get(actualGear - 1) * CalculatePower(voiture)) / (8 * voiture.getRatioDiff()));
                break;
            case 5:
                increase = (int) (((double) gearRatio.get(actualGear - 1) * CalculatePower(voiture)) / (9 * voiture.getRatioDiff()));
                break;
            case 6:
                increase = (int) (((double) gearRatio.get(actualGear - 1) * CalculatePower(voiture)) / (10 * voiture.getRatioDiff()));
                break;
            case 7:
                increase = (int) (((double) gearRatio.get(actualGear - 1) * CalculatePower(voiture)) / (10 * voiture.getRatioDiff()));
                break;
        }*/
        return increase;
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

        actualPower = choixVoiture.getPuissance1000rpm();
        currentPosition = choixVoiture.getImage().getX();

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
