package modelo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
  * Representa la bebida Cocacola
  */
 public class CocaCola extends Bebida{
     public CocaCola(){
         super(TipoProducto.COCACOLA);
     }

    /**
     * Dibuja la CocaCola en la interfaz gráfica.
     * Delega la lógica de dibujo a la clase padre pasándole el color rojo.
     * @param g El contexto gráfico utilizado para dibujar.
     * @param x La coordenada X donde se posicionará el producto.
     * @param y La coordenada Y donde se posicionará el producto.
     */
    public void paintComponent(Graphics g, int x, int y) {
        super.paintComponent(g, x, y, Color.RED);

    // Guardamos la fuente original para no desconfigurar el resto de dibujos
    Font originalFont = g.getFont();

    // 2. Definimos una letra negrita y un poco más grande
    Font cokeFont = new Font("Arial", Font.BOLD, 10);
        g.setFont(cokeFont);

    // 3. Elegimos color BLANCO para que resalte sobre el rojo
        g.setColor(Color.WHITE);

    // 4. Dibujamos el texto "COKE" centrado arriba
    // drawString(texto, x + desplazamiento, y + desplazamiento)
        g.drawString("COKE", x + 5, y + 20);

    // Restauramos la fuente original
        g.setFont(originalFont);
    }
 }

