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
    Connection connection;
    Conexion conexion = Conexion.obtenerInstancia();
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public List listar() {
        List<CarritoCompras> lista = new ArrayList<>();
        String query = "SELECT * FROM carritocompras";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CarritoCompras c = new CarritoCompras();
                c.setIdCarrito(resultSet.getInt(1));
                c.setIdCliente(resultSet.getInt(2));
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
        connection = conexion.obtenerConexion();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, idCliente);
            
            result = preparedStatement.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Carrito agregado correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.toString());
        }

        return result;
    }


    public void eliminar(int id) {
        String sql = "DELETE FROM carritocompras WHERE idCarrito =?";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Carrito eliminado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error eliminando carro: " + e.toString());
        }

    }
    
    public CarritoCompras obtenerCarritoPorIdCliente(int idCliente){
        String sql = "SELECT * FROM carritocompras WHERE idCliente = ?";
        CarritoCompras carrito = null;
                
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, idCliente);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                carrito = new CarritoCompras();
                carrito.setIdCarrito(resultSet.getInt(1));
                carrito.setIdCliente(resultSet.getInt(2));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        
        return carrito;
    }
    
}
