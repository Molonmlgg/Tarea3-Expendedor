package visual;

import modelo.Comprador;
import modelo.Expendedora;
import modelo.Moneda;
import modelo.Producto;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Panel principal de la aplicacion
 * Contiene el panel del expendedor y el panel del comprador
 */
public class PanelPrincipal extends JPanel {

    private Expendedora expendedora;
    private Comprador comprador;

    private PanelExpendedor panelExpendedor;
    private PanelComprador panelComprador;

    /**
     * Constructor del panel principal.
     */
    public PanelPrincipal() {

        this.setLayout(new GridLayout(1, 2));

        expendedora = new Expendedora(5);
        comprador = new Comprador();

        panelExpendedor = new PanelExpendedor(expendedora);
        panelComprador = new PanelComprador(comprador);

        this.add(panelExpendedor);
        this.add(panelComprador);

        panelComprador.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e){
                panelComprador.reaccionarClic(
                        e.getX(),
                        e.getY()
                );

                if (panelComprador.isComprarPresionado()) {

                    // 1. Freno: ¿La ranura está llena? (Límite visual: 5 productos)
                    if (panelExpendedor.getCantidadEnRanura() >= 8) {
                        panelComprador.setMensajeAviso("¡No queda más espacio para sacar! Guárdalo en tu mochila.");
                        panelComprador.limpiarBotonComprar();
                        return;
                    }

                    // 2. Freno: ¿El monedero está lleno? (Límite visual: 10 monedas)
                    if (comprador.getMonedero().size() >= 10) {
                        panelComprador.setMensajeAviso("¡Monedero lleno! Considera combinar sencillo.");
                        panelComprador.limpiarBotonComprar();
                        return;
                    }

                    // Si pasa los frenos, limpiamos el mensaje de error y seguimos
                    panelComprador.setMensajeAviso("");

                    int indice = panelComprador.getMonedaSeleccionada();

                    if (indice == -1) {
                        System.out.println("No hay moneda seleccionada");
                        panelComprador.limpiarBotonComprar();
                        return;
                    }

                    if (panelExpendedor.getProductoSeleccionado() == null) {
                        System.out.println("No hay producto seleccionado");
                        panelComprador.limpiarBotonComprar();
                        return;
                    }

                    try {
                        Moneda moneda = comprador.getMoneda(indice);

                        expendedora.comprarProd(
                                moneda,
                                panelExpendedor.getProductoSeleccionado()
                        );

                        Producto producto = expendedora.getProducto();

                        panelExpendedor.dejarProductoEnRanura(producto);

                        Moneda vuelto;
                        while ((vuelto = expendedora.getVuelto()) != null){
                            comprador.agregarMoneda(vuelto);
                        }

                        comprador.obtenerMonedaParaPagar(indice);

                        panelComprador.repaint();
                        panelExpendedor.repaint();

                        panelComprador.limpiarSeleccion();
                        panelExpendedor.limpiarSeleccion();

                        System.out.println("Compra realizada");

                    }
                    catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    panelComprador.limpiarBotonComprar();
                }
            }
        });

        panelExpendedor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                // Procesa primero si se seleccionó algún botón de producto
                panelExpendedor.reaccionarClic(x, y);

                // Si el clic es dentro de la ranura de retiro, extrae el producto
                if (x >= 120 && x <= 480 && y >= 480 && y <= 560) {

                    // 3. Freno: ¿La mochila está llena? (Límite visual: 7 productos)
                    if (comprador.getProductosComprados().size() >= 7) {
                        panelComprador.setMensajeAviso("¡Ya no queda más espacio en tu mochila!");
                        return;
                    }

                    Producto producto = panelExpendedor.retirarProductoRanura();

                    if (producto != null) {
                        comprador.guardarProducto(producto);
                        panelComprador.setMensajeAviso(""); // Limpiamos el mensaje de error al lograrlo
                        panelComprador.repaint();
                    }
                }
                // Si se hace clic dentro de la carcasa de la máquina pero fuera de la botonera, se rellena
                else if (x >= 100 && x <= 500 && y >= 50 && y <= 600) {
                    boolean enBotonera = (x >= 390 && x <= 430 && y >= 140 && y <= 305);

                    if (!enBotonera) {
                        expendedora.rellenarDepositosVacios();
                        panelExpendedor.repaint();
                        System.out.println("Depósitos vacíos rellenados automáticamente");
                    }
                }
            }
        });
    }
}