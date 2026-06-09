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
     * Recorre el depósito para actualizar las coordenadas internas de cada
     * producto mediante el metodo setXY requerido en la pauta.
     */
    public void actualizarPosiciones() {
        int totalProductos = deposito.size();
        for (int i = totalProductos - 1; i >= 0; i--) {
            Producto p = deposito.get(i);
            if (p != null) {
                int posicionVisual = (totalProductos - 1) - i;
                int xVisual = this.xInicial + (posicionVisual * 20);
                p.setXY(xVisual, this.yInicial);
            }
        }
    }

    /**
     * Dibuja los productos utilizando las coordenadas almacenadas en ellos.
     * @param g El contexto gráfico utilizado para dibujar.
     */
    protected void paintComponent(Graphics g) {
        // Primero forzamos el reposicionamiento mediante setXY
        actualizarPosiciones();

        // Ahora pintamos usando los getters del propio producto
        for (int i = 0; i < deposito.size(); i++) {
            Producto p = deposito.get(i);
            if (p != null) {
                p.paintComponent(g, p.getX(), p.getY());
            }
        }
    }
}
