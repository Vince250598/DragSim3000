package View;

import Controller.EventHandler;
import Main.Programme;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Demarrage {

    private Programme prog = new Programme();
    private Pane group = new Pane();
    private Scene start = new Scene(group, prog.getLargeurEcran(), prog.getHauteurEcran());
    private Image background = new Image("\\Ressources\\heure.jpg");

    public Demarrage(Stage s, EventHandler eh) {
        demarrer(s, eh);
        addElements(group);
    }

    public void demarrer(Stage stage, EventHandler eh) {
        stage.setScene(start);
        eh.anyKey(start, stage, new Selection(stage, eh));
        stage.show();
    }

    public void addElements(Pane p) {
        BackgroundImage bgImg = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        Background bg = new Background(bgImg);
        p.setBackground(bg);
        //TODO: ajouter le texte et autres trucs si nécessaire
    }
}
