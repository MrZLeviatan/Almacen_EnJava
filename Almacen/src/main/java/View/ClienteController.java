package View;

import Model.Cliente;
import Model.ClienteJuridico;
import Model.ClienteNatural;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static javafx.stage.StageStyle.UNDECORATED;



public class ClienteController {


    private final ObservableList<ClienteNatural>clienteNatural=FXCollections.observableArrayList();

    @FXML
    private TableView <ClienteNatural> tablaClienteNatural;

    @FXML
   private  TableColumn <ClienteNatural,String> columnaNombre;

    @FXML
    private TableColumn <ClienteNatural,String> columnaApellido;

    @FXML
    private TableColumn <ClienteNatural, Integer> columnaIdentificacion;

    @FXML
    private TableColumn <ClienteNatural, Integer> columnaTelefono;

    @FXML
    private  TableColumn <ClienteNatural, String> columnaDireccion;

    @FXML
    private TableColumn<ClienteNatural, LocalDate> columnaFechaNacimiento;

    @FXML
    private  TableColumn<ClienteNatural,String> columnaEmail;

    @FXML
    private Button botonActualizar;

    @FXML
    private Button botonCrear;
    @FXML
    private Button botonEliminar;

    @FXML
    private Button botonRegreso;

    @FXML
    private DatePicker datePickerNacimiento;

    @FXML
    private TextField textFieldApellido;

    @FXML
    private TextField textFieldDireccion;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldId;

    @FXML
    private TextField textFieldNit;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldTelefono;

    @FXML
    private Label x;

    @FXML
    private RadioButton botonPersonaJuridica;

    @FXML
    private RadioButton botonPersonaNatural;

    @FXML
    private ToggleGroup tipoPersona;

    private ArrayList<String> errores;

    private ArrayList<String> advertencias;





