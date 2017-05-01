package View;

import Controller.EventHandler;
import Main.Programme;
import Model.PlayList;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
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

    private Pane group = new Pane();
    private Scene start = new Scene(group, 1920, 1080);
    private Image background = new Image("\\Ressources\\background.png");
    private PlayList playList = new PlayList();

    public Demarrage() {
    }

    public Demarrage(Stage s) {
        s.setMaximized(true);
        s.setTitle("DragSim3000");
    }

    public void demarrer(EventHandler eh) {
        playList.getSong();
        Programme.getStage().setScene(start);
        eh.anyKey(start);
        Programme.getStage().show();
        if (group.getChildren().isEmpty())
            addElements();
    }

    private void addElements() {
        BackgroundImage bgImg = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        Background bg = new Background(bgImg);
        group.setBackground(bg);

        Text txt = new Text(" Press space\n to continue");
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
        group.getChildren().add(txt);

        ScaleTransition st = new ScaleTransition(Duration.millis(1000), txt);
        st.setAutoReverse(true);
        st.setCycleCount(Animation.INDEFINITE);
        st.setByX(1.1);
        st.setByY(1.1);
        st.play();

    }

}
