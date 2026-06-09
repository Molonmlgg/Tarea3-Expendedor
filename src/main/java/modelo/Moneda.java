package modelo;
import java.awt.Color;
import java.awt.Graphics;

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

    /**
     * Compara el valor de esta moneda con otra para ordenarlas.
     * @param m Moneda a comparar.
     * @return resultado de la comparacion.
     */
    @Override
    public int compareTo(Moneda m) {
        return Integer.compare(this.getValor(), m.getValor());
    }

    /**
     * @return Texto con los datos de la moneda.
     */
    @Override
    public String toString() {
        return "Moneda de: " + this.getValor() + " (Serie: " + this.getSerie() + ")";
    }
    /**
     * Retorna la serie de la moneda
     *
     * @return serie de moneda*/
    public int getSerie() {
        return this.serie;
    }

    /**
     * Dibuja la representación gráfica de la moneda.
     * @param g     El contexto gráfico (Graphics) utilizado para dibujar en el panel.
     * @param x     La coordenada X donde se posicionará la moneda.
     * @param y     La coordenada Y donde se posicionará la moneda.
     * @param color El color representativo asignado a la moneda según su valor.
     */
    public void paintComponent(Graphics g, int x, int y, Color color) {
        // Dibuja el fondo de la moneda
        g.setColor(color);
        g.fillOval(x, y, 40, 40);

        // Dibuja el borde exterior
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 40, 40);

        // Dibuja el valor y el número de serie en el centro
        g.drawString("$" + this.getValor(), x + 8, y + 18);
        g.drawString("S:" + this.getSerie(), x + 8, y + 32);
    }

}