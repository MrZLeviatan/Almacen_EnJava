package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
      FXMLLoader login= new FXMLLoader(getClass().getResource("Almacen.fxml"));
      Parent root= login.load();
      Scene loginScene=new Scene(root);
      stage.setTitle("Almacen Happy Meat Farms");
      stage.initStyle(StageStyle.UNDECORATED);
      stage.setScene(loginScene);
      stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}