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
    double area;
    double x;
    double vx;
    double time;
    double Cd;
    double accel;
    double rpm;
    int actualGear;
    double gearRatio[] = new double[8];
    double densite;
    double Fd;
    double FMoteur;
    double FTotal;
    double Frr;

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
        vx = 0;
        rpm = 1000;
        actualGear = 1;
        densite = 1;
        accel = 0;
        Frr = 0.03 * getMasse() * 9.8;

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

        if (rpm > 1500) {
            b = (((puissance1500rpm)) / 1500) - ((puissance1000rpm) / 1000) / 499;
            d = ((puissance1000rpm) / 1000) - (b * 1000);
        } else if (rpm < 2000) {
            b = (((puissance2000rpm) / 2000) - ((puissance1500rpm) / 1500)) / 499;
            d = ((puissance1500rpm) / 1500) - (b * 1500);
        } else if (rpm < 2500) {
            b = (((puissance2500rpm)) / 2500) - ((puissance2000rpm) / 2000) / 499;
            d = ((puissance2000rpm) / 2000) - (b * 2000);
        } else if (rpm < 3000) {
            b = (((puissance3000rpm) / 3000) - ((puissance2500rpm) / 2500)) / 499;
            d = ((puissance2500rpm) / 2500) - (b * 2500);
        } else if (rpm < 3500) {
            b = (((puissance3500rpm) / 3500) - ((puissance3000rpm) / 3000)) / 499;
            d = ((puissance3000rpm) / 3000) - (b * 3000);
        } else if (rpm < 4000) {
            b = (((puissance4000rpm) / 4000) - ((puissance3500rpm) / 3500)) / 499;
            d = ((puissance3500rpm) / 3500) - (b * 3500);
        } else if (rpm < 4500) {
            b = (((puissance4500rpm) / 4500) - ((puissance4000rpm) / 4000)) / 499;
            d = ((puissance4000rpm) / 4000) - (b * 4000);
        } else if (rpm < 5000) {
            b = (((puissance5000rpm) / 5000) - ((puissance4500rpm) / 4500)) / 499;
            d = ((puissance4500rpm) / 4500) - (b * 4500);
        } else if (rpm < 5500) {
            b = (((puissance5500rpm) / 5500) - ((puissance5000rpm) / 5000)) / 499;
            d = ((puissance5000rpm) / 5000) - (b * 5000);
        } else if (rpm < 6000) {
            b = (((puissance6000rpm) / 6000) - ((puissance5500rpm) / 5500)) / 499;
            d = ((puissance5500rpm) / 5500) - (b * 5500);
        } else if (rpm < 6500) {
            b = (((puissance6500rpm) / 6500) - ((puissance6000rpm) / 6000)) / 499;
            d = ((puissance6000rpm) / 6000) - (b * 6000);
        } else if (rpm < 7000) {
            b = (((puissance7000rpm) / 7000) - ((puissance6500rpm) / 6500)) / 499;
            d = ((puissance6500rpm) / 6500) - (b * 6500);
        } else if (rpm < 7500) {
            b = (((puissance7500rpm) / 7500) - ((puissance7000rpm) / 7000)) / 499;
            d = ((puissance7000rpm) / 7000) - (b * 7000);
        } else if (rpm > 7490) {
            b = (((puissance8000rpm) / 8000) - ((puissance7500rpm) / 7500)) / 499;
            d = ((puissance7500rpm) / 7500) - (b * 7500);
        } else {
            b = 0;
            d = 0;
        }
        return getRpm() * b + d;
    }

    private double HPtoNM() {
        double answer = (63025 * getPuissance() / getRpm()) * 0.18;
        return answer;
    }

    private double CalculFd() {
        Fd = 0.5 * getCd() * getArea() * getDensite() * getVx() * getVx();
        return Fd;
    }

    private double CalculFMoteur() {
        FMoteur = (HPtoNM() * getGearRatio() * getRatioDiff() * getEfficaciteTransmission() / (getRayonRoue() * 2 * Math.PI));
        return FMoteur;
    }

    public void CalculRPM() {
        setRpm(getVx() * 60 * getGearRatio() * getRatioDiff() / (2 * Math.PI * getRayonRoue()));
    }

    private double CalculFTotal() {
        double FTotal = CalculFMoteur() - CalculFd() - getFrr();
        return FTotal;
    }

    private double CalculAccel() {
        double accel = CalculFTotal() / getMasse();
        return accel;
    }

    public void CalculVx(double deltaTime) {
        if (getVx() < 0)
            setVx(0);
        setVx(getVx() + deltaTime * CalculAccel());
    }

    public void CalculX(double deltaTime) {
        setX(getX() + deltaTime * getVx());
    }

    public void gearShift(int shift) {
        if (shift + getActualGear() > getNombreVit())
            return;
        else if (shift + getActualGear() < 1)
            return;
        else {
            double oldGearRatio = getGearRatio();
            setActualGear(getActualGear() + shift);
            double newGearRatio = getGearRatio();
            setRpm(getRpm() * newGearRatio / oldGearRatio);
        }
        return;
    }

    public double getArea() {
        return area;
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

    public double getGearRatio() {
        return gearRatio[actualGear = 1];
    }

    public ImageView getImage() {
        return image;
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

    public int getNombreVit() {
        return nombreVit;
    }

    public double getRpm() {
        return rpm;
    }

    public void setRpm(double rpm) {
        this.rpm = rpm;
    }


    public int getActualGear() {
        return actualGear;
    }

    public void setActualGear(int actualGear) {
        this.actualGear = actualGear;
    }

    public void setGearRatio(double value, int index) {
        this.gearRatio[index] = value;
    }
}
