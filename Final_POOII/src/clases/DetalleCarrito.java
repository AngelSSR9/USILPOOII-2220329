package clases;

public class DetalleCarrito {
    private int idCarrito;
    private Integer idProducto = null;
    private Integer idPC = null;
    private int cantidad;

    public DetalleCarrito() {
    }

    public DetalleCarrito(int idCarrito, int idProducto, int cantidad) {
        this.idCarrito = idCarrito;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Integer getIdProducto() {
        System.out.println("idproducto: " + idProducto);
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdPC() {
        return idPC;
    }

    public void setIdPC(Integer idPC) {
        this.idPC = idPC;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }



}
