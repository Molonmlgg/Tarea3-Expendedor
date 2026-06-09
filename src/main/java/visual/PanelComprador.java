package visual;

import modelo.Comprador;
import modelo.Moneda;
import modelo.Producto;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Panel que representa la interfaz de usuario del comprador.
 * Se encarga de mostrar los controles para interactuar con la expendedora,
 * como la selección de monedas y el botón de compra.
 */
public class PanelComprador extends JPanel {
    private Comprador comprador;
    private int monedaSeleccionada;
    private boolean comprarPresionado;
    private String mensajeAviso = "";

    /**
     * Constructor del panel comprador.
     * Configura el color de fondo temporal para delimitar su espacio en pantalla.
     */
    public PanelComprador(Comprador comprador) {
        this.comprador = comprador;
        this.monedaSeleccionada = -1;
        this.comprarPresionado = false;
        // Un fondo temporal azulado para diferenciarlo
        this.setBackground(new Color(200, 200, 255));
    }

    /**
     * Dibuja tod el contenido visual del comprador (monedero, botones y mochila).
     * @param g Objeto gráfico usado para pintar en pantalla.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawString("MONEDERO", 30, 40);
        ArrayList<Moneda> monedero = comprador.getMonedero();

        for (int i = 0; i < monedero.size(); i++) {
            Moneda moneda = monedero.get(i);

            int columna = i % 2;
            int fila = i / 2;

            // Calculamos la posición
            int xVisual = 30 + (columna * 120);
            int yVisual = 60 + (fila * 45);
            moneda.setXY(xVisual, yVisual);

            // Resaltar la moneda si está seleccionada
            if (i == monedaSeleccionada) {
                g.setColor(Color.RED);
                g.drawRect(xVisual - 5, yVisual - 5, 120, 45);
            }

            // Asignar color según el valor de la moneda
            if (moneda.getValor() == 100) {
                g.setColor(new Color(200, 200, 200)); // Gris plata
            } else if (moneda.getValor() == 500) {
                g.setColor(new Color(255, 215, 0)); // Dorado
            } else if (moneda.getValor() == 1000) {
                g.setColor(new Color(144, 238, 144)); // Verde billete
            } else {
                g.setColor(Color.WHITE); // Por defecto
            }

            // Pintar el fondo de la moneda
            g.fillRect(xVisual, yVisual, 110, 35);
            g.setColor(Color.BLACK);
            g.drawRect(xVisual, yVisual, 110, 35);

            // Dibujar el texto de la moneda
            g.drawString(
                    "$" + moneda.getValor() + " (S:" + moneda.getSerie() + ")",
                    xVisual + 5,
                    yVisual + 22
            );
        }

        // Dibujar botón de compra
        g.setColor(Color.GREEN);
        g.fillRect(30,330,120,35);
        g.setColor(Color.BLACK);
        g.drawRect(30,330,120,35);
        g.drawString("COMPRAR", 60, 352);

        // Dibujar la mochila del comprador
        g.drawString("MOCHILA", 30, 380);
        g.drawRect(30, 400, 140, 150);

        ArrayList<Producto> mochila = comprador.getProductosComprados();

        // Reposicionar y dibujar los productos guardados en la mochila
        for (int i = 0; i < mochila.size(); i++){
            Producto producto = mochila.get(i);

            // Asignar posiciones a los productos
            producto.setXY(40, 425 + (i * 20));
            g.drawString(
                    producto.getTipo() + " #" + producto.getSerie(),
                    40,
                    425 + (i*20)
            );
        }

        // Mensaje de advertencias dinámicas
        g.setColor(Color.RED);
        g.drawString(mensajeAviso, 30, 580);

        // Dibujar botón de combinar sencillo
        g.setColor(Color.ORANGE);
        g.fillRect(160, 330, 120, 35);
        g.setColor(Color.BLACK);
        g.drawRect(160, 330, 120, 35);
        g.drawString("COMBINAR", 185, 352);
    }

    /**
     * Procesa los clics del usuario para seleccionar monedas o presionar botones.
     * Ahora utiliza directamente las coordenadas guardadas en cada moneda.
     * @param x Coordenada X del clic del mouse.
     * @param y Coordenada Y del clic del mouse.
     */
    public void reaccionarClic(int x, int y) {
        ArrayList<Moneda> monedero = comprador.getMonedero();

        // Verificar si se hizo clic sobre alguna moneda usando sus propias coordenadas
        for (int i = 0; i < monedero.size(); i++) {
            int columna = i % 2;
            int fila = i / 2;
            int monedaX = 30 + (columna * 120);
            int monedaY = 60 + (fila * 45);

            if (x >= monedaX &&
                    x <= monedaX + 110 &&
                    y >= monedaY &&
                    y <= monedaY + 35) {

                monedaSeleccionada = i;
                repaint();
                return;
            }
        }

        // Clic en botón de comprar
        if (x >= 30 &&
                x <= 150 &&
                y >= 330 &&
                y <= 365) {

            comprarPresionado = true;
        }

        // Clic en botón de combinar monedas
        if (x >= 160 &&
                x <= 280 &&
                y >= 330 &&
                y <= 365) {

            comprador.agruparMonedas();
            repaint();
        }
    }

    /**
     * @return El índice de la moneda que el usuario seleccionó actualmente.
     */
    public int getMonedaSeleccionada(){
        return monedaSeleccionada;
    }

    /**
     * @return Verdadero si el usuario hizo clic en el botón de comprar.
     */
    public boolean isComprarPresionado(){
        return comprarPresionado;
    }

    /***
     * Reiniciar la seleccion de moneda
     */
    public void limpiarSeleccion(){
        monedaSeleccionada = -1;
        repaint();
    }

    /**
     * Resetea el estado del botón de compra.
     */
    public void limpiarBotonComprar(){
        comprarPresionado = false;
    }

    /**
     * Establece un mensaje de error o aviso para mostrar en pantalla.
     * @param mensaje El texto que se le mostrará al usuario.
     */
    public void setMensajeAviso(String mensaje) {
        this.mensajeAviso = mensaje;
        repaint();
    }
}