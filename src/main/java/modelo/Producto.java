package modelo;

/**
 * Clase abstracta que representa un producto del expendedor
 * En este caso, podria ser una bebida o un dulce.
 */
public abstract class Producto {

    private TipoProducto tipo;

    /**
     * Constructor del producto
     * @param tipo tipo de producto para poder definir su precio.
     */
    public Producto(TipoProducto tipo){
        this.tipo = tipo;
    }

    /**
     * Retorna el precio del producto
     * @return precio en entero
     */
    public int getPrecio(){
        return tipo.getPrecio();
    }

    /**
     * Retorna el tipo de producto
     * @return tipo de producto
     */
    public TipoProducto getTipo() {
        return tipo;
    }
}
