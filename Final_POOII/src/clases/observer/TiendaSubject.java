
package clases.observer;

import clases.Producto;
import java.util.ArrayList;

/**
 * La clase TiendaSubject implementa la interfaz Subject y actúa como el sujeto
 * observado en el patrón Observer.
 */
public class TiendaSubject implements Subject{
    
    private static TiendaSubject instancia;
    private ArrayList<Observer> observadores = new ArrayList<>();
    
    private TiendaSubject() {}
    
    /**
     * Método estático para obtener la instancia única de TiendaSubject.
     *
     * @return La instancia única de TiendaSubject.
     */
    public static TiendaSubject getInstancia() {
        if (instancia == null) {
            instancia = new TiendaSubject();
        }
        return instancia;
    }
    
    @Override
    public void añadir(Observer observer) {
        observadores.add(observer);
    }

    @Override
    public void eliminar(Observer observer) {
        observadores.remove(observer);
    }

    @Override
    public void notificar(Producto producto) {
        for (Observer observer : observadores) {
            observer.actualizar(producto);
        }
    }
}
