package visual;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Panel encargado de representar visualmente la máquina expendedora.
 * Contendrá los depósitos de bebidas, monedas y la lógica visual de compra.
 */
public class PanelExpendedor extends JPanel {

    /**
     * Constructor del panel expendedor.
     * Configura el color de fondo temporal para diferenciar su área en la interfaz.
     */
    public PanelExpendedor() {
        this.setBackground(new Color(255, 200, 200));
    }

    /**
     * Método encargado de dibujar los elementos visuales en el panel.
     * @param g Objeto Graphics que actúa como el "pincel" para dibujar.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Dibuja el fondo rosado primero

        // 1. Dibujar la carcasa de la máquina (un rectángulo gris oscuro)
        g.setColor(Color.DARK_GRAY);
        // fillRect(posicionX, posicionY, ancho, alto)
        g.fillRect(100, 50, 400, 550);

        // 2. Dibujar el vidrio donde se ven las bebidas (celeste)
        g.setColor(new Color(173, 216, 230));
        g.fillRect(120, 70, 360, 380);

        // 3. Dibujar la ranura por donde sale la bebida (negro)
        g.setColor(Color.BLACK);
        g.fillRect(120, 480, 360, 80);
    }
}