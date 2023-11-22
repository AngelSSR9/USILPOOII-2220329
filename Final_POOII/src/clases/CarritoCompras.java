package clases;

public class CarritoCompras {
    private int idCarrito;
    private int idCliente;
    
    public CarritoCompras() {
    }

    public CarritoCompras(int idCarrito, int idCliente) {
        this.idCarrito = idCarrito;
        this.idCliente = idCliente;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }  
    
}
