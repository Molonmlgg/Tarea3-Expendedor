package visual;

import modelo.Expendedora;
import modelo.TipoProducto;
import modelo.Producto;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Panel encargado de representar visualmente la máquina expendedora
 */
public class PanelExpendedor extends JPanel {


    private Expendedora expendedora;

    private String mensajePantalla;

    private TipoProducto productoSeleccionado;
    private Producto productoEnRanura;

    // Instancias de los paneles visuales que dibujarán cada fila
    private PanelDeposito panelDepoCoca;
    private PanelDeposito panelDepoSprite;
    private PanelDeposito panelDepoFanta;
    private PanelDeposito panelDepoSuper8;
    private PanelDeposito panelDepoSnickers;

    /**
     * Constructor del panel expendedor
     *
     * @param expendedora Expendedora asociada al panel
     */
    public PanelExpendedor(Expendedora expendedora) {
        this.expendedora = expendedora;

        this.mensajePantalla = "BIENVENIDO";
        this.productoSeleccionado = null;
        this.productoEnRanura = null;

        this.setBackground(new Color(255, 200, 200));

        // Inicializamos las vistas pasándoles el depósito real y sus coordenadas iniciales
        this.panelDepoCoca = new PanelDeposito(expendedora.getDepositoCoca(), 140, 100);
        this.panelDepoSprite = new PanelDeposito(expendedora.getDepositoSprite(), 140, 170);
        this.panelDepoFanta = new PanelDeposito(expendedora.getDepositoFanta(), 140, 240);
        this.panelDepoSuper8 = new PanelDeposito(expendedora.getDepositoSuper8(), 140, 310);
        this.panelDepoSnickers = new PanelDeposito(expendedora.getDepositoSnickers(), 140, 380);

    }

    /**
     * Dibuja los elementos graficos de la maquina
     *
     * @param g Objeto utilizado para dibujar
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Carcasa
        g.setColor(Color.DARK_GRAY);
        g.fillRect(100, 50, 400, 550);

        // Vidrio
        g.setColor(new Color(173, 216, 230));
        g.fillRect(120, 70, 360, 380);

        // Pantalla
        g.setColor(Color.BLACK);
        g.fillRect(390, 80, 80, 40);

        g.setColor(Color.GREEN);
        g.drawString(mensajePantalla, 395, 105);

        // Botones de selección
        g.setColor(Color.RED);
        g.fillRect(390, 140, 40, 25);

        g.setColor(Color.WHITE);
        g.drawString("COKE", 392, 157);

        g.setColor(Color.CYAN);
        g.fillRect(390, 175, 40, 25);

        g.setColor(Color.BLACK);
        g.drawString("SPR", 395, 192);

        g.setColor(Color.ORANGE);
        g.fillRect(390, 210, 40, 25);

        g.setColor(Color.BLACK);
        g.drawString("FAN", 395, 227);

        g.setColor(Color.YELLOW);
        g.fillRect(390, 245, 40, 25);

        g.setColor(Color.BLACK);
        g.drawString("S8", 400, 262);

        g.setColor(new Color(139, 69, 19));
        g.fillRect(390, 280, 40, 25);

        g.setColor(Color.WHITE);
        g.drawString("SNK", 395, 297);

        g.setColor(Color.BLACK);
        g.fillRect(120, 480, 360, 80);

        if (productoEnRanura != null) {
            Color color = Color.GRAY;
            switch (productoEnRanura.getTipo()) {
                case COCACOLA:
                    color = Color.RED;
                    break;
                case SPRITE:
                    color = Color.CYAN;
                    break;
                case FANTA:
                    color = Color.ORANGE;
                    break;
                case SUPER8:
                    color = Color.YELLOW;
                    break;
                case SNICKERS:
                    color = new Color(139, 69, 19);
                    break;
            }

            // Se dibuja el único producto en la posición central de la ranura
            productoEnRanura.paintComponent(g, 200, 490, color);
        }

        // Se delega correctamente el dibujo del stock a cada panel correspondiente
        panelDepoCoca.paintComponent(g);
        panelDepoSprite.paintComponent(g);
        panelDepoFanta.paintComponent(g);
        panelDepoSuper8.paintComponent(g);
        panelDepoSnickers.paintComponent(g);
    }

    /**
     * Actualiza el mensaje mostrado según el botón seleccionado.
     *
     * @param x Coordenada X del clic.
     * @param y Coordenada Y del clic.
     */
    public void reaccionarClic(int x, int y) {

        if (x >= 390 && x <= 430 && y >= 140 && y <= 165) {
            this.mensajePantalla = "COKE";
            productoSeleccionado = TipoProducto.COCACOLA;
        } else if (x >= 390 && x <= 430 && y >= 175 && y <= 200) {
            this.mensajePantalla = "SPRITE";
            productoSeleccionado = TipoProducto.SPRITE;
        } else if (x >= 390 && x <= 430 && y >= 210 && y <= 235) {
            this.mensajePantalla = "FANTA";
            productoSeleccionado = TipoProducto.FANTA;
        } else if (x >= 390 && x <= 430 && y >= 245 && y <= 270) {
            this.mensajePantalla = "SUPER8";
            productoSeleccionado = TipoProducto.SUPER8;
        } else if (x >= 390 && x <= 430 && y >= 280 && y <= 305) {
            this.mensajePantalla = "SNICKERS";
            productoSeleccionado = TipoProducto.SNICKERS;
        }

        repaint();
    }


    /***
     * Retorna el producto seleccionado actualmente
     * @return producto seleccionado
     */
    public TipoProducto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    /***
     * Limpia la seleccion del producto
     */
    public void limpiarSeleccion() {
        productoSeleccionado = null;
        mensajePantalla = "BIENVENIDO";
        repaint();
    }

    public void dejarProductoEnRanura(Producto producto) {
        this.productoEnRanura = producto;
        repaint();
    }

    public Producto retirarProductoRanura() {
        Producto aux = this.productoEnRanura;
        this.productoEnRanura = null; // Queda vacía inmediatamente
        repaint();
        return aux;
    }

    /**
     * Revisa si la ranura ya contiene un producto esperando ser retirado.
     * Reemplaza la lógica del ArrayList para cumplir la pauta.
     */
    public boolean isRanuraOcupada() {
        return this.productoEnRanura != null;
    }
}