package visual;

import modelo.Deposito;
import modelo.Producto;
import java.awt.Graphics;

/**
 * Clase que actúa como la Vista de un depósito específico.
 * Se encarga de dibujar gráficamente los productos reales que están almacenados
 * en el modelo de la máquina expendedora.
 */
public class PanelDeposito {
    private Deposito<Producto> deposito;
    private int xInicial;
    private int yInicial;

    /**
     * Constructor del panel visual del depósito.
     * * @param deposito El depósito lógico (modelo) que contiene los productos.
     * @param xInicial La coordenada X de la pantalla donde comenzará a dibujarse la fila.
     * @param yInicial La coordenada Y de la pantalla donde comenzará a dibujarse la fila.
     */
    public PanelDeposito(Deposito<Producto> deposito, int xInicial, int yInicial) {
        this.deposito = deposito;
        this.xInicial = xInicial;
        this.yInicial = yInicial;
    }

    /**
     * Iterador visual que recorre los productos existentes en el depósito
     * y delega en ellos su propio dibujado, calculando un desplazamiento horizontal.
     * * @param g El contexto gráfico utilizado para dibujar.
     */
    protected void paintComponent(Graphics g) {
        int totalProductos = deposito.size();
        for (int i = totalProductos - 1; i >= 0; i--) {
            Producto p = deposito.get(i);
            int posicionVisual = (totalProductos - 1) - i;
            int xVisual = this.xInicial + (posicionVisual * 20);
            p.paintComponent(g, xVisual , this.yInicial);
        }
    }
        }

