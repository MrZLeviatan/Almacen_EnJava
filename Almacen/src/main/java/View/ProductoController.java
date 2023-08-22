package View;

import Model.TipoPaisOrigen;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.stage.StageStyle.UNDECORATED;

public class ProductoController implements Initializable {

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
    private ComboBox<String> comboBoxTipoPais;

    @FXML
    private ComboBox<String> comboBoxTipoProducto;

    @FXML
    private DatePicker datePickerFechaEnvasado;

    @FXML
    private DatePicker datePickerFechaVencimiento;

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


    private String[] items = {"Colombia","Peru","Argentina","Chile","Ecuador"};

    private String[] productos = {"Producto Perecedero","Producto Refigerado", "Producto Envasado"};

    private ArrayList<String> errores;

    private ArrayList<String> advertencias;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comboBoxTipoPais.getItems().addAll(items);
        comboBoxTipoProducto.getItems().addAll(productos);

        comboBoxTipoProducto.setOnAction(this::ocultar);

        errores = new ArrayList<String>();
        advertencias= new ArrayList<String>();
    }

    public void validar () {
        errores.clear();
        if (textFieldCodigo.getText().isEmpty())
            errores.add("El campo Codigo es obligatorio");

        if (textFieldNombre.getText().isEmpty())
            errores.add("El campo Nombre es obligatorio");

        if (textFieldValorUnitario.getText().isEmpty())
            errores.add("El campo Valor Unitario es obligatorio");

        if (textFieldCantidad.getText().isEmpty())
            errores.add("El campo Cantidad es obligatorio");

        if (comboBoxTipoProducto.getSelectionModel().getSelectedItem() == null) {
            errores.add("Debe seleccionar un tipo de producto");

         } else if (comboBoxTipoProducto.getValue() == "Producto Perecedero") {

            if (datePickerFechaVencimiento.getValue() == null)
                errores.add("Debe seleccionar una fecha de vencimiento");

         } else if (comboBoxTipoProducto.getValue() == "Producto Refigerado") {

            if (textFieldCodigoAprobacion.getText().isEmpty())
                errores.add("El campo Codigo de aprobacion es obligatorio");
            if (textFieldTemperatura.getText().isEmpty())
                errores.add("El campo Temperatura es obligatorio");

        } else if (comboBoxTipoProducto.getValue() == "Producto Envasado") {

            if (datePickerFechaEnvasado.getValue() == null)
                errores.add("Debe seleccionar una fecha de envasado");

            if (textFieldPesoEnvasado.getText().isEmpty())
                errores.add("El campo peso envasado es obligatorio");

            if (comboBoxTipoPais.getSelectionModel().getSelectedItem() == null)
                errores.add("Debe seleccionar un pais de origen");
        }
    }

    public void verificacion(){
        advertencias.clear();

        if (!textFieldCodigo.getText().isEmpty())
            try {
                Integer.parseInt(textFieldCodigo.getText());
            }catch (NumberFormatException e){
                advertencias.add("El campo Codigo debe ser numerico");
            }

        if (!textFieldValorUnitario.getText().isEmpty())
            try {
                Integer.parseInt(textFieldValorUnitario.getText());
            }catch (NumberFormatException e){
                advertencias.add("El campo Valor Unitario debe ser numerico");
            }

        if (!textFieldCantidad.getText().isEmpty())
            try {
                Integer.parseInt(textFieldCantidad.getText());
            }catch (NumberFormatException e){
                advertencias.add("El campo Cantidad debe ser numerico");
            }

        if (!(comboBoxTipoProducto.getSelectionModel().getSelectedItem() ==null)){
            if (comboBoxTipoProducto.getValue() == "Producto Refigerado"){
                if (!textFieldCodigoAprobacion.getText().isEmpty())
                    try {
                        Integer.parseInt(textFieldCodigoAprobacion.getText());
                    }catch (NumberFormatException e){
                        advertencias.add("El campo Codigo Aprobacion debe ser numerio");
                    }
                if (!textFieldTemperatura.getText().isEmpty())
                    try {
                        Integer.parseInt(textFieldTemperatura.getText());
                    }catch (NumberFormatException e){
                        advertencias.add("El campo Temperatura debe ser numerico");
                    }
            }else
                if (comboBoxTipoProducto.getValue()== "Producto Envasado"){
                    if (!textFieldPesoEnvasado.getText().isEmpty())
                        try {
                            Integer.parseInt(textFieldPesoEnvasado.getText());
                        }catch (NumberFormatException e){
                            advertencias.add("El campo Peso Envasado debe ser numerico");
                        }
            }
        }
    }
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

    public void ocultar(ActionEvent actionEvent) {

        String tipoProducto = comboBoxTipoProducto.getValue();

        if (tipoProducto == "Producto Perecedero") {

            datePickerFechaVencimiento.setDisable(false);
            textFieldCodigoAprobacion.setDisable(true);
            textFieldTemperatura.setDisable(true);
            datePickerFechaEnvasado.setDisable(true);
            textFieldPesoEnvasado.setDisable(true);
            comboBoxTipoPais.setDisable(true);

            textFieldCodigoAprobacion.setText("");
            textFieldTemperatura.setText("");
            datePickerFechaEnvasado.getEditor().clear();
            textFieldPesoEnvasado.setText("");
        } else if (tipoProducto == "Producto Refigerado") {
            datePickerFechaVencimiento.setDisable(true);
            textFieldCodigoAprobacion.setDisable(false);
            textFieldTemperatura.setDisable(false);
            datePickerFechaEnvasado.setDisable(true);
            textFieldPesoEnvasado.setDisable(true);
            comboBoxTipoPais.setDisable(true);

            datePickerFechaVencimiento.getEditor().clear();
            datePickerFechaEnvasado.getEditor().clear();
            textFieldPesoEnvasado.setText("");
        }else{
            datePickerFechaVencimiento.setDisable(true);
            textFieldCodigoAprobacion.setDisable(true);
            textFieldTemperatura.setDisable(true);
            datePickerFechaEnvasado.setDisable(false);
            textFieldPesoEnvasado.setDisable(false);
            comboBoxTipoPais.setDisable(false);

            datePickerFechaVencimiento.getEditor().clear();
            textFieldCodigoAprobacion.setText("");
            textFieldTemperatura.setText("");

        }

    }


    public void crearProducto(ActionEvent actionEvent) {
        validar();
        if(errores.size()>0){
            String cadenaErrores="";
            for(int i=0; i < errores.size(); i++)
                cadenaErrores+=errores.get(i)+ "\n";

            Alert mensaje  = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setHeaderText("Se encontraron los siguientes errores");
            mensaje.setContentText(cadenaErrores);
            mensaje.show();
            return;

        }

        verificacion();
        if (advertencias.size() > 0) {
            String cadenaErrores = "";
            for (int i = 0; i < advertencias.size(); i++)
                cadenaErrores += advertencias.get(i) + "\n";

            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setHeaderText("Se encontraron los siguientes errores");
            mensaje.setContentText(cadenaErrores);
            mensaje.show();
            return;
        }
    }
}
