package modelo;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Clase abstracta que representa un producto del expendedor
 * En este caso, podria ser una bebida o un dulce.
 */
public abstract class Producto {
    private static int contador = 1;
    private int serie;

    private TipoProducto tipo;

    /**
     * Constructor del producto
     *
     * @param tipo tipo de producto para poder definir su precio.
     */
    public Producto(TipoProducto tipo) {
        this.tipo = tipo;
        this.serie = contador++;
    }


    /**
     * Retorna el precio del producto
     *
     * @return precio en entero
     */
    public int getPrecio() {
        return tipo.getPrecio();
    }

    /**
     * Retorna el tipo de producto
     *
     * @return tipo de producto
     */
    public TipoProducto getTipo() {
        return tipo;
    }
    /**
     * Retorna la serie del producto
     *
     * @return serie del producto
     */
    public int getSerie() {
        return this.serie;
    }

    /**
     * Dibuja la representación gráfica del producto en la interfaz.
     * Al ser un metodo abstracto, delega la responsabilidad a cada subclase
     * (como CocaCola o Super8) para que implemente su propia lógica visual.
     * * @param g El contexto gráfico de Swing utilizado para dibujar.
     * @param x La coordenada X de la pantalla donde se dibujará el producto.
     * @param y La coordenada Y de la pantalla donde se dibujará el producto.
     */
    public abstract void paintComponent(Graphics g, int x, int y);

    /**
     * Dibuja la representación gráfica del producto.
     * @param g     El contexto gráfico (Graphics) utilizado para dibujar en el panel.
     * @param x     La coordenada X donde se posicionará el producto.
     * @param y     La coordenada Y donde se posicionará el producto.
     * @param color El color representativo asignado al tipo de producto.
     */
    public void paintComponent(Graphics g, int x, int y, Color color) {
        // Dibuja el cuerpo del producto (rectángulo)
        g.setColor(color);
        g.fillRect(x, y, 40, 60);

        // Dibuja el borde exterior
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 40, 60);

        // Dibuja el número de serie al centro
        g.drawString("S:" + this.getSerie(), x + 5, y + 35);
    }
}
