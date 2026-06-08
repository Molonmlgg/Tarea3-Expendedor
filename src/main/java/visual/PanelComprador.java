package visual;

import modelo.Comprador;
import modelo.Moneda;

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
    /**
     * Constructor del panel comprador.
     * Configura el color de fondo temporal para delimitar su espacio en pantalla.
     */
    public PanelComprador(Comprador comprador) {
        this.comprador = comprador;
        // Un fondo temporal azulado para diferenciarlo
        this.setBackground(new Color(200, 200, 255));
    }

    /**
     * Dibuja el contenido del comprador
     * @param g objeto gráfico
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawString("MONEDERO", 30, 40);
        ArrayList<Moneda> monedero = comprador.getMonedero();

        for (int i = 0; i < monedero.size(); i++){
            Moneda moneda = monedero.get(i);

            g.drawRect(30, 60 + (i*50), 100, 35);
            g.drawString(
                    "$" + moneda.getValor(),
                    60,
                    82+(i*50)
            );
        }
        g.drawString("MOCHILA", 30, 380);
        g.drawRect(30, 400, 300, 150);
    }
}