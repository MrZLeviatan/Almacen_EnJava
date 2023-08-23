package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;

//EXTENS YA QUE CLIENTE NATURAL HEREDA DE CLIENTE
public class ClienteNatural extends Cliente {


    //SE CREAN LAS VARIABLES PARA CLIENTE NATURAL

    private LocalDate fechaNacimiento;
    private String email;

    public ClienteNatural(String nombre, String apellido, int identifiacion, int telefono, String direccion, LocalDate fechaNacimiento, String email) {
        super(nombre, apellido, identifiacion, telefono, direccion);
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

