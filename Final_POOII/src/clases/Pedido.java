package clases;

import java.util.Date;

public class Pedido {
    private int idPedido;
    private Date fecha;
    private int idCliente;

    public Pedido(int idPedido, Date fecha, int idCliente) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.idCliente = idCliente;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
   
}