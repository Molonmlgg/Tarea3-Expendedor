package modelo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
  * Representa la bebida Cocacola
  */
 public class CocaCola extends Bebida {
    public CocaCola() {
        super(TipoProducto.COCACOLA);
    }

    /**
     * Dibuja la CocaCola en la interfaz gráfica.
     * Delega la lógica de dibujo a la clase padre pasándole el color rojo.
     *
     * @param g El contexto gráfico utilizado para dibujar.
     * @param x La coordenada X donde se posicionará el producto.
     * @param y La coordenada Y donde se posicionará el producto.
     */
    public void paintComponent(Graphics g, int x, int y) {
        super.paintComponent(g, x, y, Color.RED);


    }
}

