package Model;


import View.EnCourse;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Voiture {

    boolean quarterDone;
    static Voiture choice;
    String modele;
    double masse;
    double efficaciteTransmission;
    double rayonRoue;
    double ratioDiff;
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
    double area;
    double x;
    double xLabel;
    double vx;
    double time;
    double Cd;
    double accel;
    double rpm = 1000;
    int currentGear = 1;
    double gearRatio[] = new double[8];
    double densite;
    double Fd;
    double FMoteur;
    double FTotal;
    double Frr;
    double Cf;
    boolean isDried = true;
    boolean manual = false;
    double maxForce;
    double throttle = 1;

    public Voiture(double masse, double area, double Cd, String modele,
                   double efficaciteTransmission,
                   double rayonRoue,
                   double ratioDiff,
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
        this.URL = URL;
        this.masse = masse;
        this.Cd = Cd;
        this.area = area;
        image.setImage(new Image(URL));

        time = 0;
        x = 0;
        vx = 60 * getGearRatio() * getRatioDiff() / (2 * Math.PI * getRayonRoue() * 1000);
        rpm = 1000;
        currentGear = 1;
        densite = 1;
        accel = 0;
        Frr = 0.03 * getMasse() * 9.8;
        Cf = 0.85;

        setGearRatio(ratioVit1, 0);
        setGearRatio(ratioVit2, 1);
        setGearRatio(ratioVit3, 2);
        setGearRatio(ratioVit4, 3);
        setGearRatio(ratioVit5, 4);
        setGearRatio(ratioVit6, 5);
        setGearRatio(ratioVit7, 6);
        setGearRatio(ratioVit8, 7);
    }

    private double getPuissance() {
        double b;
        double d;

        if (rpm <= 1000) {
            return puissance1000rpm;
        } else if (rpm < 1500) {
            b = ((puissance1500rpm) - (puissance1000rpm)) / 500;
            d = (puissance1000rpm) - (b * 1000);
        } else if (rpm < 2000) {
            b = ((puissance2000rpm) - (puissance1500rpm)) / 500;
            d = (puissance1500rpm) - (b * 1500);
        } else if (rpm < 2500) {
            b = ((puissance2500rpm) - (puissance2000rpm)) / 500;
            d = (puissance2000rpm) - (b * 2000);
        } else if (rpm < 3000) {
            b = ((puissance3000rpm) - (puissance2500rpm)) / 500;
            d = (puissance2500rpm) - (b * 2500);
        } else if (rpm < 3500) {
            b = ((puissance3500rpm) - (puissance3000rpm)) / 500;
            d = (puissance3000rpm) - (b * 3000);
        } else if (rpm < 4000) {
            b = ((puissance4000rpm) - (puissance3500rpm)) / 500;
            d = (puissance3500rpm) - (b * 3500);
        } else if (rpm < 4500) {
            b = ((puissance4500rpm) - (puissance4000rpm)) / 500;
            d = (puissance4000rpm) - (b * 4000);
        } else if (rpm < 5000) {
            b = ((puissance5000rpm) - (puissance4500rpm)) / 500;
            d = (puissance4500rpm) - (b * 4500);
        } else if (rpm < 5500) {
            b = ((puissance5500rpm) - (puissance5000rpm)) / 500;
            d = (puissance5000rpm) - (b * 5000);
        } else if (rpm < 6000) {
            b = ((puissance6000rpm) - (puissance5500rpm)) / 500;
            d = (puissance5500rpm) - (b * 5500);
        } else if (rpm < 6500) {
            b = ((puissance6500rpm) - (puissance6000rpm)) / 500;
            d = (puissance6000rpm) - (b * 6000);
        } else if (rpm < 7000) {
            b = ((puissance7000rpm) - (puissance6500rpm)) / 500;
            d = (puissance6500rpm) - (b * 6500);
        } else if (rpm < 7500) {
            b = ((puissance7500rpm) - (puissance7000rpm)) / 500;
            d = (puissance7000rpm) - (b * 7000);
        } else if (rpm > 7499) {
            b = ((puissance8000rpm) - (puissance7500rpm)) / 500;
            d = (puissance7500rpm) - (b * 7500);
        } else {
            b = 0;
            d = 0;
        }
        double puissance = (getRpm() * b + d);
        return puissance;

    }

    private double HPtoNM() {
        return (63025 * getPuissance() / getRpm()) * 0.18;
    }

    private double CalculFd() {
        Fd = 0.45 * getCd() * getArea() * getDensite() * getVx() * getVx();
        return Fd;
    }

    private double CalculFMoteur() {
        //maxForce == force de traction maximale
        setThrottle(EnCourse.getThrottle());
        maxForce = (getCf() * 9.8 * getMasse()) / 2;
        if (getChoice() == ListeVoitures.getVoiture(9))
            maxForce = 3 * getCf() * 9.8 * getMasse();
        FMoteur = getThrottle() * (HPtoNM() * getGearRatio() * getRatioDiff() * getEfficaciteTransmission() / (getRayonRoue() * 2 * Math.PI));
        if (maxForce < FMoteur)
            FMoteur = maxForce;
        if (getRpmMax() <= getRpm())
            FMoteur = 1e-8;
        if (getThrottle() == 0)
            FMoteur = -500 * (1/getcurrentGear());
        if (getVx() > (2 * Math.PI * rayonRoue * rpmMax) / (60 * getGearRatio() * ratioDiff))
            FMoteur = -5000 * (0.75 * nombreVit/currentGear);
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
        } else if (manual) {
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

    public void gearShift() {
        if (1 + getcurrentGear() > getNombreVit())
            return;
        else if (getcurrentGear() - 1 < 1)
            return;
        else {
            double oldGearRatio = getGearRatio();
            setcurrentGear(getcurrentGear() + 1);
            double newGearRatio = getGearRatio();
            setRpm(getRpm() * newGearRatio / oldGearRatio);
        }
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
        if (getxLabel() >= 402 && !quarterDone){
            EnCourse.getQuarterMile().setText("1/4 de mile: " + Math.round(getTime() * 1000.000) / 1000.000 + " s");
            quarterDone = true;
        }
    }

    public double getArea() {
        return area;
    }

    public double getCf() {
        return Cf;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getFrr() {
        return Frr;
    }

    public double getX() {
        return x;
    }

    public double getVx() {
        return vx;
    }

    public double getTime() {
        return time;
    }

    public double getCd() {
        return Cd;
    }

    public double getDensite() {
        return densite;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getGearRatio() {
        return gearRatio[currentGear - 1];
    }

    public ImageView getImage() {
        return image;
    }

    public double getRpmMax() {
        return rpmMax;
    }

    public double getMasse() {
        return masse;
    }

    public double getEfficaciteTransmission() {
        return efficaciteTransmission;
    }

    public double getRayonRoue() {
        return rayonRoue;
    }

    public double getRatioDiff() {
        return ratioDiff;
    }

    public double getThrottle() {
        return throttle;
    }

    public void setThrottle(double throttle) {
        this.throttle = throttle;
    }

    public int getNombreVit() {
        return nombreVit;
    }

    public double getRpm() {
        return rpm;
    }

    public void setRpm(double rpm) {
        this.rpm = rpm;
    }

    public int getcurrentGear() {
        return currentGear;
    }

    public void setcurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }

    public void setGearRatio(double value, int index) {
        this.gearRatio[index] = value;
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

    public double getxLabel() {
        return xLabel;
    }

    public void setxLabel(double xLabel) {
        this.xLabel = xLabel;
    }

    public void setCf(double cf) {
        Cf = cf;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }
}
