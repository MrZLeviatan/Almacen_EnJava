package View;

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
import java.time.LocalDate;
import java.util.ResourceBundle;

import static javafx.stage.StageStyle.UNDECORATED;

public class ClienteController  {

    @FXML
    private Button botonActualizar;

    @FXML
    private Button botonCrear;

    @FXML
    private Button botonEliminar;

    @FXML
    private Button botonRegreso;

    @FXML
    private TableColumn<?, ?> columaNacimiento;

    @FXML
    private TableColumn<?, ?> columnaApellido;

    @FXML
    private TableColumn<?, ?> columnaDireccion;

    @FXML
    private TableColumn<?, ?> columnaEmail;

    @FXML
    private TableColumn<?, ?> columnaID;

    @FXML
    private TableColumn<?, ?> columnaNIT;

    @FXML
    private TableColumn<?, ?> columnaNombre;

    @FXML
    private TableColumn<?, ?> columnaTelefono;

    @FXML
    private MenuButton comboTipoPersona;

    @FXML
    private DatePicker datePickerNacimiento;

    @FXML
    private TableView<?> tablaCliente;

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
    private MenuItem menuBotonJuridico;

    @FXML
    private MenuItem menuBotonNatural;



    public void labCerrar(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
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

    public void ocultarTextoNatural (ActionEvent actionEvent){

        textFieldEmail.setDisable(false);
        datePickerNacimiento.setDisable(false);
        textFieldNit.setDisable(true);

        textFieldNit.setText("");
    }


}


