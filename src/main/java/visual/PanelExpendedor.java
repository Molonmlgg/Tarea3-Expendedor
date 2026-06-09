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

    /**
     * Constructor del panel expendedor
     * @param expendedora Expendedora asociada al panel
     */
    public PanelExpendedor(Expendedora expendedora) {
        this.expendedora = expendedora;

        this.mensajePantalla = "BIENVENIDO";
        this.productoSeleccionado = null;
        this.productoEnRanura = null;

        this.setBackground(new Color(255, 200, 200));
    }

    /**
     * Dibuja los elementos graficos de la maquina
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

        // Ranura de retiro
        g.setColor(Color.BLACK);
        g.fillRect(120, 480, 360, 80);
        if (productoEnRanura != null){
            Color color = Color.GRAY;
            switch (productoEnRanura.getTipo()){
                case COCACOLA:
                    color = Color.RED;
                    break;

                case SPRITE:
                    color = Color.GREEN;
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

            productoEnRanura.paintComponent(
                    g,
                    200,
                    490,
                    color
            );
        }

        //de aqui abajo hicimos esto para mejorar el dinamismo de el stock y que se viera en pantalla que se iba vaciando la maquina
        for (int i = 0; i < expendedora.getStockCoca(); i++) {
            new modelo.CocaCola().paintComponent(g, 140 + (i * 12), 100);
        }

        for (int i = 0; i < expendedora.getStockSprite(); i++) {
            new modelo.Sprite().paintComponent(g, 140 + (i * 12), 170);
        }

        for (int i = 0; i < expendedora.getStockFanta(); i++) {
            new modelo.Fanta().paintComponent(g, 140 + (i * 12), 240);
        }

        for (int i = 0; i < expendedora.getStockSuper8(); i++) {
            new modelo.Super8().paintComponent(g, 140 + (i * 12), 310);
        }

        for (int i = 0; i < expendedora.getStockSnickers(); i++) {
            new modelo.Snickers().paintComponent(g, 140 + (i * 12), 380);
        }
    }

    /**
     * Actualiza el mensaje mostrado según el botón seleccionado.
     * @param x Coordenada X del clic.
     * @param y Coordenada Y del clic.
     */
    public void reaccionarClic(int x, int y) {

        if (x >= 390 && x <= 430 && y >= 140 && y <= 165) {
            this.mensajePantalla = "COKE";
            productoSeleccionado = TipoProducto.COCACOLA;
        }
        else if (x >= 390 && x <= 430 && y >= 175 && y <= 200) {
            this.mensajePantalla = "SPRITE";
            productoSeleccionado = TipoProducto.SPRITE;
        }
        else if (x >= 390 && x <= 430 && y >= 210 && y <= 235) {
            this.mensajePantalla = "FANTA";
            productoSeleccionado = TipoProducto.FANTA;
        }
        else if (x >= 390 && x <= 430 && y >= 245 && y <= 270) {
            this.mensajePantalla = "SUPER8";
            productoSeleccionado = TipoProducto.SUPER8;
        }
        else if (x >= 390 && x <= 430 && y >= 280 && y <= 305) {
            this.mensajePantalla = "SNICKERS";
            productoSeleccionado = TipoProducto.SNICKERS;
        }

        repaint();
    }


    /***
     * Retorna el producto seleccionado actualmente
     * @return producto seleccionado
     */
    public TipoProducto getProductoSeleccionado(){
        return productoSeleccionado;
    }

    /***
     * Limpia la seleccion del producto
     */
    public void limpiarSeleccion(){
        productoSeleccionado = null;
        mensajePantalla = "BIENVENIDO";
        repaint();
    }

    public void dejarProductoEnRanura(Producto producto){
        productoEnRanura = producto;
        repaint();
    }

    public Producto retirarProductoRanura(){
        Producto aux = productoEnRanura;
        productoEnRanura = null;
        repaint();
        return aux;
    }
}
