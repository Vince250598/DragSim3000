package View;


import Controller.Moteur;
import Model.ListeVoitures;
import Model.Voiture;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
    private ImageView imageVoiture = new ImageView();
    static Moteur engine = new Moteur();
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

        Background bg = new Background(backgroundImage);
        group.setBackground(bg);

        stop.setTranslateX(850);
        stop.setTranslateY(410);

        stopDialog.setTitle("Stop");
        stopDialog.setHeaderText(null);
        stopDialog.setContentText("Program has been stop.\n What do you want to do?");
        stopDialog.getButtonTypes().setAll(menu, exit, cancel);

        group.getChildren().clear();
        group.getChildren().addAll(temps, vitesse, RPM, distance, stop);
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
}
