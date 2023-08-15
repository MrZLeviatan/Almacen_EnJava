package Model;

////EXTENDS YA QUE PRODUCTO REFIGERADO HEREDA DE PRODUCTO
public class ProductoRefigerado extends Producto {

    //SE CREAN LAS VARIABLES DE PRODUCTO REFIGERADO
         private int temperaturaOpt, codigoAprobacion;


    //SE CREA EL CONSTRUCTOR DE PRODUCTO REFIGERADO, SE HEREDA EL CONSTRUCTOR DE PRODUCTO
        public ProductoRefigerado(int id, int cantidad, int valorUnitario, String nombre, String descripcion, int temperaturaOpt, int codigoAprobacion) {
            super(id, cantidad, valorUnitario, nombre, descripcion);
            this.temperaturaOpt = temperaturaOpt;
            this.codigoAprobacion = codigoAprobacion;
        }

    //SE CREA EL GET Y EL SET DE PRODUCTO REFIGERADO

        public int getTemperaturaOpt() {
            return temperaturaOpt;
        }
        public int getCodigoAprobacion() {
            return codigoAprobacion;
        }

        public void setTemperaturaOpt(int temperaturaOpt) {
            this.temperaturaOpt = temperaturaOpt;
        }

        public void setCodigoAprobacion(int codigoAprobacion) {
            this.codigoAprobacion = codigoAprobacion;
        }
}
