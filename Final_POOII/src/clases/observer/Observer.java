
package clases.observer;


/**
 * La interfaz Observer define el contrato que deben seguir los observadores.
 *
 * @param <T> El tipo de objeto que el observador maneja, debe extender de ElementoObservado.
 */
public interface Observer <T extends ElementoObservado> {
    /**
     * Método que se llama cuando hay una actualización.
     *
     * @param objeto El objeto actualizado a ser notificado.
     */
    abstract void actualizar(T objeto);
}
