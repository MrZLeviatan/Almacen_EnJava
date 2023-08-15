package Model;

public  enum AlmacenInstance {
    ;

    private Almacen almacen;


    AlmacenInstance(Almacen almacen) {
        this.almacen = almacen;
    }

    public Almacen getAlmacen() {
        return almacen;
    }
}
