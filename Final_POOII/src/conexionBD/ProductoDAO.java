package conexionBD;

import clases.Producto;
import java.awt.HeadlessException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;

public class ProductoDAO {

    Connection connection;
    Conexion conexion = Conexion.obtenerInstancia();
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public List listar() {
        List<Producto> lista = new ArrayList<>();
        String query = "SELECT * FROM Productos";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Producto p = new Producto();
                p.setId(resultSet.getInt(1));
                p.setMarca(resultSet.getString(2));
                p.setModelo(resultSet.getString(3));
                p.setPrecio(resultSet.getDouble(4));
                p.setStock(resultSet.getInt(5));
                p.setCategoria(resultSet.getString(6));
                p.setTipo(resultSet.getString(7));
                byte[] imageData = resultSet.getBytes(8);
                if (imageData != null) {
                    p.setImagen(ImageIO.read(new ByteArrayInputStream(imageData)));
                } else {
                    // Asignar una imagen en blanco o realizar alguna otra acción adecuada para manejar imágenes nulas.
                    // Por ejemplo, podrías asignar una imagen por defecto.
                    p.setImagen(null);
                }
                p.setDescripcion(resultSet.getString(9));

                lista.add(p);
            }
        } catch (IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return lista;
    }

    public int agregar(Object[] o) throws IOException {
        int result = 0;
        String sql = "INSERT INTO Productos(marca,modelo,precio,stock, categoría, tipo, imagen, descripcion)values(?,?,?,?,?,?,?,?)";
        connection = conexion.obtenerConexion();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, o[0]);
            preparedStatement.setObject(2, o[1]);
            preparedStatement.setObject(3, o[2]);
            preparedStatement.setObject(4, o[3]);
            preparedStatement.setObject(5, o[4]);
            preparedStatement.setObject(6, o[5]);

            //Convertir la imagen a un arreglo de bytes para ser alamcenada en la bd
            File imagenFile = new File((String) o[6]);
            byte[] imagenBytes = Files.readAllBytes(imagenFile.toPath());

            preparedStatement.setBlob(7, new SerialBlob(imagenBytes));
            preparedStatement.setObject(8, o[7]);
            result = preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.toString());
        }

        return result;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM Productos WHERE idProducto =?";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

    }

    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE Productos SET marca=?,modelo=?,precio=?,stock=?,categoría=?,tipo=?,imagen=?,descripcion=? WHERE idProducto=?";

        if (o[6].equals("")) {
            sql = "UPDATE Productos SET marca=?, modelo=?, precio=?, stock=?, categoría=?, tipo=?, descripcion=? WHERE idProducto=?";
        }

        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, o[0]);
            preparedStatement.setObject(2, o[1]);
            preparedStatement.setObject(3, o[2]);
            preparedStatement.setObject(4, o[3]);
            preparedStatement.setObject(5, o[4]);
            preparedStatement.setObject(6, o[5]);

            if (o[6].equals("")) {
                preparedStatement.setObject(7, o[7]);
                preparedStatement.setObject(8, o[8]);
            } else {
                System.out.println("ab");
                File imagenFile = new File((String) o[6]);
                byte[] imagenBytes = Files.readAllBytes(imagenFile.toPath());
                preparedStatement.setBlob(7, new SerialBlob(imagenBytes));
                preparedStatement.setObject(8, o[7]);
                preparedStatement.setObject(9, o[8]);
            }

            r = preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto actualizado correctamente.");
        } catch (HeadlessException | IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        return r;
    }

    public int actualizarStock(int idProducto, int stock) {
        int r = 0;
        String sql = "UPDATE productos SET stock=? WHERE idProducto=?";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, stock);
            preparedStatement.setObject(2, idProducto);
            r = preparedStatement.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        return r;
    }

    public List<Producto> obtenerProductosPorTipo(String tipo) {
        String query = "SELECT * FROM Productos WHERE tipo = ?";
        List<Producto> list = new ArrayList<Producto>();
        Producto p = null;
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tipo);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                p = new Producto();
                p.setId(resultSet.getInt(1));
                p.setMarca(resultSet.getString(2));
                p.setModelo(resultSet.getString(3));
                p.setPrecio(resultSet.getDouble(4));
                p.setStock(resultSet.getInt(5));
                p.setCategoria(resultSet.getString(6));
                p.setTipo(resultSet.getString(7));
                p.setImagen(ImageIO.read(new ByteArrayInputStream(resultSet.getBytes(8))));
                p.setDescripcion(resultSet.getString(9));

                list.add(p);
            }
        } catch (IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return list;
    }

    public Producto obtenerProductoPorId(int id) {
        String query = "SELECT * FROM Productos WHERE idProducto = ?";
        Producto p = null;
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                p = new Producto();
                p.setId(resultSet.getInt(1));
                p.setMarca(resultSet.getString(2));
                p.setModelo(resultSet.getString(3));
                p.setPrecio(resultSet.getDouble(4));
                p.setStock(resultSet.getInt(5));
                p.setCategoria(resultSet.getString(6));
                p.setTipo(resultSet.getString(7));
                p.setImagen(ImageIO.read(new ByteArrayInputStream(resultSet.getBytes(8))));
                p.setDescripcion(resultSet.getString(9));
            }
        } catch (IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return p;
    }

    public Producto obtenerProductoPorCategoria(String categoria) {
        String query = "SELECT * FROM Productos WHERE categoría = ?";
        Producto p = null;
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, categoria);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                p = new Producto();
                p.setId(resultSet.getInt(1));
                p.setMarca(resultSet.getString(2));
                p.setModelo(resultSet.getString(3));
                p.setPrecio(resultSet.getDouble(4));
                p.setStock(resultSet.getInt(5));
                p.setCategoria(resultSet.getString(6));
                p.setTipo(resultSet.getString(7));
                p.setImagen(ImageIO.read(new ByteArrayInputStream(resultSet.getBytes(8))));
                p.setDescripcion(resultSet.getString(9));
            }
        } catch (IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return p;
    }

    public boolean comprobarProducto(int id) {
        String query = "SELECT * FROM Productos WHERE idProducto = ?";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, id);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next(); //devuelve true si existe siquiera uno
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
            return false;
        }
    }

}
