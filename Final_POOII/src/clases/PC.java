package clases;

import clases.observer.ElementoObservado;
import conexionBD.DetallesPcDAO;
import java.awt.Image;
import java.util.List;
import java.util.stream.Collectors;
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
