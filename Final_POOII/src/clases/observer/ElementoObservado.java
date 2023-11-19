
package clases.observer;

import java.awt.Image;


public interface ElementoObservado <T> {
    abstract String obtenerNombre();
    abstract int obtenerStock();
    abstract Image obtenerImagen();
    abstract String obtenerDescripcion();
    abstract double obtenerPrecio();
}
