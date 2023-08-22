package View;

import Model.*;
public  enum AlmacenInstance {
    INSTANCE;
    private final Almacen almacen;


    AlmacenInstance() {
        almacen = new Almacen();


    }

    public Almacen getAlmacen(){
        return almacen;
    }
}
