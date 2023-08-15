package Controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    @FXML
    void aceptarCerrar (ActionEvent event) throws IOException {
        System.exit(0);
    }

    void cancelarCerrar (ActionEvent event) throws IOException{
        Node source = (Node) event.getSource();
        Stage stage2= (Stage) source.getScene().getWindow();
        stage2.close();
    }

}