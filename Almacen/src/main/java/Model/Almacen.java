package Model;

import java.util.ArrayList;

public class Almacen {

    private ArrayList<Cliente>listaClientes;
    private ArrayList<Producto>listaProducto;
    private ArrayList<Venta>listaVenta;

    public Almacen(ArrayList<Cliente> listaClientes, ArrayList<Producto> listaProducto, ArrayList<Venta> listaVenta) {
        this.listaClientes = listaClientes;
        this.listaProducto = listaProducto;
        this.listaVenta = listaVenta;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Producto> getListaProducto() {
        return listaProducto;
    }

    public ArrayList<Venta> getListaVenta() {
        return listaVenta;
    }
}
