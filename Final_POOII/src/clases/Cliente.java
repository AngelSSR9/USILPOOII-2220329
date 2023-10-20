package clases;


import java.util.ArrayList;


public class Cliente extends Persona{
    private CarritoCompras carritoCompras;
    private ArrayList<Pedido> pedidos;
    private String nombre;
    private int id;
    private String correo;
    private String contraseña;

    public Cliente(String nombre, int dni,String correo, String contraseña) {
        super(nombre, dni);
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    public Cliente(){}


    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public CarritoCompras getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(CarritoCompras carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
}
