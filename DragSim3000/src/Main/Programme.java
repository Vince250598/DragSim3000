package Main;

import Controller.EventHandler;
import Model.ListeVoitures;
import View.Demarrage;
import View.Selection;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Programme extends Application {

    javafx.geometry.Rectangle2D screenSize = Screen.getPrimary().getBounds();
    double largeurEcran = screenSize.getWidth();
    double hauteurEcran = screenSize.getHeight();

    public double getLargeurEcran() {
        return largeurEcran;
    }

    public double getHauteurEcran() {
        return hauteurEcran;
    }

    @Override
    public void start(Stage primaryStage) {

        ListeVoitures liste = new ListeVoitures();
        EventHandler events = new EventHandler();
        Selection selection = new Selection(primaryStage, events);
        Demarrage demarrage = new Demarrage(primaryStage, events);
        events.choixVoiture(liste);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
