import visual.Ventana;

/**
 * Clase principal que inicializa la aplicación.
 * Según las restricciones del enunciado, esta clase solo se encarga
 * de instanciar la Ventana principal, delegando la creación del resto
 * de los componentes al árbol de clases.
 */
public class Main {

    /**
     * Punto de entrada principal del programa.
     * @param args Argumentos de la línea de comandos (no se utilizan en esta tarea).
     */
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }
}