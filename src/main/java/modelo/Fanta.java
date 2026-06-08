package modelo;
import java.awt.Color;
import java.awt.Graphics;

public class Fanta extends Bebida{
    /**
     * Representa bebida FANTA.
     */
    public Fanta(){
        super(TipoProducto.FANTA);
    }

    /**
     * Dibuja la Fanta en la interfaz gráfica.
     * Delega la lógica de dibujo a la clase padre pasándole el color naranja.
     * @param g El contexto gráfico utilizado para dibujar.
     * @param x La coordenada X donde se posicionará el producto.
     * @param y La coordenada Y donde se posicionará el producto.
     */
    public void paintComponent(Graphics g, int x, int y) {
        super.paintComponent(g, x, y, Color.ORANGE);
    }
}
