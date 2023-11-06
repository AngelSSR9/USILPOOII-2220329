package conexionBD;

import clases.CarritoCompras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CarritoDAO {
    Connection con;
    Conexion cn = Conexion.obtenerInstancia();
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        List<CarritoCompras> lista = new ArrayList<>();
        String query = "SELECT * FROM carritocompras";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CarritoCompras c = new CarritoCompras();
                c.setIdCarrito(rs.getInt(1));
                c.setIdCliente(rs.getInt(2));
                lista.add(c);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return lista;
    }

    public int agregar(int idCliente) {
        int result = 0;
        String sql = "INSERT INTO carritocompras(idCliente)values(?)";
        con = cn.obtenerConexion();
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, idCliente);
            
            result = ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Carrito agregado correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.toString());
        }

        return result;
    }


    public void eliminar(int id) {
        String sql = "DELETE FROM carritocompras WHERE idCarrito =?";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Carrito eliminado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error eliminando carro: " + e.toString());
        }

    }
    
    public CarritoCompras obtenerCarritoPorIdCliente(int idCliente){
        String sql = "SELECT * FROM carritocompras WHERE idCliente = ?";
        CarritoCompras carrito = null;
                
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setObject(1, idCliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                carrito = new CarritoCompras();
                carrito.setIdCarrito(rs.getInt(1));
                carrito.setIdCliente(rs.getInt(2));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        
        return carrito;
    }
    
}
