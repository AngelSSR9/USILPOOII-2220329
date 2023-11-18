package conexionBD;

import clases.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class PedidoDAO {

    Connection con;
    Conexion cn = Conexion.obtenerInstancia();
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {

        List<Pedido> lista = new ArrayList<>();
        String query = "SELECT * FROM pedidos";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt(1));
                p.setFecha(rs.getDate(2));
                p.setMetodoPago(rs.getString(3));
                p.setIdCliente(rs.getInt(4));
                lista.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return lista;
    }

    public int agregar(Date fecha, int idCliente, String metodoPago)  {
        int result = 0;
        String sql = "INSERT INTO pedidos(fecha, metodoPago, idCliente)values(?,?,?)";
        con = cn.obtenerConexion();
        try {
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setObject(1, fecha);
            ps.setObject(2, metodoPago);
            ps.setObject(3, idCliente);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            result = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println("Error" + ex.toString());;
        }

        return result;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM pedidos WHERE idPedido = ?";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Pedido eliminado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error eliminando: " + e.toString());
        }

    }
    
    public Pedido obtenerPedidoPorId(int idPedido){
        Pedido pedido = null;
        String query = "SELECT * FROM pedidos where idPedido =?";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(query);
            ps.setObject(1, idPedido);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt(1));
                pedido.setFecha(rs.getDate(2));
                pedido.setMetodoPago(rs.getString(3));
                pedido.setIdCliente(rs.getInt(4));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error obteniendo: " + e.toString());
        }

        return pedido;
    }
    
    public List<Pedido> obtenerPedidoPorIdCliente(int idCliente){
        List<Pedido> pedidosCliente = new ArrayList<>();;
        Pedido pedido;
        String query = "SELECT * FROM pedidos where idCliente=?";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt(1));
                pedido.setFecha(rs.getDate(2));
                pedido.setMetodoPago(rs.getString(3));
                pedido.setIdCliente(rs.getInt(4));
                pedidosCliente.add(pedido);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error obteniendo: " + e.toString());
        }

        return pedidosCliente;
    }

}
