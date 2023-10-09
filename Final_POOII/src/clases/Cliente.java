package clases;


import java.util.ArrayList;


public class Cliente extends Persona{
    private CarritoCompras carritoCompras;
    private ArrayList<Pedido> pedidos;
    private String nombre;
    private int id;
    private String email;
    private String password;

    public Cliente(String nombre, int dni, int telefono,String email, String password) {
        super(nombre, dni, telefono);
        this.email = email;
        this.password = password;
    }
    
    public Cliente(){}


    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
