package conexionBD;

import clases.CarritoCompras;
import clases.Cliente;
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
                p.setIdCliente(rs.getInt(3));
                lista.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return lista;
    }

    public int agregar(Date fecha, int idCliente) {
        int result = 0;
        String sql = "INSERT INTO pedidos(fecha, idCliente)values(?,?)";
        con = cn.obtenerConexion();
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, fecha);
            ps.setObject(2, idCliente);
            result = ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Pedido agregado correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error agregando: " + ex.toString());
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error eliminando: " + e.toString());
        }

    }
    
    public Pedido obtenerPedidoPorIdCliente(int idCliente){
        Pedido pedido = null;
        String query = "SELECT * FROM pedidos";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt(1));
                pedido.setFecha(rs.getDate(2));
                pedido.setIdCliente(rs.getInt(3));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error obteniendo: " + e.toString());
        }

        return pedido;
    }

}
