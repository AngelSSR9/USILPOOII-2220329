package clases;

import clases.observer.ElementoObservado;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PC implements ElementoObservado{
    private int id;
    private String nombre;
    private int stock;
    private Image imagen;
    private List<Producto> partes;
    
    public void add(Producto p){
        partes.add(p);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public List<Producto> getPartes() {
        return partes;
    }

    public void setPartes(List<Producto> partes) {
        this.partes = partes;
    }

    @Override
    public String obtenerNombre() {
        return this.getNombre();
    }

    @Override
    public int obtenerStock() {
        return this.getStock();
    }

    @Override
    public Image obtenerImagen() {
        return this.getImagen();
    }

    @Override
    public double obtenerPrecio() {
        return 00;
    }

    @Override
    public String obtenerDescripcion() {
        // Convierte la lista de productos a una cadena
        String descripcion = getPartes().stream()
                .map(producto -> producto.getTipo() + " " + producto.getMarca() + " " + producto.getModelo())
                .collect(Collectors.joining("\n"));

        return "Componentes: " + descripcion;
    }
}
