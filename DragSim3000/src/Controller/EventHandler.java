package Controller;

import Main.Programme;
import Model.Voiture;
import View.*;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

import java.util.Optional;

public class EventHandler {

    private Demarrage dem = new Demarrage();
    private Options opt = new Options();
    private EnCourse ec = new EnCourse();
    private Selection selec = new Selection();
    private static boolean shiftManual = false;

    public EventHandler() {
    }

    public void anyKey(Scene scene) {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                Programme.getStage().setScene(selec.getChoix());
                Programme.getStage().show();
                choixVoiture();
                event.consume();
            }
        });
    }

    private void choixVoiture() {

        selec.getBack().setOnMouseClicked(event -> dem.demarrer(this));

        for (int x = 0; x < selec.getList().getVoitures().size(); x++) {
            ImageView iv = selec.getList().getVoitures().get(x).getImage();
            final int i = x;

            iv.setOnMouseClicked(event -> {
                Voiture v = selec.getList().getVoitures().get(i);
                Voiture.setChoice(v);
                Programme.getStage().setScene(opt.getOption());
                opt.addElements();
                option();
                Programme.getStage().show();
                disabled();
                event.consume();
            });

            iv.setOnMouseEntered(event -> {
                selec.getList().getVoitures().get(i).getImage().setScaleX(1.2);
                selec.getList().getVoitures().get(i).getImage().setScaleY(1.2);
                event.consume();
            });

            iv.setOnMouseExited(event -> {
                selec.getList().getVoitures().get(i).getImage().setScaleX(1);
                selec.getList().getVoitures().get(i).getImage().setScaleY(1);
                event.consume();
            });
        }
    }

    private void option() {
        opt.getSec().setOnAction(event -> {
            if (opt.getSec().isSelected()) {
                opt.getTrempe().setSelected(false);
                Voiture.getChoice().setDried(true);
            } else {
                opt.getTrempe().setSelected(true);
                Voiture.getChoice().setDried(false);
            }
        });

        opt.getTrempe().setOnAction(event -> {
            if (opt.getTrempe().isSelected()) {
                opt.getSec().setSelected(false);
                Voiture.getChoice().setCf(0.45);
                Voiture.getChoice().setDried(false);
            } else {
                opt.getSec().setSelected(true);
                Voiture.getChoice().setDried(true);
                Voiture.getChoice().setCf(0.85);
            }
        });

        opt.getAutom().setOnAction(event -> {
            if (opt.getAutom().isSelected()) {
                opt.getManuel().setSelected(false);
                Voiture.getChoice().setManual(false);
                shiftManual = false;
            } else
                opt.getManuel().setSelected(true);
        });

        opt.getManuel().setOnAction(event -> {
            if (opt.getManuel().isSelected()) {
                opt.getAutom().setSelected(false);
                Voiture.getChoice().setManual(true);
                setShift();
            } else
                opt.getAutom().setSelected(true);
        });

        Glow glow = new Glow(1);
        opt.getStart().setOnMouseEntered(event -> opt.getStart().setEffect(glow));
        opt.getStart().setOnMouseExited(event -> opt.getStart().setEffect(null));

        opt.getStart().setOnMouseClicked(event -> {
            Programme.getStage().setScene(ec.getEnCourse());
            ec.addElements();
            ec.loaderVoiture();
            Programme.move();
            stop();
        });
    }

    private void setShift() {
        shiftManual = true;

        ec.getEnCourse().setOnKeyPressed(a -> {
            switch (a.getCode()) {
                case UP:
                    if (Voiture.getChoice().getcurrentGear() != Voiture.getChoice().getNombreVit() && shiftManual) {
                        Voiture.getChoice().setcurrentGear(Voiture.getChoice().getcurrentGear() + 1);
                    }
                    break;
                case DOWN:
                    if (Voiture.getChoice().getcurrentGear() - 1 != 0 && shiftManual) {
                        Voiture.getChoice().setcurrentGear(Voiture.getChoice().getcurrentGear() - 1);
                    }
            }
        });

        ec.getEnCourse().setOnMouseClicked(a -> {
            if (a.getButton() == MouseButton.PRIMARY) {
                if (Voiture.getChoice().getcurrentGear() != Voiture.getChoice().getNombreVit() && shiftManual) {
                    Voiture.getChoice().setcurrentGear(Voiture.getChoice().getcurrentGear() + 1);
                }
            }
            if (a.getButton() == MouseButton.SECONDARY) {
                if (Voiture.getChoice().getcurrentGear() - 1 != 0 && shiftManual) {
                    Voiture.getChoice().setcurrentGear(Voiture.getChoice().getcurrentGear() - 1);
                }
            }

        });

    }

    private void stop() {

        ec.getStop().setOnMouseClicked(event -> {
            Programme.getMovement().pause();
            Optional<ButtonType> button = ec.getStopDialog().showAndWait();
            if (button.get() == ec.getMenu()) {
                Programme.getMovement().stop();
                selec.reset();
                if (opt.getTrempe().isSelected())
                    opt.getTrempe().setSelected(false);
                if (opt.getManuel().isSelected())
                    opt.getManuel().setSelected(false);
                choixVoiture();
            } else if (button.get() == ec.getCancel()) {
                ec.getStopDialog().close();
                Programme.getMovement().play();
            } else {
                Programme.getStage().close();
            }
        });
    }

    private void disabled() {

        Voiture.getChoice().getImage().setOnMouseEntered(event -> {
            Voiture.getChoice().getImage().setScaleX(0.6);
            Voiture.getChoice().getImage().setScaleY(0.6);
        });
        Voiture.getChoice().getImage().setOnMouseExited(event -> {
            Voiture.getChoice().getImage().setScaleX(0.6);
            Voiture.getChoice().getImage().setScaleY(0.6);
        });
    }

    public static void setShiftManual(boolean x) {
        shiftManual = x;
    }
}
