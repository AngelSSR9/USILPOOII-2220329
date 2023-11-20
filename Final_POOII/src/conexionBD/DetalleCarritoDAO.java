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
    Connection connection;
    Conexion conexion = Conexion.obtenerInstancia();
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public List listar() {
        List<DetalleCarrito> lista = new ArrayList<>();
        String query = "SELECT * FROM detallescarrito";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DetalleCarrito d = new DetalleCarrito();
                d.setIdCarrito(resultSet.getInt(1));
                d.setIdProducto(resultSet.getInt(2));
                d.setCantidad(resultSet.getInt(3));
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
       
        connection = conexion.obtenerConexion();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, o[0]);
            preparedStatement.setObject(2, o[1]);
            preparedStatement.setObject(3, o[2]);

            result = preparedStatement.executeUpdate();
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
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCarrito);
            preparedStatement.setInt(2, idProducto);
            preparedStatement.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Detalle eliminado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

    }
    
    public void eliminarTodosDetalles(int idCarrito){
        String sql = "DELETE FROM detallescarrito WHERE idCarrito =?";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCarrito);
            preparedStatement.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Detalle eliminado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }
    
    public List obtenerDetallesPorId(int id){
        List<DetalleCarrito> lista = new ArrayList<>();
        String sql = "SELECT * FROM detallescarrito WHERE idCarrito = ?";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                DetalleCarrito d = new DetalleCarrito();
                d.setIdCarrito(resultSet.getInt(1));
                d.setIdProducto(resultSet.getInt(2));
                d.setIdPC(resultSet.getInt(3));
                d.setCantidad(resultSet.getInt(4));
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
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, nuevaCantidad);
            preparedStatement.setObject(2, idCarrito);
            preparedStatement.setObject(3, idProducto);
            r = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        return r;
    }

}
