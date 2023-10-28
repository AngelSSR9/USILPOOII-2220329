package clases;

import clases.observer.Observer;
import clases.observer.Subject;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author henry
 */
public class Administrador /*implements Subject*/{
    private String nombre;
    private String password;
    private int numero;
    private List<Observer> clientes;
    
    
    public Administrador(String nombre, String password, int numero) {
        this.nombre = nombre;
        this.password = password;
        this.numero = numero;
    }
    
    public void agregarProducto(){
        
    }
    
    public void eliminarPedido(){
        
    }
    
    public void modificarPedido(){
        
    }
    
    public void verIngresos(){
        
    }
    
    public void verEgresos(){
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    /*
    @Override
    public void añadir(Observer observer) {
        clientes.add(observer);
    }

    @Override
    public void eliminar(Observer observer) {
        clientes.remove(observer);
    }

    @Override
    public void notificar() {
        for (Observer cliente : clientes) {
            cliente.actualizar();
        }
    }
*/
    
    
    
    
}
