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
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {

        List<Pedido> lista = new ArrayList<>();
        String query = "SELECT * FROM pedidos";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt(1));
                p.setFecha(rs.getDate(2));
                p.setIdCarritoCompras(rs.getInt(3));
                lista.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return lista;
    }

    public int agregar(Date fecha, int idCarrito) {
        int result = 0;
        String sql = "INSERT INTO pedidos(fecha, idCarrito)values(?,?)";
        con = cn.conectar();
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, fecha);
            ps.setObject(2, idCarrito);
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
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Pedido eliminado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error eliminando: " + e.toString());
        }

    }
    
    public Pedido obtenerPedidoPorIdCarrito(int idCarrito){
        Pedido pedido = null;
        String query = "SELECT * FROM pedidos";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt(1));
                pedido.setFecha(rs.getDate(2));
                pedido.setIdCarritoCompras(rs.getInt(3));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error obteniendo: " + e.toString());
        }

        return pedido;
    }

    /*public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE pedidos SET fecha=?, idCarrito = ? WHERE idPedido = ?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);

            r = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pedido actualizado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        return r;
    }*/

}