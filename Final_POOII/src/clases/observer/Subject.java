
package clases.observer;

import clases.Producto;

/**
 * La interfaz Subject define el contrato que deben seguir los sujetos observados.
 */
public interface Subject {
    /**
     * Agrega un observador al conjunto de observadores.
     *
     * @param observer El observador a añadir.
     */
    abstract void añadir(Observer observer);
    /**
     * Elimina un observador del conjunto de observadores.
     *
     * @param observer El observador a eliminar.
     */
    abstract void eliminar(Observer observer);
    /**
     * Notifica a todos los observadores sobre un cambio en el sujeto observado.
     *
     * @param producto El producto que ha experimentado un cambio.
     */
    abstract void notificar(Producto producto);
}
