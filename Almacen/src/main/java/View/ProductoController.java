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

public class ProductoController {

    @FXML
    private Button botonActualizar;

    @FXML
    private Button botonCrear;

    @FXML
    private Button botonEliminar;

    @FXML
    private Button botonRegresar;

    @FXML
    private TableColumn<?, ?> columnaCodigo;

    @FXML
    private TableColumn<?, ?> columnaCodigoAprob;

    @FXML
    private TableColumn<?, ?> columnaFechaDeEnva;

    @FXML
    private TableColumn<?, ?> columnaFechaVencimiento;

    @FXML
    private TableColumn<?, ?> columnaNombre;

    @FXML
    private TableColumn<?, ?> columnaPaisOrigen;

    @FXML
    private TableColumn<?, ?> columnaPeso;

    @FXML
    private TableColumn<?, ?> columnaTemperatura;

    @FXML
    private TableColumn<?, ?> columnaValorUnitario;

    @FXML
    private DatePicker datePickerFechaEnvasado;

    @FXML
    private DatePicker datePickerFechaVencimiento;

    @FXML
    private MenuItem menuBotonArgentina;

    @FXML
    private MenuItem menuBotonChile;

    @FXML
    private MenuItem menuBotonColombia;

    @FXML
    private MenuItem menuBotonEcuador;

    @FXML
    private MenuButton menuBotonPaisOrigen;

    @FXML
    private MenuItem menuBotonPeru;

    @FXML
    private MenuItem menuBotonProdEnvasado;

    @FXML
    private MenuItem menuBotonProdPerecedero;

    @FXML
    private MenuItem menuBotonProdRefigerado;

    @FXML
    private MenuButton menuBotonTipoDeProducto;

    @FXML
    private TableView<?> tablaProductos;

    @FXML
    private TextField textFieldCantidad;

    @FXML
    private TextField textFieldCodigo;

    @FXML
    private TextField textFieldCodigoAprobacion;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldPesoEnvasado;

    @FXML
    private TextField textFieldTemperatura;

    @FXML
    private TextField textFieldValorUnitario;

    @FXML
    private TableColumn<?, ?> valorCantidad;

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
