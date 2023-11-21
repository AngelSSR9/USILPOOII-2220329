package conexionBD;

import clases.DetallePedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DetallePedidoDAO {

    Connection connection;
    Conexion conexion = Conexion.obtenerInstancia();
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public List listar() {
        List<DetallePedido> lista = new ArrayList<>();
        String query = "SELECT * FROM detallespedidos";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DetallePedido d = new DetallePedido();
                d.setIdPedido(resultSet.getInt(1));
                d.setIdProducto(resultSet.getInt(2));
                d.setCantidad(resultSet.getInt(3));
                d.setPrecioVenta(resultSet.getDouble(4));
                d.setIdPC(resultSet.getInt(5));
                lista.add(d);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error listando: " + e.toString());
        }

        return lista;
    }

    public int agregar(Object[] o) {
        int result = 0;
        String sql = "";

        if ((int) o[4] == 1) {
            sql = "INSERT INTO detallespedidos(idPedido, idProducto, cantidad, precioVenta)values(?,?,?,?)";
        } else {
            sql = "INSERT INTO detallespedidos(idPedido, idPC, cantidad, precioVenta)values(?,?,?,?)";
        }

        connection = conexion.obtenerConexion();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, o[0]);
            preparedStatement.setObject(2, o[1]);
            preparedStatement.setObject(3, o[2]);
            preparedStatement.setObject(4, o[3]);
            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Er: " + ex.toString());
        }

        return result;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM detallespedidos WHERE idPedido =?";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Detalle pedido eliminado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error eliminando: " + e.toString());
        }

    }

    public List obtenerDetallesPorId(int id) {
        List<DetallePedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM detallespedidos WHERE idPedido = ?";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DetallePedido d = new DetallePedido();
                d.setIdPedido(resultSet.getInt(1));
                d.setIdProducto(resultSet.getInt(2));
                d.setCantidad(resultSet.getInt(3));
                d.setPrecioVenta(resultSet.getDouble(4));
                d.setIdPC(resultSet.getInt(5));
                lista.add(d);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error obteniendo detalle: " + e.toString());
        }

        return lista;
    }

}
