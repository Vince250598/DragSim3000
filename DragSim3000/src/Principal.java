import Model.ListeVoitures;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {
  @Override
    public void start(Stage primaryStage){
      ListeVoitures a = new ListeVoitures();

      Group root = new Group(a.voitures.get(7).getImage());
      primaryStage.setScene(new Scene(root, 400,400));
      primaryStage.show();
  }

    public static void main(String[] args) {
        launch(args);
    }
}
