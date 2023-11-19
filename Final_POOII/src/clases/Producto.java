package clases;

import clases.observer.ElementoObservado;
import java.awt.Image;

/**
 * Se crea una clase Producto.
 */
public class Producto implements ElementoObservado{
    
    private double precio;
    private String marca;
    private String modelo;
    private int Stock;
    private int id;
    private String categoria;
    private String tipo;
    private Image imagen;
    private String descripcion;

    /**
     * @return devuelve el parametro precio.
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * 
     * @param precio
     * Establece el valor del precio.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * 
     * @return devuelve el parametro marca.
     */
    public String getMarca() {
        return marca;
    }
    /**
     * 
     * @param marca
     * Establece el valor de la marca.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /**
     * 
     * @return devuelve el parametro modelo.
     */
    public String getModelo() {
        return modelo;
    }
    /**
     * 
     * @param modelo
     * Establece el valor de la modelo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    /**
     * 
     * @return devuelve el parametro stock.
     */
    public int getStock() {
        return Stock;
    }
    /**
     * 
     * @param Stock
     * Establece el valor del stock.
     */
    public void setStock(int Stock) {
        this.Stock = Stock;
    }
    /**
     * 
     * @return devuelve el parametro id.
     */
    public int getId() {
        return id;
    }
    /**
     * 
     * @param id
     * Establece el valor del id.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * 
     * @return devuelve el parametro imagen.
     */
    public Image getImagen() {
        return imagen;
    }
    /**
     * 
     * @param imagen
     * Se establece el valor de imagen.
     */
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    /**
     * 
     * @return devuelve el parametro categoria.
     */
    public String getCategoria() {
        return categoria;
    }
    /**
     * 
     * @param categoria
     * 
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    /**
     * 
     * @return devuelve el parametro tipo.
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * 
     * @param tipo
     * Se establece el valor de tipo.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * 
     * @return devuelve el parametro descripcion.
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * 
     * @param descripcion
     * Se establece el valor de descripcion.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String obtenerNombre() {
        return this.getTipo()+this.getMarca()+this.getModelo();
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
        return this.getPrecio();
    }

    @Override
    public String obtenerDescripcion() {
        return this.getDescripcion();
    }
}
