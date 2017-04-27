package View;


import Main.Programme;
import Model.ListeVoitures;
import Model.Voiture;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class Selection {

    private ListeVoitures list = new ListeVoitures();
    private GridPane grid = new GridPane();
    private Scene choix = new Scene(grid, 1920, 1080);
    private Image background = new Image("\\Ressources\\noRoad.png");
    private Button back = new Button("Back");
    private boolean loaded = false;

    public Selection() {
        addElements();
    }

    public Scene getChoix() {
        return choix;
    }

    public void reset() {

        addElements();
        Programme.getStage().setScene(choix);
        Voiture.getChoice().setManual(false);
        Voiture.setChoice(null);
    }

    private void addElements() {

        list.getVoitures().clear();
        list.loadVoitures();
        grid.getChildren().clear();
        grid.setAlignment(Pos.CENTER);
        int nbCol = 5;
        int nbRan = 3;

        ColumnConstraints colConst = new ColumnConstraints();
        RowConstraints rowConst = new RowConstraints();

        if (!loaded) {
            colConst.setPercentWidth(100.0 / nbCol);
            rowConst.setPercentHeight(100.0 / nbRan);
            loaded = true;
        }

        for (int i = 0; i < nbCol; i++) {
            grid.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < nbRan; i++) {
            grid.getRowConstraints().add(rowConst);
        }

        int noCol = 0;
        int noRan = 0;
        for (int x = 0; x < list.getVoitures().size(); x++) {
            grid.add(list.getVoitures().get(x).getImage(), noCol, noRan);
            noCol++;
            if (noCol > 4) {
                noCol = 0;
                noRan++;
            }
        }
        BackgroundImage bgImg = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        Background bg = new Background(bgImg);
        grid.setBackground(bg);

        grid.getChildren().add(back);
        back.setTranslateX(1820);
        back.setTranslateY(810);

    }

    public Button getBack() {
        return back;
    }

    public ListeVoitures getList() {
        return list;
    }
}
