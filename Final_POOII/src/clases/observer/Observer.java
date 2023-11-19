
package clases.observer;

import clases.Producto;

/**
 * La interfaz Observer define el contrato que deben seguir los observadores.
 */
public interface Observer <T extends ElementoObservado> {
    /**
     * Método que se llama cuando hay cambios en el estado del sujeto observado.
     *
     * @param producto El producto actualizado que notifica el cambio.
     */
    abstract void actualizar(T objeto);
}
