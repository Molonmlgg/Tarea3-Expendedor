package modelo;

/**
 * Clase que representa al comprador, el mismo intenta comprar y recibir vuelto de la modelo.Expendedora.
 */
public class Comprador {

    private Producto producto;
    private int vuelto;

    /**
     * Constructor del comprador.
     * Intenta comprar un producto con la moneda que se le da.
     * @param m moneda con la que paga
     * @param tipo es el tipo de producto que elige el comprador
     * @param expendedora maquina expendedora
     */
    public Comprador(Moneda m, TipoProducto tipo, Expendedora expendedora) throws PagoIncorrectoException,
            PagoInsuficienteException,
            NoHayProductoException{
        this.producto = null;
        this.vuelto = 0;
        this.producto = expendedora.comprarProd(m, tipo);
        // Recupera todo el vuelto
        Moneda monedaVuelto;

        while ((monedaVuelto = expendedora.getVuelto()) != null){
            vuelto =  vuelto + monedaVuelto.getValor();
        }
    }

    /**
     * Retorna el produto que se compro
     * Si la compra es fallida, retorna null
     * @return producto o null
     */
    public Producto getProducto(){
        return producto;
    }

    /**
     * Retorna el vuelto total
     * @return vuelto en entero
     */
    public int getVuelto(){
        return vuelto;
    }
}
