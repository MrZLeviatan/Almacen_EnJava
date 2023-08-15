package Model;

public class Venta {

    //SE CREAN LAS VARIABLES DE VENTA, SE LLAMA A DETTALES DE VENTA

        private int codigo, fecha;
        private float total, iva;
        private DetalleVenta detalleVenta;

    //SE GENERA EL CONSTRUCTOR DE VENTA

        public Venta(int codigo, int fecha, float total, float iva, DetalleVenta detalleVenta) {
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
        public int getFecha() {
                return fecha;
        }
        public float getTotal() {
                return total;
        }
        public float getIva() {
                return iva;
        }
        public DetalleVenta getDetalleVenta() {
                return detalleVenta;
        }

    //SE GENERA EL SET DE VENTA

        public void setCodigo(int codigo) {
                this.codigo = codigo;
        }
        public void setFecha(int fecha) {
                this.fecha = fecha;
        }
        public void setTotal(float total) {
                this.total = total;
        }
        public void setIva(float iva) {
                this.iva = iva;
        }
        public void setDetalleVenta(DetalleVenta detalleVenta) {
                this.detalleVenta = detalleVenta;
        }
}
