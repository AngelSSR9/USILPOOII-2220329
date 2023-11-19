
package clases.observer;

import java.awt.Image;

/**
 * Interfaz que define el contrato para un elemento observado en el patrón Observer.
 *
 * @param <T> Tipo de objeto que se utiliza para cargar los datos del elemento observado.
 */
public interface ElementoObservado <T> {
    /**
     * Obtiene el nombre del elemento observado.
     *
     * @return El nombre del elemento observado.
     */
    abstract String cargarNombre();
    
    /**
     * Obtiene el stock del elemento observado.
     *
     * @return El stock del elemento observado.
     */
    abstract int cargarStock();
    
     /**
     * Obtiene la imagen del elemento observado.
     *
     * @return La imagen del elemento observado.
     */
    abstract Image cargarImagen();
    
    /**
     * Obtiene la descripción del elemento observado.
     *
     * @return La descripción del elemento observado.
     */
    abstract String cargarDescripcion();
    
    /**
     * Obtiene el precio del elemento observado.
     *
     * @return El precio del elemento observado.
     */
    abstract double cargarPrecio();
}
