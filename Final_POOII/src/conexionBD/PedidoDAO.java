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

    Connection connection;
    Conexion conexion = Conexion.obtenerInstancia();
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public List listar() {

        List<Pedido> lista = new ArrayList<>();
        String query = "SELECT * FROM pedidos";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(resultSet.getInt(1));
                p.setFecha(resultSet.getDate(2));
                p.setMetodoPago(resultSet.getString(3));
                p.setIdCliente(resultSet.getInt(4));
                lista.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return lista;
    }

    public int agregar(Date fecha, int idCliente, String metodoPago) {
        int result = 0;
        String sql = "INSERT INTO pedidos(fecha, metodoPago, idCliente)values(?,?,?)";
        connection = conexion.obtenerConexion();
        try {
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, fecha);
            preparedStatement.setObject(2, metodoPago);
            preparedStatement.setObject(3, idCliente);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            result = resultSet.getInt(1);
        } catch (SQLException ex) {
            System.out.println("Error" + ex.toString());;
        }

        return result;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM pedidos WHERE idPedido = ?";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Pedido eliminado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

    }

    public Pedido obtenerPedidoPorId(int idPedido) {
        Pedido pedido = null;
        String query = "SELECT * FROM pedidos where idPedido =?";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, idPedido);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(resultSet.getInt(1));
                pedido.setFecha(resultSet.getDate(2));
                pedido.setMetodoPago(resultSet.getString(3));
                pedido.setIdCliente(resultSet.getInt(4));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return pedido;
    }

    public List<Pedido> obtenerPedidoPorIdCliente(int idCliente) {
        List<Pedido> pedidosCliente = new ArrayList<>();;
        Pedido pedido;
        String query = "SELECT * FROM pedidos where idCliente=?";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(resultSet.getInt(1));
                pedido.setFecha(resultSet.getDate(2));
                pedido.setMetodoPago(resultSet.getString(3));
                pedido.setIdCliente(resultSet.getInt(4));
                pedidosCliente.add(pedido);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return pedidosCliente;
    }

}
