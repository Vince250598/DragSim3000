package Model;


import View.EnCourse;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Voiture {

    private boolean quarterDone;
    private boolean halfDone;
    private boolean mileDone;
    private static Voiture choice;
    private double masse;
    private double efficaciteTransmission;
    private double rayonRoue;
    private double ratioDiff;
    private double rpmMax;
    private int nombreVit;
    private ImageView image = new ImageView();
    private double area;
    private double x;
    private double xLabel;
    private double vx;
    private double time;
    private double Cd;
    private double accel;
    private double rpm = 1000;
    private int currentGear = 1;
    private double densite;
    private double FMoteur;
    private double FTotal;
    private double Frr;
    private double Cf;
    private boolean isDried = true;
    private boolean manual = false;
    private double maxForce;
    private double throttle = 1;
    private double puissance[];
    private double ratioVit[];

    Voiture(double masse, double area, double Cd,
            double efficaciteTransmission,
            double rayonRoue,
            double ratioDiff,
            double rpmMax,
            double[] ratioVit,
            int nombreVit,
            double[] puissance,
            String URL
    ) {

        this.efficaciteTransmission = efficaciteTransmission;
        this.nombreVit = nombreVit;
        this.ratioDiff = ratioDiff;
        this.rayonRoue = rayonRoue;
        this.rpmMax = rpmMax;
        this.masse = masse;
        this.Cd = Cd;
        this.area = area;
        image.setImage(new Image(URL));
        this.puissance = puissance;
        this.ratioVit = ratioVit;

        time = 0;
        x = 0;
        vx = 60 * getGearRatio() * getRatioDiff() / (2 * Math.PI * getRayonRoue() * 1000);
        rpm = 1000;
        currentGear = 1;
        densite = 1;
        accel = 0;
        Frr = 0.03 * getMasse() * 9.8;
        Cf = 0.85;
    }


    private double getPuissance() {
        double b;
        double d;

        if (rpm <= 1000) {
            return puissance[0];
        } else if (rpm < 1500) {
            b = ((puissance[1]) - (puissance[0])) / 500;
            d = (puissance[0]) - (b * 1000);
        } else if (rpm < 2000) {
            b = ((puissance[2]) - (puissance[1])) / 500;
            d = (puissance[1]) - (b * 1500);
        } else if (rpm < 2500) {
            b = ((puissance[3]) - (puissance[2])) / 500;
            d = (puissance[2]) - (b * 2000);
        } else if (rpm < 3000) {
            b = ((puissance[4]) - (puissance[3])) / 500;
            d = (puissance[3]) - (b * 2500);
        } else if (rpm < 3500) {
            b = ((puissance[5]) - (puissance[4])) / 500;
            d = (puissance[4]) - (b * 3000);
        } else if (rpm < 4000) {
            b = ((puissance[6]) - (puissance[5])) / 500;
            d = (puissance[5]) - (b * 3500);
        } else if (rpm < 4500) {
            b = ((puissance[7]) - (puissance[6])) / 500;
            d = (puissance[6]) - (b * 4000);
        } else if (rpm < 5000) {
            b = ((puissance[8]) - (puissance[7])) / 500;
            d = (puissance[7]) - (b * 4500);
        } else if (rpm < 5500) {
            b = ((puissance[9]) - (puissance[8])) / 500;
            d = (puissance[8]) - (b * 5000);
        } else if (rpm < 6000) {
            b = ((puissance[10]) - (puissance[9])) / 500;
            d = (puissance[9]) - (b * 5500);
        } else if (rpm < 6500) {
            b = ((puissance[11]) - (puissance[10])) / 500;
            d = (puissance[10]) - (b * 6000);
        } else if (rpm < 7000) {
            b = ((puissance[12]) - (puissance[11])) / 500;
            d = (puissance[11]) - (b * 6500);
        } else if (rpm < 7500) {
            b = ((puissance[13]) - (puissance[12])) / 500;
            d = (puissance[12]) - (b * 7000);
        } else if (rpm > 7499) {
            b = ((puissance[14]) - (puissance[13])) / 500;
            d = (puissance[13]) - (b * 7500);
        } else {
            b = 0;
            d = 0;
        }
        return ((getRpm() * b) + d);

    }

    private double HPtoNM() {
        return (63025 * getPuissance() / getRpm()) * 0.18;
    }

    private double CalculFd() {
        return 0.45 * getCd() * getArea() * getDensite() * getVx() * getVx();
    }

    private double CalculFMoteur() {
        setThrottle(EnCourse.getThrottle());
        maxForce = (getCf() * 9.8 * getMasse()) / 2;
        if (getChoice() == ListeVoitures.getVoiture())
            maxForce = 3 * getCf() * 9.8 * getMasse();
        FMoteur = getThrottle() * (HPtoNM() * getGearRatio() * getRatioDiff() * getEfficaciteTransmission() / (getRayonRoue() * 2 * Math.PI));
        if (maxForce < FMoteur)
            FMoteur = maxForce;
        if (getRpmMax() <= getRpm())
            FMoteur = 1e-8;
        if (getThrottle() == 0)
            FMoteur = -500 * (1 / getcurrentGear());
        if (getVx() > (2 * Math.PI * rayonRoue * rpmMax) / (60 * getGearRatio() * ratioDiff))
            FMoteur = -5000 * (0.75 * nombreVit / currentGear);
        return FMoteur;
    }

    public void CalculRPM() {
        if (!manual) {
            if (getRpm() >= getRpmMax())
                if (getcurrentGear() + 1 <= getNombreVit())
                    currentGear = (getcurrentGear() + 1);
            if (FTotal < 0 && rpm < rpmMax && getcurrentGear() - 1 >= 1)
                currentGear = getcurrentGear() - 1;
            rpm = (getVx() * 60 * getGearRatio() * getRatioDiff() / (2 * Math.PI * getRayonRoue()));
            if (rpm > rpmMax)
                rpm = rpmMax;
        } else {
            rpm = (getVx() * 60 * getGearRatio() * getRatioDiff() / (2 * Math.PI * getRayonRoue()));
            if (rpm > rpmMax)
                rpm = rpmMax;
        }
        if (rpm < 1000)
            rpm = 1000;
    }

    private double CalculFTotal() {
        FTotal = CalculFMoteur() - CalculFd() - getFrr();
        return FTotal;
    }

    private double CalculAccel() {
        accel = (CalculFTotal() / getMasse()) * 2;
        return accel;
    }

    public void CalculVx(double deltaTime) {
        if (getVx() < 0)
            setVx(0);
        setVx(getVx() + deltaTime * CalculAccel());
    }

    public void CalculX(double deltaTime) {
        setX(getX() + deltaTime * getVx());
        setxLabel(getxLabel() + deltaTime * getVx());
        Voiture.getChoice().getImage().setX(getX() * 30);
        Voiture.getChoice().getImage().setTranslateX(Voiture.getChoice().getImage().getX() + Voiture.getChoice().getVx());
        if (getX() > 60)
            setX(-10);

    }

    public void updateUI() {
        EnCourse.getTemps().setText("Temps: " + Math.round(getTime() * 100.00) / 100.00 + " s");
        EnCourse.getDistance().setText("Distance: " + Math.round(getxLabel()) + " m");
        EnCourse.getRPM().setText("RPM: " + Math.round(getRpm()));
        EnCourse.getVitesse().setText("Vitesse: " + Math.round(getVx() * 3.6) + " km/h");
        EnCourse.getPg().setProgress(getRpm() / getRpmMax());
        if (getRpm() / getRpmMax() < 0.85)
            EnCourse.getPg().setStyle("-fx-accent: green");
        if (getRpm() / getRpmMax() > 0.85)
            EnCourse.getPg().setStyle("-fx-accent: yellow;");
        if (getRpm() / getRpmMax() > 0.95)
            EnCourse.getPg().setStyle("-fx-accent: red");
        setTime(getTime() + 0.015);
        EnCourse.getActualGear().setText(getcurrentGear() + "");
        if (FMoteur >= maxForce)
            EnCourse.getTractionIV().setEffect(new Glow(10));
        else EnCourse.getTractionIV().setEffect(new Glow(0));
        if (getxLabel() >= 402 && !quarterDone) {
            EnCourse.getQuarterMile().setText("1/4 de mile: " + Math.round(getTime() * 1000.000) / 1000.000 + " s");
            quarterDone = true;
        }
        if (getxLabel() >= 804 && !halfDone) {
            EnCourse.getHalfMile().setText("1/2 de mile: " + Math.round(getTime() * 1000.000) / 1000.000 + " s");
            halfDone = true;
        }
        if (getxLabel() >= 1609 && !mileDone) {
            EnCourse.getMile().setText("Mile:            " + Math.round(getTime() * 1000.000) / 1000.000 + " s");
            mileDone = true;
        }
    }

    private double getArea() {
        return area;
    }

    private double getCf() {
        return Cf;
    }

    private void setVx(double vx) {
        this.vx = vx;
    }

    private double getFrr() {
        return Frr;
    }

    private double getX() {
        return x;
    }

    private double getVx() {
        return vx;
    }

    private double getTime() {
        return time;
    }

    private double getCd() {
        return Cd;
    }

    private double getDensite() {
        return densite;
    }

    private void setX(double x) {
        this.x = x;
    }

    private void setTime(double time) {
        this.time = time;
    }

    private double getGearRatio() {
        return ratioVit[currentGear - 1];
    }

    public ImageView getImage() {
        return image;
    }

    private double getRpmMax() {
        return rpmMax;
    }

    private double getMasse() {
        return masse;
    }

    private double getEfficaciteTransmission() {
        return efficaciteTransmission;
    }

    private double getRayonRoue() {
        return rayonRoue;
    }

    private double getRatioDiff() {
        return ratioDiff;
    }

    private double getThrottle() {
        return throttle;
    }

    private void setThrottle(double throttle) {
        this.throttle = throttle;
    }

    public int getNombreVit() {
        return nombreVit;
    }

    private double getRpm() {
        return rpm;
    }

    public int getcurrentGear() {
        return currentGear;
    }

    public void setcurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }

    public static Voiture getChoice() {
        return choice;
    }

    public static void setChoice(Voiture choice) {
        Voiture.choice = choice;
    }

    public boolean isDried() {
        return isDried;
    }

    public void setDried(boolean dried) {
        isDried = dried;
    }

    private double getxLabel() {
        return xLabel;
    }

    private void setxLabel(double xLabel) {
        this.xLabel = xLabel;
    }

    public void setCf(double cf) {
        Cf = cf;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }
}
