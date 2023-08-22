package Model;

import java.util.ArrayList;

public class DetalleVenta {

    //SE CREAN LAS VARIABLES DE DETALLE DE VENTA; SE LLAMA PRODUCTO
        private int cantidadPro;
        private float subTotal;
        private int IdProduco;


    //SE CREAN LOS CONSTRUCTORES DE DETALLE DE VENTA

        public DetalleVenta(int cantidadPro, float subTotal, int idProduco) {
            this.cantidadPro = cantidadPro;
            this.subTotal = subTotal;
            this.IdProduco = idProduco;
        }

    //SE CREAN LOS GET Y SET DE DETALLE DE VENTA

        public int getCantidadPro() {
            return cantidadPro;
        }
        public float getSubTotal() {
            return subTotal;
        }
        public int getIdProduco() {return IdProduco;}

        public void setCantidadPro(int cantidadPro) {
            this.cantidadPro = cantidadPro;
        }
        public void setSubTotal(float subTotal) {
            this.subTotal = subTotal;
        }

         public void setIdProduco(int idProduco) {IdProduco = idProduco;
    }
}
