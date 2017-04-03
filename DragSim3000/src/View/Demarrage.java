package View;

import Controller.EventHandler;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;

public class Demarrage {

    private Pane group = new Pane();
    private Scene start = new Scene(group, 1920, 1080);
    private Image background = new Image("\\Ressources\\background.png");
    private static MediaPlayer startingMusic;

    public Demarrage(Stage s) {
        s.setMaximized(true);
        s.setTitle("DragSim3000");
    }

    public void demarrer(Stage stage, EventHandler eh) {
        stage.setScene(start);
        eh.anyKey(start);
        stage.show();
        addElements();
    }

    public void addElements() {
        BackgroundImage bgImg = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        Background bg = new Background(bgImg);
        group.setBackground(bg);

        if (startingMusic == null) {
            URL url = getClass().getResource("/Ressources/startingMusic.mp3");
            startingMusic = new MediaPlayer(new Media(url.toString()));
            startingMusic.setCycleCount(MediaPlayer.INDEFINITE);
        }
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
        group.getChildren().add(txt);

        ScaleTransition st = new ScaleTransition(Duration.millis(1000), txt);
        st.setAutoReverse(true);
        st.setCycleCount(Animation.INDEFINITE);
        st.setByX(1.1);
        st.setByY(1.1);
        st.play();

        startingMusic.play();

    }

    public static MediaPlayer getStartingMusic() {
        return startingMusic;
    }
}
