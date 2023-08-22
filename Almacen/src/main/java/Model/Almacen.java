package Model;


import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Almacen   {

    ArrayList<ClienteNatural> clienteNatural;

    ArrayList<ClienteJuridico> clienteJuridicos;

    List<Producto>producto;
    List<Venta>venta;

    public Almacen(){

    }

    public ArrayList<ClienteNatural> getClienteNatural() {
        return clienteNatural;
    }
    public ArrayList<ClienteJuridico> getClienteJuridicos(){
        return  clienteJuridicos;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public List<Venta> getVenta() {
        return venta;
    }

    //CREAR METODO PARA BUSCAR VARIABLES

    /*
    public Cliente buscarClienteNatural(int identificacion){
        return clienteNatural.stream().filter(cliente -> cliente.getIdentificacion()==identificacion).findFirst().get();
    }
*/
    public Producto buscarProducto(int codigo){
        return producto.stream().filter(producto -> producto.getId()== codigo).findFirst().get();

    }

    public Venta buscarVenta (int codigo){
        return venta.stream().filter(venta -> venta.getCodigo()== codigo).findFirst().get();

    }

    //CREAR METODOS PARA ELIMINAR VARIABLES

    public void eliminarCliente (ClienteNatural persona){clienteNatural.remove(persona);}

    public void eliminarProducto (Producto bloque){producto.remove(bloque);}

    public void eliminarVenta (Venta persona){ venta.remove(persona);}


    //CREAR METODOS PARA AGREGAR VARIABLES

    public void agregarPersonaNatural (ClienteNatural persona){
        clienteNatural.add(persona);
        System.out.println("registro natural");
    }

    public void agregarPersonaJuridica (ClienteJuridico persona){clienteJuridicos.add(persona);
        System.out.println("registro juridico");
    }


    public void agregarProducto (Producto persona){producto.add(persona);}

    public void agregarVenta (Venta persona){ venta.add(persona);}


}
