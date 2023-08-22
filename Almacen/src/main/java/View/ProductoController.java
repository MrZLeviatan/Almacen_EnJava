package View;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static View.AlmacenInstance.INSTANCE;
import static javafx.stage.StageStyle.UNDECORATED;

public class ProductoController {

    private final ObservableList<Producto> observableProducto= FXCollections.observableArrayList();

    @FXML
    private Button botonActualizar;

    @FXML
    private Button botonCrear;

    @FXML
    private Button botonEliminar;

    @FXML
    private Button botonRegresar;

    @FXML
    private TableColumn<Producto, Integer> columnaCodigo;

    @FXML
    private TableColumn<Producto, Integer> columnaCodigoAprob;

    @FXML
    private TableColumn<Producto, LocalDate> columnaFechaDeEnva;

    @FXML
    private TableColumn<Producto, LocalDate> columnaFechaVencimiento;

    @FXML
    private TableColumn<Producto, String> columnaNombre;

    @FXML
    private TableColumn<?,?> columnaPaisOrigen;

    @FXML
    private TableColumn<Producto, Integer> columnaPeso;

    @FXML
    private TableColumn<Producto, Integer> columnaTemperatura;

    @FXML
    private TableColumn<Producto, Integer> columnaValorUnitario;

    @FXML
    private ComboBox<String> comboBoxTipoPais;

    @FXML
    private ComboBox<String> comboBoxTipoProducto;

    @FXML
    private DatePicker datePickerFechaEnvasado;

    @FXML
    private DatePicker datePickerFechaVencimiento;

    @FXML
    private TableView<Producto> tablaProductos;

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
    private TableColumn<Producto, Integer> columnaCantidad;

    @FXML
    private Label x;


    private String[] items = {"Colombia","Peru","Argentina","Chile","Ecuador"};

    private String[] productos = {"Producto Perecedero","Producto Refigerado", "Producto Envasado"};

    private ArrayList<String> errores;

    private ArrayList<String> advertencias;

