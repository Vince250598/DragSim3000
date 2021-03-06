package Main;

import Controller.EventHandler;
import Model.PlayList;
import Model.Voiture;
import View.Demarrage;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Programme extends Application {

    private EventHandler events = new EventHandler();
    private PlayList playlist = new PlayList();
    private static Stage stage;
    private static Timeline movement;
    private final static double timeIncrement = 0.015;

    private void demarrer(Stage stage) {
        Demarrage starter = new Demarrage(stage);
        starter.demarrer(events);
        playlist.getSong();
    }

    public static void move() {
        movement = new Timeline(new KeyFrame(Duration.seconds(timeIncrement), a -> {
            Voiture.getChoice().CalculVx(timeIncrement);
            Voiture.getChoice().CalculX(timeIncrement);
            Voiture.getChoice().CalculRPM();
            Voiture.getChoice().updateUI();
        }));
        movement.setCycleCount(Animation.INDEFINITE);
        movement.play();
    }

    public static Timeline getMovement() {
        return movement;
    }

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        demarrer(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
