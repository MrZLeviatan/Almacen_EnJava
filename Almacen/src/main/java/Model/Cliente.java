package Model;

public class Cliente {

    //SE CREAN LAS VARIABLES DE LA CLASE CLIENTE
        private String nombre,apellido,direccion;
        private int identificacion,telefono;


    //SE CREA EL CONSTRUCTOR DE CLIENTES

        public Cliente(String nombre, String apellido, String direccion, int identificacion, int telefono) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.direccion = direccion;
            this.identificacion = identificacion;
            this.telefono = telefono;
        }

    //SE CREA LOS GET DE CLIENTES

        public String getNombre() {
            return nombre;
        }
        public String getApellido() {
            return apellido;
        }
        public String getDireccion() {
            return direccion;
        }
        public int getIdentificacion() {
            return identificacion;
        }
        public int getTelefono() {
            return telefono;
        }

    //SE CREA LOS SET DE CLIENTES

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public void setApellido(String apellido) {
            this.apellido = apellido;
        }
        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }
        public void setIdentificacion(int identificacion) {
            this.identificacion = identificacion;
        }
        public void setTelefono(int telefono) {
            this.telefono = telefono;
        }
}
