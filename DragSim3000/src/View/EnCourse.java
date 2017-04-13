package View;


import Controller.Moteur;
import Model.ListeVoitures;
import Model.Voiture;
import javafx.geometry.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;

public class EnCourse {

    private StackPane group = new StackPane();
    private Scene enCourse = new Scene(group, 1920, 1080);
    private Image driedBackground = new Image("Ressources\\road.png");
    private Image wetBackground = new Image("Ressources\\rainyRoad.png");
    static Label temps;
    static Label vitesse;
    static Label RPM;
    static Label distance;
    private boolean dried = true;
    private Button stop = new Button("Stop");
    private Alert stopDialog = new Alert(Alert.AlertType.CONFIRMATION);
    private ButtonType menu = new ButtonType("Menu");
    private ButtonType exit = new ButtonType("Exit");
    private ButtonType cancel = new ButtonType("Cancel");
    private static MediaPlayer runningMusic;
    static ProgressBar pg;
    static HBox cadran;
    static Label actualGear;
    static Label traction;
    static Image tractionImage = new Image("Ressources\\Traction.png");
    static ImageView tractionIV = new ImageView(tractionImage);
    private Image turtleImage = new Image("Ressources\\turtle.png");
    private ImageView turtle = new ImageView(turtleImage);
    private Image rabbitImage = new Image("Ressources\\rabbit.png");
    private ImageView rabbit = new ImageView(rabbitImage);
    static Slider throttle;

    public EnCourse() {
    }

    public void addElements() {

        if (runningMusic == null) {
            URL url = getClass().getResource("/Ressources/runningMusic.mp3");
            runningMusic = new MediaPlayer(new Media(url.toString()));
        }
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

        pg = new ProgressBar(0);
        pg.setMinWidth(500);
        pg.setMinHeight(50);

        actualGear = new Label(" ");
        actualGear.setFont(Font.font(null, FontWeight.SEMI_BOLD, 50));
        actualGear.setTranslateY(-12);
        actualGear.setTranslateX(-5);

        traction = new Label("",tractionIV);
        tractionIV.setScaleX(0.5);
        tractionIV.setScaleY(0.5);
        tractionIV.setTranslateX(-40);
        tractionIV.setTranslateY(-39);

        throttle = new Slider(0,1,1);
        throttle.setMinWidth(50);
        throttle.setMinHeight(50);
        throttle.setScaleY(5);
        throttle.setScaleX(5);
        throttle.setTranslateX(250);
        throttle.setTranslateY(20);

        cadran = new HBox(50, pg, actualGear, traction, throttle);
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

        stop.setTranslateX(850);
        stop.setTranslateY(410);

        stopDialog.setTitle("Stop");
        stopDialog.setHeaderText(null);
        stopDialog.setContentText("Program has been stop.\n What do you want to do?");
        stopDialog.getButtonTypes().setAll(menu, exit, cancel);

        group.getChildren().clear();
        group.getChildren().addAll(temps, vitesse, RPM, distance, stop, cadran, turtle, rabbit);
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

    public StackPane getGroup() {
        return group;
    }

    public static MediaPlayer getRunningMusic() {
        return runningMusic;
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

    public static HBox getCadran() {
        return cadran;
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
}
