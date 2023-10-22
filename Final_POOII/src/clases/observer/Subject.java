
package clases.observer;

public interface Subject {
    abstract void añadir(Observer observer);
    abstract void eliminar(Observer observer);
    abstract void notificar();
}
