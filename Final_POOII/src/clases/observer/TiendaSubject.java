
package clases.observer;

import clases.Producto;
import java.util.ArrayList;


public class TiendaSubject implements Subject{
    
    //private static final long serialVersionUID = 1L;
    private static TiendaSubject instancia;
    private ArrayList<Observer> observadores = new ArrayList<>();
    
    private TiendaSubject() {}

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
