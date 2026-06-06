package modelo;

/** Excepción lanzada cuando no quedan unidades en el depósito seleccionado. */
public class NoHayProductoException extends Exception {
    public NoHayProductoException() {
        super("Error: No quedan unidades de este producto.");
    }
}