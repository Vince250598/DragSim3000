package View;


import Main.Programme;
import Model.ListeVoitures;
import Model.Voiture;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Selection {

    private ListeVoitures list = new ListeVoitures();
    private GridPane grid = new GridPane();
    private Scene choix = new Scene(grid, 1920, 1080);
    private Image background = new Image("\\Ressources\\noRoad.png");
    private Button back = new Button("Back");
    private Label modeleLabel = new Label("");
    private boolean loaded = false;
    private HBox modeleH = new HBox();
    private VBox infoVoiture = new VBox();
    private Label puissance = new Label("");
    private Label poids = new Label("");

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

        modeleLabel.setFont(Font.font(null, FontWeight.SEMI_BOLD, 50));
        modeleLabel.setAlignment(Pos.CENTER);
        modeleLabel.setMinWidth(1000);

        modeleH.setTranslateX(410);
        modeleH.setMaxHeight(75);
        modeleH.setTranslateY(-100);

        puissance.setFont(Font.font(null, FontWeight.SEMI_BOLD, 50));
        puissance.setAlignment(Pos.TOP_RIGHT);
        puissance.setMinWidth(750);
        puissance.setTranslateX(0);

        poids.setFont(Font.font(null, FontWeight.SEMI_BOLD, 50));
        poids.setAlignment(Pos.TOP_RIGHT);

        infoVoiture.setTranslateX(1160);
        infoVoiture.setTranslateY(-110);
        infoVoiture.setMaxHeight(80);
        infoVoiture.setAlignment(Pos.TOP_RIGHT);

        ColumnConstraints colConst = new ColumnConstraints();
        RowConstraints rowConst = new RowConstraints();

        if (!loaded) {
            colConst.setPercentWidth(100.0 / nbCol);
            rowConst.setPercentHeight(100.0 / nbRan);
            modeleH.getChildren().add(modeleLabel);
            infoVoiture.getChildren().addAll(puissance, poids);
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

        grid.getChildren().addAll(back ,modeleH ,infoVoiture);
        back.setTranslateX(1820);
        back.setTranslateY(810);

    }

    public Button getBack() {
        return back;
    }

    public ListeVoitures getList() {
        return list;
    }

    public Label getModeleLabel() {
        return modeleLabel;
    }

    public Label getPuissance() {
        return puissance;
    }

    public Label getPoids() {
        return poids;
    }
}
