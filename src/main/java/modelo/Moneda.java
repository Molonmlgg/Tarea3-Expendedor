package modelo;

/**
 * Clase abstracta que define el comportamiento base de las monedas.
 */
public abstract class Moneda implements Comparable<Moneda> {
    public Moneda() {}

    /** @return El valor entero de la moneda. */
    public abstract int getValor();

    @Override
    public int compareTo(Moneda m) {
        return Integer.compare(this.getValor(), m.getValor());
    }

    @Override
    public String toString() {
        return "modelo.Moneda de: " + this.getValor() + " (Serie: " + this.hashCode() + ")";
    }
}