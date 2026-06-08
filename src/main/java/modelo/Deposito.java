package modelo;

import java.util.ArrayList;

/**
 * Clase genérica que representa un depósito de cosas X
 */
public class Deposito<T> {
    private ArrayList<T> depo;

    public Deposito() {
        this.depo = new ArrayList<T>();
    }

    /**
     * Añade un producto X al depósito dependiendo de para que sea.
     * @param producto El objeto de tipo T a añadir.
     */
    public void addItem(T producto) {
        this.depo.add(producto);
    }

    /**
     * Retira el primer elemento del depósito.
     * @return El objeto o producto o moneda.
     */
    public T getItem() {
        if (depo.size() > 0) {
            return depo.remove(0);
        } else {
            return null;
        }
    }

    /***
     * Retorna la cantidad de elementos almacenados en el deposito.
     * @return
     */
    public int size(){
        return depo.size();
    }
}
