package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Venta {

    //SE CREAN LAS VARIABLES DE VENTA, SE LLAMA A DETTALES DE VENTA

        private int codigo;

        private Date fecha;
        private float total, iva, subTotal;

        private int  cantidadPro;

        private String nombreCliente, productoUso;




//SE GENERA EL CONSTRUCTOR DE VENTA

        public Venta(int codigo, Date fecha, float total, float iva, float subTotal, int cantidadPro, String nombreCliente, String productoUso) {
                this.codigo = codigo;
                this.fecha = fecha;
                this.total = total;
                this.iva = iva;
                this.subTotal = subTotal;
                this.cantidadPro = cantidadPro;
                this.nombreCliente = nombreCliente;
                this.productoUso = productoUso;
        }


    //SE GENERA EL GET DE VENTA

        public int getCodigo() {
                return codigo;
        }
        public Date getFecha() {
                return fecha;
        }
        public float getTotal() {
                return total;
        }
        public float getIva() {
                return iva;
        }
        public float getSubTotal () {
                return subTotal;
        }
        public int getCantidadPro (){ return cantidadPro;}

        public String getNombreCliente() {return nombreCliente;}

        public String getProductoUso() {return productoUso;}
//SE GENERA EL SET DE VENTA

        public void setCodigo(int codigo) {
                this.codigo = codigo;
        }
        public void setFecha(Date fecha) {
                this.fecha = fecha;
        }
        public void setTotal(float total) {
                this.total = total;
        }
        public void setIva(float iva) {
                this.iva = iva;
        }
        public void setSubTotal (float subTotal) {this.subTotal = subTotal;}
        public void setCantidadPro (int cantidadPro) { this.cantidadPro = cantidadPro;}

        public void setNombreCliente(String nombreCliente) {this.nombreCliente = nombreCliente;}

        public void setProductoUso(String productoUso) {this.productoUso = productoUso;}
}
