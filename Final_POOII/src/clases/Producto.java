package clases;


public abstract class Producto {
    private double precio;
    private String marca;
    private String modelo;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
