package View;


import Controller.Moteur;
import Main.Programme;
import Model.ListeVoitures;
import Model.Voiture;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EnCourse {

    private Programme programme = new Programme();
    ListeVoitures lv = new ListeVoitures();
    private Pane group = new Pane();
    private Scene enCourse = new Scene(group, programme.getLargeurEcran(), programme.getHauteurEcran());
    private Image background = new Image("Ressources\\road.png");
    private Voiture v = lv.getVoitures().get(0);
    //TODO: changer voiture pour Moteur.choixVoiture
    private ImageView voiture = v.getImage();

    public EnCourse() {
        addElements(group);
    }

    private void addElements(Pane p) {
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(300, 1080, false, false, false, false));

        VBox vb = new VBox(20);
        Label temps = new Label("Temps: ");
        temps.setFont(Font.font(null, FontWeight.SEMI_BOLD, 15));
        Label vitesse = new Label("Vitesse: ");
        vitesse.setFont(Font.font(null, FontWeight.SEMI_BOLD, 15));
        Label RPM = new Label("RPM: ");
        RPM.setFont(Font.font(null, FontWeight.SEMI_BOLD, 15));
        Label distance = new Label("Distance: ");
        distance.setFont(Font.font(null, FontWeight.SEMI_BOLD, 15));
        vb.getChildren().addAll(temps, vitesse, RPM, distance);
        voiture.setY(735);
        voiture.setX(-70);
        voiture.setScaleX(0.3);
        voiture.setScaleY(0.3);

        Background bg = new Background(backgroundImage);
        p.setBackground(bg);

        p.getChildren().addAll(vb, voiture);


    }

    public Scene getEnCourse() {
        return enCourse;
    }
}
