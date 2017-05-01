package Main;

import Controller.EventHandler;
import Model.Voiture;
import View.Demarrage;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Programme extends Application {

    EventHandler events = new EventHandler();
    Demarrage starter;
    static Stage stage;
    private static Timeline movement;
    private final static double timeIncrement = 0.015;

    public void demarrer(Stage stage) {
        starter = new Demarrage(stage);
        starter.demarrer(events);
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
