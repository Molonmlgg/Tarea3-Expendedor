package visual;

import javax.swing.JPanel;
import java.awt.Color;

/**
 * Panel que representa la interfaz de usuario del comprador.
 * Se encarga de mostrar los controles para interactuar con la expendedora,
 * como la selección de monedas y el botón de compra.
 */
public class PanelComprador extends JPanel {

    /**
     * Constructor del panel comprador.
     * Configura el color de fondo temporal para delimitar su espacio en pantalla.
     */
    public PanelComprador() {
        // Un fondo temporal azulado para diferenciarlo
        this.setBackground(new Color(200, 200, 255));
    }
}