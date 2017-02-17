package View;

import Controller.EventHandler;
import Main.Programme;
import Model.ListeVoitures;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Selection {

    private Programme prog = new Programme();
    private Stage stage = new Stage();
    private ListeVoitures lv = new ListeVoitures();
    private GridPane grid = new GridPane();
    private Scene choix = new Scene(grid, prog.getLargeurEcran(), prog.getHauteurEcran());
    private Image background = new Image("\\Ressources\\noRoad.png");

    public Selection(Stage s, EventHandler eh) {
        this.stage = s;
        addElements(grid, lv);
    }

    public Scene getChoix() {
        return choix;
    }

    public void addElements(GridPane gp, ListeVoitures liste) {

        int nbCol = 5;
        int nbRan = 3;
        for (int i = 0; i < nbCol; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / nbCol);
            gp.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < nbRan; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / nbRan);
            gp.getRowConstraints().add(rowConst);
        }

        int noCol = 0;
        int noRan = 0;
        for (int x = 0; x < liste.voitures.size(); x++) {
            gp.add(liste.voitures.get(x).getImage(), noCol, noRan);
            noCol++;
            if (noCol > 4) {
                noCol = 0;
                noRan++;
            }
        }
        BackgroundImage bgImg = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        Background bg = new Background(bgImg);
        gp.setBackground(bg);

    }
}
