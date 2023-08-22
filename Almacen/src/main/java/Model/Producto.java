package Model;

public  class Producto {

    //SE CREAN LAS VARIBLES PARA LA CLASE PRODUCTO

        private int id, cantidad, valorUnitario;
        private String nombre, descripcion;


    //SE GENERA EL CONSTRUCTOR CON LAS VARIABLES DEL PRODUCTO

        public Producto(int id, int cantidad, int valorUnitario, String nombre, String descripcion) {
            this.id = id;
            this.cantidad = cantidad;
            this.valorUnitario = valorUnitario;
            this.nombre = nombre;
            this.descripcion = descripcion;
        }

    //SE GENERAN LOS GET DE LAS VARIABLES PRODUCTOS

        public int getId() {
            return id;
        }
        public int getCantidad() {
            return cantidad;
        }
        public int getValorUnitario() {
            return valorUnitario;
        }
        public String getNombre() {
            return nombre;
        }
        public String getDescripcion() {
            return descripcion;
        }

    //SE CREAN LOS SET DE LAS VARIABLES DEL PRODUCTO

        public void setId(int id) {
            this.id = id;
        }
        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
        public void setValorUnitario(int valorUnitario) {
            this.valorUnitario = valorUnitario;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
}
