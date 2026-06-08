package modelo;
import java.awt.Color;
import java.awt.Graphics;

public class Super8 extends Dulce{
    public Super8(){
        super(TipoProducto.SUPER8);
    }

    /**
     * Dibuja el Super8 en la interfaz gráfica.
     * Delega la lógica de dibujo a la clase padre pasándole el color amarillo.
     * @param g El contexto gráfico utilizado para dibujar.
     * @param x La coordenada X donde se posicionará el producto.
     * @param y La coordenada Y donde se posicionará el producto.
     */
    public void paintComponent(Graphics g, int x, int y) {
        super.paintComponent(g, x, y, Color.YELLOW);
    }
}
