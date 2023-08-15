package Model;

//EXTENS YA QUE CLIENTE NATURAL HEREDA DE CLIENTE
public class ClienteNatural extends Cliente{


    //SE CREAN LAS VARIABLES PARA CLIENTE NATURAL

        private int fechaNacimiento;
        private String email;

    //SE GENERA EL CONSTRUCTOR DE CLIENTE NATURAL; SE HEREDA EL CONSTRUCTOS DE CLIENTE

        public ClienteNatural(String nombre, String apellido, String direccion, int identificacion, int telefono, int fechaNacimiento, String email) {
            super(nombre, apellido, direccion, identificacion, telefono);
            this.fechaNacimiento = fechaNacimiento;
            this.email = email;
        }

    //SE CREAN LOS GET Y SET DEL CLIENTE NATURAL

        public int getFechaNacimiento() {
            return fechaNacimiento;
        }
        public String getEmail() {
            return email;
        }

        public void setFechaNacimiento(int fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }
        public void setEmail(String email) {
            this.email = email;
        }
}
