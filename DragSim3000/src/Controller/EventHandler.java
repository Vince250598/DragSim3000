package Controller;

import View.Selection;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EventHandler {

    public EventHandler(){}

    public void anyKey(Scene scene, Stage stage, Selection selec){
        scene.setOnKeyPressed(event -> {
            //TODO: mettre la scene de sélection de la voiture
            stage.setScene(selec.getChoix());
        });
    }
}
