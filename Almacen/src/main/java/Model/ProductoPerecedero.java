package Model;

//EXTENDS YA QUE PRODUCTO PERECEDERO HEREDA DE PRODUCTO
public class ProductoPerecedero extends Producto {

    //SE CREAN LAS VARIABLES PARA PRODUCTOS PERECEDERO

        private  int fechaVencimiento;

    //SE CREA EL CONSTRUCTOR PARA PRODUCTOS PERECEDERO; SE TRAE EL CONSTRUCTOR HEREDADO DE PRODUCTO

        public ProductoPerecedero(int id, int cantidad, int valorUnitario, String nombre, String descripcion, int fechaVencimiento) {
            super(id, cantidad, valorUnitario, nombre, descripcion);
            this.fechaVencimiento = fechaVencimiento;
        }

    //SE CREA EL GET Y EL SET DE PRODUCTO PERECEDERO
        public int getFechaVencimiento() {
            return fechaVencimiento;
        }
        public void setFechaVencimiento(int fechaVencimiento) {
            this.fechaVencimiento = fechaVencimiento;
        }
}
