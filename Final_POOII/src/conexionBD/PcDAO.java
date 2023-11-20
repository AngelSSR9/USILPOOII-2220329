/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;

import clases.PC;
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

/**
 *
 * @author henry
 */
public class PcDAO {;
    Connection connection;
    Conexion conexion = Conexion.obtenerInstancia();
    PreparedStatement preparedStatement;
        ResultSet resultSet;
    
    public List listar(){
        List<PC> lst = new ArrayList<PC>();
        String query = "SELECT * FROM pc";
        try{
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                PC p = new PC();
                p.setId(resultSet.getInt(1));
                p.setNombre(resultSet.getString(2));
                p.setStock(resultSet.getInt(3));
                byte[] imageData = resultSet.getBytes(4);
                if (imageData != null) {
                    p.setImagen(ImageIO.read(new ByteArrayInputStream(imageData)));
                } else {
                    // Asignar una imagen en blanco o realizar alguna otra acción adecuada para manejar imágenes nulas.
                    // Por ejemplo, podrías asignar una imagen por defecto.
                    p.setImagen(null);
                }
                lst.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        
        
        return lst;
    }
    
    public int agregar(Object[] o) throws IOException, SQLException {
        int idGenerado = -1;
        String sql = "INSERT INTO pc(nombre, stock, imagen) VALUES (?, ?, ?)";
        String obtenerIdSql = "SELECT LAST_INSERT_ID() as id";  // Específico de MySQL

        connection = conexion.obtenerConexion();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, o[0]);
            preparedStatement.setObject(2, o[1]);

            // Convertir la imagen a un arreglo de bytes para ser almacenada en la base de datos
            File imagenFile = new File((String) o[2]);
            byte[] imagenBytes = Files.readAllBytes(imagenFile.toPath());

            preparedStatement.setBlob(3, new SerialBlob(imagenBytes));
            preparedStatement.executeUpdate();

            // Obtener el ID después de la inserción

            try{
                preparedStatement = connection.prepareStatement(obtenerIdSql);
                resultSet =preparedStatement.executeQuery();
                if (resultSet.next()) {
                    idGenerado = resultSet.getInt("id");
                    System.out.println("ID generado después de la inserción: " + idGenerado);
                } else {
                    System.out.println("No se pudo obtener el ID generado después de la inserción.");
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.toString());
            }

        } catch (SQLException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.toString());
            System.out.println(ex);
        }

        return idGenerado;
    }
    
    public void eliminar(int id) {
        String sql = "DELETE FROM pc WHERE idPC =?";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
        } catch (Exception e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }
    
    public int actualizarStock(int idPC, int stock){
        int r = 0;
        String sql = "UPDATE pc SET stock=? WHERE idPC=?";
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, stock);
            preparedStatement.setObject(2, idPC);
            r = preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        return r;
    }
    
    public PC obtenerPcPorId(int id){
        String query = "SELECT * FROM pc WHERE idPC = ?";
        PC p = null;
        try {
            connection = conexion.obtenerConexion();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                p = new PC();
                p.setId(resultSet.getInt(1));
                p.setNombre(resultSet.getString(2));
                p.setStock(resultSet.getInt(3));
                p.setImagen(ImageIO.read(new ByteArrayInputStream(resultSet.getBytes(4))));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error obteniendo p x id: " + e.toString());
        }

        return p;
    }
    
   
}
