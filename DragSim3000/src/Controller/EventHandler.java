package Controller;

import Model.ListeVoitures;
import Model.Voiture;
import View.Selection;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class EventHandler {

    public EventHandler() {
    }

    public void anyKey(Scene scene, Stage stage, Selection selec) {
        scene.setOnKeyPressed(event -> {
            //TODO: mettre la scene de sélection de la voiture
            stage.setScene(selec.getChoix());
        });
    }

    public void choixVoiture(ListeVoitures v) {

        for (int x = 0; x < v.getVoitures().size(); x++) {
            ImageView iv = v.getVoitures().get(x).getImage();
            final int i = x;
            iv.setOnMouseClicked(event -> {
                Moteur.setChoixVoiture(v.getVoitures().get(i));
                System.out.print(Moteur.getChoixVoiture().getModele());
            });
        }
    }
}
