package View;

import Controller.EventHandler;
import Main.Programme;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Options {

    private StackPane group = new StackPane();
    private Scene option = new Scene(group, 1920, 1080);
    private Image background = new Image("Ressources\\noRoad.png");
    private CheckBox sec = new CheckBox("Sèche");
    private CheckBox trempe = new CheckBox("Mouillée");
    private CheckBox autom = new CheckBox("Automatique");
    private CheckBox manuel = new CheckBox("Manuelle");
    private ImageView start = new ImageView(new Image("\\Ressources\\start.png"));

    public Options(){}

    public Options(EventHandler eh) {
        addElements();
        eh.option();
    }

    public void addElements(){
        BackgroundImage bgImg = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        Background bg = new Background(bgImg);
        group.setBackground(bg);

        VBox vb1 = new VBox(50);
        vb1.setAlignment(Pos.CENTER);
        HBox hb1 = new HBox(50);
        hb1.setAlignment(Pos.CENTER);
        Text txt1 = new Text("État de la chaussée:");
        txt1.setFont(Font.font(null, FontWeight.SEMI_BOLD, 50));
        sec.setSelected(true);
        sec.setFont(Font.font(null,FontWeight.SEMI_BOLD, 30));
        trempe.setFont(Font.font(null, FontWeight.SEMI_BOLD, 30));
        hb1.getChildren().addAll(sec, trempe);
        vb1.getChildren().addAll(txt1, hb1);

        VBox vb2 = new VBox(50);
        vb2.setAlignment(Pos.CENTER);
        HBox hb2 = new HBox(50);
        hb2.setAlignment(Pos.CENTER);
        Text txt2 = new Text("Type de transmission:");
        txt2.setFont(Font.font(null, FontWeight.SEMI_BOLD, 50));
        autom.setSelected(true);
        autom.setFont(Font.font(null,FontWeight.SEMI_BOLD, 30));
        manuel.setFont(Font.font(null,FontWeight.SEMI_BOLD, 30));
        hb2.getChildren().addAll(autom, manuel);
        vb2.getChildren().addAll(txt2, hb2);

        VBox vb = new VBox(100);
        vb.setAlignment(Pos.CENTER);
        start.setScaleX(2);
        start.setScaleY(2);
        vb.getChildren().addAll(vb1, vb2, start);

        group.getChildren().clear();
        group.getChildren().add(vb);
        vb.setTranslateY(-100);
    }

    public Scene getOption() {
        return option;
    }

    public CheckBox getSec() {
        return sec;
    }

    public CheckBox getTrempe() {
        return trempe;
    }

    public CheckBox getAutom() {
        return autom;
    }

    public CheckBox getManuel() {
        return manuel;
    }

    public ImageView getStart() {
        return start;
    }

    public StackPane getGroup() {
        return group;
    }
}
