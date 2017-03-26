package Controller;

import Model.Voiture;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.Vector;

//TODO DERiVEEEEEEEEEEEEEE

public class Moteur {
    private static Voiture choixVoiture;
    private double accel;
    private int rpm = 1000;
    private int actualGear = 1;
    private double wheelSpeed;
    private Vector gearRatio = new Vector();
    private Vector puissance = new Vector();
    private double actualTorque;
    private boolean max = false;
    private int increase;
    private double currentSpeed = 1;
    private double currentPosition;
    private double wheelForce;
    private double torque;
    private double maxWheelForce;
    private double totalForces;
    private double frictionForce;
    private double b;
    private double d;
    private double c1, c2, c3;
    private double vitesse;

    public Moteur() {
    }

    public int getRpm() {
        return rpm;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double getCurrentPosition() {
        return currentPosition;
    }

    public void test() {
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(15), a -> {
            System.out.println(CalculateAcceleration(choixVoiture));
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

    /*private double CalculateAcceleration(Voiture v) {
        accel = (CalculateForces(v) / v.getMasse());
        return accel;
    }*/

    private double CalculC1(Voiture v) {
        c1 = (-0.5 * v.getCD() * 1.225 * v.getHauteur() * v.getLargeur()) / v.getMasse();
        return c1;
    }

    private double CalculC2(Voiture v) {
        c2 = (60 * Math.pow((double) gearRatio.get(actualGear - 1), 2) * Math.pow(v.getRatioDiff(), 2) * b) / (2 * Math.PI * v.getMasse() * Math.pow(v.getRayonRoue(), 2));
        return c2;
    }

    private double CalculC3(Voiture v) {
        c3 = ((double) gearRatio.get(actualGear-1) * v.getRatioDiff() * d) / (v.getMasse() * v.getRayonRoue());
        return c3;
    }

    private double CalculVitesse(Voiture v){
        vitesse = (2 * Math.PI * rpm) / (60 * (double) gearRatio.get(actualGear - 1) * v.getRatioDiff());
        return vitesse;
    }

    private double CalculateAcceleration(Voiture v) {
        accel = (CalculC1(v) * Math.pow(vitesse, 2) + CalculC2(v) * vitesse + CalculC3(v));
        return accel;
    }

    public double CalculateCurrentSpeed(Voiture v) {
        if (currentSpeed >= (v.getVitesseMax() / 3.6) /*de km/h en m/s*/) {
            currentSpeed = (v.getVitesseMax() / 3.6);
            return currentSpeed;
        } else currentSpeed = (currentSpeed + (0.015 * CalculateAcceleration(v)));
        {
            return currentSpeed;
        }

    }

    public double CalculateCurrentPosition(Voiture v) {
        currentPosition = currentPosition + CalculateCurrentSpeed(v);
        choixVoiture.getImage().setTranslateX(currentPosition);
        return currentPosition;
    }

    public int RPM(Voiture v) {
        if (max)
            rpm = (int) v.getRpmMax();
        if (!max) {
            /*RPMincrease(v);
            rpm += increase;*/
            rpm = (int) ((int) (vitesse * 60 * (double) gearRatio.get(actualGear - 1) * v.getRatioDiff()) / (2 * Math.PI * v.getRayonRoue()));
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

    /*private double CalculatePower(Voiture v) {
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
    }*/

    private double CalculatePower(Voiture v) {
        if (rpm > 1500) {
            b = (((9.5488 * 0.7457 * (double) puissance.get(1)) / 1500) - ((9.5488 * 0.7457 * (double) puissance.get(0)) / 1000)) / 499;
            d = ((9.5488 * 0.7457 * (double) puissance.get(0)) / 1000) - (b * 1000);
        } else if (rpm < 2000) {
            b = (((9.5488 * 0.7457 * (double) puissance.get(2)) / 2000) - ((9.5488 * 0.7457 * (double) puissance.get(1)) / 1500)) / 499;
            d = ((9.5488 * 0.7457 * (double) puissance.get(1)) / 1500) - (b * 1500);
        } else if (rpm < 2500) {
            b = (((9.5488 * 0.7457 * (double) puissance.get(3)) / 2500) - ((9.5488 * 0.7457 * (double) puissance.get(2)) / 2000)) / 499;
            d = ((9.5488 * 0.7457 * (double) puissance.get(2)) / 2000) - (b * 2000);
        } else if (rpm < 3000) {
            b = (((9.5488 * 0.7457 * (double) puissance.get(4)) / 3000) - ((9.5488 * 0.7457 * (double) puissance.get(3)) / 2500)) / 499;
            d = ((9.5488 * 0.7457 * (double) puissance.get(3)) / 2500) - (b * 2500);
        } else if (rpm < 3500) {
            b = (((9.5488 * 0.7457 * (double) puissance.get(5)) / 3500) - ((9.5488 * 0.7457 * (double) puissance.get(4)) / 3000)) / 499;
            d = ((9.5488 * 0.7457 * (double) puissance.get(4)) / 3000) - (b * 3000);
        } else if (rpm < 4000) {
            b = (((9.5488 * 0.7457 * (double) puissance.get(6)) / 4000) - ((9.5488 * 0.7457 * (double) puissance.get(5)) / 3500)) / 499;
            d = ((9.5488 * 0.7457 * (double) puissance.get(5)) / 3500) - (b * 3500);
        } else if (rpm < 4500) {
            b = (((9.5488 * 0.7457 * (double) puissance.get(7)) / 4500) - ((9.5488 * 0.7457 * (double) puissance.get(6)) / 4000)) / 499;
            d = ((9.5488 * 0.7457 * (double) puissance.get(6)) / 4000) - (b * 4000);
        } else if (rpm < 5000) {
            b = (((9.5488 * 0.7457 * (double) puissance.get(8)) / 5000) - ((9.5488 * 0.7457 * (double) puissance.get(7)) / 4500)) / 499;
            d = ((9.5488 * 0.7457 * (double) puissance.get(7)) / 4500) - (b * 4500);
        } else if (rpm < 5500) {
            b = (((9.5488 * 0.7457 * (double) puissance.get(9)) / 5500) - ((9.5488 * 0.7457 * (double) puissance.get(8)) / 5000)) / 499;
            d = ((9.5488 * 0.7457 * (double) puissance.get(8)) / 5000) - (b * 5000);
        } else if (rpm < 6000) {
            b = (((9.5488 * 0.7457 * (double) puissance.get(10)) / 6000) - ((9.5488 * 0.7457 * (double) puissance.get(9)) / 5500)) / 499;
            d = ((9.5488 * 0.7457 * (double) puissance.get(9)) / 5500) - (b * 5500);
        } else if (rpm < 6500) {
            b = (((9.5488 * 0.7457 * (double) puissance.get(11)) / 6500) - ((9.5488 * 0.7457 * (double) puissance.get(10)) / 6000)) / 499;
            d = ((9.5488 * 0.7457 * (double) puissance.get(10)) / 6000) - (b * 6000);
        } else if (rpm < 7000) {
            b = (((9.5488 * 0.7457 * (double) puissance.get(12)) / 7000) - ((9.5488 * 0.7457 * (double) puissance.get(11)) / 6500)) / 499;
            d = ((9.5488 * 0.7457 * (double) puissance.get(11)) / 6500) - (b * 6500);
        } else if (rpm < 7500) {
            b = (((9.5488 * 0.7457 * (double) puissance.get(13)) / 7500) - ((9.5488 * 0.7457 * (double) puissance.get(12)) / 7000)) / 499;
            d = ((9.5488 * 0.7457 * (double) puissance.get(12)) / 7000) - (b * 7000);
        } else if (rpm < 8000) {
            b = (((9.5488 * 0.7457 * (double) puissance.get(14)) / 8000) - ((9.5488 * 0.7457 * (double) puissance.get(13)) / 7500)) / 499;
            d = ((9.5488 * 0.7457 * (double) puissance.get(13)) / 7500) - (b * 7500);
        }

        actualTorque = b * rpm + d;
        return actualTorque;
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

        actualTorque = (9.5488 * 0.7457 * choixVoiture.getPuissance1000rpm()) / 1000;
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
