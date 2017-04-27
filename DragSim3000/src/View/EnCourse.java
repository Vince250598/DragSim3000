package View;


import Model.Voiture;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EnCourse {

    private StackPane group = new StackPane();
    private Scene enCourse = new Scene(group, 1920, 1080);
    private Image driedBackground = new Image("Ressources\\road.png");
    private Image wetBackground = new Image("Ressources\\rainyRoad.png");
    private static Label temps;
    private static Label vitesse;
    private static Label RPM;
    private static Label distance;
    private Button stop = new Button("Stop");
    private Alert stopDialog = new Alert(Alert.AlertType.CONFIRMATION);
    private ButtonType menu = new ButtonType("Menu");
    private ButtonType exit = new ButtonType("Exit");
    private ButtonType cancel = new ButtonType("Cancel");
    private static ProgressBar pg;
    private static HBox cadran;
    private static Label actualGear;
    private static Label traction;
    private static Label quarterMile;
    private static Label halfMile;
    private static Label mile;
    private static Image tractionImage = new Image("Ressources\\Traction.png");
    private static ImageView tractionIV = new ImageView(tractionImage);
    private Image turtleImage = new Image("Ressources\\turtle.png");
    private ImageView turtle = new ImageView(turtleImage);
    private Image rabbitImage = new Image("Ressources\\rabbit.png");
    private ImageView rabbit = new ImageView(rabbitImage);
    private static Slider throttle;

    public EnCourse() {
    }

    public void addElements() {

        BackgroundImage backgroundImage;
        if (Voiture.getChoice().isDried())
            backgroundImage = new BackgroundImage(driedBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    new BackgroundSize(300, 1080, false, false, false, false));
        else
            backgroundImage = new BackgroundImage(wetBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    new BackgroundSize(300, 1080, false, false, false, false));

        temps = new Label("Temps: ");
        temps.setFont(Font.font(null, FontWeight.SEMI_BOLD, 100));
        temps.setMinWidth(1000);
        temps.setTranslateX(750);
        temps.setTranslateY(-470);

        distance = new Label("Distance: ");
        distance.setFont(Font.font(null, FontWeight.SEMI_BOLD, 100));
        distance.setMinWidth(1000);
        distance.setTranslateX(700);
        distance.setTranslateY(-320);

        vitesse = new Label("Vitesse: ");
        vitesse.setFont(Font.font(null, FontWeight.SEMI_BOLD, 100));
        vitesse.setMinWidth(1000);
        vitesse.setTranslateX(-450);
        vitesse.setTranslateY(-470);

        RPM = new Label("RPM: ");
        RPM.setFont(Font.font(null, FontWeight.SEMI_BOLD, 100));
        RPM.setMinWidth(1000);
        RPM.setTranslateX(-450);
        RPM.setTranslateY(-320);

        quarterMile = new Label("");
        quarterMile.setFont(Font.font(null, FontWeight.SEMI_BOLD, 100));
        quarterMile.setTextFill(Color.RED);
        quarterMile.setMinWidth(1000);
        quarterMile.setTranslateY(-200);

        halfMile = new Label("");
        halfMile.setFont(Font.font(null, FontWeight.SEMI_BOLD, 100));
        halfMile.setTextFill(Color.RED);
        halfMile.setMinWidth(1000);
        halfMile.setTranslateY(-100);

        mile = new Label("");
        mile.setFont(Font.font(null, FontWeight.SEMI_BOLD, 100));
        mile.setTextFill(Color.RED);
        mile.setMinWidth(1000);

        pg = new ProgressBar(0);
        pg.setMinWidth(500);
        pg.setMinHeight(50);

        actualGear = new Label(" ");
        actualGear.setFont(Font.font(null, FontWeight.SEMI_BOLD, 50));
        actualGear.setTranslateY(-12);
        actualGear.setTranslateX(-5);

        traction = new Label("", tractionIV);
        tractionIV.setScaleX(0.5);
        tractionIV.setScaleY(0.5);
        tractionIV.setTranslateX(-40);
        tractionIV.setTranslateY(-39);

        throttle = new Slider(0, 1, 1);
        throttle.setMinWidth(50);
        throttle.setMinHeight(50);
        throttle.setScaleY(5);
        throttle.setScaleX(5);
        throttle.setTranslateX(250);
        throttle.setTranslateY(0);

        cadran = new HBox(50, pg, actualGear, traction, throttle, stop);
        cadran.setTranslateY(900);
        cadran.setTranslateX(20);

        turtle.setScaleX(0.15);
        turtle.setScaleY(0.15);
        rabbit.setScaleX(0.15);
        rabbit.setScaleY(0.15);

        turtle.setTranslateX(-200);
        turtle.setTranslateY(385);
        rabbit.setTranslateX(575);
        rabbit.setTranslateY(385);

        Background bg = new Background(backgroundImage);
        group.setBackground(bg);

        stop.setScaleX(2);
        stop.setScaleY(2);
        stop.setTranslateX(650);
        stop.setTranslateY(15);

        stopDialog.setTitle("Stop");
        stopDialog.setHeaderText(null);
        stopDialog.setContentText("Program has been stop.\n What do you want to do?");
        stopDialog.getButtonTypes().setAll(menu, exit, cancel);

        group.getChildren().clear();
        group.getChildren().addAll(halfMile, mile, quarterMile, temps, vitesse, RPM, distance, cadran, turtle, rabbit);
    }

    public void loaderVoiture() {
        group.getChildren().add(Voiture.getChoice().getImage());
        Voiture.getChoice().getImage().setScaleX(0.6);
        Voiture.getChoice().getImage().setScaleY(0.6);
        StackPane.setAlignment(Voiture.getChoice().getImage(), Pos.BOTTOM_LEFT);
        Voiture.getChoice().getImage().setTranslateX(-40);
        Voiture.getChoice().getImage().setTranslateY(-210);
    }

    public Scene getEnCourse() {
        return enCourse;
    }

    public Alert getStopDialog() {
        return stopDialog;
    }

    public Button getStop() {
        return stop;
    }

    public ButtonType getMenu() {
        return menu;
    }

    public ButtonType getCancel() {
        return cancel;
    }

    public static Label getTemps() {
        return temps;
    }

    public static Label getVitesse() {
        return vitesse;
    }

    public static Label getRPM() {
        return RPM;
    }

    public static Label getDistance() {
        return distance;
    }

    public static ProgressBar getPg() {
        return pg;
    }

    public static Label getActualGear() {
        return actualGear;
    }

    public static double getThrottle() {
        return throttle.getValue();
    }

    public static ImageView getTractionIV() {
        return tractionIV;
    }

    public static Label getQuarterMile() {
        return quarterMile;
    }

    public static Label getHalfMile() {
        return halfMile;
    }

    public static Label getMile() {
        return mile;
    }
}
