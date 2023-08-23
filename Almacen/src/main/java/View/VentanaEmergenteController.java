package View;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class VentanaEmergenteController {

    @FXML
    private Button botonAceptar;

    @FXML
    private Button botonCancelar;

    @FXML
    private Label x;



    public void aceptarCerrar(javafx.scene.input.MouseEvent mouseEvent) {
        System.exit(0);

    }

    public void cancelarCerrar(MouseEvent mouseEvent) {
        Node source = (Node) mouseEvent.getSource();
        Stage stage2 = (Stage) source.getScene().getWindow();
        stage2.close();
    }
}