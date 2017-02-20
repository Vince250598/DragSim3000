package View;

import Controller.EventHandler;
import Main.Programme;
import javafx.geometry.Pos;
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
    private Image background = new Image("Ressources\\noRoad.png");

    public Options(Stage s, EventHandler eh) {
//TODO: appeler les méthodes addElements et celle qui check si on clic sur START
        addElements(group);
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
        sec.setSelected(true);
        sec.setFont(Font.font(null,FontWeight.SEMI_BOLD, 30));
        CheckBox trempe = new CheckBox("Mouillée");
        trempe.setFont(Font.font(null, FontWeight.SEMI_BOLD, 30));
        hb.getChildren().addAll(sec, trempe);
        vb.getChildren().addAll(txt, hb);



        p.getChildren().addAll(vb);
    }

    public Scene getOption() {
        return option;
    }
}
