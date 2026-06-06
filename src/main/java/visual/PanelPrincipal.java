package visual;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

/**
 * Panel principal que contiene toda la interfaz gráfica de la aplicación.
 * Administra la distribución espacial dividiendo la pantalla entre el
 * Expendedor y el Comprador.
 */
public class PanelPrincipal extends JPanel {

    /**
     * Constructor del panel principal.
     * Establece un diseño de grilla (1 fila, 2 columnas) e instancia los
     * sub-paneles correspondientes a la máquina y al usuario.
     */
    public PanelPrincipal() {
        // Configuramos la grilla: 1 fila, 2 columnas (mitad y mitad)
        this.setLayout(new GridLayout(1, 2));
        this.setBackground(Color.LIGHT_GRAY);

        // Creamos los sub-paneles
        PanelExpendedor panelExpendedor = new PanelExpendedor();
        PanelComprador panelComprador = new PanelComprador();

        // Los agregamos al panel principal
        this.add(panelExpendedor); // Se irá a la mitad izquierda
        this.add(panelComprador);  // Se irá a la mitad derecha
    }
}