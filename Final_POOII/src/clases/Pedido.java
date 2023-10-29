package clases;

import java.util.Date;

public class Pedido {
    private int idPedido;
    private Date fecha;
    private int idCarritoCompras;

    public Pedido(int idPedido, Date fecha, int idCarritoCompras) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.idCarritoCompras = idCarritoCompras;
    }

    public Pedido() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdCarritoCompras() {
        return idCarritoCompras;
    }

    public void setIdCarritoCompras(int idCarritoCompras) {
        this.idCarritoCompras = idCarritoCompras;
    }
    
    
    
}
