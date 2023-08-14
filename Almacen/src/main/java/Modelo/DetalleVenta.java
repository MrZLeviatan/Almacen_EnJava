package Modelo;

public class DetalleVenta {

    //SE CREAN LAS VARIABLES DE DETALLE DE VENTA; SE LLAMA PRODUCTO
        private int cantidadPro;
        private float subTotal;
        private Producto producto;

    //SE CREAN LOS CONSTRUCTORES DE DETALLE DE VENTA

        public DetalleVenta(int cantidadPro, float subTotal, Producto producto) {
            this.cantidadPro = cantidadPro;
            this.subTotal = subTotal;
            this.producto = producto;
        }

    //SE CREAN LOS GET Y SET DE DETALLE DE VENTA

        public int getCantidadPro() {
            return cantidadPro;
        }
        public float getSubTotal() {
            return subTotal;
        }
        public Producto getProducto() {
            return producto;
        }

        public void setCantidadPro(int cantidadPro) {
            this.cantidadPro = cantidadPro;
        }
        public void setSubTotal(float subTotal) {
            this.subTotal = subTotal;
        }
        public void setProducto(Producto producto) {
            this.producto = producto;
        }
}
