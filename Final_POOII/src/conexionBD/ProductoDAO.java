package conexionBD;

import clases.Producto;
import conexionBD.Conexion;
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

public class ProductoDAO  {
   
    Connection con;
    Conexion cn = Conexion.obtenerInstancia();
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        List<Producto> lista = new ArrayList<>();
        String query = "SELECT * FROM Productos";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setMarca(rs.getString(2));
                p.setModelo(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                p.setCategoria(rs.getString(6));
                p.setTipo(rs.getString(7));
                byte[] imageData = rs.getBytes(8);
                if (imageData != null) {
                    p.setImagen(ImageIO.read(new ByteArrayInputStream(imageData)));
                } else {
                    // Asignar una imagen en blanco o realizar alguna otra acción adecuada para manejar imágenes nulas.
                    // Por ejemplo, podrías asignar una imagen por defecto.
                    p.setImagen(null);
                }


                lista.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return lista;
    }

    public int agregar(Object[] o) throws IOException {
        int result = 0;
        String sql = "INSERT INTO Productos(marca,modelo,precio,stock, categoría, tipo, imagen)values(?,?,?,?,?,?,?)";
        con = cn.obtenerConexion();
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            
            //Convertir la imagen a un arreglo de bytes para ser alamcenada en la bd
            File imagenFile = new File((String) o[6]);
            byte[] imagenBytes = Files.readAllBytes(imagenFile.toPath());

            ps.setBlob(7, new SerialBlob(imagenBytes));
            result = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.toString());
        }

        return result;
    }


    public void eliminar(int id) {
        String sql = "DELETE FROM Productos WHERE id =?";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

    }

    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE Producto SET marca=?, modelo=?, precio=?, stock=? WHERE idProducto=?";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto actualizado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        return r;
    }
    
    public int actualizarStock(int idProducto, int stock){
        int r = 0;
        String sql = "UPDATE productos SET stock=? WHERE idProducto=?";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setObject(1, stock);
            ps.setObject(2, idProducto);
            r = ps.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        return r;
    }
    
    public Producto obtenerProductoPorId(int id){
        String query = "SELECT * FROM Productos WHERE idProducto = ?";
        Producto p = null;
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(query);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Producto();
                p.setId(rs.getInt(1));
                p.setMarca(rs.getString(2));
                p.setModelo(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                p.setCategoria(rs.getString(6));
                p.setTipo(rs.getString(7));
                p.setImagen(ImageIO.read(new ByteArrayInputStream(rs.getBytes(8))));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error obteniendo p x id: " + e.toString());
        }

        return p;
    }
    
    public Producto obtenerProductoPorCategoria(String categoria){
        String query = "SELECT * FROM Productos WHERE categoría = ?";
        Producto p = null;
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(query);
            ps.setObject(1, categoria);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Producto();
                p.setId(rs.getInt(1));
                p.setMarca(rs.getString(2));
                p.setModelo(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                p.setCategoria(rs.getString(6));
                p.setTipo(rs.getString(7));
                p.setImagen(ImageIO.read(new ByteArrayInputStream(rs.getBytes(8))));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return p;
    }
    
}
