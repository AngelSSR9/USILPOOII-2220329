package newpackage;


import java.util.ArrayList;


public class Cliente extends Persona{
    private ArrayList<CarritoCompras> compras;
    private ArrayList<Pedido> pedidos;
    private String email;
    private String password;

    public Cliente(String nombre, int dni, int telefono,String email, String password) {
        super(nombre, dni, telefono);
        this.email = email;
        this.password = password;
    }

    public ArrayList<CarritoCompras> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<CarritoCompras> compras) {
        this.compras = compras;
    }

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
    
    

    
    
    
    
    
}
