package Model;

//EXTENDS YA QUE PRODUCTO ENVASADO HEREDA DE PRODUCTO
public class ProductoEnvasado extends Producto{

    //SE CREAN LAS VARIABLES DE PRODUCTO ENVASADO; EL TIPOPAISORIGEN SE TRAE DEL ENUM DEL MISMO NOMBRE
       private int fechaEnvasado;
       private float peso;
       private TipoPaisOrigen tipoPaisOrigen;

    //SE CREA EL CONSTRUCTOR DE PRODUCTO ENVASADO; SE TRAE DE IGUALMANERA EL CONSTRUCTOR HEREDADO DE PRODUCTO

        public ProductoEnvasado(int id, int cantidad, int valorUnitario, String nombre, String descripcion, int fechaEnvasado, float peso, TipoPaisOrigen tipoPaisOrigen) {
            super(id, cantidad, valorUnitario, nombre, descripcion);
            this.fechaEnvasado = fechaEnvasado;
            this.peso = peso;
            this.tipoPaisOrigen = tipoPaisOrigen;
        }

    //SE CREA EL GET Y SET DEL PRODUCTO ENVASADO

        public int getFechaEnvasado() {
            return fechaEnvasado;
        }
        public float getPeso() {
            return peso;
        }
        public TipoPaisOrigen getTipoPaisOrigen() {
            return tipoPaisOrigen;
        }

        //-----------
        public void setFechaEnvasado(int fechaEnvasado) {
            this.fechaEnvasado = fechaEnvasado;
        }
        public void setPeso(float peso) {
            this.peso = peso;
        }
        public void setTipoPaisOrigen(TipoPaisOrigen tipoPaisOrigen) {
            this.tipoPaisOrigen = tipoPaisOrigen;
        }
}
