package modelo;

/**
 * Clase abstracta que representa a todas las bebidas disponibles en la máquina.
 * Hereda de Producto y sirve como clasificación general para CocaCola, Sprite y Fanta.
 */
public abstract class Bebida extends Producto{

    /**
     * Constructor base para las bebidas.
     * @param tipo El tipo específico de bebida (enum TipoProducto) para definir su precio.
     */
    public Bebida(TipoProducto tipo){
            super(tipo);
    }
}

