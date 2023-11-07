package conexionBD;

import clases.Cliente;
import clases.DetalleCarrito;
import clases.DetallePedido;
import clases.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DetallePedidoDAO {

    Connection con;
    Conexion cn = Conexion.obtenerInstancia();
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        List<DetallePedido> lista = new ArrayList<>();
        String query = "SELECT * FROM detallespedidos";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetallePedido d = new DetallePedido();
                d.setIdPedido(rs.getInt(1));
                d.setIdProducto(rs.getInt(2));
                d.setCantidad(rs.getInt(3));
                d.setPrecioVenta(rs.getDouble(4));
                lista.add(d);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error listando: " + e.toString());
        }

        return lista;
    }

    public int agregar(Object[] o) {
        int result = 0;
        String sql = "INSERT INTO detallespedidos(idPedido, idProducto, cantidad, precioVenta)values(?,?,?,?)";
        con = cn.obtenerConexion();
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            result = ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Detalle agregado correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error agregando: " + ex.toString());
        }

        return result;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM detallespedidos WHERE idPedido =?";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Detalle pedido eliminado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error eliminando: " + e.toString());
        }

    }
    
    public List obtenerDetallesPorId(int id){
        List<DetallePedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM detallespedidos WHERE idPedido = ?";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                DetallePedido d = new DetallePedido();
                d.setIdPedido(rs.getInt(1));
                d.setIdProducto(rs.getInt(2));
                d.setCantidad(rs.getInt(3));
                d.setPrecioVenta(rs.getDouble(4));
                lista.add(d);
            }
            //JOptionPane.showMessageDialog(null, "Detalle eliminado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error obteniendo detalle: " + e.toString());
        }
       
        return lista;
    }

}
