package Model;


import View.EnCourse;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Voiture {

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
        if (isDried())
            Cf = 0.85;
        else Cf = 0.45;

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
        if (rpm < 1000)
            return puissance1000rpm;
        else if (rpm < 2000)
            return puissance1500rpm;
        else if (rpm < 2500)
            return puissance2000rpm;
        else if (rpm < 3000)
            return puissance2500rpm;
        else if (rpm < 3500)
            return puissance3000rpm;
        else if (rpm < 4000)
            return puissance3500rpm;
        else if (rpm < 4500)
            return puissance4000rpm;
        else if (rpm < 5000)
            return puissance4500rpm;
        else if (rpm < 5500)
            return puissance5000rpm;
        else if (rpm < 6000)
            return puissance5500rpm;
        else if (rpm < 6500)
            return puissance6000rpm;
        else if (rpm < 7000)
            return puissance6500rpm;
        else if (rpm < 7500)
            return puissance7000rpm;
        else if (rpm < 8000)
            return puissance7500rpm;
        else return 0;

    }

    private double HPtoNM() {
        return (63025 * getPuissance() / getRpm()) * 0.18;
    }

    private double CalculFd() {
        Fd = 0.45 * getCd() * getArea() * getDensite() * getVx()* getVx();
        return Fd;
    }

    private double CalculFMoteur() {
        //maxForce == force de traction maximale TODO peut être qu'il va falloir ajuster ça pour le dragster pi la f1
        double maxForce = getCf() * 9.8 * getMasse();
        FMoteur = (HPtoNM() * getGearRatio() * getRatioDiff() * getEfficaciteTransmission() / (getRayonRoue() * 2 * Math.PI));
        if (maxForce < FMoteur)
            FMoteur = maxForce;
        return FMoteur;
    }

    public void CalculRPM() {
        if (getRpm() >= getRpmMax())
            if (getcurrentGear() + 1 <= getNombreVit())
            currentGear = (getcurrentGear() + 1);
        rpm = (getVx() * 60 * getGearRatio() * getRatioDiff() / (2 * Math.PI * getRayonRoue()));
        if (rpm > rpmMax)
            rpm = rpmMax;
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
    }

    public void gearShift() {
        if (1 + getcurrentGear() > getNombreVit())
            return;
        else if (1 + getcurrentGear() < 1)
            return;
        else {
            double oldGearRatio = getGearRatio();
            setcurrentGear(getcurrentGear() + 1);
            double newGearRatio = getGearRatio();
            setRpm(getRpm() * newGearRatio / oldGearRatio);
        }
        return;
    }

    public void updateUI() {
        EnCourse.getTemps().setText("Temps: " + Math.round(getTime() * 100.00) / 100.00 + " s");
        EnCourse.getDistance().setText("Distance: " + Math.round(getX()) + " m");
        EnCourse.getRPM().setText("RPM: " + Math.round(getRpm()));
        EnCourse.getVitesse().setText("Vitesse: " + Math.round(getVx() * 3.6) + " km/h");
        setTime(getTime() + 0.015);
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

    public double getAccel() {
        return accel;
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

    public void setCf(double cf) {
        Cf = cf;
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
}
