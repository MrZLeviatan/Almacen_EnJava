package Model;

import java.time.LocalDate;

//EXTENDS YA QUE PRODUCTO PERECEDERO HEREDA DE PRODUCTO
public class ProductoPerecedero extends Producto {

    //SE CREAN LAS VARIABLES PARA PRODUCTOS PERECEDERO

        private LocalDate fechaVencimiento;

    //SE CREA EL CONSTRUCTOR PARA PRODUCTOS PERECEDERO; SE TRAE EL CONSTRUCTOR HEREDADO DE PRODUCTO

        public ProductoPerecedero(int id, int cantidad, int valorUnitario, String nombre, String descripcion, LocalDate fechaVencimiento) {
            super(id, cantidad, valorUnitario, nombre, descripcion);
            this.fechaVencimiento = fechaVencimiento;
        }

    //SE CREA EL GET Y EL SET DE PRODUCTO PERECEDERO
        public LocalDate getFechaVencimiento() {
            return fechaVencimiento;
        }
        public void setFechaVencimiento(LocalDate fechaVencimiento) {
            this.fechaVencimiento = fechaVencimiento;
        }
}
