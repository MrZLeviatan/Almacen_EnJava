package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {

    //SE CREAN LAS VARIABLES DE VENTA, SE LLAMA A DETTALES DE VENTA

        private int codigo;

        private LocalDate fecha;
        private float total, iva;
        private ArrayList<DetalleVenta> detalleVenta;


    //SE GENERA EL CONSTRUCTOR DE VENTA

        public Venta(int codigo, LocalDate fecha, float total, float iva, ArrayList<DetalleVenta> detalleVenta) {
                this.codigo = codigo;
                this.fecha = fecha;
                this.total = total;
                this.iva = iva;
                this.detalleVenta = detalleVenta;
        }

    //SE GENERA EL GET DE VENTA

        public int getCodigo() {
                return codigo;
        }
        public LocalDate getFecha() {
                return fecha;
        }
        public float getTotal() {
                return total;
        }
        public float getIva() {
                return iva;
        }
        public ArrayList<DetalleVenta> getDetalleVenta() {
                return detalleVenta;
        }

    //SE GENERA EL SET DE VENTA

        public void setCodigo(int codigo) {
                this.codigo = codigo;
        }
        public void setFecha(LocalDate fecha) {
                this.fecha = fecha;
        }
        public void setTotal(float total) {
                this.total = total;
        }
        public void setIva(float iva) {
                this.iva = iva;
        }
        public void setDetalleVenta(ArrayList<DetalleVenta> detalleVenta) {
                this.detalleVenta = detalleVenta;
        }
}
