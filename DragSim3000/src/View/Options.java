package View;

import Controller.EventHandler;
import Main.Programme;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Options {

    private Programme prog = new Programme();
    private Pane group = new Pane();
    private Scene option = new Scene(group, prog.getLargeurEcran(), prog.getHauteurEcran());
    private Image background = new Image("Ressources\\noRoad.jpg");

    public Options(Stage s, EventHandler eh) {
//TODO: appeler les méthodes addElements et celle qui check si on clic sur START
    }

    public void addElements(Pane p){
        BackgroundImage bgImg = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        Background bg = new Background(bgImg);
        p.setBackground(bg);

        VBox vb = new VBox(50);
        HBox hb = new HBox(50);
        Text txt = new Text("État de la chaussée:");
        txt.setFont(Font.font(null, FontWeight.SEMI_BOLD, 50));
        CheckBox sec = new CheckBox("Sèche");
        sec.setFont(Font.font(null,FontWeight.SEMI_BOLD, 30));
        //TODO: continuer les checkbox
    }
}
