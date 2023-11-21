package clases;

import clases.observer.ElementoObservado;
import clases.observer.Observer;
import correo.MensajeCorreo;

/**
 * Clase que representa a un cliente y actúa como un observador de productos.
 */
public class Cliente  implements Observer<ElementoObservado>{
    private String nombre;
    private int dni;
    private int id;
    private String correo;
    private String contraseña;
    private boolean notificacion;
    
    /**
     * Instancia de la clase encargada de enviar mensajes de correo.
     */
    MensajeCorreo mensajeCorreo = new MensajeCorreo();

    /**
     * Constructor de la clase Cliente.
     *
     * @param nombre      El nombre del cliente.
     * @param dni         El número de identificación del cliente.
     * @param correo      La dirección de correo electrónico del cliente.
     * @param contraseña  La contraseña del cliente.
     */
    public Cliente(String nombre, int dni,String correo, String contraseña) {
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    /**
     * Constructor vacío de la clase Cliente.
     */
    public Cliente(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDecision() {
        return notificacion;
    }

    public void setDecision(boolean decision) {
        this.notificacion = decision;
    }
    
    

    /**
     * Método de la interfaz Observer que se llama cuando hay una actualización de
     * un producto o pc. Envia un mensaje de correo electrónico al cliente.
     * @param objeto 
     */
    @Override
    public void actualizar(ElementoObservado objeto) {
        mensajeCorreo.enviarMensaje(objeto, getCorreo());
    }
}
