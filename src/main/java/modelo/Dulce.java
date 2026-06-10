package modelo;

/**
 * Clase abstracta que representa a todos los dulces o snacks disponibles en la máquina.
 * Hereda de Producto y sirve como clasificación general para Super8 y Snickers.
 */
public abstract class Dulce extends Producto {

    /**
     * Constructor base para los dulces.
     * @param tipo El tipo específico de dulce (enum TipoProducto) para definir su precio.
     */
    public Dulce(TipoProducto tipo){
        super(tipo);
    }
}
