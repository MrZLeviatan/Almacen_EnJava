package View;

import Model.*;

import static View.AlmacenInstance.INSTANCE;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

import static javafx.stage.StageStyle.UNDECORATED;

public class VentaController  {

    private final ObservableList<Venta> observableVenta =FXCollections.observableArrayList();

    private final ObservableList<Producto> observableProducto =FXCollections.observableArrayList();

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
    private TableColumn<Venta, String> columnaCliente;

    @FXML
    private TableColumn<Venta, Integer> columnaCodigo;

    @FXML
    private TableColumn<Venta, Date> columnaFecha;


    @FXML
    private TableColumn<Venta, Integer> columnaProducto;


    @FXML
    private TableColumn<Venta,Float> columnaTotal;

    @FXML
    private TableView<Venta> tablaVenta;

    @FXML
    private TextField textFieldCantidad;


    @FXML
    private TextField textFieldIDCliente;

    @FXML
    private TextField textFieldIDProducto;

    @FXML
    private TextField textFieldIVA;

    @FXML
    private Label x;

    private ArrayList<String> errores;

    private ArrayList<String> advertencias;


    @FXML
    public void initialize(){

        observableVenta.addAll(INSTANCE.getAlmacen().getVenta());
        tablaVenta.setItems(observableVenta.sorted());

        llenarTabla(INSTANCE.getAlmacen().getVenta());

        columnaCodigo.setCellValueFactory(new PropertyValueFactory<Venta, Integer>("codigo"));
        columnaFecha.setCellValueFactory(new PropertyValueFactory<Venta,Date>("fecha"));
        columnaProducto.setCellValueFactory(new PropertyValueFactory<>("productoUso"));
        columnaTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        columnaCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidadPro"));
        columnaCliente.setCellValueFactory(new PropertyValueFactory<Venta, String>("nombreCliente"));

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

        if (textFieldIVA.getText().isEmpty())
            errores.add("El campo IVA es obligatorio");

        if (textFieldCantidad.getText().isEmpty())
            errores.add("El campo Cantidad es obligatorio");

        if (textFieldIDProducto.getText().isEmpty())
            errores.add("El campo ID Producto es obligatorio");

    }

    public void verificacion(){
        advertencias.clear();


        if (!textFieldIDCliente.getText().isEmpty())
            try {
                Integer.parseInt(textFieldIDCliente.getText());
            }catch (NumberFormatException e){
                advertencias.add("El campo ID Cliente debe ser numerico");
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

    public void crearEvento(ActionEvent actionEvent) throws Exception {

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

        int codigo = 1;
        int idCliente = Integer.parseInt(textFieldIDCliente.getText());
        int idProducto = Integer.parseInt(textFieldIDProducto.getText());
        Date fecha = new Date();
        int cantidad = Integer.parseInt(textFieldCantidad.getText());
        float iva = Float.parseFloat(textFieldIVA.getText());


        int valor = INSTANCE.getAlmacen().buscarProducto(idProducto).getValorUnitario();

        String nombreCliente = INSTANCE.getAlmacen().buscarCliente(idCliente).getNombre();

        String nombreProducto= INSTANCE.getAlmacen().buscarProducto(idProducto).getNombreProducto();


        float subtotal = cantidad*valor;
        ArrayList<DetalleVenta> detalleVentas = new ArrayList<>();

        float total=calcularTotal(detalleVentas);
        Venta venta = new Venta(codigo,fecha,total,iva,subtotal,idProducto,nombreCliente,nombreProducto);

        observableVenta.add(venta);
        tablaVenta.setItems(observableVenta);

        INSTANCE.getAlmacen().agregarVenta(venta);
        tablaVenta.refresh();
        mensajeRegistro("Registro Completo del Producto");


        llenarCampos();


    }


    public float calcularTotal (ArrayList<DetalleVenta> detalleVentas){
        int iva = Integer.parseInt(textFieldIVA.getText());
        float total=0;
        for(int i=0;i<detalleVentas.size();i++){
            total+=detalleVentas.get(i).getSubTotal();
        }
        return total+iva;
    }

    public void mensajeError(String descripcion, String cadena) {
        Alert mensaje = new Alert(Alert.AlertType.WARNING);
        mensaje.setTitle("Error");
        mensaje.setHeaderText(descripcion);
        mensaje.setContentText(String.valueOf(cadena));
        mensaje.show();
    }


    public void mensajeRegistro(String descripcion){

        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);
        mensaje.setTitle("Mensaje");
        mensaje.setHeaderText(descripcion);
        mensaje.setContentText("Registro de venta completo");
        mensaje.show();

    }

    public void llenarCampos (){
        textFieldIDCliente.setText("");
        textFieldIDProducto.setText("");
        textFieldCantidad.setText("");
        textFieldIVA.setText("");

    }



}

