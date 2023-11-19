package clases;

import clases.observer.ElementoObservado;
import conexionBD.DetallesPcDAO;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Clase que representa una PC y actúa como un elemento observado.
 */
public class PC implements ElementoObservado{
    private int id;
    private String nombre;
    private int stock;
    private Image imagen;
    private List<Producto> partes;
    
    /**
     * Agrega un producto a la lista de partes de la PC.
     *
     * @param p El producto a agregar.
     */
    public void add(Producto p){
        partes.add(p);
    }

    /**
     * Obtiene el ID de la PC.
     *
     * @return El ID de la PC.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la PC.
     *
     * @param id El nuevo ID de la PC.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la PC.
     *
     * @return El nombre de la PC.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la PC.
     *
     * @param nombre El nuevo nombre de la PC.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el stock de la PC.
     *
     * @return El stock de la PC.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece el stock de la PC.
     *
     * @param stock El nuevo stock de la PC.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Obtiene la imagen de la PC.
     *
     * @return La imagen de la PC.
     */
    public Image getImagen() {
        return imagen;
    }

    /**
     * Establece la imagen de la PC.
     *
     * @param imagen La nueva imagen de la PC.
     */
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    /**
     * Obtiene la lista de partes (productos) de la PC.
     *
     * @return La lista de partes de la PC.
     */
    public List<Producto> getPartes() {
        return partes;
    }

    /**
     * Establece la lista de partes (productos) de la PC.
     *
     * @param partes La nueva lista de partes de la PC.
     */
    public void setPartes(List<Producto> partes) {
        this.partes = partes;
    }

    @Override
    public String cargarNombre() {
        return this.getNombre();
    }

    @Override
    public int cargarStock() {
        return this.getStock();
    }

    @Override
    public Image cargarImagen() {
        return this.getImagen();
    }

    @Override
    public double cargarPrecio() {
        DetallesPcDAO detalles = new DetallesPcDAO();
        List<Producto> productosDePc = detalles.obtenerDetallesPorId(this.getId());

        // Calcula la suma de los precios de los productos
        double precioTotal = productosDePc.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();

        return precioTotal;
    }

    @Override
    public String cargarDescripcion() {
        // Convierte la lista de productos a una cadena
        DetallesPcDAO detalles= new DetallesPcDAO();
        List<Producto> productosDePc = detalles.obtenerDetallesPorId(this.getId());
        String descripcion = productosDePc.stream()
                .map(producto -> producto.getTipo() + " " + producto.getMarca() + " " + producto.getModelo())
                .collect(Collectors.joining(", "));

        return "Componentes: " + "\n"+descripcion;
    }
}
