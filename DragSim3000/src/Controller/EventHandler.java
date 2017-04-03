package Controller;

import Main.Programme;
import Model.ListeVoitures;
import Model.Voiture;
import View.Demarrage;
import View.EnCourse;
import View.Options;
import View.Selection;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Optional;

public class EventHandler {

    /*
    *
    *
    *
    * TODO: quand je reset, la grille de sélection rapetisse à chaque fois ou bien il manque une voiture dans la grille, selon si on call addElements() dans reset
    *
    *
    *
    *
    *
    * */

    Moteur engine = new Moteur();
    Options opt = new Options();
    EnCourse ec = new EnCourse();
    Selection selec = new Selection(this);

    public EventHandler() {
    }

    public void anyKey(Scene scene) {
        scene.setOnKeyPressed(event -> {
            Programme.getStage().setScene(selec.getChoix());
            Programme.getStage().show();
            choixVoiture();
            event.consume();
        });
    }

    public void choixVoiture() {

        for (int x = 0; x < selec.getList().getVoitures().size(); x++) {
            ImageView iv = selec.getList().getVoitures().get(x).getImage();
            final int i = x;

            iv.setOnMouseClicked(event -> {
                Voiture v = selec.getList().getVoitures().get(i);
                Moteur.setChoixVoiture(v);
                Programme.getStage().setScene(opt.getOption());
                opt.addElements();
                option();
                Programme.getStage().show();
                event.consume();
            });

            iv.setOnMouseEntered(event -> {
                selec.getList().getVoitures().get(i).getImage().setScaleX(1.2);
                selec.getList().getVoitures().get(i).getImage().setScaleY(1.2);
            });

            iv.setOnMouseExited(event -> {
                selec.getList().getVoitures().get(i).getImage().setScaleX(1);
                selec.getList().getVoitures().get(i).getImage().setScaleY(1);
            });
        }
    }

    public void option() {
        //TODO: ne pas oublier de modifier les coefficients de friction et de max force selon que isDried ou non
        opt.getSec().setOnAction(event -> {
            if (opt.getSec().isSelected()) {
                opt.getTrempe().setSelected(false);
                ec.setDried(true);
            } else {
                opt.getTrempe().setSelected(true);
                ec.setDried(false);
            }
        });

        opt.getTrempe().setOnAction(event -> {
            if (opt.getTrempe().isSelected()) {
                opt.getSec().setSelected(false);
                ec.setDried(false);
            } else {
                opt.getSec().setSelected(true);
                ec.setDried(true);
            }
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
            Programme.getStage().setScene(ec.getEnCourse());
            ec.addElements();
            ec.loaderVoiture();
            engine.tableauData();
            engine.RPM(Moteur.getChoixVoiture());
            engine.test();
            Demarrage.getStartingMusic().pause();
            EnCourse.getRunningMusic().play();
            stop();
        });
    }

    public void stop() {
        ec.getStop().setOnAction(event -> {
            engine.getTl().pause();
            Optional<ButtonType> button = ec.getStopDialog().showAndWait();
            if (button.get() == ec.getMenu()) {
                engine.getTl().stop();
                selec.reset();
                engine.setActualGear(1);
                engine.setCurrentPosition(0);
                engine.setCurrentSpeed(1);
                choixVoiture();
            } else if (button.get() == ec.getCancel()) {
                ec.getStopDialog().close();
                engine.getTl().play();
            } else Programme.getStage().close();
            EnCourse.getRunningMusic().stop();
        });
    }
}
