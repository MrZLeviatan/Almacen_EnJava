package Model;

//EXTENS YA QUE CLIENTE JURIDICO HEREDA DE CLIENTE


public class ClienteJuridico extends Cliente {


        private int nit;


    public ClienteJuridico(String nombre, String apellido, int identifiacion, int telefono, String direccion, int nit) {
        super(nombre, apellido, identifiacion, telefono, direccion);
        this.nit = nit;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }
}


