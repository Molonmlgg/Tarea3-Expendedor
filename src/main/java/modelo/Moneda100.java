package modelo;
import java.awt.Color;
import java.awt.Graphics;

/** Representa una moneda de 100 pesos. */
public class Moneda100 extends Moneda {
    @Override
    public int getValor() {
        return 100;
    }

    /**
     * Dibuja la moneda de 100 en la interfaz gráfica.
     * Delega la lógica de dibujo a la clase padre pasándole su color específico.
     * @param g El contexto gráfico utilizado para dibujar.
     * @param x La coordenada X donde se posicionará la moneda.
     * @param y La coordenada Y donde se posicionará la moneda.
     */
    public void paintComponent(Graphics g, int x, int y) {
        super.paintComponent(g, x, y, Color.GREEN);
    }
}