    @FXML
    public void initialize() {

        observableProducto.addAll(INSTANCE.getAlmacen().getProducto());
        tablaProductos.setItems(observableProducto.sorted());

        llenarTabla(INSTANCE.getAlmacen().getProducto());

        columnaNombre.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombreProducto"));
        columnaCodigo.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("id"));
        columnaValorUnitario.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("valorUnitario"));
        columnaCantidad.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("cantidad"));
        columnaFechaDeEnva.setCellValueFactory(new PropertyValueFactory<>("fechaEnvasado"));
        columnaFechaVencimiento.setCellValueFactory(new PropertyValueFactory<>("fechaVencimiento"));
        columnaCodigoAprob.setCellValueFactory(new PropertyValueFactory<>("codigoAprobacion"));
        columnaTemperatura.setCellValueFactory(new PropertyValueFactory<>("temperaturaOpt"));
        columnaPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        columnaPaisOrigen.setCellValueFactory(new PropertyValueFactory<>("tipoPaisOrigen"));

        comboBoxTipoPais.getItems().addAll(items);
        comboBoxTipoProducto.getItems().addAll(productos);

        comboBoxTipoProducto.setOnAction(this::ocultar);

        errores = new ArrayList<String>();
        advertencias= new ArrayList<String>();
    }

    private void llenarTabla(ArrayList<Producto> personas) {
        tablaProductos.setItems(FXCollections.observableArrayList(personas));
        tablaProductos.refresh();
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
        irOtraPagina("ventanaEmergente.fxml");
    }

    public void regresarPaginaInicial(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Almacen.fxml"));
        Parent root = loader.load();
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

            mensajeError("Falta de informacion",cadenaErrores);
            return;

        }

        verificacion();
        if (advertencias.size() > 0) {
            String cadenaErrores = "";
            for (int i = 0; i < advertencias.size(); i++)
                cadenaErrores += advertencias.get(i) + "\n";

            mensajeError("Mensaje de error", cadenaErrores);
            return;
        }

        String tipoProduco = comboBoxTipoProducto.getValue();



        if (tipoProduco == "Producto Perecedero"){


            String nombre = textFieldNombre.getText();
            int codigo= Integer.parseInt(textFieldCodigo.getText());
            int valorUnitario = Integer.parseInt(textFieldValorUnitario.getText());
            int cantidad = Integer.parseInt(textFieldCantidad.getText());
            LocalDate fechaVencimiento= datePickerFechaVencimiento.getValue();


            ProductoPerecedero productoPerecedero = new ProductoPerecedero(codigo,cantidad
                    , valorUnitario,nombre,null,fechaVencimiento);

            observableProducto.add(productoPerecedero);
            tablaProductos.setItems(observableProducto);
            INSTANCE.getAlmacen().agregarProducto(productoPerecedero);
            tablaProductos.refresh();
            mensajeBienvenida("Registro Completo del Producto Perecedero");
            limpiarCampos();


        }else if (tipoProduco == "Producto Refigerado"){

            String nombre = textFieldNombre.getText();
            int codigo= Integer.parseInt(textFieldCodigo.getText());
            int valorUnitario = Integer.parseInt(textFieldValorUnitario.getText());
            int cantidad = Integer.parseInt(textFieldCantidad.getText());
            int codigoAprobacion= Integer.parseInt(textFieldCodigoAprobacion.getText());
            int temperatura = Integer.parseInt(textFieldTemperatura.getText());


            ProductoRefigerado productoRefigerado = new ProductoRefigerado(codigo,cantidad
                    , valorUnitario,nombre,null,temperatura,codigoAprobacion);

            observableProducto.add(productoRefigerado);
            tablaProductos.setItems(observableProducto);
            INSTANCE.getAlmacen().agregarProducto(productoRefigerado);
            tablaProductos.refresh();
            mensajeBienvenida("Registro Completo del Producto Refigerado");
            limpiarCampos();


        }else if (tipoProduco == "Producto Envasado") {

            String nombre = textFieldNombre.getText();
            int codigo= Integer.parseInt(textFieldCodigo.getText());
            int valorUnitario = Integer.parseInt(textFieldValorUnitario.getText());
            int cantidad = Integer.parseInt(textFieldCantidad.getText());
            LocalDate fechaEnvasado = datePickerFechaEnvasado.getValue();
            int pesoEnvasado = Integer.parseInt(textFieldPesoEnvasado.getText());
            TipoPaisOrigen tipoPais = TipoPaisOrigen.valueOf(comboBoxTipoPais.getSelectionModel().getSelectedItem());

            ProductoEnvasado productoEnvasado = new ProductoEnvasado(codigo, cantidad
                    , valorUnitario, nombre, null, fechaEnvasado, pesoEnvasado
                    , tipoPais);


            observableProducto.add(productoEnvasado);
            tablaProductos.setItems(observableProducto);
            INSTANCE.getAlmacen().agregarProducto(productoEnvasado);
            tablaProductos.refresh();
            mensajeBienvenida("Registro Completo del Producto Envasado");
            limpiarCampos();
        }
    }


    public void mensajeError(String descripcion, String cadena) {
        Alert mensaje = new Alert(Alert.AlertType.WARNING);
        mensaje.setTitle("Error");
        mensaje.setHeaderText(descripcion);
        mensaje.setContentText(String.valueOf(cadena));
        mensaje.show();
    }

    public void irOtraPagina (String view) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(view));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(UNDECORATED);
        stage.setScene(scene);
        stage.showAndWait();

    }

    public void mensajeBienvenida(String descripcion){

        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);
        mensaje.setTitle("Mensaje");
        mensaje.setHeaderText(descripcion);
        mensaje.setContentText("Registro Completo");
        mensaje.show();

    }

    public void limpiarCampos(){
        textFieldNombre.setText("");
        textFieldCodigo.setText("");
        textFieldValorUnitario.setText("");
        textFieldCantidad.setText("");
        datePickerFechaVencimiento.getEditor().clear();
        textFieldCodigoAprobacion.setText("");
        textFieldTemperatura.setText("");
        datePickerFechaEnvasado.getEditor().clear();
        textFieldPesoEnvasado.setText("");
        comboBoxTipoPais.getEditor().clear();

    }


}
