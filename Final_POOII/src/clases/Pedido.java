package clases;

import java.util.Date;

public class Pedido {
    private int idPedido;
    private int idCliente;
    private Date fecha;
    private String metodoPago;

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

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
    
}