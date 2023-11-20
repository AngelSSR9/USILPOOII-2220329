package conexionBD;

import clases.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO  {
   
    Connection connection;
    Conexion conexion = Conexion.obtenerInstancia();
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public List listar() {
        List<Cliente> lista = new ArrayList<>();
        String query = "SELECT * FROM Clientes";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cliente c = new Cliente();
                c.setId(resultSet.getInt(1));
                c.setNombre(resultSet.getString(2));
                c.setCorreo(resultSet.getString(3));
                c.setContraseña(resultSet.getString(4));
                c.setDni(resultSet.getInt(5));
                lista.add(c);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return lista;
    }

    public int agregar(Object[] o) {
        int result = 0;
        String sql = "INSERT INTO Clientes(nombre, correo, contraseña, dni)values(?,?,?,?)";
        connection = conexion.obtenerConexion();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, o[0]);
            preparedStatement.setObject(2, o[1]);
            preparedStatement.setObject(3, o[2]);
            preparedStatement.setObject(4, o[3]);
            result = preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.toString());
        }

        return result;
    }


    public void eliminar(int id) {
        String sql = "DELETE FROM Clientes WHERE idCliente =?";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

    }

    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE Clientes SET nombre=?, correo=?, contraseña=?, dni=? WHERE idCliente=?";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, o[0]);
            preparedStatement.setObject(2, o[1]);
            preparedStatement.setObject(3, o[2]);
            preparedStatement.setObject(4, o[3]);
            preparedStatement.setObject(5, o[4]);
            r = preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        return r;
    }

    public Cliente obtenerClientePorDNI(int dni) {
        String query = "SELECT * FROM Clientes WHERE DNI =" + dni;
        Cliente c = null;
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                c = new Cliente();
                c.setId(resultSet.getInt(1));
                c.setNombre(resultSet.getString(2));
                c.setCorreo(resultSet.getString(3));
                c.setContraseña(resultSet.getString(4));
                c.setDni(resultSet.getInt(5));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        
        return c;
    }

}
