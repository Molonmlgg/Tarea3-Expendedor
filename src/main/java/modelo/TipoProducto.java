package modelo;

/**
 * Enum que representa los tipos de productos disponibles con su precio.
 */
public enum TipoProducto {

    COCACOLA(500),
    SPRITE(500),
    FANTA(500),
    SUPER8(300),
    SNICKERS(300);

    private int precio;

    /**
     * Constructor del enum
     * @param precio precio del producto.
     */
    TipoProducto(int precio){
        this.precio = precio;
    }
    /**
     * Retorna el precio del producto
     * @return precio en entero
     */
    public int getPrecio(){
        return precio;
    }
}
