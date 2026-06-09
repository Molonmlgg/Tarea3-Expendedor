package modelo;

import java.util.ArrayList;

/**
 * Clase que representa el inventario y estado del usuario en la aplicación.
 */
public class Comprador {

    // El monedero infinito para guardar el dinero del usuario
    private ArrayList<Moneda> monedero;
    // La mochila donde guardará los productos que saque de la máquina
    private ArrayList<Producto> productosComprados;

    public Comprador() {
        this.monedero = new ArrayList<>();
        this.productosComprados = new ArrayList<>();

        // El comprador empieza con una suma de dinero suficiente para varias compras
        this.monedero.add(new Moneda1000());
        this.monedero.add(new Moneda1000());
        this.monedero.add(new Moneda500());
        this.monedero.add(new Moneda100());
        this.monedero.add(new Moneda100());
    }

    /**
     * Agrega una moneda al monedero (útil para cuando recoja el vuelto o añada más dinero).
     */
    public void agregarMoneda(Moneda m) {
        if (m != null) {
            monedero.add(m);
            this.ordenarMonedero();
        }
    }

    /**
     * Saca una moneda del monedero para usarla en un pago.
     * @param indice El índice de la moneda en la lista.
     * @return La Moneda seleccionada, o null si el índice es inválido.
     */
    public Moneda obtenerMonedaParaPagar(int indice) {
        if (indice >= 0 && indice < monedero.size()) {
            return monedero.remove(indice);
        }
        return null;
    }

    /**
     * Retorna una moneda sin retirarla del monedero
     * @param indice posicion de la moneda
     * @return moneda encontrada o null si el indice es invalido
     */
    public Moneda getMoneda(int indice){
        if (indice >= 0 && indice < monedero.size()){
            return monedero.get(indice);
        }
        return null;
    }

    /**
     * Guarda un producto retirado de la máquina en el inventario del comprador.
     */
    public void guardarProducto(Producto p) {
        if (p != null) {
            productosComprados.add(p);
        }
    }

    public ArrayList<Moneda> getMonedero() {
        return monedero;
    }

    public ArrayList<Producto> getProductosComprados() {
        return productosComprados;
    }

    public void agruparMonedas() {
        int contador100 = 0;
        int contador500 = 0;

        for (Moneda m : monedero) {
            if (m.getValor() == 100) contador100++;
            else if (m.getValor() == 500) contador500++;
        }

        while (contador100 >= 5) {
            eliminarMonedasPorValor(100, 5);
            monedero.add(new Moneda500());
            contador100 -= 5;
            contador500++;
        }

        while (contador500 >= 2) {
            eliminarMonedasPorValor(500, 2);
            monedero.add(new Moneda1000());
            contador500 -= 2;
        }
        this.ordenarMonedero();
    }

    private void eliminarMonedasPorValor(int valor, int cantidad) {
        int eliminadas = 0;
        for (int i = monedero.size() - 1; i >= 0; i--) {
            if (monedero.get(i).getValor() == valor) {
                monedero.remove(i);
                eliminadas++;
                if (eliminadas == cantidad) break;
            }
        }
    }
    public void ordenarMonedero() {
        if (this.monedero != null && !this.monedero.isEmpty()) {
            this.monedero.sort((m1, m2) -> Integer.compare(m2.getValor(), m1.getValor()));
        }
    }
}