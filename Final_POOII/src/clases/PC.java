package clases;

import java.awt.Image;
import java.util.List;

public class PC {
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

}
