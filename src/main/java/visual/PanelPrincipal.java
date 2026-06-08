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

                        comprador.guardarProducto(producto);

                        Moneda vuelto;
                        while ((vuelto = expendedora.getVuelto()) != null){
                            comprador.agregarMoneda(vuelto);
                        }

                        comprador.obtenerMonedaParaPagar(indice);


                        panelComprador.repaint();

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
                panelExpendedor.reaccionarClic(
                        e.getX(),
                        e.getY()
                );
            }
        });
    }
}