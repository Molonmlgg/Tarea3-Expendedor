package modelo;

/**
 * Clase abstracta que define el comportamiento base de las monedas.
 */
public abstract class Moneda implements Comparable<Moneda> {
    private static int contador = 1;
    private int serie;
    /**
     * Constructor de la moneda (serie)
     *
     */
    public Moneda() {
        this.serie=contador++;
    }


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
    /**
     * Retorna la serie de la moneda
     *
     * @return serie de moneda*/
    public int getSerie() {
        return this.serie;
    }

}