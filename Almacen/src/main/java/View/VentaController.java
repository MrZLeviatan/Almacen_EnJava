package View;

import Model.*;

import static View.AlmacenInstance.INSTANCE;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import static View.AlmacenInstance.INSTANCE;
import static javafx.stage.StageStyle.UNDECORATED;

public class VentaController  {

    private final ObservableList<Venta> observableVenta =FXCollections.observableArrayList();

    @FXML
    private Button botonActualizar;

    @FXML
    private Button botonCrear;

    @FXML
    private Button botonEliminar;

    @FXML
    private Button botonRegresar;

    @FXML
    private TableColumn<Venta, Integer> columnaCantidad;

    @FXML
    private TableColumn<Venta, Integer> columndaCliente;

    @FXML
    private TableColumn<Venta, Integer> columnaCodigo;

    @FXML
    private TableColumn<Venta, LocalDate> columnaFecha;


    @FXML
    private TableColumn<Venta, Integer> columnaProducto;


    @FXML
    private TableColumn<Venta,Float> columnaTotal;

    @FXML
    private TableView<Venta> tablaVenta;

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
    private TextField textFieldSubTotal;

    @FXML
    private Label x;

    private ArrayList<String> errores;

    private ArrayList<String> advertencias;




    @FXML
    public void initialize() {

        observableVenta.addAll(INSTANCE.getAlmacen().getVenta());
        tablaVenta.setItems(observableVenta.sorted());

        llenarTabla(INSTANCE.getAlmacen().getVenta());

        columnaCodigo.setCellValueFactory(new PropertyValueFactory<Venta, Integer>("codigo"));
        columnaFecha.setCellValueFactory(new PropertyValueFactory<Venta,LocalDate>("fecha"));
        columndaCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaProducto.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
        columnaTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

    }

    private void llenarTabla(ArrayList<Venta> personas) {
        tablaVenta.setItems(FXCollections.observableArrayList(personas));
        tablaVenta.refresh();
    }

    public VentaController (){
        errores = new ArrayList<String>();
        advertencias = new ArrayList<String>();
    }



    public void validar (){
        errores.clear();

        if(textFieldCodigo.getText().isEmpty())
            errores.add("El campo codigo es obligatorio");

        if (textFieldFecha.getValue()== null)
            errores.add("Debe seleccionar una fecha");

        if (textFieldIDCliente.getText().isEmpty())
            errores.add("El campo ID Cliente es obligatorio");

        if (textFieldSubTotal.getText().isEmpty())
            errores.add("El campo Sub Total es obligatorio");

        if (textFieldIVA.getText().isEmpty())
            errores.add("El campo IVA es obligatorio");

        if (textFieldCantidad.getText().isEmpty())
            errores.add("El campo Cantidad es obligatorio");

        if (textFieldIDProducto.getText().isEmpty())
            errores.add("El campo ID Producto es obligatorio");

    }

    public void verificacion(){
        advertencias.clear();

        if (!textFieldCodigo.getText().isEmpty())
            try {
                Integer.parseInt(textFieldCodigo.getText());
            }catch (NumberFormatException e){
                advertencias.add("El campo Codigo debe ser numerico");
            }

        if (!textFieldIDCliente.getText().isEmpty())
            try {
                Integer.parseInt(textFieldIDCliente.getText());
            }catch (NumberFormatException e){
                advertencias.add("El campo ID Cliente debe ser numerico");
            }

        if (!textFieldSubTotal.getText().isEmpty())
            try {
                Boolean.parseBoolean(textFieldSubTotal.getText());
            }catch (NumberFormatException e){
                advertencias.add("El campo Sub Total debe ser numerico");
            }

        if (!textFieldIVA.getText().isEmpty())
            try {
                Boolean.parseBoolean(textFieldIVA.getText());
            }catch (NumberFormatException e){
                advertencias.add("El campo IVA debe ser numerico");
            }

        if (!textFieldCantidad.getText().isEmpty())
            try {
                Integer.parseInt(textFieldCantidad.getText());
            }catch (NumberFormatException e){
                advertencias.add("El campo Cantidad debe ser numerico");
            }

        if (!textFieldIDProducto.getText().isEmpty())
            try {
                Integer.parseInt(textFieldIDProducto.getText());
            }catch (NumberFormatException e){
                advertencias.add("El campo ID Producto debe ser numerico");
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

    public void crearEvento(ActionEvent actionEvent) {

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

            mensajeError("Mensaje de error",cadenaErrores);
        }
/*
        int idCliente = Integer.parseInt(textFieldIDCliente.getText());
        int idProducto = Integer.parseInt(textFieldIDProducto.getText());
        LocalDate fecha = textFieldFecha.getValue();
        int cantidad = Integer.parseInt(textFieldCantidad.getText());
        float iva = Float.parseFloat(textFieldIVA.getText());

        Producto producto = INSTANCE.getAlmacen().buscarProducto(idProducto);
        int valor = producto.getValorUnitario();

        int codigo = (int) Math.random();
        float Subtotal = cantidad*valor+iva;
        ArrayList<DetalleVenta> detalleVentas = new ArrayList<>();
        detalleVentas.add(new DetalleVenta(cantidad,Subtotal,idProducto));

        Venta venta = new Venta(codigo,fecha,total,iva,detalleVentas);

*/

    }

/*
    public float calcularTotal (ArrayList<DetalleVenta> detalleVentas){

        float total = 0;
         float total = detalleVentas.stream().mapToLong(DetalleVenta::getSubTotal).sum();
         return total;
    }
*/
    public void mensajeError(String descripcion, String cadena) {
        Alert mensaje = new Alert(Alert.AlertType.WARNING);
        mensaje.setTitle("Error");
        mensaje.setHeaderText(descripcion);
        mensaje.setContentText(String.valueOf(cadena));
        mensaje.show();
    }

}

