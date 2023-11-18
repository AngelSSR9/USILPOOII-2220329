package conexionBD;

import clases.Cliente;
import clases.DetalleCarrito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DetalleCarritoDAO {
    Connection con;
    Conexion cn = Conexion.obtenerInstancia();
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        List<DetalleCarrito> lista = new ArrayList<>();
        String query = "SELECT * FROM detallescarrito";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleCarrito d = new DetalleCarrito();
                d.setIdCarrito(rs.getInt(1));
                d.setIdProducto(rs.getInt(2));
                d.setCantidad(rs.getInt(3));
                lista.add(d);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return lista;
    }

    public int agregar(Object[] o) {
        int result = 0;
        String sql = "";
        if((int) o[3] == 1){
            sql = "INSERT INTO detallescarrito(idCarrito, idProducto, cantidad)values(?,?,?)";
        }
        else{
            sql = "INSERT INTO detallescarrito(idCarrito, idPC, cantidad)values(?,?,?)";
        }
       
        con = cn.obtenerConexion();
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);

            result = ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Detalle agregado correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());;
        }

        return result;
    }


    public void eliminar(int idCarrito, int idProducto, int identidad) {
        String sql = "";
        if(identidad == 1){
            sql = "DELETE FROM detallescarrito WHERE idCarrito =? AND idProducto =?";
        }
        else{
            sql = "DELETE FROM detallescarrito WHERE idCarrito =? AND idPC =?";
        }
    
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCarrito);
            ps.setInt(2, idProducto);
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Detalle eliminado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

    }
    
    public void eliminarTodosDetalles(int idCarrito){
        String sql = "DELETE FROM detallescarrito WHERE idCarrito =?";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCarrito);
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Detalle eliminado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }
    
    public List obtenerDetallesPorId(int id){
        List<DetalleCarrito> lista = new ArrayList<>();
        String sql = "SELECT * FROM detallescarrito WHERE idCarrito = ?";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                DetalleCarrito d = new DetalleCarrito();
                d.setIdCarrito(rs.getInt(1));
                d.setIdProducto(rs.getInt(2));
                d.setIdPC(rs.getInt(3));
                d.setCantidad(rs.getInt(4));
                lista.add(d);
            }
            //JOptionPane.showMessageDialog(null, "Detalle eliminado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error detalle x id: " + e.toString());
        }
       
        return lista;
    }
    
    public int actualizarCantidadProducto(int nuevaCantidad, int idCarrito, int idProducto, int identidad){
        int r = 0;
        String sql = "";
        if(identidad == 1){
            sql = "UPDATE detallescarrito SET cantidad=? WHERE idCarrito = ? and idProducto = ?";
        }
        else {
            sql = "UPDATE detallescarrito SET cantidad=? WHERE idCarrito = ? and idPC = ?";
        }
        
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nuevaCantidad);
            ps.setObject(2, idCarrito);
            ps.setObject(3, idProducto);
            r = ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        return r;
    }

}
