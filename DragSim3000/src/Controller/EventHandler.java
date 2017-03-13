package Controller;

import Model.ListeVoitures;
import Model.Voiture;
import View.EnCourse;
import View.Options;
import View.Selection;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class EventHandler {

    Moteur engine = new Moteur();

    public EventHandler() {
    }

    public void anyKey(Scene scene, Stage stage, Selection selec) {
        scene.setOnKeyPressed(event -> {
            stage.setScene(selec.getChoix());
        });
    }

    public void choixVoiture(ListeVoitures v, Stage stage, Options opt) {
        for (int x = 0; x < v.getVoitures().size(); x++) {
            ImageView iv = v.getVoitures().get(x).getImage();
            final int i = x;

            iv.setOnMouseClicked(event -> {
                Moteur.setChoixVoiture(v.getVoitures().get(i));
                stage.setScene(opt.getOption());
            });

            iv.setOnMouseEntered(event -> {
                v.getVoitures().get(i).getImage().setScaleX(1.2);
                v.getVoitures().get(i).getImage().setScaleY(1.2);
            });

            iv.setOnMouseExited(event -> {
                v.getVoitures().get(i).getImage().setScaleX(1);
                v.getVoitures().get(i).getImage().setScaleY(1);
            });
        }
    }

    //TODO: arranger le vbox qui monte quand je check une case
    public void option(Options opt, Stage stage, EnCourse ec) {
        opt.getSec().setOnAction(event -> {
            if (opt.getSec().isSelected())
                opt.getTrempe().setSelected(false);
            else
                opt.getTrempe().setSelected(true);
        });

        opt.getTrempe().setOnAction(event -> {
            if (opt.getTrempe().isSelected())
                opt.getSec().setSelected(false);
            else
                opt.getSec().setSelected(true);
        });

        opt.getAutom().setOnAction(event -> {
            if (opt.getAutom().isSelected())
                opt.getManuel().setSelected(false);
            else
                opt.getManuel().setSelected(true);
        });

        opt.getManuel().setOnAction(event -> {
            if (opt.getManuel().isSelected())
                opt.getAutom().setSelected(false);
            else
                opt.getAutom().setSelected(true);
        });

        Glow glow = new Glow(1);
        opt.getStart().setOnMouseEntered(event -> opt.getStart().setEffect(glow));
        opt.getStart().setOnMouseExited(event -> opt.getStart().setEffect(null));

        opt.getStart().setOnMouseClicked(event -> {
            stage.setScene(ec.getEnCourse());
            ec.loaderVoiture();
            engine.tableauData();
            engine.RPM(Moteur.getChoixVoiture());
            engine.test();
        });
    }
}
