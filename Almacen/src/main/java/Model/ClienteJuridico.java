package Model;

//EXTENS YA QUE CLIENTE JURIDICO HEREDA DE CLIENTE

public class ClienteJuridico extends Cliente{

    //SE CREA LA VARIABLE DE CLIENTE JURIDICO

        private int nit;

    //SE GENERA EL CONSTRUCTOR DE CLIENTE JURIDICO; SE HEREDA EL CONSTRUCTOR DE CLIENTE

        public ClienteJuridico(String nombre, String apellido, String direccion, int identificacion, int telefono, int nit) {
            super(nombre, apellido, direccion, identificacion, telefono);
            this.nit = nit;
        }

     //SE GENERA EL GET Y EL SET DE CLIENTE JURIDICO

        public int getNit() {
            return nit;
        }

        public void setNit(int nit) {
            this.nit = nit;
        }
}
