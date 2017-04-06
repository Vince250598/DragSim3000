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
        temps.setTranslateX(-780);
        temps.setTranslateY(-490);

        distance = new Label("Distance: ");
        distance.setFont(Font.font(null, FontWeight.SEMI_BOLD, 100));
        distance.setTranslateX(-740);
        distance.setTranslateY(-340);

        vitesse = new Label("Vitesse: ");
        vitesse.setFont(Font.font(null, FontWeight.SEMI_BOLD, 100));
        vitesse.setTranslateX(190);
        vitesse.setTranslateY(-490);

        RPM = new Label("RPM: ");
        RPM.setFont(Font.font(null, FontWeight.SEMI_BOLD, 100));
        RPM.setTranslateX(140);
        RPM.setTranslateY(-340);

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
        Voiture.getChoice().getImage().setScaleX(0.3);
        Voiture.getChoice().getImage().setScaleY(0.3);
        StackPane.setAlignment(Voiture.getChoice().getImage(), Pos.BOTTOM_LEFT);
        Voiture.getChoice().getImage().setTranslateX(-75);
        Voiture.getChoice().getImage().setTranslateY(-200);
    }

    public static void majUI() {
        //TODO: ne se mete pas à jour, peut-être le changer de classe
        temps.setText("Temps: " /*TODO: ajouter le temps*/);
        vitesse.setText("Vitesse: " + engine.getCurrentSpeed() + " m/s");
        RPM.setText("RPM: " + engine.getRpm());
        distance.setText("Distance: " + engine.getCurrentPosition());
    }

    public Scene getEnCourse() {
        return enCourse;
    }

    public ImageView getImageVoiture() {
        return imageVoiture;
    }

    public boolean isDried() {
        return dried;
    }

    public void setDried(boolean dried) {
        this.dried = dried;
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
