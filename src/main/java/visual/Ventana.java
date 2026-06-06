package visual;

import javax.swing.JFrame;

/**
 * Clase que representa la ventana principal de la aplicación.
 * Sirve como contenedor base para la interfaz gráfica.
 */
public class Ventana extends JFrame {

    /**
     * Constructor de la ventana. Configura el título, tamaño,
     * posición centrada y agrega el panel principal al marco.
     */
    public Ventana() {
        this.setTitle("Expendedor de Bebidas - Tarea 3");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280, 720); // Tamaño inicial

        PanelPrincipal panelPrincipal = new PanelPrincipal();
        this.add(panelPrincipal);

        this.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        this.setVisible(true);
    }
}