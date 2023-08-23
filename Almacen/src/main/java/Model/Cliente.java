package Model;


public class Cliente {

    private String nombre;
    private String apellido;

    private int identifiacion;

    private int telefono;

    private  String direccion;

    public Cliente(String nombre, String apellido, int identifiacion, int telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identifiacion = identifiacion;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getIdentifiacion() {
        return identifiacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion(){ return direccion;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setIdentifiacion(int identifiacion) {
        this.identifiacion = identifiacion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion){this.direccion= direccion;}
}
