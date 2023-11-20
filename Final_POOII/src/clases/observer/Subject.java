
package clases.observer;


/**
 * La interfaz Subject define el contrato que deben seguir los sujetos observados.
 *
 * @param <T> El tipo de objeto que el sujeto observado maneja, debe extender de ElementoObservado.
 */
public interface Subject <T extends ElementoObservado> {
    /**
     * Agrega un observador al conjunto de observadores.
     *
     * @param observer El observador a añadir.
     */
    abstract void añadir(Observer<T> observer);
    /**
     * Elimina un observador del conjunto de observadores.
     *
     * @param observer El observador a eliminar.
     */
    abstract void eliminar(Observer<T> observer);
    /**
     * Notifica a todos los observadores sobre un cambio en el sujeto observado.
     *
     * @param objeto El objeto que ha experimentado un cambio.
     */
    abstract void notificar(T objeto);
}