    @FXML
    public void initialize() {

        tablaClienteNatural.setItems(clienteNatural);

        columnaNombre.setCellValueFactory(new PropertyValueFactory<ClienteNatural,String >("nombre"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory<ClienteNatural,String>("apellido"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<ClienteNatural,Integer>("telefono"));
        columnaIdentificacion.setCellValueFactory(new PropertyValueFactory<ClienteNatural,Integer>("identificacion"));
        columnaDireccion.setCellValueFactory(new PropertyValueFactory<ClienteNatural,String>("direccion"));
        columnaFechaNacimiento.setCellValueFactory(new PropertyValueFactory<ClienteNatural,LocalDate>("fechaNacimiento"));
        columnaEmail.setCellValueFactory(new PropertyValueFactory<ClienteNatural,String>("email"));


        }

    public ClienteController() {

        errores = new ArrayList<String>();

        advertencias= new ArrayList<String>();
    }



    public void labCerrar(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        irOtraPagina("VentanaEmergente.fxml");

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

    /*CON ESTE EVENTO, AL PRESIONAR EN EL MENU DE PERSONA JURIDICA, ACTIVA LA CASILLA
     EL TEXTFIELD DE NIT, MIENTRAS QUE LOS OTROS TEXFIELD SE BLOQUEAN Y BORRA SU
     CONTENIDO
    */
    public void ocultarTextoJuridico(ActionEvent actionEvent) {

        textFieldEmail.setDisable(true);
        datePickerNacimiento.setDisable(true);
        textFieldNit.setDisable(false);

        textFieldEmail.setText("");
        datePickerNacimiento.getEditor().clear();
    }

    public void ocultarTextoNatural(ActionEvent actionEvent) {

        textFieldEmail.setDisable(false);
        datePickerNacimiento.setDisable(false);
        textFieldNit.setDisable(true);

        textFieldNit.setText("");
    }


    public void validar() {
        errores.clear();
        if (textFieldNombre.getText().isEmpty())
            errores.add("El campo nombre es obligatorio");

        if (textFieldApellido.getText().isEmpty())
            errores.add("El campo apellido es obligatorio");

        if (textFieldId.getText().isEmpty())
            errores.add("El campo Identificacion es obligarotio");

        if (textFieldDireccion.getText().isEmpty())
            errores.add("El campo direccion es obligatorio");

        if (textFieldTelefono.getText().isEmpty())
            errores.add("El campo telefono es obligatorio");

        if (tipoPersona.getSelectedToggle() == null) {
            errores.add("Seleccionar que tipo de persona es");

            } else if (botonPersonaNatural.isSelected()) {

                 if (datePickerNacimiento.getValue() == null)
                  errores.add("Seleccione la fecha de nacimiento");

                 if (textFieldEmail.getText().isEmpty())
                  errores.add("El campo email es obligatorio");

        } else if (textFieldNit.getText().isEmpty())

                errores.add("El campo NIT es obligatorio");
            }


    public void verificacion() {
        advertencias.clear();

        if (!textFieldId.getText().isEmpty())
            try {
                Integer.parseInt(textFieldId.getText());
            } catch (NumberFormatException e) {
                advertencias.add("El campo Identificacion debe ser numerico");
            }
        if (!textFieldTelefono.getText().isEmpty())
            try {
                Integer.parseInt(textFieldTelefono.getText());

            } catch (NumberFormatException e) {
                advertencias.add("El campo Telefono debe ser numerico");
            }
        if (botonPersonaJuridica.isSelected()) {
            if (!textFieldNit.getText().isEmpty())
                try {
                    Integer.parseInt(textFieldNit.getText());

                } catch (NumberFormatException e) {
                    advertencias.add("El campo NIT debe ser numerico");
                }
        }
    }
    public void crearEvento(ActionEvent actionEvent) {

        validar();
        if (errores.size() > 0) {
            String cadenaErrores = "";
            for (int i = 0; i < errores.size(); i++)
                cadenaErrores += errores.get(i) + "\n";

            mensajeError("Falta de informacion", cadenaErrores);
            return;

        }
        verificacion();
        if (advertencias.size() > 0) {
            String cadenaErrores = "";
            for (int i = 0; i < advertencias.size(); i++)
                cadenaErrores += advertencias.get(i) + "\n";

            mensajeError("Se encontraron los siguientes errores",cadenaErrores);
            return;
        }

        if (botonPersonaNatural.isSelected()) {

            String nombre = textFieldNombre.getText();
            String apellido = textFieldApellido.getText();
            int identificacion = Integer.parseInt(textFieldId.getText());
            String direccion= textFieldDireccion.getText();
            int telefono = Integer.parseInt(textFieldTelefono.getText());
            LocalDate fecha = datePickerNacimiento.getValue();
            String email= textFieldEmail.getText();

           // clienteNatural.add(new ClienteNatural(nombre,apellido,direccion,identificacion,
             //       telefono,fecha,email));

            clienteNatural.add(new ClienteNatural(nombre, apellido, identificacion,telefono,direccion,
                    fecha,email));
                tablaClienteNatural.setItems(clienteNatural);


            mensajeBienvenida("Registro Completo Cliente Juridico");



            limpiarCampos();



        }else if(botonPersonaJuridica.isSelected()){


            String nombre = textFieldNombre.getText();
            String apellido = textFieldApellido.getText();
            String direccion = textFieldDireccion.getText();
            int id= Integer.parseInt(textFieldId.getText());
            int telefono = Integer.parseInt(textFieldTelefono.getText());
            int nit= Integer.parseInt(textFieldNit.getText());

          ClienteJuridico persona = new ClienteJuridico(nombre,apellido,id
                    ,telefono,direccion,nit);


            mensajeBienvenida("Registro Completo Cliente Juridico");

            limpiarCampos();

        }

    }

    public void limpiarCampos(){
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        textFieldId.setText("");
        textFieldDireccion.setText("");
        textFieldTelefono.setText("");
        textFieldEmail.setText("");
        datePickerNacimiento.getEditor().clear();
        textFieldNit.setText("");
    }

    public void mensajeBienvenida(String descripcion){

        Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);
        mensaje.setTitle("Mensaje");
        mensaje.setHeaderText(descripcion);
        mensaje.setGraphic(new ImageView(this.getClass().getResource("/Image/Icon.png").toString()));
        mensaje.setContentText("Bienvenido al almacen Happy Meet Famrs");
        mensaje.show();

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



}





