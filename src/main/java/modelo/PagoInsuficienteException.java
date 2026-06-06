package modelo;

/** Excepción lanzada cuando el monto de la moneda es menor al precio del producto. */
public class PagoInsuficienteException extends Exception {
    public PagoInsuficienteException() {
        super("Error: El dinero entregado no es suficiente.");
    }
}