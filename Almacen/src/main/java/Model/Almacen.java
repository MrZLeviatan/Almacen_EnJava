package Model;


import View.AlmacenInstance;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Almacen   {

    private ArrayList<Cliente> listacliente;
    private ArrayList<Producto>listaproducto;
    private ArrayList<Venta>listaVenta;


    public Almacen(){


        listaproducto= new ArrayList<>();
        listaVenta= new ArrayList<>();
        listacliente = new ArrayList<>();



    }

    public ArrayList<Cliente> getCliente() {
        return listacliente;
    }

    public ArrayList<Producto> getProducto() {
        return listaproducto;
    }

    public ArrayList<Venta> getVenta() {
        return listaVenta;
    }

    //CREAR METODO PARA BUSCAR VARIABLES


    public Cliente buscarCliente(int identificacion) throws Exception {
        try {
            return listacliente.stream().filter(cliente -> cliente.getIdentifiacion()==identificacion).findFirst().get();
        }catch (Exception e){
            Alert mensaje = new Alert(Alert.AlertType.WARNING);
            mensaje.setTitle("Error");
            mensaje.setHeaderText("Cliente no encontrado");
            mensaje.show();
            throw new Exception(e);
        }
    }


    public Producto buscarProducto(int codigo) throws Exception {
        try {
            return listaproducto.stream().filter(producto -> producto.getId() == codigo).findFirst().get();

        } catch (Exception e) {
            Alert mensaje = new Alert(Alert.AlertType.WARNING);
            mensaje.setTitle("Error");
            mensaje.setHeaderText("Producto no encontrado");
            mensaje.show();
            throw new Exception(e);
        }
    }


    public Venta buscarVenta (int codigo){
        return listaVenta.stream().filter(venta -> venta.getCodigo()== codigo).findFirst().get();

    }

    //CREAR METODOS PARA ELIMINAR VARIABLES

    public void eliminarCliente (Cliente persona) {

        listaVenta.remove(persona.getIdentifiacion());

    }


    public void eliminarProducto (Producto bloque){listaproducto.remove(bloque);}

    public void eliminarVenta (Venta persona){ listaVenta.remove(persona);}


    //CREAR METODOS PARA AGREGAR VARIABLES
    public void agregarCliente (Cliente cliente){listacliente.add(cliente);}

    public void agregarProducto (Producto persona){listaproducto.add(persona);}

    public void agregarVenta (Venta persona){ listaVenta.add(persona);}


}
