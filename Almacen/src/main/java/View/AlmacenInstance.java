package View;

import Model.*;
public  enum AlmacenInstance {
    INSTANCE;
    private final Almacen almacen;


    AlmacenInstance() {
        almacen = new Almacen();

        almacen.agregarProducto(new ProductoEnvasado(12,20,3000,"Papas",
              null,null,30,TipoPaisOrigen.Chile ));

        almacen.agregarCliente(new ClienteNatural("nicolas","cabrera",1234,305,"calle 5",null,
                "ni"));
    }

    public Almacen getAlmacen(){
        return almacen;
    }
}
