package visual;

import modelo.Comprador;
import modelo.Expendedora;

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
            }
        });
    }
}