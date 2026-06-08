package modelo;
import java.awt.Color;
import java.awt.Graphics;

public class Snickers extends Dulce{
    public Snickers(){
        super(TipoProducto.SNICKERS);
    }

    /**
     * Dibuja el Snickers en la interfaz gráfica.
     * Delega la lógica de dibujo a la clase padre pasándole un color café personalizado.
     * @param g El contexto gráfico utilizado para dibujar.
     * @param x La coordenada X donde se posicionará el producto.
     * @param y La coordenada Y donde se posicionará el producto.
     */
    public void paintComponent(Graphics g, int x, int y) {
        super.paintComponent(g, x, y, new Color(139, 69, 19)); // Color Café
    }
}
