package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primatyStage) throws IOException {
      Parent root= FXMLLoader.load(getClass().getResource("Almacen.fxml"));
      primatyStage.setTitle("Almacen");
      primatyStage.setScene(new Scene(root,300,275));
      primatyStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}