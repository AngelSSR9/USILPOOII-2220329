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
public class PcDAO {
    DetallesPcDAO detPc = new DetallesPcDAO();
    Connection con;
    Conexion cn = Conexion.obtenerInstancia();
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List<PC> lst = new ArrayList<PC>();
        String query = "SELECT * FROM pc";
        try{
            con = cn.obtenerConexion();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                PC p = new PC();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setStock(rs.getInt(3));
                byte[] imageData = rs.getBytes(4);
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

        con = cn.obtenerConexion();
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);

            // Convertir la imagen a un arreglo de bytes para ser almacenada en la base de datos
            File imagenFile = new File((String) o[2]);
            byte[] imagenBytes = Files.readAllBytes(imagenFile.toPath());

            ps.setBlob(3, new SerialBlob(imagenBytes));
            ps.executeUpdate();

            // Obtener el ID después de la inserción

            try{
                ps = con.prepareStatement(obtenerIdSql);
                rs =ps.executeQuery();
                if (rs.next()) {
                    idGenerado = rs.getInt("id");
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
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
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
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setObject(1, stock);
            ps.setObject(2, idPC);
            r = ps.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        return r;
    }
    
    public PC obtenerPcPorId(int id){
        String query = "SELECT * FROM pc WHERE idPC = ?";
        PC p = null;
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(query);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new PC();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setStock(rs.getInt(3));
                p.setImagen(ImageIO.read(new ByteArrayInputStream(rs.getBytes(4))));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error obteniendo p x id: " + e.toString());
        }

        return p;
    }
    
   
}
