package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import static javafx.stage.StageStyle.UNDECORATED;

public class Main extends Application {
    @Override
    public void start(Stage primatyStage) throws IOException {
        FXMLLoader login = new FXMLLoader(Main.class.getResource("AlmacenController.fxml"));
        Parent root=login.load();
        Scene loginScene=new Scene(root);
        primatyStage.initStyle(UNDECORATED);
        primatyStage.setScene(loginScene);
        primatyStage.show();

    }

    public static void main(String[] args) {

        launch();
    }
}