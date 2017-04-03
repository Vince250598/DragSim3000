package Main;

import Controller.EventHandler;
import Controller.Moteur;
import Model.ListeVoitures;
import View.Demarrage;
import View.EnCourse;
import View.Options;
import View.Selection;
import javafx.application.Application;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Programme extends Application {

    EventHandler events = new EventHandler();
    Demarrage starter;
    Selection selec = new Selection();
    static Stage stage;

    public void demarrer(Stage stage) {
        starter = new Demarrage(stage);
        starter.demarrer(stage, events);
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
