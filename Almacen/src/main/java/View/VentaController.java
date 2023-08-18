package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.stage.StageStyle.UNDECORATED;

public class VentaController {

    @FXML
    private Button botonActualizar;

    @FXML
    private Button botonCrear;

    @FXML
    private Button botonEliminar;

    @FXML
    private Button botonRegresar;

    @FXML
    private TableColumn<?, ?> columnaCantidad;

    @FXML
    private TableColumn<?, ?> columnaCliente;

    @FXML
    private TableColumn<?, ?> columnaCodigo;

    @FXML
    private TableColumn<?, ?> columnaFecha;

    @FXML
    private TableColumn<?, ?> columnaIVA;

    @FXML
    private TableColumn<?, ?> columnaProducto;

    @FXML
    private TableColumn<?, ?> columnaSubTotal;

    @FXML
    private TableColumn<?, ?> columnaTotal;

    @FXML
    private TableView<?> tablaVenta;

    @FXML
    private TextField textFieldCantidad;

    @FXML
    private TextField textFieldCodigo;

    @FXML
    private DatePicker textFieldFecha;

    @FXML
    private TextField textFieldIDCliente;

    @FXML
    private TextField textFieldIDProducto;

    @FXML
    private TextField textFieldIVA;

    @FXML
    private TextField textFieldTotal;

    @FXML
    private Label x;

    public void labCerrar(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaEmergente.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(UNDECORATED);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public void regresarPaginaInicial(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Almacen.fxml"));
        Parent root= loader.load();
        Stage stage = new Stage();
        stage.initStyle(UNDECORATED);
        stage.setScene(new Scene(root));
        Node source = (Node) mouseEvent.getSource();
        Stage stage2 = (Stage) source.getScene().getWindow();
        stage2.hide();
        stage.show();
    }


}
