package View;


import Controller.Moteur;
import Main.Programme;
import Model.ListeVoitures;
import Model.Voiture;
import javafx.geometry.Pos;
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
    private StackPane group = new StackPane();
    private Scene enCourse = new Scene(group, programme.getLargeurEcran(), programme.getHauteurEcran());
    private Image background = new Image("Ressources\\road.png");
    private Voiture voiture;
    private ImageView imageVoiture = new ImageView();
    static Moteur engine = new Moteur();
    static Label temps;
    static Label vitesse;
    static Label RPM;
    static Label distance;

    public EnCourse() {}

    //TODO: ajouter un bouton "menu" qui arrête tout et nous renvoie au menu principal

    public void addElements() {
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(300, 1080, false, false, false, false));

        VBox vb = new VBox(20);
        temps = new Label("Temps: ");
        temps.setFont(Font.font(null, FontWeight.SEMI_BOLD, 15));
        vitesse = new Label("Vitesse: ");
        vitesse.setFont(Font.font(null, FontWeight.SEMI_BOLD, 15));
        RPM = new Label("RPM: ");
        RPM.setFont(Font.font(null, FontWeight.SEMI_BOLD, 15));
        distance = new Label("Distance: ");
        distance.setFont(Font.font(null, FontWeight.SEMI_BOLD, 15));
        vb.getChildren().addAll(temps, vitesse, RPM, distance);


        Background bg = new Background(backgroundImage);
        group.setBackground(bg);

        group.getChildren().add(vb);
    }

    public void loaderVoiture(){
        voiture = Moteur.getChoixVoiture();
        group.getChildren().add(Moteur.getChoixVoiture().getImage());
        Moteur.getChoixVoiture().getImage().setScaleX(0.3);
        Moteur.getChoixVoiture().getImage().setScaleY(0.3);
        StackPane.setAlignment(Moteur.getChoixVoiture().getImage(), Pos.BOTTOM_LEFT );
        Moteur.getChoixVoiture().getImage().setTranslateX(-50);
        Moteur.getChoixVoiture().getImage().setTranslateY(-200);
    }

    public static void majUI(){
        //TODO: ne se mete pas à jour, peut-être le changer de classe
        temps.setText("Temps: " /*TODO: ajouter le temps*/);
        vitesse.setText("Vitesse: " + engine.getCurrentSpeed() + " m/s");
        RPM.setText("RPM: " + engine.getRpm());
        distance.setText("Distance: " + engine.getCurrentPosition());
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
