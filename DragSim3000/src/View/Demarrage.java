package View;

import Controller.EventHandler;
import Main.Programme;
import javafx.animation.Animation;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Demarrage {

    private Programme prog = new Programme();
    private Pane group = new Pane();
    private Scene start = new Scene(group, prog.getLargeurEcran(), prog.getHauteurEcran());
    private Image background = new Image("\\Ressources\\background.png");

    public Demarrage(Stage s, EventHandler eh) {
        demarrer(s, eh);
        addElements(group);
        s.setMaximized(true);
        s.setTitle("DragSim3000");
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

        Text txt = new Text("Press any key\n to continue");
        txt.setFill(Color.RED);
        txt.setFont(Font.font(null, FontWeight.BOLD, 100));
        txt.setTranslateX(950);
        txt.setTranslateY(350);
        txt.setRotate(25);
        GaussianBlur gb = new GaussianBlur();
        DropShadow ds = new DropShadow();
        ds.setOffsetX(18);
        ds.setOffsetY(18);
        gb.setInput(ds);
        txt.setEffect(gb);
        p.getChildren().add(txt);

        ScaleTransition st = new ScaleTransition(Duration.millis(1000), txt);
        st.setAutoReverse(true);
        st.setCycleCount(Animation.INDEFINITE);
        st.setByX(1.1);
        st.setByY(1.1);
        st.play();

    }
}
