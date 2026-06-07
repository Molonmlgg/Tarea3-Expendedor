package modelo;

/**
 * Simula una máquina expendedora que almacena productos en depósitos y procesa las ventas.
 */

public class Expendedora {
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> snickers;
    private Deposito<Producto> super8;
    private Deposito<Moneda> monVu;
    private Producto productoComprado;
    private Deposito<Moneda> depositoPago;

    /**
     * Constructor del Expendedor.
     *
     * @param cantidad La cantidad inicial de productos con la que se llena cada depósito.
     */
    public Expendedora(int cantidad) {
        this.coca = new Deposito<>();
        this.sprite = new Deposito<>();
        this.fanta = new Deposito<>();
        this.snickers = new Deposito<>();
        this.super8 = new Deposito<>();
        this.monVu = new Deposito<>();

        for (int i = 0; i < cantidad; i++) {
            coca.addItem(new CocaCola());
            sprite.addItem(new Sprite());
            fanta.addItem(new Fanta());
            snickers.addItem(new Snickers());
            super8.addItem(new Super8());
        }
    }

    /**
     * Intenta vender un producto validando el pago y el stock disponible.
     *
     * @param m    La moneda con la que se paga.
     * @param tipo El tipo de producto deseado.
     * @throws PagoIncorrectoException   Si la moneda ingresada es nula.
     * @throws PagoInsuficienteException Si el valor de la moneda es menor al precio del producto.
     * @throws NoHayProductoException    Si no queda stock del producto en el depósito.
     */
    public void comprarProd(Moneda m, TipoProducto tipo)
            throws
            PagoIncorrectoException,
            PagoInsuficienteException,
            NoHayProductoException {
        if (m == null) {
            throw new PagoIncorrectoException();

        }
        int precioProd = tipo.getPrecio();
        if (m.getValor() < precioProd) {
            monVu.addItem(m);
            throw new PagoInsuficienteException();
        }
        Producto p = null;
        if (tipo == TipoProducto.COCACOLA) {
            p = coca.getItem();
        } else if (tipo == TipoProducto.SPRITE) {
            p = sprite.getItem();
        } else if (tipo == TipoProducto.FANTA) {
            p = fanta.getItem();
        } else if (tipo == TipoProducto.SNICKERS) {
            p = snickers.getItem();
        } else if (tipo == TipoProducto.SUPER8) {
            p = super8.getItem();
        }
        if (p != null) {
            depositoPago.addItem(m);
            int vuelto = m.getValor() - p.getPrecio();
            while (vuelto >= 1000) {
                monVu.addItem(new Moneda1000());
                vuelto -= 1000;
            }
            while (vuelto >= 500) {
                monVu.addItem(new Moneda500());
                vuelto -= 500;
            }
            while (vuelto >= 100) {
                monVu.addItem(new Moneda100());
                vuelto -= 100;
            }
            this.productoComprado = p;

        } else {
            monVu.addItem(m);
            throw new NoHayProductoException();
        }
    }

    /**
     * Entrega el vuelto moneda por moneda (de a 100 pesos).
     *
     * @return Una modelo.Moneda de 100, o null si ya no queda más vuelto por entregar.
     */
    public Moneda getVuelto() {
        return monVu.getItem();
    }

    /**
     * Retira el producto comprado del receptáculo.
     *
     * @return El Producto comprado, o null si está vacío.
     */
    public Producto getProducto() {
        Producto aux = this.productoComprado;
        this.productoComprado = null;
        return aux;
    }
}


