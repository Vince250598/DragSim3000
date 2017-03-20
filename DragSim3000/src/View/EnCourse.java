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
    private Voiture voiture;
    private ImageView imageVoiture = new ImageView();

    public EnCourse() {
        addElements();
    }

    //TODO: ajouter un bouton "menu" qui arrête tout et nous renvoie au menu principal

    private void addElements() {
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


        Background bg = new Background(backgroundImage);
        group.setBackground(bg);

        group.getChildren().add(vb);
    }

    public void loaderVoiture(){
        voiture = Moteur.getChoixVoiture();
        imageVoiture.setImage(new Image(voiture.getURL()));
        imageVoiture.setY(735);
        imageVoiture.setX(-70);
        imageVoiture.setScaleX(0.3);
        imageVoiture.setScaleY(0.3);
        group.getChildren().add(imageVoiture);
    }

    public Scene getEnCourse() {
        return enCourse;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public ImageView getImageVoiture() {
        return imageVoiture;
    }
}
